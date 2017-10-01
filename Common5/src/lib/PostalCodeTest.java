package lib;


public class PostalCodeTest {

	public static void main (String [] args) {

		String goodCode = "J4X 2G3";
		String goodLowerCode = "j4x 2g3";
		String goodCode2 = "H3H 1M6";
		String badFormat = "4J2 G3G";
		String badCode = "123456";
		String shortCode = "j4x"; 
		String longInvalidCode = "a1b2c3d4e5";
		String longCode = "j4x 2g3 j4x";
		String invalidCode1 = "W4Z 7H3";
		String invalidCode2 = "Z4W 7H3";
		String invalidCode3 = "D1A 2B3";
		String invalidCode4 = "C4F 5E6";
		String invalidCode5 = "G7H 8I9";
		String invalidCode6 = "O1J 2K3";
		String invalidCode7 = "L4Q 5M6";
		String invalidCode8 = "N7P 8U9";
		boolean expectValid = true;
		
		
		
		System.out.println("----------COMPARETO---------------------------------------------------------------------------------------------------------------------");

		
		System.out.println("\n----------EQUALS---------------------------------------------------------------------------------------------------------------------");
			//equalsTest(goodCode, goodLowerCode, expectValid);
			//equalsTest(goodCode, goodCode2, expectValid);
			//equalsTest(goodCode, goodLowerCode, expectValid);
	
		System.out.println("\n----------HASHCODE---------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n----------GETCODE---------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n----------INRANGE---------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n----------TOPostalCode---------------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n----------VALIDATE---------------------------------------------------------------------------------------------------------------------");
			validateTest(goodCode, expectValid);
			validateTest(invalidCode1, expectValid);
			validateTest(invalidCode2, expectValid);
			validateTest(invalidCode3, expectValid);
			validateTest(invalidCode4, expectValid);
			validateTest(invalidCode5, expectValid);
			validateTest(invalidCode6, expectValid);
			validateTest(invalidCode7, expectValid);
			validateTest(invalidCode8, expectValid);
			validateTest(badFormat, expectValid);
			validateTest(badCode, expectValid);
			validateTest(shortCode, expectValid);
			validateTest(longCode, expectValid);
			validateTest(longInvalidCode, expectValid);


	}// end main method


	
	private static void compareToTest(String test1, String test2, String test3) {
		System.out.println("\n\nTESTING COMPARETO()");
		
		PostalCode code1 = new PostalCode(test1);
		PostalCode code2 = new PostalCode(test2);
		PostalCode code3 = new PostalCode(test3);
		
		System.out.println("\tComparing code \"" + code1.getCode() + "\" with code \"" + code2.getCode() + "\" should return 0");
			int result1 = code1.compareTo(code2);
			if (result1 == 0) {
				System.out.println("\t\tResult: " + result1 + "   ==== PASSED TEST ====");
			}else {
				System.out.println("\t\tResult: " + result1 + "   ==== FAILED TEST ====");
			}
			
		System.out.println("\n\tComparing code \"" + test1 + "\" with code \"" + test3 + "\" should return 1");
			int result2 = code1.compareTo(code3);
			if (result2 == 0) {
				System.out.println("\t\tResult: " + result2 + "   ==== PASSED TEST ====");
			}else {
				System.out.println("\t\tResult: " + result2 + "   ==== FAILED TEST ====");
			}
		
		System.out.println("\n\tComparing code \"" + test3 + "\" with code \"" + test2 + "\" should return -1");
			int result3 = code3.compareTo(code2);
			if (result3 == 0) {
				System.out.println("\t\tResult: " + result3 + "   ==== PASSED TEST ====");
			}else {
				System.out.println("\t\tResult: " + result3 + "   ==== FAILED TEST ====");
			}
			
		System.out.println("\n\tPassing null; should throw an exception.");
			try {
				code1.compareTo(null);
			}catch (IllegalArgumentException e) {
				System.out.println("\t\tTEST PASSED");
			}
		
	}//end compareToTest
	
	private static void equalsTest(Object obj1, Object obj2, boolean expectedValid) {
		System.out.println("\n\nTEST EQUALS()");
		
		System.out.println("\tComparing object \"" + ((PostalCode) obj1).getCode() + "\" with object \"" + ((PostalCode) obj2).getCode() + "\" should return 0");
		System.out.println("code1: " + ((PostalCode)obj1).getCode());
		System.out.println("code1: " + ((PostalCode)obj2).getCode());
			if(obj1.equals(obj2) == expectedValid) {
				System.out.println("\t\tobj1: " + ((PostalCode)obj1).getCode() + " is equal to obj2: " + ((PostalCode)obj2).getCode());
				System.out.println("\t\t ==== PASSED TEST ====");
			}else if (obj1.equals(obj2) != expectedValid){
				System.out.println("\t\t ==== FAILED TEST ====");
			}
		
	}//end equalsTest
	
	
//*********************************************************
	private static void hashCodeTest(String test) {
		System.out.println("\n\nTEST HASHCODE()");
		
	}//end hashCodeTest

	private static void getCodeTest(PostalCode code, boolean expectedValid) {
		System.out.println("\n\nTEST GETCODE()");
		
		System.out.println("\tPassing code \"" + code.getCode() + "\" should get \"J4X2G3\" ");
			if(code.getCode().equals("J4X2G3") == expectedValid) {
				System.out.println("\t\t" + code.getCode());
				System.out.println("\t\t ==== PASSED TEST ====");
			}else {
				System.out.println("\t\t ==== FAILED TEST ====");
			}
	}//end getCodeTest
	
	
//*********************************************************
	private static void inRangeTest(PostalCode code) {
		System.out.println("\n\nTEST INRANGE()");
	}

	private static void toString(String test1, boolean expectedValid) {
		System.out.println("\n\nTEST TOPostalCode()");
		System.out.println("\tPassing code \"\" should return in all uppercase");
		
		PostalCode code = new PostalCode(test1);
		
			if (code.getCode().equals(test1.toUpperCase()) == expectedValid) {
				System.out.println("\t\t" + code.getCode());
				System.out.println("\t\t ==== PASSED TEST ====");
			}else {
				System.out.println("\t\t ==== FAILED TEST ====");
			}
		
	}
	
	private static void validateTest(String test, boolean expectedValid) {
		System.out.println("\nTESTING VALIDATE()");
		
		try {
			PostalCode code = new PostalCode(test);
			System.out.println("\n\tPassing: " + test);
			
			if(code.getCode().equals(test.toUpperCase().replace(" ","")) == expectedValid) {
				System.out.println("\tResult: " + code.getCode());
				System.out.println("\n\t ==== PASSED TEST ====");
			}else {
				System.out.println("\t" + code.getCode());
				System.out.println("\n\t ==== FAILED TEST ====");
				
			}
						
		}catch (IllegalArgumentException e){
			System.out.println("\n\tPassing: " + test);
			System.out.println("\tResult: " + e);
			System.out.println("\n\t ==== PASSED TEST ==== ");
		}
	}

	

}//end Test Class
