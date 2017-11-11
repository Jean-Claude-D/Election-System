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

public class VoterListDB implements VoterDAO {

  private List<Voter> database;
  private final ListPersistenceObject listPersistenceObject;
  private final ElectionFactory factory;


  public VoterListDB(ListPersistenceObject listPersistenceObject) {

    this.factory = DawsonElectionFactory.DAWSON_ELECTION;
    this.listPersistenceObject = listPersistenceObject;
    this.database = this.listPersistenceObject.getVoterDatabase();
  }

  public VoterListDB(ListPersistenceObject listPersistenceObject, ElectionFactory factory) {

    this.listPersistenceObject = listPersistenceObject;
    this.factory = factory;
    this.database = this.listPersistenceObject.getVoterDatabase();
  }

  public void add(Voter voter) throws DuplicateVoterException {

    Voter instantiateVoter = factory.getVoterInstance(voter);

    if (ListUtilities.binarySearch(database, voter) >= 0) {
      throw new DuplicateVoterException("This voter is already existed in the database");
    }

    for (int i = 0; i < database.size(); i++) {

      if (instantiateVoter.compareTo(database.get(i)) >= 0) {
        database.add(i, instantiateVoter);
      }
    }

  }

  public void disconnect() throws IOException {

  }

  public Voter getVoter(String email) throws InexistentVoterException {

  }

  public void update(Email email, PostalCode postalCode) throws InexistentVoterException {

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
