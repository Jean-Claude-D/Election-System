package election.business;

public class VoterPostalCodeComparatorTest {
  
  public static void main(String[] args) {
    

    
    testVoterPostalCodeComparator("Yamamoto", "Isoroku", "Rising_Sun@Banzai.Kamikaze.jp", "H5J 2G9");
    
//    DawsonVoter voter1 = new DawsonVoter("Yamamoto", "Isoroku", "Rising_Sun@Banzai.Kamikaze.jp", "H5J 2G9");
//    
//    DawsonVoter voter2 = new DawsonVoter("Takeda", "Shingen", "Rise_Of_Samurai@Katana.jp", "J5B 2Y7");
    
  }
  
  public static void testVoterPostalCodeComparator (String fname, String lname, String email, String address) {
    
    VoterPostalCodeComparator check = new VoterPostalCodeComparator();
    
    DawsonVoter voter1 = new DawsonVoter(fname, lname, email, address);  //H5J 2G9
    
    DawsonVoter voter2 = new DawsonVoter("John", "Smith", "Idk@idk.idk", "E4V 3X6");
    
    DawsonVoter voter3 = new DawsonVoter(fname, lname, email, "H7L 1Z1");
    
    DawsonVoter voter4 = new DawsonVoter("Jimmy", "Legend", "Jimmy@gmail.com", "P8T 1Y8");
    
    DawsonVoter voter5 = new DawsonVoter(fname, lname, email, address);

    System.out.println(check.compare(voter1, voter2) > 0 ? "TEST PASSED" : "TEST FAILED");
    System.out.println();
    System.out.println(check.compare(voter1, voter3) == 0 ? "TEST PASSED" : "TEST FAILED");
    System.out.println();
    System.out.println(check.compare(voter1, voter4) < 0 ? "TEST PASSED" : "TEST FAILED");
    System.out.println();
    System.out.println(check.compare(voter1, voter5) == 0 ? "TEST PASSED" : "TEST FAILED");
    System.out.println();
    

    VoterPostalCodeComparator check = new VoterPostalCodeComparator();
    
    DawsonVoter voter1 = new DawsonVoter("Yamamoto", "Isoroku", "Rising_Sun@Banzai.Kamikaze.jp", "H5J 2G9");
    
    DawsonVoter voter2 = new DawsonVoter("Takeda", "Shingen", "Rise_Of_Samurai@Katana.jp", "J5B 2Y7");
    
    check.compare(voter1, voter2);


  }
}

