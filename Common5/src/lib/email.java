package lib;

import java.io.Serializable;


public class email implements Serializable, Comparable<email>{
	
	private static final long serialVersionUID = 4203172017L;
	private final String address;
	
	
	
	
	public email(String address){
		
		this.address=validateEmail(address);
		
	}

	public String getAddress() {
		return address;
	}
	
	public String getUserId() {
		
		return address.substring(0, address.indexOf('@'));
		
	}
	
	public String getHost() {
		
		return address.substring(address.indexOf('@'));
	}
	
	@Override
	
	public boolean equals(Object email){

		  if (this instanceof email) {
			  
		  
		    if (email.toString().equalsIgnoreCase(this.getAddress())) {
		      
		      return true;
		    }
		  
		  }
		return false;  
	}	
		
	@Override
	
	public int hashCode() {
		
		return this.getAddress().toLowerCase().hashCode();
		
		}
		  
	
	
	@Override
	
	public String toString() {
		
		return this.getAddress();
		
	}
	
	
	
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


