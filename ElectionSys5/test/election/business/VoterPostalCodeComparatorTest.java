package election.business;

public class VoterPostalCodeComparatorTest {

  public static void main(String[] args) {

    DawsonVoter voter1 = 
        new DawsonVoter("Farsight", "Vio'Lar", "Farsight@Enclave.tau", "H5J 2G9");
    DawsonVoter voter2 = 
        new DawsonVoter("Dorn", "Rogal", "Imperial@Fist.imperium", "H7L 1Z1");
    DawsonVoter voter3 = 
        new DawsonVoter("Jimmy", "Legend", "Jimmy@gmail.com", "P8T 1Y8");
    DawsonVoter voter4 =
        new DawsonVoter("Harbinger", "Of Appocalypse", "Sauralianza@Dynasty.Necron", "A2N 3J8");
    DawsonVoter voter5 =
        new DawsonVoter("Reaper", "Of Sovereign", "DeepSpace@Void.Galaxy", "H5J 2G9");
    DawsonVoter voter6 =
        new DawsonVoter("Collector", "Keeper Of Secret", "GrimDark@40k.uk", "T4J 2W9");

    testVoterPostalCodeComparator(voter1, voter2, -1);
    testVoterPostalCodeComparator(voter1, voter3, -1);
    testVoterPostalCodeComparator(voter1, voter4, 1);
    testVoterPostalCodeComparator(voter1, voter5, 0);
    testVoterPostalCodeComparator(voter1, voter6, -1);
    testVoterPostalCodeComparator(voter5, voter1, 0);
    testVoterPostalCodeComparator(voter4, voter3, -1);
    testVoterPostalCodeComparator(voter3, voter4, 1);
  }

  public static void testVoterPostalCodeComparator(DawsonVoter voter1, DawsonVoter voter2, int confirm) {

    VoterPostalCodeComparator check = new VoterPostalCodeComparator();
    String a = voter1.getPostalCode().toString();
    String b = voter2.getPostalCode().toString();

    System.out.println("voter1's postal code :" + a);
    System.out.println();
    System.out.println("voter2's postal code :" + b);
    System.out.println();

    if ( (check.compare(voter1, voter2) == 0) && (check.compare(voter1, voter2) == confirm) ) {
      System.out.println(check.compare(voter1, voter2));
      System.out.println(a + " Is Equal To " + b + "\t\t\t\t\t TEST PASSED\n");
      System.out.println("==================================\n");
    } else if ( (check.compare(voter1, voter2) > 0) && (check.compare(voter1, voter2) >= confirm)) {
      System.out.println(check.compare(voter1, voter2));
      System.out.println(a + " Is Greater Than " + b + "\t\t\t\t\t TEST PASSED\n");
      System.out.println("==================================\n");
    } else if ( (check.compare(voter1, voter2) < 0) && (check.compare(voter1, voter2) <= confirm)) {
      System.out.println(check.compare(voter1, voter2));
      System.out.println(a + " Is Smaller Than " + b + "\t\t\t\t\t TEST PASSED\n");
      System.out.println("==================================\n");
    } else
      System.out.println("TEST FAILED");
  }
}

