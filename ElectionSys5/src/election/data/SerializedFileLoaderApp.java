package election.data;

<<<<<<< HEAD
import java.io.IOException;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import util.Utilities;
=======
import java.io.Serializable;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
>>>>>>> df1fe591d871a8c10b4bb5058312265220d84476

public class SerializedFileLoaderApp {

  public static void main(String[] args) {

    String voter = "datafiles/databse/voters.txt";
    String election = "datafiles/databse/elections.txt";
    String tally = "datafiles/databse/tally.txt";

    SequentialTextFileList lists = new SequentialTextFileList(voter, election, tally);

    List<Voter> voterList = lists.getVoterDatabase();
    List<Election> electionList = lists.getElectionDatabase();
<<<<<<< HEAD

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
=======
    
    Utilities.serialize(voterList, String "datafiles/database/voters.ser");
    Utilities.serialize(electionList, String "datafiles/database/elections.ser");
>>>>>>> df1fe591d871a8c10b4bb5058312265220d84476

  }

}
