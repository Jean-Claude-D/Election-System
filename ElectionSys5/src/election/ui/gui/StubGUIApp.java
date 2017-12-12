package election.ui.gui;

import election.business.DawsonElectionFactory;
import election.business.DawsonElectionOffice;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
import election.data.ElectionListDB;
import election.data.InexistentElectionException;
import election.data.SequentialTextFileList;
import election.data.VoterListDB;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.VoterDAO;

public class StubGUIApp {
  public static void main(String[] args) throws InexistentElectionException {
    ElectionFactory factory = DawsonElectionFactory.DAWSON_ELECTION;
    VoterDAO voterDb = new VoterListDB(new SequentialTextFileList("datafiles/database/voters.txt",
        "datafiles/database/elections.txt", "datafiles/database/tally.txt"));
    ElectionDAO electionDb =
        new ElectionListDB(new SequentialTextFileList("datafiles/database/voters.txt",
            "datafiles/database/elections.txt", "datafiles/database/tally.txt"));
    Election e = electionDb.getElection("Brittany independence referendum");
    DawsonElectionOffice model = new DawsonElectionOffice(factory, electionDb, voterDb);

    election.ui.gui.MainApp.initContext(model, e);
    javafx.application.Application.launch(election.ui.gui.MainApp.class);
  }
}
