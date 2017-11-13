package election.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import election.business.DawsonElectionFactory;
import election.business.interfaces.ElectionFactory;
import election.business.interfaces.Voter;
import election.data.interfaces.InexistentVoterException;
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

  }

  public void disconnect() throws IOException {

  }

  /**
   * Takes an email string and looks for it in the voter database. If a match is found it returns the voter who's email it belongs to.
   * If no match found, it throws an InexistentVoterException.
   * 
   * @author Felicia Gorgatchov
   * @return Voter : the reference of the voter who's email belongs to
   * @param email : String email that the maethod will use to look through the database of voters
   */
  public Voter getVoter(String email) throws InexistentVoterException {
    Voter dummy = this.factory.getVoterInstance(null, null, email, null);
    if(ListUtilities.binarySearch(this.database, dummy) < 0) {
      throw new InexistentVoterException();
    }
    else {
      int voterIndex = ListUtilities.binarySearch(this.database, dummy);
      return this.database.get(voterIndex);
    }

  }//end getVoter 



  public void update(Email email, PostalCode postalCode) throws IllegalArgumentException {

  }

  @Override
  public String toString() {

  }
}
