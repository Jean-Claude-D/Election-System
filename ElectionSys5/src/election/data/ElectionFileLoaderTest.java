package election.data;

import java.io.IOException;
import election.business.DawsonElection;
import election.business.DawsonTally;
import election.business.interfaces.Election;

public class ElectionFileLoaderTest {

  public static void main(String[] args) throws IOException {


    // Variables
    String nameOfFile = null;
    boolean expectedResult = false;


    // The test method where we will pass the variables

    // Variable Team mate 1
    testGetVoterListFromSequentialFile(nameOfFile, expectedResult);

    // Variable Team mate 2
    testGetElectionListFromSequentialFile(nameOfFile, expectedResult);

    // Variable Team mate 3

    String nameOfFile3 = "datafiles/tally.txt";
    String nameofFile4 = "datafiles/elections25";
    String nameofFile5 = "";
    String nameofFile6 = "abejck";

    Boolean expectedResult3 = true;
    Boolean expectedResult4 = false;
    Boolean expectedResult5 = false;
    Boolean expectedResult6 = false;

    String nameElection1 = "Dawson Color Election 2020";
    String nameElection2 = "Prom Queen";
    String nameElection3 = "Favourite Food";

    String type1 = "Ranked";
    String type2 = "Ranked";
    String type3 = "Ranked";

    int startYear1 = 2017;
    int startYear2 = 2017;
    int startYear3 = 2017;

    int startMonth1 = 10;
    int startMonth2 = 11;
    int startMonth3 = 12;

    int startDay1 = 28;
    int startDay2 = 16;
    int startDay3 = 17;

    int endYear1 = 2018;
    int endYear2 = 2018;
    int endYear3 = 2018;

    int endMonth1 = 5;
    int endMonth2 = 6;
    int endMonth3 = 7;

    int endDay1 = 15;
    int endDay2 = 16;
    int endDay3 = 17;

    String startRange1 = null;
    String startRange2 = null;
    String startRange3 = null;

    String endRang1 = null;
    String endRang2 = null;
    String endRang3 = null;

    int choice = 0;

    DawsonTally tally1 = new DawsonTally(choice, nameElection1);
    DawsonTally tally2 = new DawsonTally(choice, nameElection2);
    DawsonTally tally3 = new DawsonTally(choice, nameElection3);

    Election election1 = new DawsonElection(nameElection1, type1, startYear1, startMonth1,
        startDay1, endYear1, endMonth1, endDay1, startRange1, endRang1, tally1, "H", "Jean Claude",
        "Felicia", "Maria");
    Election election2 = new DawsonElection(nameElection2, type2, startYear2, startMonth2,
        startDay2, endYear2, endMonth2, endDay2, startRange2, endRang2, tally2, "H", "Jean Claude",
        "Felicia", "Maria");
    Election election3 = new DawsonElection(nameElection3, type3, startYear3, startMonth3,
        startDay3, endYear3, endMonth3, endDay3, startRange3, endRang3, tally3, "H", "Jean Claude",
        "Felicia", "Maria");

    Election[] allElectionCreated = {election1, election2, election3};


    testsetExistingTallyFromSequentialFile(nameOfFile3, expectedResult3, allElectionCreated);
    testsetExistingTallyFromSequentialFile(nameofFile4, expectedResult4, allElectionCreated);
    testsetExistingTallyFromSequentialFile(nameofFile5, expectedResult5, allElectionCreated);
    testsetExistingTallyFromSequentialFile(nameofFile6, expectedResult6, allElectionCreated);



  }// Main

  public static void testGetVoterListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetVoterListFromSequentialFile

  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

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


