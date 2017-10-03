package election.business;

import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import lib.Name;
import java.time.LocalDate;

public class DawsonVoter implements Voter {
	
	private static final long serialVersionUID = 42031768871L;
	
	private final Name name;
	
	private final Email email;
	
	private final PostalCode postalCode;
	
	public DawsonVoter(String fName, String lName, String email, String postalCode) {
		this.name = new Name(fName, lName);
		this.eMail = new Email(email);
		this.postalCode = new PostalCode(postalCode);
	}
	
	@Override
	public Name getName() {
		return this.name;
	}
	
	@Override
	public Email getEmail() {
		return this.email;
	}

	@Override
	public PostalCode getPostalCode() {
		return this.postalCode;
	}
	
	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = new PostalCode(postalCode);
	}

	@Override
	public int compareTo(Voter arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEligible(Election election) {
		if()
		return false;
	}

}
