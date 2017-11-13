package election.data;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import election.business.DawsonElectionFactory;
import election.business.DawsonTally;
import election.business.ElectionType;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
import election.business.interfaces.Tally;
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
    this.listPersistenceObject.saveElectionDatabase(this.database);
    this.database = null;
  }

  /**
   * 
   */
  @Override
  public void add(Election election) throws DuplicateElectionException {
    if (ListUtilities.binarySearch(this.database, election) >= 0) {
      throw new DuplicateElectionException(election.toString() + "\nIs already in the database");
    }

    boolean found = false;
    for (int i = 0; i < this.database.size() && !found;) {
      if (election.compareTo(this.database.get(i)) <= 0) {
        this.database.add(i, this.factory.getElectionInstance(election));
        found = true;
      }
    }
  }

  /**
   * 
   */
  @Override
  public Election getElection(String name) /* throws InexistentElectionException */ {
    LocalDate now = LocalDate.now();

    Tally tally = new DawsonTally(0, name);
    Election dummy = this.factory.getElectionInstance(name, ElectionType.SINGLE.toString(),
        now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getYear(), now.getMonthValue(),
        now.getDayOfMonth(), null, null, "1", "2", "3");

    int index = ListUtilities.binarySearch(this.database, dummy);
    if (index < 0) {
      throw new IllegalArgumentException("Election with name \'" + name + "\' was not found");
    }

    return this.factory.getElectionInstance(this.database.get(index));
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
