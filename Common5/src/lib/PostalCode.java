package lib;
import java.io.Serializable;

public class PostalCode implements Serializable, Comparable<PostalCode> {

	private long serialVersionUID = 4203172017L;
	private final String code;
	
	
	public PostalCode (String codeParam) {
		this.code = validate(codeParam);
	}
	
	@Override
	public int compareTo(PostalCode code) {
		
		if (this == code) {
			return 0;
		}
		
		if (this.code.getCode() > code.getCode()) {
			return 1;
		}
		
		if (this < code) {
			return -1;
		}
		
		
		
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (this == object) {
			return true;
		}
		
		if (object == null) {
			return false;
		}
		
		if (object instanceof PostalCode) {
			PostalCode obj = (PostalCode) object;
			this.code.equalsIgnoreCase(obj.code);
			return true;
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
			
			if(start.charAt(i) == Character.DECIMAL_DIGIT_NUMBER) {
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

		if (code.length() < 6 || code.length() > 7) {
			throw new IllegalArgumentException("Invalid postal code: too long or too short.");
		}
		
		if(code.charAt(0) == Character.DECIMAL_DIGIT_NUMBER) {
			throw new IllegalArgumentException("Invalid postal code: invalid format.");
		}
		
		if(code.charAt(0) == 'W' || code.charAt(0) == 'w' || code.charAt(0) == 'Z' || code.charAt(0) == 'z') {
			throw new IllegalArgumentException("Invalid postal code: invalid characters.");
		}
		
		for (int i = 0; i < code.length(); i += 2 ) {
			if (code.charAt(i) == 'D' || code.charAt(i) == 'F' || code.charAt(i) == 'I' || code.charAt(i) == 'O' || code.charAt(i) == 'Q' || code.charAt(i) == 'U') {
				throw new IllegalArgumentException("Invalid postal code: invalid characters.");
			}
		}
		
		code = code.toUpperCase();
		
		if(code.charAt(3) == ' ') {
			code = code.replace(" ","");
		}
		 
		return code;
	}
	

	
	
	
	
}
