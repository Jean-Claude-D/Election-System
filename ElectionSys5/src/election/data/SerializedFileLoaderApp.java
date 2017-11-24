package election.data;


import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;

public class SerializedFileLoaderApp {

  public static void main(String[] args) {

    String voter = "datafiles/databse/voters.txt";
    String election = "datafiles/databse/elections.txt";
    String tally = "datafiles/databse/tally.txt";

    SequentialTextFileList lists = new SequentialTextFileList(voter, election, tally);

    List<Voter> voterList = lists.getVoterDatabase();
    List<Election> electionList = lists.getElectionDatabase();
    
    Utilities.serialize(voterList, String "datafiles/database/voters.ser");
    Utilities.serialize(electionList, String "datafiles/database/elections.ser");

  }

}
