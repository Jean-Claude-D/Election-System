package lib;

public class PostalCodeTest {
	
	public static void compareToTest() {
		
	}
	
	public static void equalsTest() {
		
	}

	public static void hashCodeTest() {
	
	}

	public static void getCodeTest() {
	
	}

	public static void inRangeTest() {
	
	}

	public static void toStringTest() {
		
	}
	
	public static void validateTest() {
		
	}
	
	
	public static void main (String [] args) {
		
		PostalCode goodCode = new PostalCode ("J4X 2G3");
		PostalCode goodLowerCode = new PostalCode ("j4x 2g3");
		
//test compareTo()
		
//test equals()
		
//test hashCode()
		
//test getCode()
		
//test inRange()	
		try {
			System.out.println("\n\nTEST INRANGE()--------------------------------------------------------------------------------------------------------------------");
			System.out.println("\tPassing \"j4x 2g3\" ");
			System.out.println("\tIt should print the code in all caps without a white space in the middle");
			if(goodLowerCode.getCode().equals("J4X2G3")) {
				System.out.println("\tTEST PASSED:");
				System.out.println("\t\t" + goodLowerCode.getCode());
			} 
			else {
				System.out.println("\tTEST FAILED:" + goodLowerCode.getCode());
			}
		}catch (IllegalArgumentException e){
				System.out.println("\tTEST FAILED:" + e);
			}
		
//test toString()
		
//test validate()
		try {
			System.out.println("\n\nTEST VALIDATE()--------------------------------------------------------------------------------------------------------------------");
			System.out.println("\tPassing \"j4x 2g3\" ");
			System.out.println("\tIt should print the code in all caps without a white space in the middle");
			if(goodLowerCode.getCode().equals("J4X2G3")) {
				System.out.println("\tTEST PASSED:");
				System.out.println("\t\t" + goodLowerCode.getCode());
			} 
			else {
				System.out.println("\tTEST FAILED:" + goodLowerCode.getCode());
			}
		}catch (IllegalArgumentException e){
				System.out.println("\tTEST FAILED:" + e);
		}
		
		try {
			System.out.println("\n\tPassing \"4J2 X3G\" ");
			System.out.println("\tIt should not work because it is not a valid postal code");
			PostalCode invalidCode = new PostalCode ("4J2 X3G");
		}catch (IllegalArgumentException e){
			System.out.println("\tTEST PASSED: " + e);
		}
		
		try {
			System.out.println("\n\tPassing \"123\" ");
			System.out.println("\tIt should not work because it is not a valid postal code");
			PostalCode shortCode = new PostalCode ("123");
		}catch (IllegalArgumentException e){
			System.out.println("\tTEST PASSED: " + e);
		}
		
		try {
			System.out.println("\n\tPassing \"abc\" ");
			System.out.println("\tIt should not work because it is not a valid postal code");
			PostalCode longCode = new PostalCode ("a1b2c3d4e5");
		}catch (IllegalArgumentException e){
			System.out.println("\tTEST PASSED: " + e);
		}
		

		
	
	}// end main method
}//end Test Class
