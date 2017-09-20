/**
 * 
 */
package lib;

/**
 * @author Mish
 *
 */

public class Person {
	private Name name;
	private Address address;
	
	
	public Person (String firstName, String lastName,Address address ) {
		this.name = new Name(firstName, lastName);
		this.address = new Address(address.getCivicNumber(), address.getStreetName(), address.getCity());		
	}
	
	public Person (String firstName, String lastName) {
		this(firstName, lastName,new Address("","",""));
		
	}	
	
	
	public Person (Name n, Address address) {
		this.name = new Name(n.getFirstname(), n.getLastname());
		this.address = new Address(address.getCivicNumber(), address.getStreetName(), address.getCity());
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return new Name(name);
	}

	/**
	 * @return the adress
	 */
	public Address getAdress() {
		return new Address(address);
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String firstName, String lastName) {
		this.name.setFirstname(firstName);
		this.name.setLastname(lastName);
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {

	    return name.toString() + "*" +
	        (address == null ? "" : address.toString());
	}

	
}
