package election.data;

import java.io.IOException;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import util.Utilities;

public class SerializedFileLoaderApp {

  public static void main(String[] args) {

    String voter = "datafiles/database/voters.txt";
    String election = "datafiles/database/elections.txt";
    String tally = "datafiles/database/tally.txt";

    SequentialTextFileList lists = new SequentialTextFileList(voter, election, tally);

    List<Voter> voterList = lists.getVoterDatabase();
    
    try {
    List<Election> electionList = lists.getElectionDatabase();
    }
    
    catch(Exception e) {
      
      e.S
    }

    String voterSer = "datafiles/database/voters.ser";
    String electionSer = "datafiles/database/elections.ser";

    try {
      Utilities.serializeObject(voterList, voterSer);
    } catch (IOException e) {

      e.printStackTrace();
    }

    try {
      Utilities.serializeObject(electionList, electionSer);
    } catch (IOException e) {

      e.printStackTrace();
    }

    try {
      Utilities.deserializeObject(voterSer);
    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }

    try {
      Utilities.deserializeObject(electionSer);

    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }


  }

}
