package lib;
import java.io.Serializable;
import java.util.Objects;

/**
 * Name Class create an Object that will represent a voter for the Election System Project.
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
	 * before create an Object Name, the Constructor will call the validate method
	 * to check if the strings are valid or not.
	 * @param fname taking a string as first name.
	 * @param lname taking a string as last name.
	 * @throws IllegalArgumentException if first name or last name is not valid.
	 */
	public Name (String fname, String lname) {
		validate(fname);  // Verify if fname is valid or not.
		validate(lname);  // Verify if lname is valid or not
		this.firstname = fname;
		this.lastname = lname;
	}

	/**
	 * This is a Deep Copy Constructor. It will take a Name object and create a
	 * new Name object which is copied from the original Name object.
	 * @param name The Name Object you want to copy from.
	 */
	public Name(Name name) {
		this.firstname = name.firstname;
		this.lastname = name.lastname;
	}

	/**
	 * This is a getter method that is used to acquire the firstname of Name Object.
	 * @return the firstname string representation of firstname of the Name Object.
	 */
	public String getFirstName() {
		return firstname;
	}

	/**
	 * This is a getter method that is used to acquire the firstname of Name.
	 * @return the lastname string representation of lastname of the Name Object.
	 */
	public String getLastName() {
		return lastname;
	}
	
	/**
	 * This is a getter method that is used to acquire both first and last name
	 * of Name Object.
	 * @return firstname, follows by an empty space, follow by last name. E.g. John Smith.
	 */
	public String getFullName() {
		return (firstname + " " + lastname);
	}
	
	/**
	 * The validate method will take in the string to check whether the string
	 * is valid or not. The algorithm of the check is: Only letter and 3 special
	 * characters are allow: hyphen, apostrophe and white space. And these 3 special
	 * characters must be between 2 letters. This algorithm is applied for both
	 * first name and last name.
	 * @param name the string of either first or last name that need to be checked.
	 * @throws IllegalArgumentException.
	 */
	private void validate(String name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Parameter name is null");
		}
		if (name.length() < 2 || name.length() < 2)
		{
			throw new IllegalArgumentException("Your First Name Is Too Short, or null");
		}
		// Check for the first and last character of the string must be a letter.
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
					// If the previous character is a space, hyphen or apostrophe, the next character must be a letter.
					if (!Character.isLetter(name.charAt(i+1)))
					{
						throw new IllegalArgumentException("Two special characters cannot be next to each other");
					}
				}
			}
		}
	}
	
	/**
	 * toString method is overrided, it will return fullname,
	 * but in different format.
	 * @return firstname, follows by an "*", follow by last name. E.g. John*Smith
	 */
	@Override
	public String toString() {
	    return (this.firstname + "*" + this.lastname);
	}
	
	/**
	 * compareTo method will check if two Name Objects are equal or not.
	 * @return 0 if two Name are equal, a positive integer if current Name
	 * is greater than the passed in Name, a negative if vice versa.
	 * @param name as a parameter of Name Object
	 * @throws IllegalArgumentException if Name is null.
	 */
	@Override
	public int compareTo(Name name) {
		if (name == null)
		{
			throw new IllegalArgumentException("Object Name is Null");
		}
		
		int check = this.lastname.compareToIgnoreCase(name.lastname);
		
		if (check != 0)
		{
			return check;
		}
		return this.firstname.compareToIgnoreCase(name.firstname);
	}
	
	/**
	 * equals method will check an Object is equal to a Name Object or not.
	 * A note for this method: If 2 Objects are equal, they MUST have the same
	 * hashcode
	 * @param object as the parameter of Objects
	 * @return true if an Object and a Name Object are equal, false otherwise.
	 */
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
	
	/**
	 * hashcode return the hascode from the getFullName on a Name Object.
	 * A note for this method: If 2 Objects are equal, they MUST have the same
	 * hashcode
	 * @return the hashcode of the Object.
	 */
	@Override
	public int hashCode() {
//		return this.toString().toUpperCase().hashCode();
		return Objects.hash(this.getFullName().toUpperCase());
	}
}