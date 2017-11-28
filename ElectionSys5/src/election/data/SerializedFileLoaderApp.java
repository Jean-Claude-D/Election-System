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
    List<Election> electionList = lists.getElectionDatabase();



    String voterSer = "datafiles/database/voters.ser";
    String electionSer = "datafiles/database/elections.ser";

    try {
      Utilities.serializeObject(voterList, voterSer);
      List<Voter> voterList1 = (List<Voter>) Utilities.deserializeObject(voterSer);

      for (int i = 0; i < voterList.size(); i++) {

        if (!voterList.get(i).equals(voterList1.get(i))) {
          System.out.println("fail for voter");
        }
      }
    } catch (IOException | ClassNotFoundException e) {


      e.printStackTrace();
    }

    try {
      Utilities.serializeObject(electionList, electionSer);
      @SuppressWarnings("unchecked")
      List<Election> electionList1 = (List<Election>) Utilities.deserializeObject(electionSer);

      for (int i = 0; i < electionList.size(); i++) {

        if (!electionList.get(i).equals(electionList1.get(i))) {
          System.out.println("fail for election");
        }
      }

    } catch (IOException | ClassNotFoundException e) {


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
