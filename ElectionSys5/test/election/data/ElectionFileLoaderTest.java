package election.data;

import java.io.IOException;
import election.business.DawsonElection;
import election.business.DawsonTally;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;

public class ElectionFileLoaderTest {

  public static void main(String[] args) throws IOException {


    // String nameOfFile3 = "datafiles/tally.txt";
    // String nameofFile4 = "datafiles/elections25";
    // String nameofFile5 = "";
    // String nameofFile6 = "abejck";
    //
    // Boolean expectedResult3 = true;
    // Boolean expectedResult4 = false;
    // Boolean expectedResult5 = false;
    // Boolean expectedResult6 = false;
    //
    // String nameElection1 = "Dawson Color Election 2020";
    // String nameElection2 = "Prom Queen";
    // String nameElection3 = "Favourite Food";
    //
    // String type1 = "Ranked";
    // String type2 = "Ranked";
    // String type3 = "Ranked";
    //
    // int startYear1 = 2017;
    // int startYear2 = 2017;
    // int startYear3 = 2017;
    //
    // int startMonth1 = 10;
    // int startMonth2 = 11;
    // int startMonth3 = 12;
    //
    // int startDay1 = 28;
    // int startDay2 = 16;
    // int startDay3 = 17;
    //
    // int endYear1 = 2018;
    // int endYear2 = 2018;
    // int endYear3 = 2018;
    //
    // int endMonth1 = 5;
    // int endMonth2 = 6;
    // int endMonth3 = 7;
    //
    // int endDay1 = 15;
    // int endDay2 = 16;
    // int endDay3 = 17;
    //
    // String startRange1 = null;
    // String startRange2 = null;
    // String startRange3 = null;
    //
    // String endRang1 = null;
    // String endRang2 = null;
    // String endRang3 = null;
    //
    // int choice = 0;

    // DawsonTally tally1 = new DawsonTally(choice, nameElection1);
    // DawsonTally tally2 = new DawsonTally(choice, nameElection2);
    // DawsonTally tally3 = new DawsonTally(choice, nameElection3);
    //
    // Election election1 = new DawsonElection(nameElection1, type1, startYear1, startMonth1,
    // startDay1, endYear1, endMonth1, endDay1, startRange1, endRang1, tally1, "H", "Jean Claude",
    // "Felicia", "Maria");
    // Election election2 = new DawsonElection(nameElection2, type2, startYear2, startMonth2,
    // startDay2, endYear2, endMonth2, endDay2, startRange2, endRang2, tally2, "H", "Jean Claude",
    // "Felicia", "Maria");
    // Election election3 = new DawsonElection(nameElection3, type3, startYear3, startMonth3,
    // startDay3, endYear3, endMonth3, endDay3, startRange3, endRang3, tally3, "H", "Jean Claude",
    // "Felicia", "Maria");
    //
    // Election[] allElectionCreated = {election1, election2, election3};
    //
    //
    // testsetExistingTallyFromSequentialFile(nameOfFile3, expectedResult3, allElectionCreated);
    // testsetExistingTallyFromSequentialFile(nameofFile4, expectedResult4, allElectionCreated);
    // testsetExistingTallyFromSequentialFile(nameofFile5, expectedResult5, allElectionCreated);
    // testsetExistingTallyFromSequentialFile(nameofFile6, expectedResult6, allElectionCreated);

    /*
     * Test GetVoterListFromSequentialFile with voters1.txt :
     * 
     * djflower@hotmail.com*Daisy*Johnson*H7N9L0
     * 
     * robsmith@gmail.com*Robert*Smith*J8F4K2
     * 
     * andrasemily@outlook.ca*Emily*Andras*T3K7V6
     * 
     * mscott@dundermifflin.com*Michael*Scott*J9F2N1
     * 
     * callmepeggy@gmail.com*Margaret*Carter*C1K9G6
     * 
     * thehunter217@hotmail.ca*Erin*Hunter*N6F8S5
     * 
     * basketball14@videotron.ca*Troy*Bolton*X7B0F6
     * 
     * blackbears@live.ca*Andrew*Belle*K4W4P7
     * 
     * sabrinacarpenter@gmail.com*Sabrina*Carpenter*V3Y0K1
     * 
     * fastestmanalive@bell.ca*Grant*Gustin*F3N7G8
     */

    // Voter[] validVoter1 = {
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Daisy", "Johnson",
    // "djflower@hotmail.com", "H7N9L0"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Emily", "Andras",
    // "andrasemily@outlook.ca", "T3K7V6"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Margaret", "Carter",
    // "callmepeggy@gmail.com", "C1K9G6"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Andrew", "Belle",
    // "blackbears@live.ca", "K4W4P7"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Sabrina", "Carpenter",
    // "sabrinacarpenter@gmail.com", "V3Y0K1")};
    //
    //
    // testGetVoterListFromSequentialFile("datafiles/voters1.txt", validVoter1, true, null);

    /*
     * Test GetVoterListFromSequentialFile with voters21.txt :
     * 
     * IsaacSFinch@teleworm.us*Isaac*Finch*K7S2R5
     * 
     * 1-3_5678910121416182022242628303@abc1-2-3.b.com*Koodo Moodo*Tentucky*H5S 2J5
     * 
     * Michelle.Obama@Whitehouse.gov*Mich'elle*Obama*T2K0P7
     * 
     * maryjgarcia@dayrep.com*Mary*Garcia*M5H1P6
     * 
     * RandallDRabin@teleworm.us*Randall*Rabin*V9T5H3
     * 
     * SimonCroteau@gmail.com*Simon*Croteau*J2C 4N1
     * 
     * julietAssange12@hello.ca*Juliet*Assange*J4R9S1
     * 
     * SebStrol_89@kayak_com*Sebastian*Strol*J6L5T9
     * 
     * PaulS74@word*Paul*S*J8O2E6
     * 
     * RayanMars@lobster*Rayan*Mars*W8D9W2
     */

    // Voter[] validVoter21 = {
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Isaac", "Finch",
    // "IsaacSFinch@teleworm.us", "H5S 2J5"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Koodo Moodo", "Tentucky",
    // "1-3_5678910121416182022242628303@abc1-2-3.b.com", "K7S2R5"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Mich'elle", "Obama",
    // "Michelle.Obama@Whitehouse.gov", "T2K0P7"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Mary", "Garcia",
    // "maryjgarcia@dayrep.com", "M5H1P6"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Randall", "Rabin",
    // "RandallDRabin@teleworm.us", "V9T5H3"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Simon", "Croteau",
    // "SimonCroteau@gmail.com", "J2C 4N1"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Juliet", "Assange",
    // "julietAssange12@hello.ca", "J4R9S1"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Sebastian", "Strol",
    // "SebStrol_89@kayak_com", "J6L5T9")};
    //
    //
    // testGetVoterListFromSequentialFile("datafiles/voters21.txt", validVoter21, true, null);

    /*
     * Test GetVoterListFromSequentialFile with voters21.txt :
     * 
     * AronB43@hotmail.com*Aron*Bauer*H9S M2K
     * 
     * HarpPlayer45@gmail.com*Romeo*Harper*E7C V6T
     * 
     * Burkanator@yahoo.ca*Anthony*Burke*E3N L9G
     * 
     * warnerjaylene@gmail.com*Jaylene*Warner*K7A 3Y8
     * 
     * curtis-Rocks@gmail.com*Summer*Curtis*V1J 0C8
     * 
     * LawNoGotNoRules@outlook.com*Noel*Lawrence*H9J 2P0
     * 
     * currysmeller17@yahoo.ca*Kailyn*Curry*L4T 0R3
     * 
     * avah386@gmail.com*Avah*Walsh*E7B 0W2
     * 
     * queen.Fiona@hotmail.com*Fiona*Quinn*T9C 1P7
     * 
     * josh_matthew99@outlook.com*Josh*Mathews*E9B 2Y5
     */

    // Voter[] validVoter7 = {
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Jaylene", "Warner",
    // "warnerjaylene@gmail.com", "K7A 3Y8"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Summer", "Curtis",
    // "curtis-Rocks@gmail.com", "V1J 0C8"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Noel", "Lawrence",
    // "LawNoGotNoRules@outlook.com", "H9J 2P0"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Avah", "Walsh", "avah386@gmail.com",
    // "E7B 0W2"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Fiona", "Quinn",
    // "queen.Fiona@hotmail.com", "T9C 1P7"),
    // DawsonElectionFactory.DAWSON_ELECTION.getVoterInstance("Josh", "Mathews",
    // "josh_matthew99@outlook.com", "E9B 2Y5")};
    //
    // testGetVoterListFromSequentialFile("datafiles/voters7.txt", validVoter7, true, null);


    /*
     * Test GetVoterListFromSequentialFile with null and "":
     * 
     * Should raise an InvalidPathException
     */

    // testGetVoterListFromSequentialFile(null, null, false, InvalidPathException.class);
    // testGetVoterListFromSequentialFile("", null, false, InvalidPathException.class);

    /*
     * Test GetVoterListFromSequentialFile with a path that leads no where :
     * 
     * Should raise an NoSuchFileException
     */

    // testGetVoterListFromSequentialFile("There/is/no/file/at.txt", null, false,
    // NoSuchFileException.class);
    //
    // testGetVoterListFromSequentialFile("datafiles/voters34.txt", null, false,
    // NoSuchFileException.class);

    DawsonTally tally = new DawsonTally(1, "null");

    DawsonElection test1 = new DawsonElection("Federal Canadian Election 2017-18", "ranked", 2018,
        11, 1, 2019, 11, 4, "", "", tally, "randomPoliticalNo1", "randomPoliticalNo2");
    test1.setTally(new DawsonTally(test1.getElectionChoices().length, test1.getName()));

    DawsonElection test2 = new DawsonElection("Dawson Color Election 2020", "ranked", 2020, 12, 20,
        2022, 1, 20, "", "", tally, "Red", "Green", "Orange", "Blue", "Pink", "Cyan");
    test2.setTally(new DawsonTally(test2.getElectionChoices().length, test2.getName()));

    DawsonElection test3 =
        new DawsonElection("National Hair Style Election", "ranked", 3017, 6, 23, 3017, 9, 29, "",
            "", tally, "Crew", "Mullet", "Afro", "YoungDicaprio", "Dreads", "Undercut", "Ombre");

    test3.setTally(new DawsonTally(test3.getElectionChoices().length, test3.getName()));

    testGetElectionListFromSequentialFile("datafiles/unsorted/elections3.txt", test1, test2, test3);

  }

