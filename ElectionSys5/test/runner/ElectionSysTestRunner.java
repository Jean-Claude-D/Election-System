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

    System.out.println("=================Common5 Project Test Cases=================");
    System.out.println();
    System.out.println(

        "****All the below test cases are from the test/lib and test/util in the Common5 Project****");

    System.out.println();
    System.out.println();

    System.out.println(
        "****The following test cases is testing the EMAIL class. The test class is EmailTest.java****");
    System.out.println();


    EmailTest.main(args);

    System.out.println(
        "****The following test cases is testing the NAME class. The test class is NameTest.java****");
    System.out.println();
    NameTest.main(args);

    System.out.println(
        "The following test cases is testing the POSTAL CODE class. The test class is PostalCodeTest.java");
    System.out.println();
    PostalCodeTest.main(args);

    System.out.println(
        "The following test cases is testing the LISTUTILITIES class. The test class is ListUtilitiesTest.java");
    System.out.println();
    ListUtilitiesTest.main(args);


    System.out.println("=================ElectionSys5 Project Test Cases=================");
    System.out.println();

    System.out.println(

        "All the below test cases are from the test/election.business and test/election.data in the Common5 Project");


    DawsonBallotItemTest.main(args);
    DawsonElectionTest.main(args);
    DawsonVoterTest.main(args);
    VoterNameComparatorTest.main(args);
    VoterPostalCodeComparatorTest.main(args);

    ElectionFileLoaderTest.main(args);
    ElectionListDBTest.main(args);
    VoterListDBTest.main(args);



  }

}
