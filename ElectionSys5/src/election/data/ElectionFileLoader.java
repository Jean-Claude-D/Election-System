package election.data;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;

/**
 * @author Maria Hossain
 * @version  0.0.1
 * 
 * */

public class ElectionFileLoader {
	
	
	/**
	 * 
	 * @param filename
	 * @return Voter[]
	 * 
	 * This method iterate through a list voter(contained in a text file) with its information such as email,first name,last name and postal
	 * code. And basacally created and array of Voter Object with that following information.
	 */


	public static Voter[] getVoterListFromSequentialFile(String filename) {

		return null;

	}
	
	/**
	 * 
	 * @param filename
	 * @return Election[]
	 * 
	 * This method iterate through the text file and extract the diffrent elections and will put it into a 
	 * an array of Elections
	 */
	
	public static Election[] getElectionListFromSequentialFile(String filename) {
		
		return null;
	} 
	
	/**
	 * 
	 * @param filename
	 * @param elections
	 * 
	 * This method takes in a file and an election array. It will basacally match the name of the election in that
	 * array and match it with the matching name and display the result in an int[][]. 
	 */


	public static void setExistingTallyFromSequentialFile(String filename,Election[] elections) {
		
	}




}
