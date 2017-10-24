package election.data;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import util.ListUtilities;

public class SortMergeApp {

  private Path path = new Path("\\ElectionSys\\ElectionSys5\\datafiles");

  /*
   * load(read) 9 voter files and sort and put in new file datafiles\sorted\sorteVotersX where X is
   * the number of the voter file
   */
  public static void sortVoters() {
    Paths.get(path);
  }


  /*
   * merge them together (first merges with 2 to make "Total", total merges with 3 and updates
   * total, total merges with 4, etc. Total now contains the 4 first voters place the final result
   * in datafiles\database\voters.txt duplicate voters must be stored in
   * datafiles\database\duplicatevoters.txt
   */
  public static void mergeVoters(Path sortedVorters) {

  }


  public static void sortElection() {

    // Created a path to which the Election Files will be called
    Path p = Paths.get(path);

    // Turned this list into a arrayList
    List<String> election = Files.readAllLines(p);


    // Turned the list into an Array of size election.size
    String[] electionToArray = election.toArray(new String[election.size()]);

    // Called the sort methods onto the array
    ListUtilities.sort(electionToArray);

  }


  /*
   * 
   */


}

