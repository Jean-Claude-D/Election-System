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
   * @author DesJC
   */
  public ElectionListDB(ListPersistenceObject listPersistenceObject) {
    this(listPersistenceObject, DawsonElectionFactory.DAWSON_ELECTION);
  }

  /**
   * 
   * @author DesJC
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
   * @author hoss_m
   */
  @Override
  public void disconnect() throws IOException {
    // TODO implement disconnect()
  }

  /**
   * 
   * @author DesJC
   */
  @Override
  public void add(Election election) throws DuplicateElectionException {
    if (ListUtilities.binarySearch(this.database, election) >= 0) {
      throw new DuplicateElectionException(election.toString() + "\nIs already in the database");
    }

    boolean found = false;
    for (int i = 0; i < this.database.size() && !found; i++) {
      if (election.compareTo(this.database.get(i)) <= 0) {
        System.out
            .println(election.getName() + " is smaller than " + this.database.get(i).getName());
        this.database.add(i, this.factory.getElectionInstance(election));
        found = true;
      }
    }
  }

  /**
   * 
   * @author hoss_m
   */
  @Override
  public Election getElection(String name) /* throws InexistentElectionException */ {
    // TODO implement getElection(Election)
    return null;
  }

  /**
   * 
   * @author DesJC
   */
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


