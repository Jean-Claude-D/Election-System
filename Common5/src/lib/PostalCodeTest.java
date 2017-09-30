package lib;

public class PostalCodeTest {
	
	public static void compareToTest(PostalCode code1, PostalCode code2, PostalCode code3) {
		System.out.println("TEST COMPARETO()--------------------------------------------------------------------------------------------------------------------");
		System.out.println("\tComparing code \"1\" with code \"2\" should return 0");
		System.out.println("\tComparing code \"1\" with code \"3\" should return 1");
		System.out.println("\tComparing code \"3\" with code \"2\" should return -1");
	}
	
	public static void equalsTest(PostalCode code1, PostalCode code2, PostalCode code3) {
		System.out.println("\n\nTEST EQUALS()--------------------------------------------------------------------------------------------------------------------");
		System.out.println("\tComparing code \"1\" with code \"2\" should return true");
		
		if(code1.equals(code2)) {
			System.out.println("\t\tcode1:" + code1.getCode() + " is equal to code2:" + code2.getCode());
			System.out.println("\t\tTEST PASSED");
		}else {
			System.out.println("\t\tTEST FAILED");
		}
		
		System.out.println("\tComparing code \"1\" with code \"3\" should return false");
		
		if(code1.equals(code3)) {
			System.out.println("\t\tTEST FAILED");
		}else {
			System.out.println("\t\tcode1:" + code1.getCode() + " is not equal to code3:" + code2.getCode());
			System.out.println("\t\tTEST PASSED");
		}
	}
//*********************************************************
	public static void hashCodeTest(PostalCode code) {
		System.out.println("\n\nTEST HASHCODE()--------------------------------------------------------------------------------------------------------------------");
		
	}

	public static void getCodeTest(PostalCode code) {
		System.out.println("\n\nTEST GETCODE()--------------------------------------------------------------------------------------------------------------------");
		System.out.println("\tPassing code \"j4x 2g3\" should get \"J4X2G3\" ");
		
		if(code.getCode().equals("J4X2G3")) {
			System.out.println("\t\t" + code.getCode());
			System.out.println("\t\tTEST PASSED");
		}else {
			System.out.println("\t\tTEST FAILED");
		}
	}
//*********************************************************
	public static void inRangeTest(PostalCode code) {
		System.out.println("\n\nTEST INRANGE()--------------------------------------------------------------------------------------------------------------------");
	}

	public static void toStringTest(PostalCode code) {
		System.out.println("\n\nTEST TOSTRING()--------------------------------------------------------------------------------------------------------------------");
		System.out.println("\tPassing code \"\" should return in all uppercase");
		
			if (code.getCode().equals("")) {
				System.out.println("\t\t" + code.getCode());
				System.out.println("\t\tTEST PASSED");
			}else {
				System.out.println("\t\tTEST FAILED");
			}
		
	}
	
	public static void validateTest() {
		System.out.println("\n\nTEST VALIDATE()--------------------------------------------------------------------------------------------------------------------");
		System.out.println("\tPassing \"j4x 2g3\" ");
		System.out.println("\tIt should print the code in all caps without a white space in the middle");
		
		try {
			PostalCode validLowerCode = new PostalCode ("j4x 2g3");
			if(validLowerCode.getCode().equals("J4X2G3")) {
				System.out.println("\tTEST PASSED:");
				System.out.println("\t\t" + validLowerCode.getCode());
			}
		}catch (IllegalArgumentException e){
				System.out.println("\tTEST FAILED:" + e);
		}
		
		try {
			System.out.println("\n\tPassing \"4J2 X3G\" ");
			System.out.println("\tIt should not work because it is not a valid postal code");
			PostalCode code2 = new PostalCode ("4J2 X3G");
		}catch (IllegalArgumentException e){
			System.out.println("\tTEST PASSED: " + e);
		}
		
		try {
			System.out.println("\n\tPassing \"123\" ");
			System.out.println("\tIt should not work because it is not a valid postal code");
			PostalCode code3 = new PostalCode ("123");
		}catch (IllegalArgumentException e){
			System.out.println("\tTEST PASSED: " + e);
		}
		
		try {
			System.out.println("\n\tPassing \"a1b2c3d4e5\" ");
			System.out.println("\tIt should not work because it is not a valid postal code");
			PostalCode code4 = new PostalCode ("a1b2c3d4e5");
		}catch (IllegalArgumentException e){
			System.out.println("\tTEST PASSED: " + e);
		}
	}
	
	
	public static void main (String [] args) {
		
		PostalCode goodCode = new PostalCode ("J4X 2G3");
		PostalCode goodLowerCode = new PostalCode ("j4x 2g3");
		



		
	
	}// end main method
}//end Test Class
