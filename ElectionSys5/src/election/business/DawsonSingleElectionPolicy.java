package election.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionPolicy;


/**
 * DawsonSingleElectionPolicy checks first the Election must NOT be null and its type is SINGLE.
 * Else it will throw IllegalArgumentException. The constructor will create a reference to this
 * object as an instance variable
 * 
 * @author Cao Hoang Nguyen
 * @version 1.0
 */
public class DawsonSingleElectionPolicy implements ElectionPolicy, Serializable {

  private static final long serialVersionUID = 42031768871L;
  private Election singleElection;

  /**
   * Constructor of DawsonSingleElectionPolicy creates a reference of the Election and store it as
   * an instance variable.
   * 
   * @param e the Election that the constructor creates the reference from.
   * @throws IllegalArgumentException when the Election is either null or its type is NOT SINGLE.
   */
  public DawsonSingleElectionPolicy(Election e) {

    if (e == null) {
      throw new IllegalArgumentException("Your Election Is Null. Please Double Check Your Data.");
    }

    if (e.getElectionType() != ElectionType.SINGLE) {
      throw new IllegalArgumentException(
          "Your Election Type Is Not Single. Hence The Policy Cannot Be Applied");
    }
    this.singleElection = e;
  }

  /**
   * Return a List of String that contains the "Winner" of this Election. In Type SINGLE, the
   * Election can ONLY have either 0 or 1 Winner. The winner is the choice that has the most vote
   * AND its amount of vote is either:
   * 
   * 1/ GREATER than half the amount of TOTAL vote
   * 
   * OR
   * 
   * 2/ GREATER OR EQUAL to half the amount of TOTAL vote PLUS 1.
   * 
   * Else, there is NO winner
   * 
   * @return a List of String contains the Winner.
   * @throws IncompleteElectionException if this method is called BEFORE the Election is Finished.
   */
  public List<String> getWinner() {

    // Check if the Election is finished or not. If not, throw IncompleteElectionException.
    if (singleElection.getEndDate().isAfter(LocalDate.now())) {
      throw new IncompleteElectionException(
          "The Election Is NOT Finished Yet. Democracy is NON-Negotiable");
    }

    List<String> theWinner = new ArrayList<String>();

    // Store the number of Vote for EACH choices in an Election. e.g. [12][5][1] means 1st choice
    // has 12 vote, 2nd has 5 and last has 1.
    int[] numbOfVotePerChoice = new int[singleElection.getElectionChoices().length];

    for (int i = 0; i < singleElection.getElectionChoices().length; i++) {
      numbOfVotePerChoice[i] = this.singleElection.getTally().getVoteBreakdown()[i][i];
    }

    int tempHighestVote = 0;
    int index = 0;


    /*
     * Find the choice that has the highest vote. Then note down its index. Note: the
     * getElectionChoices() method in DawsonElection class return an array of String of all the
     * choices in an Election, therefore using the index allows us to retrieve the choice.
     */
    for (int i = 0; i < numbOfVotePerChoice.length; i++) {

      if (numbOfVotePerChoice[i] > tempHighestVote) {
        tempHighestVote = numbOfVotePerChoice[i];
        index = i;
      }
    }

    int verifyWinner = this.singleElection.getTotalVotesCast() / 2;

    // Check if the choice is qualify as the "Winner" or not.
    if (tempHighestVote > verifyWinner) {
      theWinner.add(this.singleElection.getElectionChoices()[index]);
      return theWinner;
    }
    return theWinner;
  }
}
