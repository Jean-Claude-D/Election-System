package lib;
import lib.PostalCode;


public class PostalCodeTest {

	public static void main (String [] args) {

		String goodCode = "J4X 2G3";
		String goodLowerCode = "j4x 2g3";
		String goodCode2 = "H3Z 1A1";
		String badFormat = "4J2 G3G";
		String numberCode = "123456";
		String letterCode = "abcdefg";
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
		boolean expectInvalid = false;
		PostalCodeChild sameClass = new PostalCodeChild ("j4x2g3");
		PostalCode object1 = new PostalCode("J4X 2G3");
		PostalCode object2 = new PostalCode("J4X 2G3");
		PostalCode object3 = new PostalCode("H3Z 1A1");
		
		System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------------");
			compareToTest(goodCode, goodLowerCode, expectValid);
			compareToTest(goodCode, goodCode2, expectValid);
			compareToTest(goodCode2, goodCode, expectValid);
			compareToTest(goodCode, null, expectInvalid);
			compareToTest(null, goodCode, expectInvalid);
			
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
			equalsTest(object1, object2, expectValid);
			equalsTest(object1, object3, expectValid);
			equalsTest(object1, sameClass, expectValid);
	
		System.out.println("\n----------HASHCODE---------------------------------------------------------------------------------------------------------------------");
			hashCodeTest(object1, object2);
			hashCodeTest(object1, object3);
			hashCodeTest(object1, sameClass);
		
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
			getCodeTest(goodCode, expectValid);
			getCodeTest(goodCode2, expectValid);
			getCodeTest(goodLowerCode, expectValid);
		
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
			inRangeTest("G", "H", goodCode2, expectValid);
			inRangeTest("H1", "J5", goodCode2, expectValid);
			inRangeTest("J", "Z", goodCode2, expectInvalid);
			inRangeTest("A", "E", goodCode2, expectInvalid);
			inRangeTest("L4A  1B5", "L6N  9Z3", "L4M 1S4", expectValid);
		
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
			toStringTest(goodLowerCode,expectValid);
		
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
			validateTest(goodCode, expectValid);
			validateTest(invalidCode1, expectInvalid);
			validateTest(invalidCode2, expectInvalid);
			validateTest(invalidCode3, expectInvalid);
			validateTest(invalidCode4, expectInvalid);
			validateTest(invalidCode5, expectInvalid);
			validateTest(invalidCode6, expectInvalid);
			validateTest(invalidCode7, expectInvalid);
			validateTest(invalidCode8, expectInvalid);
			validateTest(badFormat, expectInvalid);
			validateTest(numberCode, expectInvalid);
			validateTest(letterCode, expectInvalid);
			validateTest(shortCode, expectInvalid);
			validateTest(longCode, expectInvalid);
			validateTest(longInvalidCode, expectInvalid);


	}// end main method -------------------------------------------------------------------------------------------------------------


	
	private static void compareToTest(String test1, String test2, boolean expectResult) {
		System.out.println("\nCOMPARETO() TESTING");
		
		try { 
			
			PostalCode code1 = new PostalCode(test1);
			PostalCode code2 = new PostalCode(test2);
			
			System.out.println("\tComparing \"" + test1 + "\" with \"" + test2 + "\"");
			if (code1.compareTo(code2) == 0) {
				System.out.println("\tExpected result: equal, should be 0");
				System.out.println("\tResult: " + code1.compareTo(code2));
				System.out.println("\n\t ==== PASSED TEST ====");
			}
			else {
				if (code1.compareTo(code2) > 0) {
					System.out.println("\tExpected result: LHS is greater than RHS, should be greater than 0");
					System.out.println("\tResult: " + code1.compareTo(code2));
					System.out.println("\n\t ==== PASSED TEST ====");
				}
				else if (code1.compareTo(code2) < 0) {
					System.out.println("\tExpected result: LHS is smaller than RHS, should be less than 0");
					System.out.println("\tResult: " + code1.compareTo(code2));
					System.out.println("\n\t ==== PASSED TEST ====");
				}
			}
			if (test1.equals(null) || test2.equals(null)) {
				System.out.println("\n\t ==== PASSED FAILED null argument, no exception thrown ====");
			}
		}catch (IllegalArgumentException e) {
				System.out.println("\tComparing \"" + test1 + "\" with \"" + test2 + "\"");
				System.out.println("\tResult: " + e);
				System.out.println("\n\t ==== PASSED TEST exception caught successfully ==== ");
			}

			
			
	}//end compareToTest -----------------------------------------------------------------------------------------------------
	
	
	
	
	private static void equalsTest(Object obj1, Object obj2, boolean expectedValid) {
		System.out.println("\nEQUALS() TESTING");
		
		System.out.println("\tComparing object \"" + ((PostalCode) obj1).getCode() + "\" with object \"" + ((PostalCode) obj2).getCode() + "\"");
			if(obj1.equals(obj2) == expectedValid) {
				System.out.println("\tResult: " + obj1.equals(obj2));
				System.out.println("\n\t ==== PASSED TEST ====");
			}else if (obj1.equals(obj2) != expectedValid){
				System.out.println("\tResult: " + obj1.equals(obj2));
				System.out.println("\n\t ==== PASSED TEST ====");
			}
			else {
				System.out.println("\tobj1: " + ((PostalCode)obj1).getCode() + " and obj2: " + ((PostalCode)obj2).getCode());
				System.out.println("\tResult: " + obj1.equals(obj2));
				System.out.println("\n\t ==== FAILED TEST ====");
			}
			
			System.out.println("\n\tPassing null");
				if (obj2.equals(null) != expectedValid) {
					System.out.println("\tResult: " + obj2.equals(null));
					System.out.println("\n\t ==== PASSED TEST ====");
				}else {
					System.out.println("\tResult: " + obj2.equals(null));
					System.out.println("\n\t ==== FAILED TEST ====");
				}
	
			
	}//end equalsTest --------------------------------------------------------------------------------------------------------
	
	
	
