package runner;

import java.io.IOException;
import election.business.DawsonBallotItemTest;
import election.business.DawsonElectionTest;
import election.business.DawsonVoterTest;
import election.business.VoterNameComparatorTest;
import election.business.VoterPostalCodeComparatorTest;
import election.data.ElectionFileLoaderTest;
import election.data.ElectionListDBTest;
import election.data.VoterListDBTest;
import lib.EmailTest;
import lib.NameTest;
import lib.PostalCodeTest;
import util.ListUtilitiesTest;

public class ElectionSysTestRunner {

  public static void main(String[] args) throws IOException {

    System.out.println("=================Common5 Project Test Cases=================" + '\n');
    System.out.println(

        "****All the below test cases are from the test/lib and test/util in the Common5 Project****"
            + '\n');

    System.out.println();
    System.out.println(
        "**The following test cases is testing the EMAIL class. The test class is EmailTest.java**");
    System.out.println();

    EmailTest.main(args);
    System.out.println(
        "**The following test cases is testing the NAME class. The test class is NameTest.java**");
    System.out.println();
    NameTest.main(args);

    System.out.println(
        "**The following test cases is testing the POSTAL CODE class. The test class is PostalCodeTest.java**");
    System.out.println();
    PostalCodeTest.main(args);

    System.out.println(
        "**The following test cases is testing the LISTUTILITIES class. The test class is ListUtilitiesTest.java**");
    System.out.println();
    ListUtilitiesTest.main(args);


    System.out.println("=================ElectionSys5 Project Test Cases=================" + '\n');
    System.out.println(

        "****All the below test cases are from the test/election.business and test/election.data in the Common5 Project****");

    System.out.println(
        "**The following test cases is testing the DAWSONBALLOTITEM class. The test class name is DawsonBallotItemTest.java**");
    System.out.println();

    DawsonBallotItemTest.main(args);

    System.out.println(
        "**The following test cases is testing the DAWSONELECTIONTEST class. The test class is DawsonElectionTest.java**");
    System.out.println();
    DawsonElectionTest.main(args);

    System.out.println(
        "**The following test cases is testing the DAWSONVOTER class. The test class is DawsonVoterTest.java**");
    System.out.println();
    DawsonVoterTest.main(args);

    System.out.println(
        "**The following test cases is testing the VOTERNAMECOMPARATOR class. The test class is VoterNameComparatorTest.java**");
    System.out.println();
    VoterNameComparatorTest.main(args);

    System.out.println(
        "**The following test cases is testing the VOTERPOSTALCODECOMPARATOR class. The test class is VoterPostalCodeComparatorTest.java**");
    System.out.println();
    VoterPostalCodeComparatorTest.main(args);

    System.out.println(
        "**The following test cases is testing the ELECTIONFILELOADER class. The test class is ElectionFileLoaderTest.java**");
    System.out.println();
    ElectionFileLoaderTest.main(args);

    System.out.println(
        "**The following test cases is testing the ELECTIONLISTDB class. The test class is ElectionListDBTest.java**");
    System.out.println();
    ElectionListDBTest.main(args);

    System.out.println(
        "**The following test cases is testing the VOTERLISTDB class. The test class is VoterListDBTest.java**");
    System.out.println();
    VoterListDBTest.main(args);



  }

}
