package lib;

import lib.email;

public class emailTest {

	public static void main(String[] args) {
		
		String email1= "mariahossain6@gmail.com";
		String email2= "mariahosSain6@hotmail.com";
		
		
		email voter1Email = new email(email1);
		email voter2Email= new email(email2);
		
		System.out.println(voter1Email.getAddress());
		System.out.println(voter1Email.getUserId());
		System.out.println(voter1Email.getHost());
		
		System.out.println(voter1Email.equals(voter2Email));
		System.out.println(voter1Email.hashCode());
		
		

	}

}
