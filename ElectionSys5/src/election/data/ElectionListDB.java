package election.data;

import java.io.IOException;
import java.util.List;
import election.business.DawsonElectionFactory;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
// import election.data.interfaces.DuplicateElectionException;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.ListPersistenceObject;
import util.ListUtilities;
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

    this.database = listPersistenceObject.getElectionDatabase();
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
    if(ListUtilities.binarySearch(this.database, election) >= 0) {
      throw new
    }
    
  }

  /**
   * 
   */
  @Override
  public Election getElection(String name) /* throws InexistentElectionException */ {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String toString() {
    StringBuilder result =
        new StringBuilder("Number of elections in database: " + this.database.size());

    for (Election e : this.database) {
      String eStr = e.toString();
      result.append("\n" + eStr.substring(0, eStr.indexOf('\n')));
    }

    return result.toString();
  }

}
