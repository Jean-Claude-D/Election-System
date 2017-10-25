package election.data;

import java.io.IOException;
import election.business.DawsonElection;
import election.business.DawsonTally;
import election.business.interfaces.Election;

public class ElectionFileLoaderTest {

  public static void main(String[] args) throws IOException {

    DawsonTally tally = new DawsonTally(1, "null");

    DawsonElection test1 = new DawsonElection("Federal Canadian Election 2017-18", "ranked", 2017,
        11, 1, 2017, 11, 4, "", "", tally, "randomPoliticalNo1", "randomPoliticalNo2");
    test1.setTally(new DawsonTally(test1.getElectionChoices().length, test1.getName()));

    DawsonElection test2 = new DawsonElection("Dawson Color Election 2020", "ranked", 2020, 12, 20,
        2022, 1, 20, "", "", tally, "Red", "Green", "Orange", "Blue", "Pink", "Cyan");
    test2.setTally(new DawsonTally(test2.getElectionChoices().length, test2.getName()));

    DawsonElection test3 =
        new DawsonElection("National Hair Style Election", "ranked", 3017, 6, 23, 3017, 9, 29, "",
            "", tally, "Crew", "Mullet", "Afro", "YoungDicaprio", "Dreads", "Undercut", "Ombre");
    test3.setTally(new DawsonTally(test3.getElectionChoices().length, test3.getName()));

    testGetElectionListFromSequentialFile("datafiles/elections3.txt", test1, test2, test3);

    testGetElectionListFromSequentialFile("datafiles/elections3.txt", test1, test2, test3);
  }

  public static void testGetVoterListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetVoterListFromSequentialFile

  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      DawsonElection check1, DawsonElection check2, DawsonElection check3) throws IOException {

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
      boolean expectedValid) {

  }// End of testing SetExistingTallyFromSequentialFile


}
