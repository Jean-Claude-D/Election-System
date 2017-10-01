package lib;
import java.io.Serializable;

public class PostalCode implements Serializable, Comparable<PostalCode> {

	private long serialVersionUID = 4203172017L;
	private final String code;
	
	
	public PostalCode (String codeParam) {
		this.code = validate(codeParam);
	}
	
	@Override
	public int compareTo(PostalCode postalCode) {
		
		if (postalCode == null) {
			throw new IllegalArgumentException("Cannot compare to null object.");
		}

		for (int i = 0; i < this.code.length(); i++) {

			if (this.code.charAt(i) > postalCode.code.charAt(i)) {
				return 1;
			}
			
			else if (this.code.charAt(i) < postalCode.code.charAt(i)) {
				return -1;
			}
			
		}
		//if it did not return 1 or -1, they must be equal so return 0
		return 0;
			
	}
	
	@Override
	public boolean equals(Object object) {
		
		
	  //comparing the 2 object to see if they have the same address, in which case they would be the same object referenced differently
		if (this == object) {
			return true;
		}
		
		if (object == null) {
			return false;
		}
		
		if (object instanceof PostalCode) {
			PostalCode obj = (PostalCode) object;
			if (this.code.equalsIgnoreCase(obj.code)) {
				return true;
			}
		}
		
		return false;

	}
	
	/*Two postal code objects are considered equal if their code are equal (case insensitive). 
	 * If the equals method is overridden as final, the	hashCode method must be final as well.
	*/
	
	@Override
	public int hashCode() {
		return this.toString().toUpperCase().hashCode();
	}//end hashCode
	
	
	public String getCode() {
		return this.code;
	}//end getCode
	
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
	
	@Override
	public String toString() {
		return code.toUpperCase(); 
	}

	
	public static String validate(String code) throws IllegalArgumentException {

		char[] invalidChar = {'D','F','I','O','Q','U'};

		//check if object is null 
		if (code.equals(null)) {
			throw new IllegalArgumentException("Invalid Argument: Cannot be null.");
		}

		code = code.toUpperCase();
		
		//check to see if code is the right length; 6 is without a space, 7 is with a space
		if (code.length() < 6) {
			throw new IllegalArgumentException("Invalid postal code: too short.");
		}
		if (code.length() > 7) {
			throw new IllegalArgumentException("Invalid postal code: too long.");
		}
		
		//if there is any space anywhere, remove it
		if(code.charAt(3) == ' ') {
			code = code.replace(" ","");
		}
		
		//verify that the code is in the right format A#A#A#, if there's a digit where a letter should be, throw exception. If there's a letter where a number should be, throw exception.	
		for(int i = 0; i < code.length(); i += 2) {
			if(Character.isDigit(code.charAt(i))) {
				throw new IllegalArgumentException("Invalid postal code format. Correct format: A#A #A#, where A is any letter and # is any number.");
			}
			
		}
		for(int j = 0; j < code.length(); j += 2) {
			if(Character.isLetter(code.charAt(j))) {
				throw new IllegalArgumentException("Invalid postal code format. Correct format: A#A #A#, where A is any letter and # is any number.");
			}
			
		}
	
		if(code.charAt(0) == 'W' || code.charAt(0) == 'Z') {
			throw new IllegalArgumentException("Cannot begin by W or Z. Invalid character: " + code.charAt(0));
		}
		
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
