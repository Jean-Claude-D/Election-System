package election.data;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import util.ListUtilities;

public class SortMergeApp {

  public static void main(String[] args) {

    System.out.println(
        "Fetching voter and election files from ElectionSys\\ElectionSys5\\datafiles\\unsorted");

    System.out.println("\n\t1. Create a new directory called sorted in the datafiles directory");

    new File("ElectionSys\\ElectionSys5\\datafiles\\sorted").mkdir();

    System.out.println(
        "\n\t2. Sort all the files, place the result in new files, and place those result files in the new sorted directory");



  }


  /**
   * This method creates a File object that contains all the files from the unsorted directory and
   * stores their name in a String array In a for loop that goes through all the names in the array:
   * check if the name contains "voters" if it does, modify the path so it includes the text file's
   * name and verify if it exists if it exists, read and place all the lines in an array sort that
   * array and place the sorted array in a new file using savelistToTextFile(array,fileName)
   * 
   * if it doesn't contain "voters", see if it contains "elections" repeat the same steps
   * 
   * @author Felicia Gorgatchov
   * @throws IOException
   * 
   */

  public static void sortAndStore() throws IOException {

    String path = "/ElectionSys/ElectionSys5/datafiles/unsorted";
    List<String> unsortedArray = new ArrayList<>();

    File files = new File(path);
    String[] listOfFiles = files.list();

    for (int i = 0; i < listOfFiles.length; i++) {
      // check if file name contains "voters"
      if (listOfFiles[i].matches("voters.\\.txt")) {
        path = path + "/voters" + i + ".txt";
        File voterFile = new File(path);
        if (voterFile.exists()) {
          Path p = Paths.get(path);
          unsortedArray = Files.readAllLines(p);
          String[] sortedArray = unsortedArray.toArray(new String[unsortedArray.size()]);
          ListUtilities.sort(sortedArray);
          ListUtilities.saveListToTextFile(sortedArray, "sortedVoters" + i + ".txt");
        }
      } else if (listOfFiles[i].matches("elections.\\.txt")) {
        path = path + "/elections" + i + ".txt";
        File electionFile = new File(path);
        if (electionFile.exists()) {
          Path p = Paths.get(path);
          unsortedArray = Files.readAllLines(p);
          String[] sortedArray = unsortedArray.toArray(new String[unsortedArray.size()]);
          ListUtilities.sort(sortedArray);
          ListUtilities.saveListToTextFile(sortedArray, "sortedElections" + i + ".txt");
        }

      }
    }

  }// end sort and store


  /*
   * merge them together (first merges with 2 to make "Total", total merges with 3 and updates
   * total, total merges with 4, etc. Total now contains the 4 first voters place the final result
   * in datafiles\database\voters.txt duplicate voters must be stored in
   * datafiles\database\duplicatevoters.txt
   */
  public static void mergeAll() throws IOException {

    String path = "datafiles/sorted";
    List<Election[]> superSaiyanArrayOfElection = new ArrayList<Election[]>();
    Election[] resultElection = new Election[1];
    List<Voter[]> superSaiyanArrayOfVoter = new ArrayList<Voter[]>();
    Voter[] resultVoter = new Voter[1];

    File files = new File(path);
    String[] listOfFiles = files.list();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].matches("voters.\\.txt")) {
        String path2 = path + "/voters" + i + ".txt";
        File voterFile = new File(path);
        if (voterFile.exists()) {
          Path p = Paths.get(path);
          superSaiyanArrayOfVoter.add(ElectionFileLoader.GetVoterListFromSequentialFile(path2));
        }
      } else if (listOfFiles[i].matches("elections.\\.txt")) {
        String path2 = path + "/elections" + i + ".txt";
        File electionFile = new File(path);
        if (electionFile.exists()) {
          Path p = Paths.get(path);
          superSaiyanArrayOfElection
              .add(ElectionFileLoader.getElectionListFromSequentialFile(path2));
        }
      }
    }

    for (int i = 0; i < superSaiyanArrayOfElection.size(); i++) {
      ListUtilities.merge(resultElection, superSaiyanArrayOfElection.get(i),
          "datafiles/duplicates/duplicate.txt");
    }

    for (int i = 0; i < superSaiyanArrayOfVoter.size(); i++) {
      ListUtilities.merge(resultVoter, superSaiyanArrayOfVoter.get(i),
          "datafiles/duplicates/duplicate.txt");
    }

    ListUtilities.saveListToTextFile(resultElection, "datafiles/database/elections.txt", false);

    ListUtilities.saveListToTextFile(resultVoter, "datafiles/database/elections.txt", false);


  }// end merge all method


  // Tally method

}// end class

