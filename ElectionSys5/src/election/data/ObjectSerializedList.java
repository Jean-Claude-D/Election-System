package election.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.Tally;
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
  private final String tallySerFilename;

  /**
   * Constructs a new <code>ObjectSerializedList</code> from 3 <code>String</code> specifying the
   * path files of serialized <code>List<Voter></code>, <code>List<Election></code> and
   * <code>List<Tally></code>.
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
   * Gets a <code>List<Voter></code> from the file located at <code>this</code>
   * <code>ObjectSerialized</code>'s <code>voterSerFilename</code>.
   * 
   * @return the deserialized <code>List<Voter></code> at <code>this</code>
   *         <code>ObjectSerialized</code>'s <code>voterSerFilename</code>
   */
  @Override
  public List<Voter> getVoterDatabase() {
    Voter[] voters;

    try {
      voters = (Voter[]) Utilities.deserializeObject(this.voterSerFilename);
    } catch (IOException | ClassNotFoundException e) {
      return new ArrayList<Voter>();
    }

    return Arrays.asList(voters);
  }

  /**
   * Gets a <code>List<Election></code> from the file located at <code>this</code>
   * <code>ObjectSerialized</code>'s <code>electionSerFilename</code>. Associates the
   * <code>Tally</code> objects from <code>this</code> <code>ObjectSerialized</code>'s
   * <code>tallySerFilename</code> to the <code>Election</code> objects.
   * 
   * @return the deserialized <code>List<Election></code> at <code>this</code>
   *         <code>ObjectSerialized</code>'s <code>electionSerList</code>
   */
  @Override
  public List<Election> getElectionDatabase() {
    Election[] elections;
    Tally[] tallies;


    try {
      elections = (Election[]) Utilities.deserializeObject(this.electionSerFilename);
      tallies = (Tally[]) Utilities.deserializeObject(this.tallySerFilename);
    } catch (IOException | ClassNotFoundException e) {
      return new ArrayList<Election>();
    }

    if (elections.length == tallies.length) {
      for (int i = 0; i < elections.length; i++) {
        elections[i].setTally(tallies[i]);
      }
    }

    return Arrays.asList(elections);
  }

  /**
   * Serializes the <code>voters</code> parameter into <code>this</code>
   * <code>ObjectSerialized</code>'s <code>voterSerFilename</code>.
   * 
   * @param elections the <code>List<Voter></code> to be serialized
   */
  @Override
  public void saveVoterDatabase(List<Voter> voters) throws IOException {
    Voter[] voterArray = voters.toArray(new Voter[voters.size()]);
    Utilities.serializeObject(voterArray, this.voterSerFilename);
  }

  /**
   * Serializes the <code>elections</code> parameter into <code>this</code>
   * <code>ObjectSerialized</code>'s <code>electionSerFilename</code>. Serializes the
   * <code>Tally</code> objects associated to the <code>elections</code> parameter into
   * <code>this</code> <code>ObjectSerialized</code>'s <code>tallySerFilename</code>.
   * 
   * @param elections the <code>List<Election></code> to be serialized
   */
  @Override
  public void saveElectionDatabase(List<Election> elections) throws IOException {
    Election[] electionArray = elections.toArray(new Election[elections.size()]);
    Utilities.serializeObject(electionArray, this.electionSerFilename);

    Tally[] tallies = new Tally[electionArray.length];
    for (int i = 0; i < tallies.length; i++) {
      tallies[i] = electionArray[i].getTally();
    }
    Utilities.serializeObject(tallies, this.tallySerFilename);
  }

}
