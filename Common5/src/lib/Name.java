package lib;
import java.io.Serializable;
import java.util.Objects;

/**
 * Name Class represents by 2 String, firstName and lastName. Both firstName and lastName
 * must be at least 2 characters long, and cannot be null. Only hyphen, apostrophe and white-space
 * are alllowed, but they must be between 2 letters
 * @author Cao Hoang Nguyen
 * @version 1.5
 */
public class Name implements Serializable, Comparable<Name> {
	private String firstName;
	private String lastName;
	private static final long serialVersionUID = 42031768871L;

	/**
	 * Constructs an object
	 * before create Name object, the Constructor calls the validate method
	 * to check if the strings are valid or not.
	 * @param fname taking a String as firstName.
	 * @param lname taking a String as lastName.
	 * @throws IllegalArgumentException if first name or last name is not valid.
	 * @see lib.Name#validate(String)
	 */
	public Name (String fname, String lname) {
		this.firstName = validate(fname);
		this.lastName = validate(lname);
	}

	/**
	 * Copy this Name. This is a deep copy constructor.
	 * @param name The Name you want to copy from.
	 */
	public Name(Name name) {
		this.firstName = name.firstName;
		this.lastName = name.lastName;
	}

	/**
	 * Return the String representation of firstName of Name.
	 * @return firstName of This Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Return the String representation of lastName of Name
	 * @return lastName of This Name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Return the String representation of firstName follows by an empty space,
	 * follow by last name. E.g. John Smith.
	 * of Name Object.
	 * @return firstNam.
	 */
	public String getFullName() {
		return (firstName + " " + lastName);
	}
	
	/**
	 * Validate to see if a string is valid or not.
	 * The algorithm of the check is: Only letter and 3 special
	 * characters are allow: hyphen, apostrophe and white space. And these 3 special
	 * characters must be between 2 letters. This algorithm is applied for both
	 * first name and last name.
	 * @param name the String of either first or last name that need to be checked.
	 * @throws IllegalArgumentException.
	 */
	private String validate(String name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Parameter name is null");
		}
		if (name.length() < 2)
		{
			throw new IllegalArgumentException("Your Name is too short");
		}
		// Check for the first character of the string must be a letter.
		if ( (!Character.isLetter(name.charAt(0))) ) 
		{
			throw new IllegalArgumentException("Not a Valid Name, first character \'" + name.charAt(0) + "\' must be a letter");
		}
		// Check for the last character of the string must be a letter.
		if (( !Character.isLetter(name.charAt(name.length() - 1))))
		{
			throw new IllegalArgumentException("Not a Valid Name, first character \'" + (name.charAt(0) - 1) + "\' must be a letter");
		}
		
		for (int i = 0; i < name.length() - 1; i++)														
		{
			char currentChar = name.charAt(i);
			
			if (!Character.isLetter(currentChar))
			{
				if ( (currentChar != '\'') && (currentChar != '-') && (currentChar != ' ') )
				{
					throw new IllegalArgumentException("Illegal Character: " + currentChar);
				}
				if (!Character.isLetter(name.charAt(i + 1)))
				{
					throw new IllegalArgumentException("Two special characters cannot be next to each other");
				}
			}
		}
		return name;
	}

	
	/**
	 * Return a String representation of firstName follows by an "*",
	 * follow by last name. E.g. John*Smith
	 * @return firstName*lastName
	 */
	@Override
	public String toString() {
	    return (this.firstName + "*" + this.lastName);
	}
	
	/**
	 * Check if two Name objects are equal or not.
	 * @return 0 if two Name are equal, a positive integer if current Name
	 * is greater than the passed in Name, a negative if vice versa.
	 * @param name compare to This Name
	 * @throws IllegalArgumentException if name is null.
	 */
	@Override
	public int compareTo(Name name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Object Name is Null");
		}
		
		int check = this.lastName.compareToIgnoreCase(name.lastName);
		
		if (check != 0)
		{
			return check;
		}
		return this.firstName.compareToIgnoreCase(name.firstName);
	}
	
	/**
	 * Check if an Object is equal to a Name or not.
	 * A note for this method: If 2 Objects are equal, they MUST have the same
	 * hashcode
	 * @param object as the parameter of Objects
	 * @return true if an Object and a Name Object are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null)
		{	
			return false;
		}
		if (this == object)
		{
			return true;
		}

		if (object.getClass().equals(this.getClass()))										
		{
			if ( ((Name)object).getFirstName().equalsIgnoreCase(this.getFirstName())  )
			{
				if ( ((Name)object).getLastName().equalsIgnoreCase(this.getLastName())  )
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Return the hascode from the getFullName of Name
	 * A note for this method: If 2 Objects are equal, they MUST have the same
	 * hashcode
	 * @return the hashcode of the Object.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.getFirstName().toUpperCase(), this.getLastName().toUpperCase());
	}
}