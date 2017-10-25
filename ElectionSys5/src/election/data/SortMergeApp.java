package election.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SortMergeApp {
	
	private static String path = "/ElectionSys/ElectionSys5/datafiles/unsorted";
	static List<String> arrayOfVoters = new ArrayList<>();
	
	
	/*
	 * load(read) 9 voter files and sort and put in new file datafiles\sorted\sorteVotersX where X 
	 * is the number of the voter file
	 */
	public static void sortVoters() throws IOException{
		//read and place in array
		//sort array
		//put sorted array in new file
		//repeat
		ListUtilities a = new ListUtilities();
		File voters = new File(path);
		String[] listOfVoters = voters.list();
		for(int i = 0; i < listOfVoters.length; i++) {
			//checkif file nate containes "voters"
			if(listOfVoters[i].matches("voters")) {
				path = path + "/voters" + i + ".txt";
				File voterFile = new File(path);
				if (voterFile.exists()) {
					Path p = Paths.get(path);
					arrayOfVoters = Files.readAllLines(p);
					String[] sortedArray = arrayOfVoters.toArray(new String[arrayOfVoters.size()]);
					ListUtilities.sort(sortedArray);
				}
				
			}
			//call this method
			ElectionFileLoader.GetVoterListFromSequentialFile(listOfVoters[i]);
		}
		
		
		
	}
	
	
	/*
	 * merge them together (first merges with 2 to make "Total", total merges with 3 and updates total, total merges with 4, etc. 
	 * Total now contains the 4 first voters
	 * place the final result in datafiles\database\voters.txt
	 * duplicate voters must be stored in datafiles\database\duplicatevoters.txt
	 */
	public static void mergeVoters(Path sortedVorters) {
		
	}
	
	
	/*
	 * 
	 */
	
	
	
}
