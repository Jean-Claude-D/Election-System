package election.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import election.business.interfaces.ElectionPolicy;


/**
 * This class takes an object of type Election and gives points to the options that had the most
 * votes according to a ranking system implemented below.
 * 
 * @author Felicia Gorgatchov
 *
 */

public class DawsonRankedElectionPolicy implements ElectionPolicy {

  private static final long serialVersionUID = 42031768871L;
  private DawsonElection election;
  private List<String> winnerList = new ArrayList<String>();
  LocalDate today = LocalDate.now();

  /**
   * takes an object of type election and keeps it as a reference
   * 
   * @param electionParam
   */
  public DawsonRankedElectionPolicy(DawsonElection electionParam) {

    if (electionParam == null) {
      throw new IllegalArgumentException(
          "The election you've select is null. Please verify the validity of your data.");
    }
    if (e.getElectionType() != ElectionType.RANKED) {
      throw new IllegalArgumentException(
          "The election you've selected is not of type Ranked. Please verify the validity of your data.");
    }

    this.election = electionParam;

  }

  /**
   * This method allocates 5 points per vote for each choice as first rank and 2 point points per
   * vote for each choice as second rank. It adds up the total amount of points of each choice and
   * whichever choice got the most points is placed in a list and returned.
   * 
   * @return a list containing the name of the winning choice
   * 
   */

  @Override
  public List<String> getWinner() {

    if (election.getEndDate().isAfter(today)) {
      throw new IncompleteElectionException(
          "The election you've select is not yet complete. To get the winner of an election, the latter must first have been completed.");
    }

    int[][] results = election.getTally().getVoteBreakdown();
    String[] ballotChoices = election.getElectionChoices();

    int winningResult = 0;
    int points;
    String winner = null;

    // go through each choice to look at how many votes they got as number 1 and as number 2
    for (int choice = 0; choice < results.length; choice++) {

      // return points to zero every time you go to the next option
      points = 0;


      /*
       * Verify how many votes for the current choice as number 1, multiply by 5 and add to points.
       * In the second itteration, multiply the number of votes for the current choice as number 2,
       * multiply by 2 and add to points as well
       */
      for (int ranking = 0; ranking < results[choice].length; ranking++) {
        if (ranking == 0) {
          points += results[choice][ranking] * 5;
        }

        else if (ranking == 1) {
          points += results[choice][ranking] * 2;
        }

        else {
          continue;
        }
      }

      /*
       * If the number of points for the current choice is greater than than the winning number of
       * points, make winningResult equal to the current number of points for the next choice
       * evaluation and save the name of the current choice in a list.
       */

      if (points > winningResult) {
        winningResult = points;
        winner = ballotChoices[choice];
      }

    }

    winnerList.add(winner);

    // return a list containing the name of the winning choice
    return winnerList;

  }

}
