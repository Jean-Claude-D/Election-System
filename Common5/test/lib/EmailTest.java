package lib;

import lib.Email;

public class EmailTest {

	public static void main(String[] args) {
		
		
		//Created 2 email address String with identical UserID and different 
		//HostId
		String email1= "mariahossain6@gmail.com";
		String email2= "mariahosSain6@hotmail.com";
		String email3= "maria@ol";
		String email4= "peter-griffin@familguy.com";
			
		testConstructorEmail();
		
		testGetterMethod(email1);
		testGetterMethod(email2);
		testGetterMethod(email3);
		testGetterMethod(email4);
		
		testEqualsAndHashcode(email1,email2);
		testEqualsAndHashcode(email2,email4);
		
		

	}// -------End of Main Method
	
	public static void testConstructorEmail() {
		
		try {
		System.out.println("Below are 3 Valid Emails");
		System.out.println("brent.sensei@hotmail.com");
		System.out.println("gfo@whatever.me");
		System.out.println("soccerforever@gymlife.ca");
		
		System.out.println();
		
		Email email1=new Email("brent.sensei@hotmail.com");
		Email email2=new Email("gfo@whatever.me");
		Email email3=new Email("soccerforever@gymlife.ca");
		
		System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
		System.out.println("----------------------------");
		System.out.println();
		
		}
		catch(IllegalArgumentException e) {
			
			System.out.println("TEST FAILED");
		}
		
		
		System.out.println("Below are 3 InValid Emails");
		System.out.println("brent..t@gmail.co");
		System.out.println("--lalaland@cristmas.com");
		System.out.println("bestGrandpa.@hotmail.co");
		
		
		try {
			
			Email email4=new Email("brent..t@gmail.co");
			System.out.println("TEST FAIL");
		}
		
		catch(IllegalArgumentException e) {
			
			System.out.println("brent..t@gmail.co is not a valid name\t\t\t === TEST PASSED ===");
			System.out.println("----------------------------");
			System.out.println();
			
		}
		
try {
			
			Email email5=new Email(".lalaland@.0.cristmas.com");
			System.out.println("TEST FAIL");
		}
		
		catch(IllegalArgumentException e) {
			
			System.out.println(".lalaland@.0.cristmas.com is not a valid name\t\t\t === TEST PASSED ===");
			System.out.println("----------------------------");
			System.out.println();
			
		}

try {
	
	Email email6=new Email("bestGrandp.@hotmail.co");
	System.out.println("TEST FAIL");
}

catch(IllegalArgumentException e) {
	
	System.out.println("bestGrandpa.@hotmail.co is not a valid name\t\t\t === TEST PASSED ===");
	System.out.println("----------------------------");
	System.out.println();
	
}
		
		
	}//----------End of Test Validate Method
	
	
	public static void testGetterMethod(String a) {
		
		Email email7= new Email(a);
		
		System.out.println((email7.getAddress().equals(a)) ? "The email is: " + email7.getAddress() + "\t\t\t\t === TEST PASSED ===" : "TEST FAILED");
		System.out.println((email7.getUserId().equals(email7.getUserId())) ? "The userID is: " + email7.getUserId() + "\t\t\t\t === TEST PASSED ===" :"TEST FAILED");
		System.out.println((email7.getHost().equals(email7.getHost())) ? "The hostID is: " + email7.getHost() + "\t\t\t\t === TEST PASSED ===" :"TEST FAILED");
		System.out.println("------------------------------");
		System.out.println();
	}//----------End of Test getAddress Method
	
	
	public static void testEqualsAndHashcode(String a, String b) {
		
		Email email1 = new Email(a);
		Email email2 = new Email(b);
		Email email2Copy = new Email(b);
		System.out.println("We will test equals and hashcode method at the same time");
		
		if (email2.equals(email2) && (email2.hashCode() == email2.hashCode()))
		{
			System.out.println("Email2 is \"equal\" to Email2, Therefore they have the same hashcode ");
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println();
		}
		else
		{
			System.out.println("\t\t\t\t\t\t\t === TEST FAILED ===");
		}
		
		if (!email2.equals(email1) && (email2.hashCode() != email1.hashCode()))
		{
			System.out.println("Email2 is NOT \"equal\" to Email1, hence they DO NOT have the same hashcode ");
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println();
		}
		else
		{
			System.out.println("TEST FAILED");
		}
		
		
		if (email2.equals(email2Copy) && (email2.hashCode() == email2Copy.hashCode()))
		{
			System.out.println("email2 is \"equal\" to copyEmail2, hence they DO NOT have the same hashcode ");
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println();
		}
		else
		{
			System.out.println("TEST FAILED");
		}
	}// --------------------End of testing Equalsto and Hashcode method at the sametime
	
	
	

}
