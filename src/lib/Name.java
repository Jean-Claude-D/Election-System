/**
 * 
 */
package lib;

/**
 * @author Mish
 *
 */
public class Name {
	private String firstname;
	private String lastname;

	public Name (String fname, String lname) {
		this.firstname = fname;
		this.lastname = lname;
		
	}

	public Name(Name name) {
		this.firstname = name.firstname;
		this.lastname = name.lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * @return the lastname
	 */
	public String getFullName() {
		return (firstname + " " + lastname);
	}
	
	

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
	    return (this.firstname + "*" + this.lastname + "*");
	}

	
}