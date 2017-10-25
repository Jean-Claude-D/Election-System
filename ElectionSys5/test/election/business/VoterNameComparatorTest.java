package election.business;

public class VoterNameComparatorTest {

  public static void main(String[] args) {

    testVoterNameComparator();


  }// End Main


  public static void testVoterNameComparator() {

    System.out.println("Testing VoterNameComparator");
    System.out.println();

    String fname1 = "Maria";
    String lname1 = "Hossain";
    String email1 = "mariahossain6@gmail.com";
    String postalcode1 = "H4J2G6";

    String fname2 = "Gman";
    String lname2 = "Anatharaja";
    String email2 = "g.man6@hotmail.com";
    String postalcode2 = "H4l1W8";

    String fname3 = "Maria";
    String lname3 = "Hossain";
    String email3 = "maria_hossain@hotmail.com";
    String postalcode3 = "H6Y2H5";

    String fname4 = "Maria";
    String lname4 = "Hossain";
    String email4 = "mariahossain6@gmail.com";
    String postalcode4 = "H4J2G6";

    DawsonVoter voter1 = new DawsonVoter(fname1, lname1, email1, postalcode1);
    DawsonVoter voter2 = new DawsonVoter(fname2, lname2, email2, postalcode2);
    DawsonVoter voter3 = new DawsonVoter(fname3, lname3, email3, postalcode3);
    DawsonVoter voter1copy = new DawsonVoter(fname4, lname4, email4, postalcode4);

    System.out.println("Voter1's Name: Maria Hossain");
    System.out.println("Voter2's Name:Gman Anatharaja");
    System.out.println("Voter3's Name: Maria Hossain (But has diffrent email and postal code)");
    System.out.println();

    VoterNameComparator comparison1 = new VoterNameComparator();
    VoterNameComparator comparison2 = new VoterNameComparator();
    VoterNameComparator comparison3 = new VoterNameComparator();

    if (comparison1.compare(voter1, voter2) > 1 || comparison1.compare(voter1, voter2) < 1) {

      System.out.println(
          "The name is not the same therefore it will give a result that is greater or less than 1");
      System.out.println("We are comparing the name Maria (Voter1) and Gman (Voter1)");
      System.out.println("==========================PASS=======================");
      System.out.println();
    }

    else {

      System.out.println("===================================FAIL========================");
      System.out.println();
    }


    if (comparison1.compare(voter1, voter3) > 1 || comparison1.compare(voter1, voter3) < 1) {

      System.out.println(
          "Voter1 and Voter3 have the same name but not the same information such as email and postal");
      System.out.println("==============================PASS===========================");
      System.out.println();
    }

    else {

      System.out.println("============================FAILED============================");
      System.out.println();
    }


    if (comparison3.compare(voter1, voter1copy) == 0) {

      System.out.println(
          "Voter1 and voter1copy have the exact same name, email and postal code which means that it should return 1");
      System.out.println("=============================PASS======================");
      System.out.println();
    }

    else {

      System.out.println("============================FAIL=========================");
      System.out.println();
    }
  }

}


