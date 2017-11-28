package election.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import election.data.interfaces.ListPersistenceObject;
import util.Utilities;

/**
 * Provides a unified way of interacting with serialized files of <code>List<Voter></code> and
 * <code>List<Voter></code>.
 * 
 * @author DesJC
 *
 */
public class ObjectSerializedList implements ListPersistenceObject {

  private final String voterSerFilename;
  private final String electionSerFilename;

  /**
   * Constructs a new <code>ObjectSerializedList</code> from 3 <code>String</code> specifying the
   * path files of serialized <code>List<Voter></code> and <code>List<Election></code>.
   * 
   * @param voterSerFilename
   * @param electionSerFilename
   */
  public ObjectSerializedList(String voterSerFilename, String electionSerFilename) {
    this.voterSerFilename = voterSerFilename;
    this.electionSerFilename = electionSerFilename;
  }

  /**
   * Gets a <code>List<Voter></code> from the file located at <code>this</code>
   * <code>ObjectSerialized</code>'s <code>voterSerFilename</code>.
   * 
   * @return the deserialized <code>List<Voter></code> at <code>this</code>
   *         <code>ObjectSerialized</code>'s <code>voterSerFilename</code>
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Voter> getVoterDatabase() {
    List<Voter> voters;

    try {
      voters = (List<Voter>) Utilities.deserializeObject(this.voterSerFilename);
    } catch (IOException | ClassNotFoundException e) {
      return new ArrayList<Voter>();
    }

    return voters;
  }

  /**
   * Gets a <code>List<Election></code> from the file located at <code>this</code>
   * <code>ObjectSerialized</code>'s <code>electionSerFilename</code>.
   * 
   * @return the deserialized <code>List<Election></code> at <code>this</code>
   *         <code>ObjectSerialized</code>'s <code>electionSerList</code>
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Election> getElectionDatabase() {
    List<Election> elections;


    try {
      elections = (List<Election>) Utilities.deserializeObject(this.electionSerFilename);
    } catch (IOException | ClassNotFoundException e) {
      return new ArrayList<Election>();
    }

    return elections;
  }

  /**
   * Serializes the <code>voters</code> parameter into <code>this</code>
   * <code>ObjectSerialized</code>'s <code>voterSerFilename</code>.
   * 
   * @param elections the <code>List<Voter></code> to be serialized
   */
  @Override
  public void saveVoterDatabase(List<Voter> voters) throws IOException {
    Utilities.serializeObject(voters, this.voterSerFilename);
  }

  /**
   * Serializes the <code>elections</code> parameter into <code>this</code>
   * <code>ObjectSerialized</code>'s <code>electionSerFilename</code>.
   * 
   * @param elections the <code>List<Election></code> to be serialized
   */
  @Override
  public void saveElectionDatabase(List<Election> elections) throws IOException {
    Utilities.serializeObject(elections, this.electionSerFilename);
  }

}
