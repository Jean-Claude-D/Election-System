package election.data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
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
  public static Voter[] GetVoterListFromSequentialFile(String filename) throws IOException {
    if (filename == null || filename.isEmpty()) {
      throw new InvalidPathException("", "Path is null or empty");
    }

    Path pathToVoterFile = Paths.get(filename);

    List<String> fileVoters = Files.readAllLines(pathToVoterFile, StandardCharsets.UTF_8);

    List<Voter> voters = new ArrayList<Voter>();

    Optional<Voter> voter;

    for (int i = 0; i < fileVoters.size(); i++) {
      String[] tempVoter = fileVoters.get(i).split("\\*");

      try {
        // No need to use ofNullable, since exception would've been thrown
        voter = Optional.of(DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance(tempVoter[1],
            tempVoter[2], tempVoter[0], tempVoter[3]));

        // No need to verify Voter is present, since exception would've been thrown
        voters.add(voter.get());
      }
      // Voter not created because either firstname/lastname/email/pcode was invalid
      catch (IllegalArgumentException e) {
        System.err.println("Could not create [" + tempVoter[1] + ',' + tempVoter[2] + "] on line #"
            + (i + 1) + " because of : " + e.getMessage());
      }
    }
    ((ArrayList<Voter>) voters).trimToSize();

    return voters.toArray(new Voter[voters.size()]);
  }

  /**
   * 
   * @param filename
   * @return Election[]
   * @throws IOException
   * 
   *         This method iterate through the text file and extract the different elections and will
   *         put it into a an array of Elections
   */

  public static Election[] getElectionListFromSequentialFile(String filename) throws IOException {


    return null;
  }

  /**
   * 
   * @param filename
   * @param elections
   * @throws IOException
   * 
   *         This method takes in a file and an election array. It will basically match the name of
   *         the election in that array and match it with the matching name and display the result
   *         in an int[][].
   */


  public static void setExistingTallyFromSequentialFile(String filename, Election[] elections)
      throws IOException {
    {

      Path p = Paths.get(filename);

      List<String> electionList = Files.readAllLines(p);

      int linePositionElectionList = 0;

      for (int i = 0; i < elections.length; i++) {


        while (linePositionElectionList < electionList.size()) {

          String[] arrayOfLineInTxtFile = electionList.get(i).split("\\*");

          for (int w = 0; w < arrayOfLineInTxtFile.length; w++) {

            String choice = arrayOfLineInTxtFile[1];
            int choiceInt = Integer.parseInt(choice);


            if (arrayOfLineInTxtFile[w].equals(elections[i].getName())) {


              int[][] result = new int[choiceInt][choiceInt];

              for (int b = 0; b < choiceInt; b++) {

                String[] tally = electionList.get(linePositionElectionList + 1).split("\\*");

                for (int a = 0; a < tally.length; a++) {


                  int Tally = Integer.parseInt(tally[a]);
                  result[b][a] = Tally;

                }

              }

              DawsonElectionFactory.DAWSON_ELECTION.setExistingTally(result, elections[i]);
              linePositionElectionList = choiceInt + linePositionElectionList;
            }

          }

        }
      }
    }
  }
}


