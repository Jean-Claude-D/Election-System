package election.business;

public class VoterPostalCodeComparatorTest {

  public static void main(String[] args) {

    testVoterPostalCodeComparator("Yamamoto", "Isoroku", "Rising_Sun@Banzai.Kamikaze.jp",
        "H5J 2G9");
  }


  public static void testVoterPostalCodeComparator(String fname, String lname, String email,
      String address) {

    VoterPostalCodeComparator check = new VoterPostalCodeComparator();

    DawsonVoter voter1 = new DawsonVoter(fname, lname, email, address); // H5J 2G9

    DawsonVoter voter2 = new DawsonVoter("John", "Smith", "Idk@idk.idk", "E4V 3X6");

    DawsonVoter voter3 = new DawsonVoter(fname, lname, email, "H7L 1Z1");

    DawsonVoter voter4 = new DawsonVoter("Jimmy", "Legend", "Jimmy@gmail.com", "P8T 1Y8");

    DawsonVoter voter5 = new DawsonVoter(fname, lname, email, address);

    DawsonVoter voter6 = new DawsonVoter(fname, lname, email, "H5J 2G9");

    System.out.println("voter1's postal code Compare To voter2's postal code");
    System.out.println();

    System.out
        .println(check.compare(voter1, voter2) > 0 ? voter1.getPostalCode() + " Is Greater Than "
            + voter2.getPostalCode() + "\t\t\t\t\t\t TEST PASSED\n" : "TEST FAILED");

    System.out.println("=============================================\n");

    System.out.println("voter1's postal code Compare To voter3's postal code");
    System.out.println();

    System.out
        .println(check.compare(voter1, voter3) < 0 ? voter1.getPostalCode() + " Is Smaller Than "
            + voter3.getPostalCode() + "\t\t\t\t\t\t TEST PASSED\n" : "TEST FAILED");

    System.out.println("=============================================\n");

    System.out.println("voter1's postal code Compare To voter4's postal code");
    System.out.println();

    System.out
        .println(check.compare(voter1, voter4) < 0 ? voter1.getPostalCode() + " Is Smaller Than "
            + voter4.getPostalCode() + "\t\t\t\t\t\t TEST PASSED\n" : "TEST FAILED");

    System.out.println("=============================================\n");

    System.out.println("voter1's postal code Compare To voter5's postal code");
    System.out.println();

    System.out.println(check.compare(voter1, voter5) == 0 ? voter1.getPostalCode() + " Is Equal To "
        + voter5.getPostalCode() + "\t\t\t\t\t\t TEST PASSED" : "TEST FAILED");

    System.out.println();

    System.out.println("=============================================\n");

    System.out.println("voter1's postal code Compare To voter6's postal code");
    System.out.println();

    System.out.println(check.compare(voter1, voter6) == 0 ? voter1.getPostalCode() + " Is Equal To "
        + voter6.getPostalCode() + "\t\t\t\t\t\t TEST PASSED" : "TEST FAILED");

    System.out.println();

    System.out.println("=============================================\n");

    System.out.println("voter6's postal code Compare To voter3's postal code");
    System.out.println();

    System.out
        .println(check.compare(voter3, voter6) > 0 ? voter3.getPostalCode() + " Is Greater Than "
            + voter6.getPostalCode() + "\t\t\t\t\t\t TEST PASSED" : "TEST FAILED");

    System.out.println();
  }
}

