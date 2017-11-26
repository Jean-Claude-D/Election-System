package election.data;

import java.io.IOException;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import util.Utilities;

public class SerializedFileLoaderApp {

  public static void main(String[] args) {

    String voter = "datafiles/databse/voters.txt";
    String election = "datafiles/databse/elections.txt";
    String tally = "datafiles/databse/tally.txt";

    SequentialTextFileList lists = new SequentialTextFileList(voter, election, tally);

    List<Voter> voterList = lists.getVoterDatabase();
    List<Election> electionList = lists.getElectionDatabase();

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

  }

}
