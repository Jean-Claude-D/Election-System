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
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.VoterDAO;

public class DawsonElectionOffice extends Observable implements ElectionOffice {

  private final ElectionFactory factory;
  private final ElectionDAO elections;
  private final VoterDAO voters;
  private static final long serialVersionUID = 42031768871L;


  public DawsonElectionOffice(ElectionFactory factory, ElectionDAO elections, VoterDAO voters) {
    this.factory = factory;
    this.elections = elections;
    this.voters = voters;
  }

  @Override
  public Ballot getBallot(Voter voter, Election election) throws InvalidVoterException {
    return election.getBallot(voter);
  }

  @Override
  public void castBallot(Voter voter, Ballot b) {
    b.cast(voter);
  }

  @Override
  public void closeOffice() throws IOException {
    this.elections.disconnect();
    this.voters.disconnect();
  }

  @Override
  public Election createElection(String name, String type, int startYear, int startMonth,
      int startDay, int endYear, int endMonth, int endDay, String startRange, String endRange,
      String... choices) throws DuplicateElectionException {
    Election newElection = this.factory.getElectionInstance(name, type, startYear, startMonth,
        startDay, endYear, endMonth, endDay, startRange, endRange, choices);
    this.elections.add(newElection);
    return newElection;
  }

  @Override
  public List<String> getWinner(Election election) {
    // Need ElectionFactory's getElectionPolicy
    // return this.factory.getElectionPolicy(election).getWinner();
    return null;
  }

  @Override
  public Voter registerVoter(String firstName, String lastName, String email, String postalcode)
      throws DuplicateVoterException {
    Voter newVoter = this.factory.getVoterInstance(firstName, lastName, email, postalcode);
    this.voters.add(newVoter);
    return newVoter;
  }

  @Override
  public Election findElection(String name) throws InexistentElectionException {
    Election found = this.elections.getElection(name);
    return found;
  }

  @Override
  public Voter findVoter(String email) throws InexistentVoterException {
    Voter found = this.voters.getVoter(email);
    return found;
  }

}
