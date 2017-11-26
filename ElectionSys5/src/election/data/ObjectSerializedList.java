package election.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import election.data.interfaces.ListPersistenceObject;
import util.Utilities;

/**
 * 
 * @author DesJC
 *
 */
public class ObjectSerializedList implements ListPersistenceObject {

  private final String voterSerFilename;
  private final String electionSerFilename;
  private final String tallySerFilename;

  /**
   * 
   * @param voterSerFilename
   * @param electionSerFilename
   * @param tallySerFilename
   */
  public ObjectSerializedList(String voterSerFilename, String electionSerFilename,
      String tallySerFilename) {
    this.voterSerFilename = voterSerFilename;
    this.electionSerFilename = electionSerFilename;
    this.tallySerFilename = tallySerFilename;
  }

  /**
   * 
   */
  @Override
  public List<Voter> getVoterDatabase() {
    Voter[] voters;

    try {
      voters = (Voter[]) Utilities.deserializeObject(voterSerFilename);
    } catch (IOException | ClassNotFoundException e) {
      return new ArrayList<Voter>();
    }

    return Arrays.asList(voters);
  }

  /**
   * 
   */
  @Override
  public List<Election> getElectionDatabase() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   */
  @Override
  public void saveVoterDatabase(List<Voter> voters) throws IOException {
    // TODO Auto-generated method stub

  }

  /**
   * 
   */
  @Override
  public void saveElectionDatabase(List<Election> elections) throws IOException {
    // TODO Auto-generated method stub

  }

}
