package election.business;

import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import lib.*;
import java.time.LocalDate;

public class DawsonVoter implements Voter {
	
	private static final long serialVersionUID = 42031768871L;
	
	private Name name;
	
	private Email email;
	
	private PostalCode postalCode;
	
	public DawsonVoter(String fName, String lName, String email, String postalCode) {
		this.name = new Name(fName, lName);
		this.email = new Email(email);
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
	
	public void setPostalCode(PostalCode newpostalCode) {
		this.postalCode = new PostalCode(newpostalCode);
	}

	@Override
	public int compareTo(Voter voter) {
		return this.email.compareTo(voter.getEmail());
	}

	@Override
	public boolean isEligible(Election election) {
		
		LocalDate now = LocalDate.now();
		
		return (!now.isBefore(election.getStartDate())) && (!now.isAfter(election.getEndDate())) &&
			   (this.postalCode.inRange(election.getPostalRangeStart(), election.getPostalRangeEnd()));
	}
	
	@Override
	public final boolean equals(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException("The obj parameter must be non-null");
		}
		
		return (obj instanceof DawsonVoter) && this.email.equals(((DawsonVoter) obj).email);
	}
	
	@Override
	public final int hashCode() {
		int prime = 157;
		return prime * this.email.hashCode();
	}
	
	@Override
	public String toString() {
		return this.email.toString() + '*' + this.name.getFirstName() + '*'
			   + this.name.getLastName() + '*' + this.postalCode.toString();
	}

}
