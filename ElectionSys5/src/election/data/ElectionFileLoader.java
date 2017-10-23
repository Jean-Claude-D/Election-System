package election.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    return null;

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

          String[] arrayOfLineInTxtFile = electionList.get(i).split("*");

          for (int w = 0; w < arrayOfLineInTxtFile.length; w++) {

            String choice = arrayOfLineInTxtFile[w + 1];
            int choiceInt = Integer.parseInt(choice);
            linePositionElectionList = choiceInt + linePositionElectionList;

            if (arrayOfLineInTxtFile[w].equals(elections[i])) {


              int[][] result = new int[choiceInt][];

              for (int b = 0; 0 < choiceInt; b++) {

                String[] tally = electionList.get(linePositionElectionList + 1).split("*");

                for (int a = 0; a < tally.length; a++) {


                  int Tally = Integer.parseInt(tally[a]);
                  result[b][a] = Tally;

                }
              }


            }

          }

        }



      }
    }
  }
}


