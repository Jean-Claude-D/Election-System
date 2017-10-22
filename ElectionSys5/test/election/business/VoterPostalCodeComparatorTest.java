package election.business;

public class VoterPostalCodeComparatorTest {
  
  public static void main(String[] args) {
    
    VoterPostalCodeComparator check = new VoterPostalCodeComparator();
    
    DawsonVoter voter1 = new DawsonVoter("Yamamoto", "Isoroku", "Rising_Sun@Banzai.Kamikaze.jp", "H5J 2G9");
    
    DawsonVoter voter2 = new DawsonVoter("Takeda", "Shingen", "Rise_Of_Samurai@Katana.jp", "J5B 2Y7");
    
    check.compare(voter1, voter2);

  }
}

