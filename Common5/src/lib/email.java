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
		
		if (this.address.indexOf('@') == -1) {
			
			throw new IllegalArgumentException("This is not an Email");
		}
		
		return address; 
		
	}
	
	
		  
	}


