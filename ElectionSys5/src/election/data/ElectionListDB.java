package election.data;

import java.io.IOException;
import java.time.LocalDateTime;
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
 * VoterListDB creates a database of Election that is read from a .txt file, This include using:
 * listPersistenceObject: Interface that defines all behaviour required by a class that loads from
 * disk -- Factory: Instantiate an Election -- Database: List of all Voter
 * 
 * @author DesJC
 * @version 1.25252
 *
 */
public class ElectionListDB implements ElectionDAO {

  private List<Election> database;
  private final ListPersistenceObject listPersistenceObject;
  private final ElectionFactory factory;

  /**
   * Constructor that will use the default factory to setup the Election
   * 
   * @author DesJC
   * @param listPersistenceObject define the interface that is used to read the file
   */
  public ElectionListDB(ListPersistenceObject listPersistenceObject) {
    this(listPersistenceObject, DawsonElectionFactory.DAWSON_ELECTION);
  }

  /**
   * Constructor that will use the custom factory to setup the Election
   * 
   * @author DesJC
   * @param listPersistenceObject define the interface that is used to read the file
   * @param factory the Election that you want to be instantiate according to database.
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
   * Saves the electionDatabase and assigns the database to null so that no one can add or remove
   * any elections.
   * 
   * @author hoss_m
   * @throws IOException will be thrown if the database is empty.
   * 
   */
  @Override
  public void disconnect() throws IOException {

    listPersistenceObject.saveElectionDatabase(database);
    database = null;
  }

  /**
   * 
   * @author DesJC
   */
  @Override
  public void add(Election election) throws DuplicateElectionException {

    int indexInsertion = ListUtilities.binarySearch(this.database, election);

    if (indexInsertion >= 0) {
      throw new DuplicateElectionException(
          election.toString() + "\nIs already in the " + this.toString());
    }

    this.database.add(-(indexInsertion) - 1, this.factory.getElectionInstance(election));

  }

  /**
   * Take a string which represents the name of an election. It then creates a dummy election with
   * the name of election as the pertinent information. The reason this is done is because the
   * recursive binary method take a list of election and an election as parameters. Once that dummy
   * election is put through the binary method it will return the index of the election in the
   * database if a match is found. If not than it will throw an InexistentElectionException.
   * 
   * Takes a String name of a particular election and will look through the database using the
   * recursive binary search method located in the List Utilities which return the index. Before
   * doing that it will create a dummy Election object with the name as the only pertinent
   * information. The reason we do that is because the Binary Search method only take parameter of
   * the same type. Since our database is of type List<Election>, the key must be an Election as
   * well. Once we find the index, it return the whole election found the in the list of election.
   * If it does not match than it will throw an InexistentElectionException stating that it does not
   * exist and cannot return any Election.
   * 
   * @author hoss_m
   * @param name is a String representation of the name of the election that we will need to find in
   *        the database.
   * @return returns an Election object, once the string that is passed through is matched and found
   *         in the database, it will return the whole election object that matches that String name
   * @throws InexistentElectionException if the election name passed does not exist in the database.
   */
  @Override
  public Election getElection(String name) throws InexistentElectionException {

    String type = "SINGLE";
    int startYear = LocalDateTime.now().getYear();
    int startMonth = LocalDateTime.now().getMonthValue();
    int startDay = LocalDateTime.now().getDayOfMonth();
    int endYear = LocalDateTime.now().getYear() + 1;
    int endMonth = LocalDateTime.now().getMonthValue();
    int endDay = LocalDateTime.now().getDayOfMonth();
    String startRange = null;
    String endRange = null;
    String choice = "A";
    String choice2 = "B";

    Election dummy =
        DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name, type, startYear, startMonth,
            startDay, endYear, endMonth, endDay, startRange, endRange, choice, choice2);


    int index = ListUtilities.binarySearch(database, dummy);

    if (index < 0) {

      throw new InexistentElectionException("This election does not exist.");
    }

    return database.get(index);

  }

  /**
   * Return the Election as a String format: Including how many Election in the database plus the
   * list of all the Election afterward.
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


