package lib;

import lib.Name;

public class NameTest {

	public static void main(String[] args) {
		//  These String variables below will be used throughout the test.
		final String firstName1 = "Großer";
		final String lastName1 = "Kurfürst";
		final String firstName2 = "Friedrich";
		final String lastName2 = "Der Grosse";
		
		testConstructor();
		testGetterMethod(firstName1, lastName1);
		testToString(firstName1, lastName1);
		testCopyConstructor(firstName2, lastName2);
		testCompareTo(firstName1, lastName1, firstName2, lastName2);
		testEqualAndHashCode(firstName1, lastName1, firstName2, lastName2);
	}
		
	private static void testConstructor() {
		try {
			System.out.println("Create 3 Valid Name Objects:");
			System.out.println("+ Luke Skywalker");
			System.out.println("+ MA-CE WIN'DU");
			System.out.println("+ Han's Get Z e FLAMMEN-WERFER");
			Name person1 = new Name("Luke", "Skywalker");
			Name person2 = new Name("MA-CE", "WIN'DU");
			Name person3 = new Name("Han's", "Get Z e FLAMMEN-WERFER");
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println("----------------------------");
			System.out.println();
		}
		catch (IllegalArgumentException ex) {
			System.out.println("TEST FAILED");
		}
		
		System.out.println("Create 3 Invalid Name Objects:");
		System.out.println("+ J#ohn !Cena");
		System.out.println("+  Steve Job ");  // SPACE AT THE BEGINNING OF fname AND AT THE END OF lname
		System.out.println("+ Alex--ander T''he Gr-e--at");
		System.out.println();
		
		try {
			Name person4 = new Name("J#ohn", "!Cena");
			System.out.println("TEST FAILED");
		}
		catch (IllegalArgumentException ex) {
			System.out.println("\"J#ohn !Cena\" is not a valid name\t\t\t === TEST PASSED ===");
			System.out.println("----------------------------");
			System.out.println();
		}
		
		try {
			Name person5 = new Name(" Steve", "Job ");  // Space at beginning of fname and at the end of lname
			System.out.println("TEST FAILED");
		}
		catch (IllegalArgumentException ex) {
			System.out.println("\" Steve Job \" is not a valid name\t\t\t === TEST PASSED ===");
			System.out.println("----------------------------");
			System.out.println();
		}
		
		try {
			Name person6 = new Name("Alex--ander", "T''he Gr-e--at");
			System.out.println("TEST FAILED");
		}
		catch (IllegalArgumentException ex) {
			System.out.println("\"Alex--ander T''he Gr-e--at\" is not a valid name\t === TEST PASSED ===");
			System.out.println("----------------------------");
			System.out.println();
		}
	}
	
	private static void testGetterMethod(String a, String b) {
		Name person1 = new Name(a, b);
		System.out.println("Test getter methods (get first/last/full name)");
		
		System.out.println( (person1.getfirstName().equals(a)) ? "person1's first name is: " + person1.getfirstName() + "\t\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println( (person1.getlastName().equals(b)) ? "person1's last name is: " + person1.getlastName() + "\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println( (person1.getFullName().equals(a + " " + b)) ? "person1's full name is: " + person1.getFullName() + "\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();
	}

	private static void testToString(String a, String b) {
		Name person1 = new Name(a, b);
		System.out.println("Test toString method");
		System.out.println( (person1.toString().equals(a + "*" + b)) ? "person1's toString is: " + person1.toString() + "\t\t\t === TEST PASSED ===" : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();
	}
	
	private static void testCopyConstructor(String a, String b) {
		Name person2 = new Name(a, b);  // person2 will be used throughout this test.
		Name copyPerson2 = new Name(person2);  // copyPerson2 will be used throughout this test.
		System.out.println("Test Copy Constructor");
		System.out.println( (copyPerson2.getfirstName().equals(a)) ? "copyPerson2's first name is: " + copyPerson2.getfirstName() + "\t\t\t === TEST PASSED ==="  : "TEST FAILED" );
		System.out.println( (copyPerson2.getlastName().equals(b)) ? "copyPerson2's last name is: " + copyPerson2.getlastName() + "\t\t\t === TEST PASSED ==="  : "TEST FAILED" );
		System.out.println( (copyPerson2.getfirstName().equals(a)) ? "copyPerson2's full name is: " + copyPerson2.getFullName() + "\t === TEST PASSED ==="  : "TEST FAILED" );
		System.out.println( person2.equals(copyPerson2) ? "person2 name is : " + person2.getFullName() + "\t\t\t === TEST PASSED ==="  : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();
	}
	
	private static void testCompareTo(String a, String b, String c, String d) {
		Name person1 = new Name(a, b);
		Name person2 = new Name(c, d);
		Name copyPerson2 = new Name(person2);
		System.out.println("Test compareTo method");
		
		System.out.println("Compare person2 to null");
		try {
			person2.compareTo(null);	
			System.out.println("TEST FAILED");
		}
		catch (IllegalArgumentException ex) {
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
		}
		
		int check1 = person2.compareTo(copyPerson2);
		int check2 = person2.compareTo(person1);
		int check3 = person2.compareTo(person2);
		int check4 = copyPerson2.compareTo(person2);
		;
		System.out.println( (check1 == 0) ? "Value of check1 is: " + check1  + "\t\t\t\t\t === TEST PASSED ==="   : "TEST FAILED" );
		System.out.println( (check2 < 0) ? "Value of check2 is: " + check2  + "\t\t\t\t\t === TEST PASSED ==="   : "TEST FAILED" );
		System.out.println( (check3 == 0) ? "Value of check3 is: " + check3  + "\t\t\t\t\t === TEST PASSED ==="   : "TEST FAILED" );
		System.out.println( (check4 == 0) ? "Value of check3 is: " + check4  + "\t\t\t\t\t === TEST PASSED ==="   : "TEST FAILED" );
		System.out.println("------------------------------");
		System.out.println();
	}
	
	private static void testEqualAndHashCode(String a, String b, String c, String d) {
		Name person1 = new Name(a, b);
		Name person2 = new Name(c, d);
		Name copyPerson2 = new Name(person2);
		System.out.println("Test equals method and hashcode method");
		
		if (person2.equals(person2) && (person2.hashCode() == person2.hashCode()))
		{
			System.out.println("person2 is \"equal\" to person2, hence they have the same hashcode ");
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println();
		}
		else
		{
			System.out.println("\t\t\t\t\t\t\t === TEST FAILED ===");
		}
		
		if (!person2.equals(person1) && (person2.hashCode() != person1.hashCode()))
		{
			System.out.println("person2 is NOT \"equal\" to person2, hence they DO NOT have the same hashcode ");
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println();
		}
		else
		{
			System.out.println("TEST FAILED");
		}
		
		if (person2.equals(copyPerson2) && (person2.hashCode() == copyPerson2.hashCode()))
		{
			System.out.println("person2 is \"equal\" to copyPerson2, hence they DO NOT have the same hashcode ");
			System.out.println("\t\t\t\t\t\t\t === TEST PASSED ===");
			System.out.println();
		}
		else
		{
			System.out.println("TEST FAILED");
		}		
	}
}




