package election.data;

/**
 * Exception thrown when a voter profile does not exist / is not found
 * @author Felicia Gorgatchov
 *
 */

public class InexistentVoterException extends Exception{

  private static final long serialVersionUID = 42031768871L;
  private static final String original = "The voter you are looking for unfortunately does not exist in our system database.";
  
  /**
   * Default constructor, prints the default message when called
   */  
  public InexistentVoterException() {
    super(original);
  }

  /**
   * Constructor, allows to print custom message instead of the default one.
   * @param message : message that the developer using this constructor wants to display instead of the default message.
   */
  public InexistentVoterException(String message) {
    super(message == null || message.isEmpty() ? original : message);
  }
  
}