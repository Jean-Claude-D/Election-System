package election.data;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import util.ListUtilities;

public class SortMergeApp {
	

	
	
	/*
	 * This method creates a File object that contains all the files from the unsorted directory and stores their name in a String array
	 * In a for loop that goes through all the names in the array: 
	 * 		check if the name contains "voters" 
	 * 		if it does, modify the path so it includes the text file's name and verify if it exists
	 * 		if it exists, read and place all the lines in an array
	 * 		sort that array and place the sorted array in a new file using savelistToTextFile(array,fileName)
	 * 
	 * 		if it doesn't contain "voters", see if it contains "elections"
	 * 		repeat the same steps
	 */
	public static void sortAndStore() throws IOException{
		
		String path = "/ElectionSys/ElectionSys5/datafiles/unsorted";
		List<String> unsortedArray = new ArrayList<>();

		File files = new File(path);
		String[] listOfFiles = files.list();
		
		for(int i = 0; i < listOfFiles.length; i++) {
			//checkif file name contains "voters"
			if(listOfFiles[i].matches("voters")) {
				path = path + "/voters" + i + ".txt";
				File voterFile = new File(path);
				if (voterFile.exists()) {
					Path p = Paths.get(path);
					unsortedArray = Files.readAllLines(p);
					String[] sortedArray = unsortedArray.toArray(new String[unsortedArray.size()]);
					ListUtilities.sort(sortedArray);
					ListUtilities.saveListToTextFile(sortedArray, "sortedVoters" + i + ".txt");
				}
			}
			else if(listOfFiles[i].matches("elections")) {
				path = path + "/elections" + i + ".txt";
				File electionFile = new File(path);
				if (electionFile.exists()) {
					Path p = Paths.get(path);
					unsortedArray = Files.readAllLines(p);
					String[] sortedArray = unsortedArray.toArray(new String[unsortedArray.size()]);
					ListUtilities.sort(sortedArray);
					ListUtilities.saveListToTextFile(sortedArray, "sortedElections" + i + ".txt");
				}
				
			} 
		}	
		
	}//end sort and store
	
	
	/*
	 * merge them together (first merges with 2 to make "Total", total merges with 3 and updates total, total merges with 4, etc. 
	 * Total now contains the 4 first voters
	 * place the final result in datafiles\database\voters.txt
	 * duplicate voters must be stored in datafiles\database\duplicatevoters.txt
	 */
	public static void mergeAll() throws IOException{
		
		String path = "/ElectionSys/ElectionSys5/datafiles/unsorted";
		List<String> superSaiyanArray = new ArrayList<>();

		File files = new File(path);
		String[] listOfFiles = files.list();
		
		for(int i = 0; i < listOfFiles.length; i++) {
			//check if file name contains "voters"
			if(listOfFiles[i].matches("voters")) {
				path = path + "/voters" + i + ".txt";
				File voterFile = new File(path);
				if (voterFile.exists()) {
					Path p = Paths.get(path);
					superSaiyanArray = Files.readAllLines(p);
					String[] sortedArray = superSaiyanArray.toArray(new String[superSaiyanArray.size()]);
					
				}
			}
			else if(listOfFiles[i].matches("elections")) {
				path = path + "/elections" + i + ".txt";
				File electionFile = new File(path);
				if (electionFile.exists()) {
					Path p = Paths.get(path);
					superSaiyanArray = Files.readAllLines(p);
					String[] sortedArray = superSaiyanArray.toArray(new String[superSaiyanArray.size()]);
					ListUtilities.sort(sortedArray);
					ListUtilities.saveListToTextFile(sortedArray, "sortedElections" + i + ".txt");
				}
				
			} 
		}
	}
	
	
	/*
	 * 
	 */
	
	
	
}

