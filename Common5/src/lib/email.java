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
public class email implements Serializable, Comparable<email>{
	
	private static final long serialVersionUID = 4203172017L;
	private final String address;
	
	
/**
 * 	
 * @param address
 * 
 * This constructor take a String and Validates the address string to make it complies with the
 * restriction of what the email should look like
 */
	
	public email(String address){
		
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

		  if (this instanceof email) {
			  
		  
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
		
		return this.getAddress();
		
	}
	
	/**
	 * 
	 * Check is 2 adress are written the same way
	 */
	
	
	
	public int compareTo(email emails) {
		
		if (this.getHost().compareTo(emails.getHost()) == 1) {
			
			return 1;
		}
		
		else if (this.getHost().compareTo(emails.getHost()) == -1) {
			
			return -1;
		}
		
		else if (this.getUserId().compareTo(emails.getUserId()) == 1) {
			
			return 1;
		}
		
		else if(this.getUserId().compareTo(emails.getUserId()) == 1) {
			
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
			
			throw new IllegalArgumentException("not valid");
		}
		
		else if (userid.length() <1 || userid.length() >32) {
			
			throw new IllegalArgumentException("not valid");
		}
		
		
		
		for (int i= 0; i< userid.length(); i++) {
			char currentChar = userid.charAt(i);
			
			if(!(currentChar== Character.UPPERCASE_LETTER || currentChar== Character.DECIMAL_DIGIT_NUMBER ||
			currentChar== Character.LOWERCASE_LETTER || currentChar== '-' || currentChar== '_' || currentChar == '.') ) {
				
				throw new IllegalArgumentException("not valid");
			}
			
			if (currentChar == '.') {
				
				if( userid.charAt(i+1) =='.')  {
					
					throw new IllegalArgumentException("not valid");
				}	
				
				
			}
			
			
			
			
		}
		
if (hostid.charAt(0) == '-' || hostid.charAt( ( hostid.length() ) -1) == '-') {
			
			throw new IllegalArgumentException("not valid");
		}

else if (hostid.length() <1 || hostid.length() >32) {
	
	throw new IllegalArgumentException("not valid");
}

		
		
	
	
	for(int i=0; i< domainArray.length; i++) {
		
		
		for(int r= 0; r <domainArray[i].length();i++) {
		
		if(!(domainArray[i].charAt(r)== Character.UPPERCASE_LETTER) || domainArray[i].charAt(r)== Character.DECIMAL_DIGIT_NUMBER ||
				domainArray[i].charAt(r)== Character.LOWERCASE_LETTER || domainArray[i].charAt(r)== '-' || domainArray[i].charAt(r)== '_' || 
				domainArray[i].charAt(r) == '.') {
					
					throw new IllegalArgumentException("not valid");
				}
		
		if (domainArray[i].charAt(r) == '.') {
			
			if( domainArray[i].charAt(r+1) =='.')  {
				
				throw new IllegalArgumentException("not valid");
			}
		
		
		}
		
	}
		}
	
	return address;
		
	}
	
		  
	}