  public static void testGetVoterListFromSequentialFile(String fileNameTest, Voter[] expectedVoters,
      boolean expectedValid, Class expectedException) {
    final String FAIL = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST FAILED";
    final String PASS = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST PASS";

    System.out.println(
        "==================================================================================================================");
    System.out.println("BEGIN testGetVoterListFromSequentialFile with :");
    System.out.println("fileNameTest : " + fileNameTest);
    if (expectedVoters == null || expectedVoters.length == 0) {
      System.out.println("expectedVoters is empty");
    } else {
      System.out.println("expectedVoters :");
      System.out.println('[');
      for (Voter v : expectedVoters) {
        System.out.println(v);
      }
      System.out.println(']');
    }
    System.out.println(expectedValid ? "Expected to be valid" : "Should not be valid");
    System.out.println(expectedException == null ? "No exception expected"
        : expectedException.getName() + " expected");
    System.out.println();
    System.out.println();


    try {
      Voter[] voters = ElectionFileLoader.GetVoterListFromSequentialFile(fileNameTest);

      if (voters.length == expectedVoters.length && expectedValid) {
        for (int i = 0; i < voters.length; i++) {
          if (!voters[i].equals(expectedVoters[i])) {
            System.out.println('[' + voters[i].toString() + ']' + " should equal " + '['
                + expectedVoters[i].toString() + ']' + FAIL);

            return;
          }
        }
        System.out.println("All Voters successfully have been read from " + fileNameTest
            + " and matched expectedVoters" + PASS);

        return;
      } else if (expectedValid) {
        System.out.println("voters length (" + voters.length + ") and expectedVoters length ("
            + expectedVoters.length + ") are not equal" + FAIL);
      } else if (!expectedValid) {
        System.out.println(fileNameTest + " did not throw any exception and should have" + FAIL);
      }

    } catch (Exception e) {
      if (expectedValid) {
        System.out
            .println("Data was supposed to be valid, but throwed " + e.getClass().getName() + FAIL);
        e.getStackTrace();

        return;
      }

      if (e.getClass().equals(expectedException)) {
        System.out.println(e.getClass().toString() + " was successfully catched" + PASS);

        return;
      }

      System.out.println("The expected error was '" + expectedException.toString() + "' but '"
          + e.getClass().toString() + "' was thrown" + FAIL);
    }
  }// End of Testing GetVoterListFromSequentialFile


