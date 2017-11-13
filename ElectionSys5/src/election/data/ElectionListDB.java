package election.data;

import java.io.IOException;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
// import election.data.interfaces.DuplicateElectionException;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.ListPersistenceObject;
// import election.data.interfaces.InexistentElectionException;

/**
 * 
 * @author DesJC
 *
 */
public class ElectionListDB implements ElectionDAO {

  private List<Election> database;
  private final ListPersistenceObject listPersistenceObject;
  private final ElectionFactory factory;

  /**
   * 
   */
  public ElectionListDB(ListPersistenceObject listPersistenceObject) {
    // TODO Auto-generated constructor stub
  }

  /**
   * 
   */
  public ElectionListDB(ListPersistenceObject listPersistenceObject, ElectionFactory factory) {
    // TODO Auto-generated constructor stub
  }

  /**
   * 
   */
  @Override
  public void disconnect() throws IOException {
    // TODO Auto-generated method stub

  }

  /**
   * 
   */
  @Override
  public void add(Election election)/* throws DuplicateElectionException */ {
    // TODO Auto-generated method stub

  }

  /**
   * 
   */
  @Override
  public Election getElection(String name) /* throws InexistentElectionException */ {
    // TODO Auto-generated method stub
    return null;
  }

}
