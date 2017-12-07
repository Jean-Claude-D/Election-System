package election.business;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import election.business.interfaces.Ballot;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
import election.business.interfaces.ElectionOffice;
import election.business.interfaces.Voter;
import election.data.DuplicateElectionException;
import election.data.DuplicateVoterException;
import election.data.InexistentElectionException;
import election.data.InexistentVoterException;
import election.data.SequentialTextFileList;
import election.data.VoterListDB;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.VoterDAO;

/**
 * Provides a unified 'Facade' between the UI and business classes. Allows the election
 * administrators to query the system about voters and elections, ensuring that all business rules
 * are respected for the particular election.
 * 
 * @author DesJC
 */
public class DawsonElectionOffice extends Observable implements ElectionOffice {

  private final ElectionFactory factory;
  private final ElectionDAO elections;
  private final VoterDAO voters;
  private static final long serialVersionUID = 42031768871L;

  /**
   * Constructs a new <code>DawsonElectionOffice</code> object with an <code>ElectionFactory</code>,
   * an <code>ElectionDAO</code> and a <code>VoterDAO</code>.
   * 
   * @param factory the consistent way that every business object is going to be instantiated
   * @param elections the consistent way that <code>Election</code> objects are to accessed/saved
   * @param voters the consistent way that <code>Voter</code> objects are to accessed/saved
   */
  public DawsonElectionOffice(ElectionFactory factory, ElectionDAO elections, VoterDAO voters) {
    this.factory = factory;
    this.elections = elections;
    this.voters = voters;
  }

  /**
   * Gets a <code>Ballot</code> object from <code>election</code> for <code>voter</code>.
   * 
   * @param voter the <code>Voter</code> requesting a <code>Ballot</code>
   * @param election the <code>Election</code> in which <code>voter</code> requests a
   *        <code>Ballot</code>
   * @throws InvalidVoterException if <code>voter</code> is not eligible to vote in
   *         <code>election</code>
   * @return the <code>Ballot</code> object from <code>election</code> for <code>voter</code>
   */
  @Override
  public Ballot getBallot(Voter voter, Election election) throws InvalidVoterException {
    return election.getBallot(voter);
  }

  /**
   * Casts the given <code>b</code>
   * 
   * @param voter the <code>Voter</code> who wants to cast <code>b</code>
   * @param b the <code>Ballot</code> to be casted by <code>voter</code>
   */
  @Override
  public void castBallot(Voter voter, Ballot b) {
    b.cast(voter);
  }

  /**
   * Disconnects <code>this</code> <code>DawsonElectionOffice</code>'s <code>elections</code> and
   * <code>voters</code>. Saves all their content to files.
   * 
   * @throws IOException if there is a problem in closing the files <code>elections</code> and
   *         <code>voters</code> are linked to
   */
  @Override
  public void closeOffice() throws IOException {
    this.elections.disconnect();
    this.voters.disconnect();
  }

  /**
   * Creates a new <code>Election</code> object. Adds it to <code>this</code>
   * <code>DawsonElectionOffice</code>'s <code>elections</code> if it was successfully created.
   * 
   * @param name
   * @param type
   * @param startYear
   * @param startMonth
   * @param startDay
   * @param endYear
   * @param endMonth
   * @param endDay
   * @param startRange the starting postal range
   * @param endRange the ending postal range
   * @param choices
   * @throws DuplicateElectionException if the newly created <code>Election</code> already exists in
   *         <code>this</code> <code>DawsonElectionOffice</code>'s <code>elections</code>
   * @return the newly created <code>Election</code>
   */
  @Override
  public Election createElection(String name, String type, int startYear, int startMonth,
      int startDay, int endYear, int endMonth, int endDay, String startRange, String endRange,
      String... choices) throws DuplicateElectionException {
    Election newElection = this.factory.getElectionInstance(name, type, startYear, startMonth,
        startDay, endYear, endMonth, endDay, startRange, endRange, choices);
    this.elections.add(newElection);
    return newElection;
  }

  /**
   * Gets the winning choice(s) of <code>election</code>.
   * 
   * @param election
   * @throws IncompleteElectionException if <code>election</code> is not yet finished
   * @return a <code>List<String></code> representing the winner(s) choice(s)
   */
  @Override
  public List<String> getWinner(Election election) {
    return this.factory.getElectionPolicy(election).getWinner();
  }

  /**
   * Creates a new <code>Voter</code> object. Adds it to <code>this</code>
   * <code>DawsonElectionOffice</code>'s <code>voters</code> if it was successfully created.
   * 
   * @param firstName
   * @param lastName
   * @param email
   * @param postalcode
   * @throws DuplicateElectionException if the newly created <code>Election</code> already exists in
   *         <code>this</code> <code>DawsonElectionOffice</code>'s <code>elections</code>
   * @return the newly created <code>Election</code>
   */
  @Override
  public Voter registerVoter(String firstName, String lastName, String email, String postalcode)
      throws DuplicateVoterException {
    Voter newVoter = this.factory.getVoterInstance(firstName, lastName, email, postalcode);
    this.voters.add(newVoter);
    return newVoter;
  }

  /**
   * Gets the <code>Election</code> with name <code>name</code> in <code>this</code>
   * <code>DawsonElectionOffice</code>'s <code>elections</code>.
   * 
   * @param name of the <code>Election</code> to be found
   * @return the found <code>Election</code>
   * @throws InexistentElectionException if an <code>Election</code> with that name cannot be found
   */
  @Override
  public Election findElection(String name) throws InexistentElectionException {
    Election found = this.elections.getElection(name);
    return found;
  }

  /**
   * Gets the <code>Voter</code> with an email <code>email</code> in <code>this</code>
   * <code>DawsonElectionOffice</code>'s <code>voters</code>.
   * 
   * @param email of the <code>Voter</code> to be found
   * @return the found <code>Voter</code>
   * @throws InexistentVoterException if a <code>Voter</code> with that email cannot be found
   */
  @Override
  public Voter findVoter(String email) throws InexistentVoterException {
    Voter found = this.voters.getVoter(email);
    return found;
  }

  @Override
  /**
   * Finds a voter with a given email
   * 
   * @author Felicia Gorgatchov
   * 
   * @param email of the voter
   * @param notify observers if true
   * @return
   * @throws InexistentVoterException
   */
  public Voter findVoter(String email, boolean notify) throws InexistentVoterException {

    /*
     * take email and look for it through a VoterListDB
     * 
     * if the voter is found and notify is true, notify the observers and return the voter if the
     * voter is found and notify is set to false, return the voter only
     * 
     * if the voter is not found and notify is true, notify the observers and throw exception if the
     * voter is not found and notify is false, throw an exception only
     */

    SequentialTextFileList textFile =
        new SequentialTextFileList("voters.txt", "elections.txt", "tally.txt");
    VoterListDB voterList = new VoterListDB(textFile);

    try {
      Voter voter = voterList.getVoter(email);

      if (notify == true) {
        notifyObservers();
        return voter;
      } else {
        return voter;
      }
    } catch (InexistentVoterException ive) {
      if (notify == true) {
        notifyObservers();
        System.out.println(
            "No voter was found with the given email. Please register, or verify the provided email.");
      } else {
        System.out.println(
            "No voter was found with the given email. Please register, or verify the provided email.");
      }
    }

    return null;
  }



}


