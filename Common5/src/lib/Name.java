package lib;
import java.io.Serializable;
import java.util.Objects;

/**
 * Name Class create an Object that will represent a voter for the Election System Project
 * @author Cao Hoang Nguyen
 * @version 1.5
 * @since 20th September, 2017
 */
public class Name implements Serializable, Comparable<Name> {
	private String firstname;
	private String lastname;
	private static final long serialVersionUID = 42031768871L;

	/**
	 * This Constructor will take 2 strings, 1 as first name, the other as last name
	 * Before create an Object Name, the Constructor will call the validate method
	 * To check
	 * @param fname
	 * @param lname
	 */
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
	public String getFirstName() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastName() {
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
		}
	}
	
	@Override
	public String toString() {
	    return (this.firstname + "*" + this.lastname);
	}
	
	@Override
	public int compareTo(Name name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Object Name is Null");
		}
		
		int check = this.lastname.compareToIgnoreCase( name.lastname );
		
		if (check != 0)
		{
			return check;
		}
		return this.firstname.compareToIgnoreCase( name.firstname );
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
			if ( ((Name)object).getFullName().equalsIgnoreCase(this.getFullName())  )
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
//		return this.toString().toUpperCase().hashCode();
		return Objects.hash(this.getFullName().toUpperCase());
	}

	
}