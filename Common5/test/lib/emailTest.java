package lib;

import lib.email;

public class emailTest {

	public static void main(String[] args) {
		
		
		//Created 2 email address String with identical UserID and diffrent 
		//HostId
		String email1= "mariahossain6@gmail.com";
		String email2= "mariahosSain6@hotmail.com";
		
		//Using the email address, we created 2 email objects to test the methods
		//within it
		email voter1Email = new email(email1);
		email voter2Email= new email(email2);
		
		
		
		System.out.println(voter1Email.getAddress());//Output:mariahossain6@gmail.com
		System.out.println(voter1Email.getUserId());//Output:mariahossain6
		System.out.println(voter1Email.getHost());//Output: gmail.com
		
		System.out.println(voter1Email.equals(voter2Email));//Output:False
		System.out.println(voter1Email.hashCode());//Output: A number
		
		

	}

}
