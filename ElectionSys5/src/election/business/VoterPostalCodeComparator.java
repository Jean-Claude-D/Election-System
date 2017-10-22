package election.business;

import java.util.Comparator;
import election.business.interfaces.Voter;

/**
 * This class provides an alternative way to compare Voter objects, besides the natural order.
 * Voters are compared based on their postal code. If the postal codes are the same, they are order
 * naturally.
 * 
 * @author Jaya/Maja
 *
 */
public class VoterPostalCodeComparator implements Comparator<Voter> {


  @Override
  public int compare(Voter voter1, Voter voter2) {
    // if two objects are equal, comparing them should yield 0
    if (voter1.getPostalCode().equals(voter2.getPostalCode())) {
      return voter1.getPostalCode().compareTo(voter2.getPostalCode());
    }
    return voter1.compareTo(voter2);
  }

}