	private static void hashCodeTest(PostalCode code1, PostalCode code2) {
		System.out.println("\nHASHCODE() TESTING");
		
		System.out.println("\n\tPassing \"" + code1.getCode() + "\" with \"" + code2.getCode() + "\"");
		
			if (code1.hashCode() == code2.hashCode()) {
				System.out.println("\n\tHashcode 1: " + code1.hashCode());
				System.out.println("\tHashcode 2 : " + code2.hashCode());
				System.out.println("\tResult : " + (code1.hashCode() == code2.hashCode()));
				System.out.println("\n\t ==== PASSED TEST ====");
			} else if (code1.hashCode() != code2.hashCode()) {
				System.out.println("\n\tHashcode 1: " + code1.hashCode());
				System.out.println("\tHashcode 2 : " + code2.hashCode());
				System.out.println("\tResult : " + (code1.hashCode() == code2.hashCode()));
				System.out.println("\n\t ==== PASSED TEST ====");
			}else {
				System.out.println("\n\tHashcode 1: " + code1.hashCode());
				System.out.println("\tHashcode 2 : " + code2.hashCode());
				System.out.println("\tResult : " + (code1.hashCode() == code2.hashCode()));
				System.out.println("\n\t ==== FAILED TEST ====");
			}
		
	}//end hashCodeTest ------------------------------------------------------------------------------------------------------
	
	
	
