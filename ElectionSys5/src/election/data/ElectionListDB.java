package election.data;

import java.io.IOException;
import election.business.interfaces.Election;
// import election.data.interfaces.DuplicateElectionException;
import election.data.interfaces.ElectionDAO;
// import election.data.interfaces.InexistentElectionException;

public class ElectionListDB implements ElectionDAO {

  public ElectionListDB() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void disconnect() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public void add(Election election)/* throws DuplicateElectionException */ {
    // TODO Auto-generated method stub

  }

  @Override
  public Election getElection(String name) /* throws InexistentElectionException */ {
    // TODO Auto-generated method stub
    return null;
  }

}
