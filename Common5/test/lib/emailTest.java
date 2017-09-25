package lib;

import lib.email;

public class emailTest {

	public static void main(String[] args) {
		
		String email1= "mariahossain6@gmail.com";
		
		email voter1Email = new email(email1);
		
		System.out.println(voter1Email.getAddress());
		System.out.println(voter1Email.getUserId());
		System.out.println(voter1Email.getHost());

	}

}
