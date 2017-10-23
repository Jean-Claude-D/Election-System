package election.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
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

//  public static Election[] getElectionListFromSequentialFile(String filename) throws IOException {
//
//    Path p = Paths.get(filename);
//    List<String> temp = Files.readAllLines(p);
//    List<String> electionList = new ArrayList<String>();
//
//    BufferedReader reader = new BufferedReader(new FileReader(filename));
//    int lines = 0;
//    while (reader.readLine() != null)
//      lines++;
//    reader.close();
//
//    int i = 0;
//
//    while (i < lines) {
//      electionList.add(temp.get(i).split("\\*"));
//    }
//
//  }
  
//public static Election[] getElectionListFromSequentialFile(String filename) throws IOException {
//try {
//  Path p = Paths.get(filename);
//  List<String> temp = Files.readAllLines(p);
//  List<Election> electionList = new ArrayList<Election>();
//
//  for (int i = 0; i <temp.size(); i++) {
//      Optional<Election> electionTemp1= parseFields(temp.get(i).split("\\*"));
//      Optional<Election> electionTemp2 = parseFields(temp.get(i).split("\\r?\\n"));
//      if (electionTemp1.isPresent()) {
//          electionList(i) = electionTemp1[i].
//      }
//      if (electionTemp2.isPresent()) {
//          electionList(i) = electionTemp2[i].
//      }
//  }
//  Election[] finalList = new Election[electionList.length();
//  return finalList = electionList.toAray(finalList);
//}
//catch (NoSuchFileException e) {
//  System.err.println("File not found: " +  e.getMessage());
//  return new Election[];
//}




  public static Election[] getElectionListFromSequentialFile(String filename) throws IOException {


    Path p = Paths.get(filename);
    List<String> allLines = Files.readAllLines(p);
    ArrayList<Election> list = new ArrayList<Election>();
    String[] tactical = (allLines.get(0).split("\\*"));
    
    ArrayList<String> tacticalList = new ArrayList<String>();
    
    for (int i = 0; i < tactical.length; i++) {
      tacticalList.add(tactical[i]);
      //System.out.print(tactical[i]);

    }

    for (int i = 1; i - 1 < Integer.parseInt(tactical[10]); i++) {
      tacticalList.add(allLines.get(i));
      //System.out.println(allLines.get(i));
    }
    
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

    }



  }
}
