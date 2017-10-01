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
	}
	
	
	public String getCode() {
		return this.code;
	}
	

	public boolean inRange(String start, String end) {
		/*The inRange method determines if the code falls between the range of two strings 
		 * (inclusive). For example, if the code is "H3Z1A1" :
		 * 		inRange("G", "H") returns true
		 * 		inRange("H1", "J5") returns true
		 * 		inRange("J", "Z") returns false
		*/
		
		start = start.toUpperCase();
		end = end.toUpperCase();
		
		for(int i=0; i < start.length(); i++) {
			
			if(Character.isDigit(start.charAt(i))) {
				return false;
			}
			
			if(this.code.charAt(i) <= start.charAt(i) && this.code.charAt(i) >= end.charAt(i)) {
				return true;
			}

		}
		return false;
	}
	
	//a.inRange("1", "R");
	
	@Override
	public String toString() {
		return code.toUpperCase(); 
	}

	
	public static String validate(String code) throws IllegalArgumentException {

		if (code.equals(null)) {
			throw new IllegalArgumentException("Invalid Argument: Cannot be null.");
		}

		code = code.toUpperCase();
		
		if (code.length() < 6) {
			throw new IllegalArgumentException("Invalid postal code: too short.");
		}
		if (code.length() > 7) {
			throw new IllegalArgumentException("Invalid postal code: too long.");
		}
		
		if(Character.isDigit(code.charAt(0))) {
			throw new IllegalArgumentException("Invalid postal code format. Code must begin with a letter. Example: A#A #A#");
		}
		
		if(code.charAt(0) == 'W' || code.charAt(0) == 'Z') {
			throw new IllegalArgumentException("Cannot begin by W or Z. Invalid character: " + code.charAt(0));
		}
		
		for (int i = 0; i < code.length(); i += 2 ) {
			if (code.charAt(i) == 'D' || code.charAt(i) == 'F' || code.charAt(i) == 'I' || code.charAt(i) == 'O' ||  code.charAt(i) == 'U' || code.charAt(i) == 'Q') {
				throw new IllegalArgumentException("Invalid characters: " + code.charAt(i));
			}
		}
		
		if(code.charAt(3) == ' ') {
			code = code.replace(" ","");
		}
		 
		return code;
	}
	
	
}//end class
