package election.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ElectionFileLoaderTest {

	public static void main(String[] args) throws IOException {
		
		
		//Variables
		String nameOfFile = null;
		boolean expectedResult= false;
		
		
		//The test method where we will pass the variables
		
		//Variable Team mate 1 
		testGetVoterListFromSequentialFile(nameOfFile,expectedResult);
		
		//Variable Team mate 2
		testGetElectionListFromSequentialFile(nameOfFile,expectedResult);
		
		//Variable Team mate 3 
		testsetExistingTallyFromSequentialFile(nameOfFile,expectedResult);
		
	

	}// Main

	public static void testGetVoterListFromSequentialFile(String fileNameTest, boolean expectedValid) {

	}// End of Testing GetVoterListFromSequentialFile

	public static void testGetElectionListFromSequentialFile(String fileNameTest, boolean expectedValid) {

	}// End of Testing GetElectionListFromSequentialFile

	public static void testsetExistingTallyFromSequentialFile(String fileNameTest, boolean expectedValid) {
	
	}// End of testing SetExistingTallyFromSequentialFile
	

}
