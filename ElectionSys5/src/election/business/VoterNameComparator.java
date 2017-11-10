package election.business;

import java.util.Comparator;
import election.business.interfaces.Voter;

public class VoterNameComparator implements Comparator<Voter> {

  @Override
  public int compare(Voter voter1, Voter voter2) {

    if (voter1.getName().compareTo(voter2.getName()) == 0) {

      return voter1.compareTo(voter2);

    }

    else {

      return voter1.getName().compareTo(voter2.getName());
    }


  }

}


