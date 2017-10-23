package election.business;

import java.util.Comparator;

import election.business.interfaces.Voter;

public class VoterNameComparator implements Comparator<Voter> {

	@Override
	public int compare(Voter voter1, Voter voter2) {

		if (voter1.getName().equals(voter2.getName())) {

			if (voter1.getName().compareTo(voter2.getName()) == 0){

				return 0;
			}

			else if(voter1.getName().compareTo(voter2.getName()) == 1) {

				return 1;
			}

			else {

				return -1;
			}
		}
		
		//If it does not go in the if statement it is because the name of the voters are not the same so it will
		//Automatically return -1
		return -1;
		
		
	}

}



