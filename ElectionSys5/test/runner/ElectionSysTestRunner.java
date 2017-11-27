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

/**
 * 
 * @author Maria Hossain
 * @version 0.0.1
 *
 *
 *          This main class summarizes all the test classes that has been created for all classes
 *          created in this project. It calls its main method for each of those classes which in
 *          return prints the results.
 */

public class ElectionSysTestRunner {

  public static void main(String[] args) throws IOException {

    System.out.println("=================Common5 Project Test Cases=================" + '\n');
    System.out.println(

        "****All the below test cases are from the test/lib and test/util in the Common5 Project****"
            + '\n');

    System.out.println(
        "**The following test cases is testing the EMAIL class. The test class is EmailTest.java**"
            + '\n');

    EmailTest.main(args);
    System.out.println(
        "**The following test cases is testing the NAME class. The test class is NameTest.java**"
            + '\n');
    NameTest.main(args);

    System.out.println(
        "**The following test cases is testing the POSTAL CODE class. The test class is PostalCodeTest.java**"
            + '\n');
    PostalCodeTest.main(args);

    System.out.println(
        "**The following test cases is testing the LISTUTILITIES class. The test class is ListUtilitiesTest.java**"
            + '\n');
    ListUtilitiesTest.main(args);


    System.out.println("=================ElectionSys5 Project Test Cases=================" + '\n');
    System.out.println(

        "****All the below test cases are from the test/election.business and test/election.data in the Common5 Project****");

    System.out.println(
        "**The following test cases is testing the DAWSONBALLOTITEM class. The test class name is DawsonBallotItemTest.java**"
            + '\n');

    DawsonBallotItemTest.main(args);

    System.out.println(
        "**The following test cases is testing the DAWSONELECTIONTEST class. The test class is DawsonElectionTest.java**"
            + '\n');
    DawsonElectionTest.main(args);

    System.out.println(
        "**The following test cases is testing the DAWSONVOTER class. The test class is DawsonVoterTest.java**"
            + '\n');
    DawsonVoterTest.main(args);

    System.out.println(
        "**The following test cases is testing the VOTERNAMECOMPARATOR class. The test class is VoterNameComparatorTest.java**"
            + '\n');
    VoterNameComparatorTest.main(args);

    System.out.println(
        "**The following test cases is testing the VOTERPOSTALCODECOMPARATOR class. The test class is VoterPostalCodeComparatorTest.java**"
            + '\n');
    VoterPostalCodeComparatorTest.main(args);

    System.out.println(
        "**The following test cases is testing the ELECTIONFILELOADER class. The test class is ElectionFileLoaderTest.java**"
            + '\n');
    ElectionFileLoaderTest.main(args);

    System.out.println(
        "**The following test cases is testing the ELECTIONLISTDB class. The test class is ElectionListDBTest.java**"
            + '\n');
    ElectionListDBTest.main(args);

    System.out.println(
        "**The following test cases is testing the VOTERLISTDB class. The test class is VoterListDBTest.java**"
            + '\n');
    VoterListDBTest.main(args);



  }

}
