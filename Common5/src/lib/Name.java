/**
 * 
 */
package lib;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 *
 */
public class Name implements Serializable, Comparable<Name> {
	private String firstname;
	private String lastname;
	private static final long serialVersionUID = 42031768871L;

	public Name (String fname, String lname) {
		validate(fname);
		validate(lname);
		this.firstname = fname;
		this.lastname = lname;
		
		
	}

	public Name(Name name) {
		this.firstname = name.firstname;
		this.lastname = name.lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * @return the lastname
	 */
	public String getFullName() {
		return (firstname + " " + lastname);
	}
	
	

	/**
	 * @param firstname the firstname to set
	 */

	
	public void validate(String name) {		
		if (name.length() < 2 || name.length() < 2)
		{
			throw new IllegalArgumentException("Your First Name Is Too Short");
		}
		
		if ( (!Character.isLetter(name.charAt(0)) ) || ( !Character.isLetter(name.charAt(name.length() - 1))) )
		{
			throw new IllegalArgumentException("Not a Valid Name");
		}
		
		for (int i = 0; i < name.length(); i++)
		{
			char currentChar = name.charAt(i);
			
			if (!Character.isLetter(currentChar))
			{
				if ( (currentChar != '\'') && (currentChar != '-') && (currentChar != ' ') )
				{
					throw new IllegalArgumentException("Illegal Character " + currentChar);
				}
				else if (currentChar == '\'' || (currentChar == '-') || (currentChar == ' '))
				{
					if (!Character.isLetter(name.charAt(i+1)))
					{
						throw new IllegalArgumentException("Two special characters cannot be next to each other");
					}
				}
			}
		} // Appe-		
		
//		for (int i = 0; i < fname.length(); i++) {
//			if(fname.charAt(i) !=)
//		}
	}
	
	@Override
	public String toString() {
	    return (this.firstname + "*" + this.lastname);
	}
	
	@Override
	public int compareTo(Name name) {
		if (!(name instanceof Name))
		{
			throw new IllegalArgumentException("ABC");
		}
		
		int check = this.lastname.compareToIgnoreCase( ((Name)name).lastname );
		
		if (check != 0)
		{
			return check;
		}
		return this.firstname.compareToIgnoreCase( ((Name)name).firstname );
	}
	
	@Override
	public boolean equals (Object object) {
		if (this == object)
		{
			return true;
		}
		if (object == null)
		{	
			return false;
		}
		if (object instanceof Name)
		{
			if ( ((Name)object).getFullName() == this.getFullName() )
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
//		return this.toString().toUpperCase().hashCode();
		return Objects.hash(this.firstname, this.lastname);
	}

	
}