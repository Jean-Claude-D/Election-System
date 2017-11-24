package election.business;

import java.util.ArrayList;
import java.util.List;
import election.business.interfaces.ElectionPolicy;

public class DawsonRankedElectionPolicy implements ElectionPolicy {

  private static final long serialVersionUID = 42031768871L;
  private DawsonElection election;
  private List<String> winnerList = new ArrayList<String>();

  public DawsonRankedElectionPolicy(DawsonElection electionParam) {
    this.election = electionParam;
  }

  @Override
  public List<String> getWinner() {

    int[][] results = election.getTally().getVoteBreakdown();
    String[] ballotChoices = election.getElectionChoices();

    int winningResult = 0;
    int points;
    String winner == null;

    for (int choice = 0; choice < results.length; choice++) {

      points = 0;

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

      if (points > winningResult) {
        winningResult = points;
        winner = ballotChoices[choice];
      }

    }
    
    winnerList.add(winner);

    return winnerList;

  }

}
