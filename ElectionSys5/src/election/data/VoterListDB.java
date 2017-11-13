package election.data;

import java.io.IOException;
import java.util.List;
import election.business.DawsonElectionFactory;
import election.business.interfaces.ElectionFactory;
import election.business.interfaces.Voter;
import election.data.interfaces.ListPersistenceObject;
import election.data.interfaces.VoterDAO;
import lib.Email;
import lib.PostalCode;
import util.ListUtilities;

/**
 * VoterListDB creates a database of Voter that is read from a .txt file, This include using:
 * listPersistenceObject: Interface that defines all behaviour required by a class that loads from
 * disk -- Factory: Instantiate an Election -- Database: List of all Voter
 * 
 * @author Cao Hoang and Felicia
 * @version 1.1.0.1
 */
public class VoterListDB implements VoterDAO {

  private List<Voter> database;
  private final ListPersistenceObject listPersistenceObject;
  private final ElectionFactory factory;


  /**
   * This constructor is used when you want to use the default factory
   * 
   * @param listPersistenceObject define the interface that is used to read the file
   */
  public VoterListDB(ListPersistenceObject listPersistenceObject) {

    this.factory = DawsonElectionFactory.DAWSON_ELECTION;
    this.listPersistenceObject = listPersistenceObject;
    this.database = this.listPersistenceObject.getVoterDatabase();
  }

  /**
   * This constructor is used when you want to use a custom factory to create elections from the
   * database
   * 
   * @param listPersistenceObject define the interface that is used to read the file
   * @param factory the Election that you want to be instantiate according to database.
   */
  public VoterListDB(ListPersistenceObject listPersistenceObject, ElectionFactory factory) {

    this.listPersistenceObject = listPersistenceObject;
    this.factory = factory;
    this.database = this.listPersistenceObject.getVoterDatabase();
  }

  /**
   * This method will take a Voter, check if the Voter is in the database or not. If it is, it
   * throws a DuplicateVoterException. If not it adds the Voter into the correct place in the
   * database (in a sorted order)
   * 
   * @param voter The Voter Object that we want to put inside the database.
   * @exception DuplicateVoterException
   */
  public void add(Voter voter) throws DuplicateVoterException {

    Voter instantiateVoter = factory.getVoterInstance(voter);

    if (ListUtilities.binarySearch(database, voter) >= 0) {
      throw new DuplicateVoterException("This voter is already existed in the database");
    }

    for (int i = 0; i < database.size(); i++) {

      if (instantiateVoter.compareTo(database.get(i)) <= 0) {
        database.add(i, instantiateVoter);
        return;
      }
    }
    database.add(instantiateVoter);
  }

  public void disconnect() throws IOException {

  }

  public Voter getVoter(String email) throws InexistentVoterException {
    return null;
  }

  public void update(Email email, PostalCode postalCode) throws IllegalArgumentException {

  }

  @Override
  public String toString() {

    StringBuilder voterDatabase =
        new StringBuilder("Number of voters in database: " + this.database.size() + "\n");

    for (int i = 0; i < this.database.size(); i++) {
      voterDatabase.append(database.get(i).getEmail() + "*"
          + database.get(i).getName().getFirstName() + "*" + database.get(i).getName().getLastName()
          + "*" + database.get(i).getPostalCode() + "\n");
    }
    return voterDatabase.toString();
  }


}
