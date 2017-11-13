package election.data;

import java.io.IOException;
import java.util.List;
import election.business.DawsonElectionFactory;
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
    this(listPersistenceObject, DawsonElectionFactory.DAWSON_ELECTION);
  }

  /**
   * 
   */
  public ElectionListDB(ListPersistenceObject listPersistenceObject, ElectionFactory factory) {
    if (listPersistenceObject == null) {
      throw new IllegalArgumentException("The listPersistenceObject parameter must be non-null");
    } else if (factory == null) {
      throw new IllegalArgumentException("The factory parameter must be non-null");
    }

    this.listPersistenceObject = listPersistenceObject;
    this.factory = factory;
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
