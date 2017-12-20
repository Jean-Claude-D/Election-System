package election.ui.tui;

import election.business.DawsonElectionFactory;
import election.business.DawsonElectionOffice;
import election.business.interfaces.ElectionFactory;
import election.data.DuplicateVoterException;
import election.data.ElectionListDB;
import election.data.InexistentElectionException;
import election.data.InexistentVoterException;
import election.data.ObjectSerializedList;
import election.data.VoterListDB;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.VoterDAO;

/**
 * Main application for the Text-based user interface
 * 
 * @author Jaya, Maja
 */
public class TextApp {
  public static void main(String[] args)
      throws InexistentVoterException, DuplicateVoterException, InexistentElectionException {
    ElectionFactory factory = DawsonElectionFactory.DAWSON_ELECTION;
    VoterDAO voterDb = new VoterListDB(new ObjectSerializedList("datafiles/database/voters.ser",
        "datafiles/database/elections.ser"));
    ElectionDAO electionDb =
        new ElectionListDB(new ObjectSerializedList("datafiles/database/voters.ser",
            "datafiles/database/elections.ser"));

    DawsonElectionOffice model = new DawsonElectionOffice(factory, electionDb, voterDb);
    TextView view = new TextView(model);
    TextController controller = new TextController(model);
    controller.run();
  }
}
