package lib;

import java.io.Serializable;


public class email implements Serializable{
	
	
	private final long serialVersionUID = 4203172017L;
	
	private final String address;
	
	public email(String address){
		
		this.address=address;
		
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

		  if (this instanceof email){
			  
		  
		    if (email.toString().equalsIgnoreCase(this.getAddress())){
		      
		      return true;
		    
		    }
		    
		  else { 
		  
		  return false;
		  
		  }
		  }
		    
		  }
		  
	}

}
