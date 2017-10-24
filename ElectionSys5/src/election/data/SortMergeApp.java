package election.data;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SortMergeApp {
	
	private Path path= new Path( "\\ElectionSys\\ElectionSys5\\datafiles");
	
	/*
	 * load(read) 9 voter files and sort and put in new file datafiles\sorted\sorteVotersX where X 
	 * is the number of the voter file
	 */
	public static void sortVoters() {
		Paths.get(path);
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
