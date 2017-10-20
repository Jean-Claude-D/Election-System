package election.business;

import java.time.LocalDate;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import lib.Email;
import lib.Name;
import lib.PostalCode;

/**
 * 
 * @author JeanClaudeDesrosiers
 * @version 0.0.1
 */
public class DawsonVoter implements Voter {

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////// Fields
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * The static final long value used in deserialization process
   * 
   * @see java.io.Serializable
   * @since 0.0.1
   */
  private static final long serialVersionUID = 42031768871L;

  /**
   * The name of this DawsonVoter object as defined by Name
   * 
   * @since 0.0.1
   */
  private Name name;

  /**
   * The email address of this DawsonVoter object as defined by Email
   * 
   * @since 0.0.1
   */
  private Email email;

  /**
   * The postal code of this DawsonVoter object as defined by PostalCode
   * 
   * @since 0.0.1
   */
  private PostalCode postalCode;

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////// Ctor
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Constructs a DawsonVoter object with a first and last name, an email and a postal code
   * 
   * @param fName The first name
   * @param lName The last name
   * @param email The email address
   * @param pCode The postal code
   * 
   * @since 0.0.1
   */
  public DawsonVoter(String fName, String lName, String email, String pCode) {
    this.name = new Name(fName, lName);
    this.email = new Email(email);
    this.postalCode = new PostalCode(pCode);
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////// Getters
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Returns the Name name of this DawsonVoter
   * 
   * @return the Name name of this DawsonVoter
   * 
   * @since 0.0.1
   */
  @Override
  public Name getName() {
    return this.name;
  }

  /**
   * Returns the Email email address of this DawsonVoter
   * 
   * @return the Email email address of this DawsonVoter
   * 
   * @since 0.0.1
   */
  @Override
  public Email getEmail() {
    return this.email;
  }

  /**
   * Returns the PostalCode postal code of this DawsonVoter
   * 
   * @return the PostalCode postal code of this DawsonVoter
   * 
   * @since 0.0.1
   */
  @Override
  public PostalCode getPostalCode() {
    return this.postalCode;
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////// Setter
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Sets the PostalCode postal code of this DawsonVoter
   * 
   * @throws IllegalArgumentException if the PostalCode newPostalCode is null
   * 
   * @since 0.0.1
   */
  public void setPostalCode(PostalCode newPostalCode) {
    if (newPostalCode == null) {
      throw new IllegalArgumentException("The PostalCode newPostalCode must be non-null");
    }

    this.postalCode = new PostalCode(newPostalCode.getCode());
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // DawsonVoter methods
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Returns true if this DawsonVoter is eligible to voting in the Election election
   * 
   * For a DawsonVoter object to be eligible to an Election object:
   * 
   * The LocalDate date at which a DawsonVoter calls the method must be inclusively within the date
   * range of an Election. AND if an Election is limited to a range of PostalCode postal codes, then
   * a DawsonVoter's PostalCode postal code must be within the postal code range of an Election.
   * 
   * @return true if this DawsonVoter is eligible to voting in the Election election false otherwise
   * 
   * @since 0.0.1
   */
  @Override
  public boolean isEligible(Election election) {

    LocalDate now = LocalDate.now();

    if (!(now.isBefore(election.getStartDate())) && !(now.isAfter(election.getEndDate()))) {
      if (election.isLimitedToPostalRange()) {
        return this.postalCode.inRange(election.getPostalRangeStart(),
            election.getPostalRangeEnd());
      }

      return true;
    }

    return false;
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /// Comparable methods
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Compares this DawsonVoter with the Voter voter.
   * 
   * Ordering of DawsonVoter objects follows the ordering of their Email email address
   * 
   * Where x, y and z contain DawsonVoter objects:
   * 
   * x.compareTo(y) == -(y.compareTo(x)) AND if x.compareTo(y) > 0 && y.compareTo(z), then
   * x.compareTo(z) > 0 AND if x.compareTo(y) == 0, then x.compareTo(z) == y.compareTo(z) AND if
   * x.compareTo(y) == 0, then x.equals(y) returns true
   * 
   * @return a positive integer if this DawsonVoter is greater than the Voter voter zero if this
   *         DawsonVoter is equal to the Voter voter a negative integer otherwise
   * 
   * @see java.lang.Comparable
   * 
   * @since 0.0.1
   */
  @Override
  public int compareTo(Voter voter) {
    return this.email.compareTo(voter.getEmail());
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///// Object methods
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * Returns true if this DawsonVoter is equal to the Object object
   * 
   * Where x, y and z contain DawsonVoter objects:
   * 
   * x.equals(y) == y.equals(x) AND if x.equals(y) && y.equals(z), then x.equals(z) AND
   * x.equals(null) == false AND x.equals(x) AND if x.equals(y), then x.hashCode() == y.hashCode()
   * 
   * Two DawsonVoter objects are considered equal if:
   * 
   * They are of instance DawsonVoter AND Their Email email addresses are equal, according to
   * Email's definition of equality.
   * 
   * @param obj The Object object to check equality with this DawsonVoter
   * 
   * @return true if this DawsonVoter object equals the Object object
   * 
   * @throws IllegalArgumentException if the Object obj is null
   * 
   * @since 0.0.1
   */
  @Override
  public final boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this == obj) {
      return true;
    }

    return (obj instanceof DawsonVoter) && this.email.equals(((DawsonVoter) obj).email);
  }


  /**
   * Returns the computed hash code of this DawsonVoter object.
   * 
   * Where x and y are DawsonVoter objects:
   * 
   * if x.hashCode() == y.hashCode(), then x.equals(y) == true
   * 
   * but, if x.equals(y) == false, then x.hashCode() != y.hashCode() may not always be true
   * 
   * @return the computed hash code of this DawsonVoter object
   * 
   * @since 0.0.1
   */
  @Override
  public final int hashCode() {
    int prime = 157;
    return prime * this.email.hashCode();
  }


  /**
   * Returns a String representation of this DawsonVoter object.
   * 
   * The String representation follows the following format:
   * 
   * email address*first name*last name*postal code
   * 
   * @return a String representation if this DawsonVoter object
   * 
   * @since 0.0.1
   */
  @Override
  public String toString() {
    return this.email.toString() + '*' + this.name.toString() + '*' + this.postalCode.toString();
  }

}
