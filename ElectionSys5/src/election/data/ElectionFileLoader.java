package election.data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import election.business.DawsonElectionFactory;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;

/**
 * @author Maria Hossain
 * @version 0.0.1
 * 
 */

public class ElectionFileLoader {

  private ElectionFileLoader() {

  }


  /**
   * 
   * @param filename
   * @return Voter[]
   * @throws IOException
   * 
   *         This method iterate through a list voter(contained in a text file) with its information
   *         such as email,first name,last name and postal code. And basically created and array of
   *         Voter Object with that following information.
   */

  public static Voter[] getVoterListFromSequentialFile(String filename) throws IOException {
    if (filename == null || filename.isEmpty()) {
      throw new InvalidPathException("", "Path is null or empty");
    }

    Path pathToVoterFile = Paths.get(filename);

    List<String> fileVoters = Files.readAllLines(pathToVoterFile, StandardCharsets.UTF_8);

    List<Voter> voters = new ArrayList<Voter>();

    Optional<Voter> voter;

    for (int i = 0; i < fileVoters.size(); i++) {
      String[] tempVoter = fileVoters.get(i).split("\\*");

      if (tempVoter.length == 4) {
        try {
          // No need to use ofNullable, since exception would've been thrown
          voter = Optional.of(DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance(tempVoter[1],
              tempVoter[2], tempVoter[0], tempVoter[3]));

          // No need to verify Voter is present, since exception would've been thrown
          voters.add(voter.get());
        }
        // Voter not created because either firstname/lastname/email/pcode was invalid
        catch (IllegalArgumentException e) {
          System.err.println("Could not create [" + tempVoter[1] + ',' + tempVoter[2]
              + "] on line #" + (i + 1) + " because of : " + e.getMessage());
        }
      } else {
        System.err.println("Could not create voter #" + i
            + ", missing some information, only length of " + tempVoter.length);
      }
    }
    ((ArrayList<Voter>) voters).trimToSize();

    return voters.toArray(new Voter[voters.size()]);
  }

  /**
   * This method iterate through the text file and extract the different elections and will put it
   * into a an array of Elections
   * 
   * @param filename
   * @return Election[] that contains usually 3 El
   * @throws IOException
   */
  public static Election[] getElectionListFromSequentialFile(String filename) throws IOException {
    try {
      Path p = Paths.get(filename);
      List<String> allLines = Files.readAllLines(p);
      ArrayList<Election> listElection = new ArrayList<>();

      String[] split;

      for (int i = 0; i < allLines.size(); i += Integer.parseInt(split[10]) + 1) {


        split = (allLines.get(i).split("\\*"));

        // Check If The First Line Of Every Election Have All The Required Fields Or Not.
        if (split.length != 11) {
          System.err.println(
              "One or more required fields for an Election are missing. This Election cannot be created.");
          break;
        }

        String[] choices = allLines.subList(i + 1, i + Integer.parseInt(split[10]) + 1)
            .toArray(new String[Integer.parseInt(split[10])]);

        try {
          listElection.add(DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(split[0],
              split[9], Integer.parseInt(split[1]), Integer.parseInt(split[2]),
              Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]),
              Integer.parseInt(split[6]), split[7], split[8], choices));

        } catch (Exception e) {
          System.out.println("One of the variable is invalid" + e);
        }
      }
      return listElection.toArray(new Election[listElection.size()]);
    } catch (NoSuchFileException e) {
      System.err.println("File not found: " + e.getMessage());
      return new Election[0];
    }
  }

  /**
   * 
   * @param filename
   * @param elections
   * @throws IOException
   * @author Maria Hossain
   * 
   *         This method takes in a file and an election array. It will basically match the name of
   *         the election in that array and match it with the matching name and display the result
   *         in an int[][].
   */


  public static void setExistingTallyFromSequentialFile(String filename, Election[] elections)
      throws IOException {


    Path path = Paths.get(filename);

    List<String> allLines = Files.readAllLines(path);

    int numChoice;

    String[] line;

    int[][] result = null;

    for (int i = 0; i < elections.length; i++) {// Going through every Election object

      if (elections[i].equals(null)) {

        System.err.println("This election is not valid ");
        break;
      }
      for (int linePositionElectionList = 0; linePositionElectionList < allLines
          .size(); linePositionElectionList += (numChoice + 1)) { // Going through every line with
                                                                  // election names

        line = allLines.get(linePositionElectionList).split("\\*"); // [nameOfElection][choices]
        numChoice = Integer.parseInt(line[1]); // number of choices for this election

        if (line[0].equals(null)) {

          System.out.print("There is no valid on that election");
        }

        if (line[0].equals(elections[i].getName())) {

          List<String> choices = allLines.subList(linePositionElectionList + 1,
              linePositionElectionList + numChoice + 1);

          result = fillingTally(choices);

        }

      }
      DawsonElectionFactory.DAWSON_ELECTION.setExistingTally(result, elections[i]);
    }

  }



  // **************************************************HELPER
  // METHOD****************************************//

  public static int[][] fillingTally(List<String> choices) {
    int[][] result = new int[choices.size()][choices.size()];

    for (int i = 0; i < result.length; i++) {
      String[] choice = choices.get(i).split("\\*");
      for (int j = 0; j < result.length; j++) {
        result[i][j] = Integer.parseInt(choice[j]);
      }
    }

    return result;
  }

}


