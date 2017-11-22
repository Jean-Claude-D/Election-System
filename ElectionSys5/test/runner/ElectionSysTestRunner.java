package runner;

import lib.EmailTest;
import lib.NameTest;
import lib.PostalCodeTest;
import util.ListUtilitiesTest;

public class ElectionSysTestRunner {

  public static void main(String[] args) {

    System.out.println("Common5 Project Test Cases");
    System.out.println(

        "All the below test cases are from the test/lib and test/util in the Common5 Project");

    System.out.println();
    System.out.println();

    System.out.println(
        "The following test cases is testing the EMAIL class. The test class is EmailTest.java");
    System.out.println();


    EmailTest.main(args);

    System.out.println(
        "The following test cases is testing the NAME class. The test class is NameTest.java");
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


  }

}
