package lib;
import java.io.Serializable;


/**
 * PostalCode Class accepts a string following specific postal code formats
 * @author Felicia Goragtchov
 */
public class PostalCode implements Serializable, Comparable<PostalCode> {

	private static final long serialVersionUID = 4203172017L;
	private final String code;
	
	/**
	 * constructor takes a string and runs it through a validator method. if the postal code string is conform it is returned and 
	 * stored in the code private final field
	 * @param codeParam
	 */	
	public PostalCode (String codeParam) {
		this.code = validate(codeParam);
	}
	
	/**
	 * is run on a object and takes an object. compares the strings to determine if they are equal or which is greater
	 * if this object is greater, return 1. if the comparison object is greater, return -1. if one is not greater than the other, they must be equal, return 0.
	 * @param postalCode
	 */
	@Override
	public int compareTo(PostalCode postalCode) {
		
		if (postalCode == null) {
			throw new IllegalArgumentException("Cannot compare to null object.");
		}

//		for (int i = 0; i < this.code.length(); i++) {
//
//			if (this.code.charAt(i) > postalCode.code.charAt(i)) {
//				return 1;
//			}
//			
//			else if (this.code.charAt(i) < postalCode.code.charAt(i)) {
//				return -1;
//			}
//			
//		}
//		//if it did not return 1 or -1, they must be equal so return 0
//		return 0;
		
		return this.code.compareToIgnoreCase(postalCode.code);
			
	}
	
	/**
	 * verifies that the argument object is not null. verifies if the objects are the same or if the argument is a child of this class
	 * @param object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object object) {
		
		
	  //comparing the 2 object to see if they have the same address, in which case they would be the same object referenced differently
		
		if (object == null) {
			return false;
		}
		
		if (this == object) {
			return true;
		}
		
		return (this.getClass() == object.getClass()) &&
			   ((PostalCode) object).code.equalsIgnoreCase(this.code);

	}
	

	/**
	 * follows the equals(); it returns a boolean so the calculation of the hashcode by adding code.hashCode() to 1 * any prime number.
	 * @return the hashCode of a postalCode object, of the string it contains 
	 */
	@Override
	public int hashCode() {
		
		final int prime = 97;
		
		return prime * code.hashCode();
		
	}//end hashCode
	
	/**
	 * returns the String contained in the code field
	 * @return String
	 */
	public String getCode() {
		return this.code;
	}//end getCode
	
	
	
	/**
     * Returns true if this PostalCode comes after or at start and comes before or at end. compareTo(PostalCode)'s ordering is
     * used to order PostalCode from smallest to largest.
     *
     * @param start the lower boundary
     * @param end   the upper boundary
     *
     * @return true if this PostalCode's code field is greater than start and
     *         smaller than end, according to lib.Name#compareTo(PostalCode)'s
     *         definition of ordering PostalCode.
     *         false otherwise.
     *
     * @throws IllegalArgumentException if start or end are null
     *
     * @see lib.Name#removeSpace(String)
     * @see lib.Name#compareTo(PostalCode)
     * 
     * @author Jean-Claude Desrosiers
     */
	public boolean inRange(String start, String end) {
        
		if(start == null) {
            throw new IllegalArgumentException("Start index must not be null.");
        }
        
        if(end == null) {
            throw new IllegalArgumentException("End index must not be null.");
        }

        //Remove space characters, if any, in start and end
        start = start.replace(" ","");
        end = end.replace(" ","");

        
        /* Make start the smallest postal code string possible by filling
         * up until the length of a postal code
         * e.g. if start's value is "R3", then it would fill it like so :
         * "R3A1A1"
         */
        for(int i = start.length(); i <= 5; i++) {
            //First character of a postal code is a letter, then a digit, then a letter...
            if(i % 2 == 0) {
                start += 'A';
            }
            else {
                start += '0';
            }
        }

        /* 
         * Make end the largest postal code string possible by filling
         * up until the length of a postal code
         * e.g. if end's value is "", then it would fill it like so : "Y9Z9Z9"
         */
        
        for(int i = end.length(); i <= 5; i++) {
            if(i % 2 == 0) {
                //First character of a postal code cannot be 'Z'
                if(i == 0) {
                    end += 'Y';
                }
                else {
                    end += 'Z';
                }
            }
            else {
                end += '9';
            }
        }

        /*
         * Wrapping start and end in PostalCode objects allows their validation
         * and the use of compareTo(PostalCode)
         */
        
        PostalCode startPostalCode = new PostalCode(start);
        PostalCode endPostalCode = new PostalCode(end);

        return this.compareTo(startPostalCode) >= 0
                && this.compareTo(endPostalCode) <= 0;

    }//end inRange
	
	
	
	/**
	 * returns the code String in all uppercase
	 * @return String
	 */
	@Override
	public String toString() {
		return code.toUpperCase(); 
	}

	
	
	/**
	 * Ensures that the passed string for postal code follows the correct format and restrictions.
	 * @param code String
	 * @return once the string passed all the validations and is in the correct format, the entire string is made in uppercase and if there is a space, it is removed.
	 * @throws IllegalArgumentException
	 */
	public static String validate(String code) throws IllegalArgumentException {

		char[] invalidChar = {'D','F','I','O','Q','U'};

	//check if object is null 
		if (code == null) {
			throw new IllegalArgumentException("Invalid Argument: Cannot be null.");
		}
		
	//check to see if code is the right length; 6 is without a space, 7 is with a space. Less than 6 and more than 7 is invalid.
		if (code.length() < 6) {
			throw new IllegalArgumentException("Invalid postal code: too short.");
		}
		if (code.length() > 7) {
			throw new IllegalArgumentException("Invalid postal code: too long.");
		}
		
		code = code.toUpperCase();
		
	//if there is any space anywhere, remove it
		if(code.charAt(3) == ' ') {
			code = code.replace(" ","");
		}
		
	//verify that the code is in the right format A#A#A#, 
	//if there's a digit where a letter should be, throw exception.
		for(int i = 0; i < code.length(); i += 2) {
			if(Character.isDigit(code.charAt(i))) {
				throw new IllegalArgumentException("Invalid postal code format. Correct format: A#A #A#, where A is any letter and # is any number.");
			}
		}
	//If there's a letter where a number should be, throw exception.	
		for(int j = 1; j < code.length(); j += 2) {
			if(Character.isLetter(code.charAt(j))) {
				throw new IllegalArgumentException("Invalid postal code format. Correct format: A#A #A#, where A is any letter and # is any number.");
			}
			
		}
	//verify that the code does not begin with W or Z, if it does, throw an exception
		if(code.charAt(0) == 'W' || code.charAt(0) == 'Z') {
			throw new IllegalArgumentException("Cannot begin by W or Z. Invalid character: " + code.charAt(0));
		}
	//Code must not contain any of these characters ('D','F','I','O','Q','U') anywhere in the string. If it does, throw an exception.
		for (int codeIndex = 0; codeIndex < code.length(); codeIndex += 2 ) {
			for (int arrIndex = 0; arrIndex < invalidChar.length; arrIndex++) {
				if (code.charAt(codeIndex) == invalidChar[arrIndex]) {
					throw new IllegalArgumentException("Invalid characters: " + code.charAt(codeIndex));
				}
			}	
		}
		
		return code;
	}
	
	
}//end class
