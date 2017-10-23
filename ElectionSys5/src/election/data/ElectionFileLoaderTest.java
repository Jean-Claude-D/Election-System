package election.data;

import java.io.IOException;
import election.business.DawsonElection;
import election.business.DawsonTally;

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
    testsetExistingTallyFromSequentialFile(nameOfFile, expectedResult);



  }// Main

  public static void testGetVoterListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetVoterListFromSequentialFile

  public static void testGetElectionListFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

  }// End of Testing GetElectionListFromSequentialFile

  public static void testsetExistingTallyFromSequentialFile(String fileNameTest,
      boolean expectedValid) {

    String nameElection1 = "Dawson Color Election 2020";
    String nameElection2 = "Prom Queen";
    String nameElection3 = "Favourite Food";

    String type1 = "Ranked";
    String type2 = "Ranked";
    String type3 = "Ranked";

    int startYear1 = 2017;
    int startYear2 = 2016;
    int startYear3 = 2015;

    int startMonth1 = 5;
    int startMonth2 = 6;
    int startMonth3 = 7;

    int startDay1 = 15;
    int startDay2 = 16;
    int startDay3 = 17;

    int endYear1 = 2018;
    int endYear2 = 2017;
    int endYear3 = 2016;

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

    int choice;

    DawsonTally tally1 = new DawsonTally((Integer) null, nameElection1);
    DawsonTally tally2 = new DawsonTally((Integer) null, nameElection2);
    DawsonTally tally3 = new DawsonTally((Integer) null, nameElection3);

    DawsonElection election1 = new DawsonElection(nameElection1, type1, startYear1, startMonth1,
        startDay1, endYear1, endMonth1, endDay1, startRange1, endRang1, tally1);
    DawsonElection election2 = new DawsonElection(nameElection2, type2, startYear2, startMonth2,
        startDay2, endYear2, endMonth2, endDay2, startRange2, endRang2, tally2);
    DawsonElection election3 = new DawsonElection(nameElection3, type3, startYear3, startMonth3,
        startDay3, endYear3, endMonth3, endDay3, startRange3, endRang3, tally3);

    DawsonElection[] allElectionCreated = {election1, election2, election3};



  }// End of testing SetExistingTallyFromSequentialFile


}