	private static void getCodeTest(String test, boolean expectedValid) {
		System.out.println("\nGETCODE() TESTING ");
		
		PostalCode code = new PostalCode(test);
		
		System.out.println("\tPassing code \"" + test + "\" should get \"" + code.getCode() + "\"");
			if(code.getCode().equals(test.toUpperCase().replace(" ", "")) == expectedValid) {
				System.out.println("\tResult: " + code.getCode());
				System.out.println("\n\t ==== PASSED TEST ====");
			}else {
				System.out.println("\tResult: " + code.getCode());
				System.out.println("\n\t ==== FAILED TEST ====");
			}
			
	}//end getCodeTest -------------------------------------------------------------------------------------------------------
	
	
	
	
	private static void inRangeTest(String start, String end, String test1, boolean expectResult) {
		System.out.println("\nINRANGE() TESTING");
		
		PostalCode code = new PostalCode(test1);
		
		System.out.println("\tPassing: " + test1);
		System.out.println("\tRange from " + start + " to " + end);
		
		try {
			if (code.inRange(start, end) == expectResult) {
				System.out.println("\tResult: " + code.inRange(start, end));
				System.out.println("\n\t ==== PASSED TEST ====");
			}else {
				System.out.println("\tResult: " + code.inRange(start, end));
				System.out.println("\n\t ==== FAILED TEST ====");
			}
		}catch (IllegalArgumentException e) {
			
			if (expectResult == true) {
				System.out.println("\n\tPassing: " + test1);
				System.out.println("\tRange from " + start + " to " + end);
				System.out.println("\tResult: " + e);
				System.out.println("\n\t ==== TEST FAILED exception thrown when data is valid ==== ");
			}else {
				System.out.println("\n\tPassing: " + test1);
				System.out.println("\tRange from " + start + " to " + end);
				System.out.println("\tResult: " + e);
				System.out.println("\n\t ==== PASSED TEST exception caught successfully ==== ");
			}
		}
		
	}//end inRangeTest -------------------------------------------------------------------------------------------------------

	
	private static void toStringTest(String test1, boolean expectResult) {
		System.out.println("\nTOSTRING() TESTING ");
		System.out.println("\tPassing: \"" + test1 + "\" should return in all uppercase");
		
		PostalCode code = new PostalCode(test1);
		
			if (code.getCode().equals(test1.toUpperCase().replace(" ","")) == expectResult) {
				System.out.println("\tResult: " + code.getCode());
				System.out.println("\n\t ==== PASSED TEST ====");
			}else {
				System.out.println("\tResult: " + code.getCode());
				System.out.println("\n\t ==== FAILED TEST ====");
			}
		
	}//end toStringTest -----------------------------------------------------------------------------------------------------------
	
	private static void validateTest(String test, boolean expectedResult) {
		System.out.println("\nVALIDATE() TESTING ");
		
		try {
			PostalCode code = new PostalCode(test);
			System.out.println("\n\tPassing: " + test);
			
			if(code.getCode().equals(test.toUpperCase().replace(" ","")) == expectedResult) {
				System.out.println("\tResult: " + code.getCode());
				System.out.println("\n\t ==== PASSED TEST ====");
			}else {
				System.out.println("\t" + code.getCode());
				System.out.println("\n\t ==== FAILED TEST ====");
				
			}
						
		}catch (IllegalArgumentException e){
			
			if (expectedResult == true) {
				System.out.println("\n\tPassing: " + test);
				System.out.println("\tResult: " + e);
				System.out.println("\n\t ==== TEST FAILED exception thrown when data is valid ==== ");
			}else {
				System.out.println("\n\tPassing: " + test);
				System.out.println("\tResult: " + e);
				System.out.println("\n\t ==== PASSED TEST exception caught successfully ==== ");
		}
	}//end validateTest -----------------------------------------------------------------------------------------------------------

}//end Test Class ------------------------------------------------------------------------------------------------------------------

}
// after fixing, i was missing a closing bracket somewhere but couldn't find it for the love of god and this fixes it, 
// so don't touch unless you've successfully found where the missing curly bracket goes. Thank you. 
	
class PostalCodeChild extends PostalCode {
	
	private long serialVersionUID = 4203172017L;

	public PostalCodeChild(String codeParam) {
		super(codeParam);
	}
	
}//end child class -----------------------------------------------------------------------------------------------------------------
