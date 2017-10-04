package lib;

import java.io.Serializable;

/**
 * 
 * @author Maria Hossain
 * @since Oct 2nd 2017
 * 
 *
 *
 */
public class Email implements Serializable, Comparable<Email>{

	private static final long serialVersionUID = 4203172017L;
	private final String address;


	/**
	 * 	
	 * @param address
	 * 
	 * This constructor take a String and Validates the address string to comply with the
	 * restriction of what the email should look like
	 */

	public Email(String address){

		this.address=validateEmail(address);

	}

	/**
	 * 
	 * @return Returns the email address
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * returns the userId part of the email
	 * 
	 * @return 
	 */

	public String getUserId() {

		return address.substring(0, address.indexOf('@'));

	}

	/**
	 * 
	 * Returns the host of the email
	 * @return
	 */

	public String getHost() {

		return address.substring(address.indexOf('@'));
	}


	/**
	 * 
	 * Verifies that the object is of the same instance as the email class and checks if its
	 * email address is the same 
	 */

	@Override

	public boolean equals(Object email){

		if(email== null) {

			throw new IllegalArgumentException("email cannot be null");

		}

		if (this instanceof Email) {


			if (email.toString().equalsIgnoreCase(this.getAddress())) {

				return true;
			}

		}
		return false;  
	}	


	/**
	 * 
	 * 
	 * Returns the hashcode of the email address while being case insensitive
	 */

	@Override

	public int hashCode() {

		return this.getAddress().toLowerCase().hashCode();

	}


	/**
	 * 
	 * 
	 * Returns the String version of the email address
	 */



	@Override

	public String toString() {

		return this.address;

	}

	/**
	 * 
	 * Check is 2 address are written the same way
	 */



	public int compareTo(Email emails) {

		if (this.getHost().compareTo(emails.getHost()) > 0) {

			return 1;
		}

		else if (this.getHost().compareTo(emails.getHost()) < 0) {

			return -1;
		}

		else if (this.getUserId().compareTo(emails.getUserId()) > 0) {

			return 1;
		}

		else if(this.getUserId().compareTo(emails.getUserId()) < 0) {

			return -1;
		}

		else {

			return 0;
		}
	}


	/**
	 * Makes sure that the string passed in the constructor is a valid email address
	 * @param address
	 * @return
	 */

	private String validateEmail(String address) {

		String userid= address.substring(0, address.indexOf('@'));
		String hostid= address.substring(address.indexOf('@'));
		String[] domainArray= hostid.split(".");


		if (userid.charAt(0) == '.' || userid.charAt( ( userid.length() ) -1) == '.') {

			throw new IllegalArgumentException("Your userId should not begin or end with a dot");
		}

		else if (userid.length() <1 || userid.length() >32) {

			throw new IllegalArgumentException("Your userId should not be less than 1 and more than 32 characters");
		}



		for (int i= 0; i< userid.length(); i++) {
			char currentChar = userid.charAt(i);
			int category = Character.getType(currentChar);

			if(!(category == Character.UPPERCASE_LETTER || category== Character.DECIMAL_DIGIT_NUMBER ||
					category== Character.LOWERCASE_LETTER || currentChar == '-' || currentChar== '_' || currentChar == '.') ) {

				throw new IllegalArgumentException("UserId cannot contain " + currentChar);
			}

			if (currentChar == '.') {

				if( userid.charAt(i+1) =='.')  {

					throw new IllegalArgumentException("You user Id should not have 2 consecutive dots \'" + userid + '\'');
				}	


			}




		}

		if (hostid.charAt(0) == '-' || hostid.charAt( ( hostid.length() ) -1) == '-') {

			throw new IllegalArgumentException("HostId Cannot start or end with a dash");
		}





		for(int i=0; i< domainArray.length; i++) {
			
			if(! (domainArray[i].length() > 1) || ! (domainArray[i].length() < 32)) {
				throw new IllegalArgumentException("domain name " + domainArray[i] + " is too long or too short.");
			}


			for(int r= 0; r <domainArray[i].length();i++) {
				
				if(!(domainArray[i].charAt(r)== Character.UPPERCASE_LETTER) || domainArray[i].charAt(r)== Character.DECIMAL_DIGIT_NUMBER ||
						domainArray[i].charAt(r)== Character.LOWERCASE_LETTER || domainArray[i].charAt(r)== '-' || domainArray[i].charAt(r)== '_' || 
						domainArray[i].charAt(r) == '.') {

					throw new IllegalArgumentException("The hostId cannot have invalid characters");
				}

				if (domainArray[i].charAt(r) == '.') {

					if( domainArray[i].charAt(r+1) =='.')  {

						throw new IllegalArgumentException("The hostId cannot have 2 consecutive dots");
					}


				}

			}
		}

		return address;

	}


}


