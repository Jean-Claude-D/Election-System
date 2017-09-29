package lib;

import lib.Name;

public class NameTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("Create 3 Valid Name Objects:");
			System.out.println("+ Luke Skywalker");
			System.out.println("+ MA-CE WIN'DU");
			System.out.println("+ Han's Get Z e FLAMMEN-WERFER");
			Name person1 = new Name("Luke", "Skywalker");
			Name person2 = new Name("MA-CE", "WIN'DU");
			Name person3 = new Name("Han's", "Get Z e FLAMMEN-WERFER");
			System.out.println("TEST PASSED");
			System.out.println("----------------------------");
			System.out.println();
		}
		catch (IllegalArgumentException ex){
			System.out.println("TEST FAILED");
		}
		
		try {
			System.out.println("Create 3 Invalid Name Objects:");
			System.out.println("+ J#ohn !Cena");
			System.out.println("+  Steve Job ");  // SPACE AT THE BEGINNING OF fname AND AT THE END OF lname
			System.out.println("+ Alex--ander T''he Gr-e--at");
			Name person4 = new Name("J#ohn", "!Cena");
			Name person5 = new Name(" Steve", "Job ");
			Name person6 = new Name("Alex--ander", "T''he Gr-e--at");	
			System.out.println("TEST FAILED");
		}
		catch (IllegalArgumentException ex){
			System.out.println("TEST PASSED");
			System.out.println("----------------------------");
			System.out.println();
		}

		Name person1 = new Name("Großer", "Kurfürst");  // person1 will be used throughout this Test.
		
		System.out.println( (person1.getFirstName().equals("Großer")) ? "person1's first name is: " + person1.getFirstName() : "TEST FAILED" );
		System.out.println( (person1.getLastName().equals("Kurfürst")) ? "person1's last name is: " + person1.getLastName() : "TEST FAILED" );
		System.out.println( (person1.getFullName().equals("Großer Kurfürst")) ? "person1's full name is: " + person1.getFullName() : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();

					
		System.out.println("Test toString method");
		System.out.println( (person1.toString().equals("Großer*Kurfürst")) ? "person1's toString is: " + person1.toString() : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();
		
		System.out.println("Test Copy Constructor");
		Name person2 = new Name("Friedrich", "Der Grosse");  // person2 will be used throughout this test.
		Name copyPerson2 = new Name(person2);  // copyPerson2 will be used throughout this test.
		
		System.out.println( (copyPerson2.getFirstName().equals("Friedrich")) ? "copyPerson2's first name is: " + copyPerson2.getFirstName() : "TEST FAILED" );
		System.out.println( (copyPerson2.getLastName().equals("Der Grosse")) ? "copyPerson2's last name is: " + copyPerson2.getLastName() : "TEST FAILED" );
		System.out.println( (copyPerson2.getFirstName().equals("Friedrich")) ? "copyPerson2's full name is: " + copyPerson2.getFullName() : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();
		
		System.out.println("Test compareTo method");
		int a = person2.compareTo(copyPerson2);
		int b = person2.compareTo(person1);
		int c = person2.compareTo(person2);
		
		System.out.println("Compare person2 to null");
		try {
			int d = person2.compareTo(null);	
			System.out.println("TEST FAILED");

		}
		catch (IllegalArgumentException ex) {
			System.out.println("TEST PASSED");
		}
		
		
		
		System.out.println( (a == 0) ? "Value of a is: " + a : "TEST FAILED" );
		System.out.println( (b != 0) ? "Value of b is: " + b : "TEST FAILED" );
		System.out.println( (c == 0) ? "Value of c is: " + c : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();
		
		System.out.println("Test equals method and hashcode method");
		if (person2.equals(person2) && (person2.hashCode() == person2.hashCode()))
		{
			System.out.println("person2 is \"equal\" to person2, hence they have the same hashcode ");
		}
		else
		{
			System.out.println("TEST FAILED");
		}
		
		if (!person2.equals(person1) && (person2.hashCode() != person1.hashCode()))
		{
			System.out.println("person2 is NOT \"equal\" to person2, hence they DO NOT have the same hashcode ");
		}
		else
		{
			System.out.println("TEST FAILED");
		}
		
		if (person2.equals(copyPerson2) && (person2.hashCode() == copyPerson2.hashCode()))
		{
			System.out.println("person2 is \"equal\" to copyPerson2, hence they DO NOT have the same hashcode ");
		}
		else
		{
			System.out.println("TEST FAILED");
		}		
	}
}


