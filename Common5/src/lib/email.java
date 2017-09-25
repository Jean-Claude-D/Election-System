package lib;

//blablab
public class email {
	
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

}