  // Start of method testGetElectionFromSequentialFile
  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      DawsonElection check1, DawsonElection check2, DawsonElection check3) throws IOException {

    System.out.println("Hello");

    Election[] list = ElectionFileLoader.getElectionListFromSequentialFile(fileNameTest);

    for (int i = 0; i < list.length; i++) {
      if (list[i].getName().equals(check1.getName())) {
        System.out.println(list[i].getName() + " is equal to " + check1.getName());
        System.out.println("TEST PASSED");
        System.out.println();
      }

      else if (list[i].getName().equals(check2.getName())) {
        System.out.println(list[i].getName() + " is equal to " + check2.getName());
        System.out.println("TEST PASSED");
        System.out.println();
      }

      else if (list[i].getName().equals(check3.getName())) {
        System.out.println("Start Date: " + list[i].getName() + " is equal to " + check3.getName());
        System.out.println("TEST PASSED");
        System.out.println();
      } else
        System.out.println("TEST FAILED");

      if (list[i].getStartDate().equals(check1.getStartDate())) {
        System.out.println("Start Date: " + list[i].getStartDate() + " is equal to "
            + "Start Date: " + check1.getStartDate());
        System.out.println("TEST PASSED");
        System.out.println();

      } else if (list[i].getStartDate().equals(check2.getStartDate())) {
        System.out.println("Start Date: " + list[i].getStartDate() + " is equal to "
            + "Start Date: " + check2.getStartDate());
        System.out.println("TEST PASSED");
        System.out.println();
      }

      else if (list[i].getStartDate().equals(check3.getStartDate())) {
        System.out.println("Start Date: " + list[i].getStartDate() + " is equal to "
            + "Start Date: " + check3.getStartDate());
        System.out.println("TEST PASSED");
        System.out.println();
      } else
        System.out.println("TEST FAILED");

      if (list[i].getEndDate().equals(check1.getEndDate())) {
        System.out.println("End Date: " + list[i].getEndDate() + " is equal to " + "End Date: "
            + check1.getEndDate());
        System.out.println("TEST PASSED");
        System.out.println();

      } else if (list[i].getEndDate().equals(check2.getEndDate())) {
        System.out.println("End Date: " + list[i].getEndDate() + " is equal to " + "End Date: "
            + check2.getEndDate());
        System.out.println("TEST PASSED");
        System.out.println();
      }

      else if (list[i].getEndDate().equals(check3.getEndDate())) {
        System.out.println("End Date: " + list[i].getEndDate() + " is equal to " + "End Date: "
            + check3.getEndDate());
        System.out.println("TEST PASSED");
        System.out.println();

      } else
        System.out.println("TEST FAILED");

      if (list[i].getPostalRangeStart().equals(check1.getPostalRangeStart())) {
        System.out.println("Start Postal Range: " + list[i].getPostalRangeStart() + " is equal to "
            + "Start Postal Range: " + check1.getPostalRangeStart());
        System.out.println("TEST PASSED");
        System.out.println();

      } else if (list[i].getPostalRangeStart().equals(check2.getPostalRangeStart())) {
        System.out.println("Start Postal Range: " + list[i].getPostalRangeStart() + " is equal to "
            + "Start Postal Range: " + check2.getPostalRangeStart());
        System.out.println("TEST PASSED");
        System.out.println();
      }

      else if (list[i].getPostalRangeStart().equals(check3.getPostalRangeStart())) {
        System.out.println("Start Postal Range: " + list[i].getPostalRangeStart() + " is equal to "
            + "Start Postal Range: " + check3.getPostalRangeStart());
        System.out.println("TEST PASSED");
        System.out.println();

      } else
        System.out.println("TEST FAILED");

      if (list[i].getPostalRangeEnd().equals(check1.getPostalRangeEnd())) {
        System.out.println("End Postal Range: " + list[i].getPostalRangeEnd() + " is equal to "
            + "End Postal Range: " + check1.getPostalRangeEnd());
        System.out.println("TEST PASSED");
        System.out.println();

      } else if (list[i].getPostalRangeEnd().equals(check2.getPostalRangeEnd())) {
        System.out.println("End Postal Range: " + list[i].getPostalRangeEnd() + " is equal to "
            + "End Postal Range: " + check2.getPostalRangeEnd());
        System.out.println("TEST PASSED");
        System.out.println();
      }

      else if (list[i].getPostalRangeEnd().equals(check3.getPostalRangeEnd())) {
        System.out.println("End Postal Range: " + list[i].getPostalRangeEnd() + " is equal to "
            + "End Postal Range: " + check3.getPostalRangeEnd());
        System.out.println("TEST PASSED");
        System.out.println();

      } else
        System.out.println("TEST FAILED");
    }

  }// End of Testing GetElectionListFromSequentialFile

  public static void testsetExistingTallyFromSequentialFile(String fileNameTest,
      boolean expectedValid, Election[] allElectionCreated) throws IOException {



    try {
      ElectionFileLoader.setExistingTallyFromSequentialFile(fileNameTest, allElectionCreated);

      if ((allElectionCreated[0].getTally() != null) == expectedValid) {

        System.out.println(fileNameTest + "is a valid file and the tally is filled");
        System.out.println();
        System.out
            .println("==================================PASS=================================");
        System.out.println();
      }

      else {

        System.out.println(fileNameTest + "The tally is not filled. There is a problem");
        System.out.println("=================================FAIL================================");
        System.out.println();
      }

    }

    catch (IOException e) {

      System.out.println();
      System.out.println(fileNameTest + "is not a valid file");
      System.out.println("==================================PASS=================================");
      System.out.println(
          "The only valid file is the tally.txt. Everything else is not valid and should throw and error");
      System.out.println();

    }


  }

}


