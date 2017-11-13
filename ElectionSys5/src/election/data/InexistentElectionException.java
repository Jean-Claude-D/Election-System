package election.data;


/**
 * 
 * @author Maria Hossain
 * 
 *         This exception class throws a InexistentElectionException whenever an election is not
 *         found or null
 *
 */

public class InexistentElectionException extends Exception {

  private static final long serialVersionUID = 1L;

  private static final String DEFAULT = "This election does not exist.";


  /**
   * 
   * This constructor calls the super on the field name DEFAULT
   */

  public InexistentElectionException() {
    super(DEFAULT);
  }

  /**
   * This constructor displays the error message when the message is either null or empty
   * 
   * @param message
   */

  public InexistentElectionException(String message) {

    super(message == null || message.isEmpty() ? DEFAULT : message);
  }

  /**
   * 
   * Constructs a new InexistentElectionException with the message and cause parameters.
   * 
   * @param cause
   */
  public InexistentElectionException(Throwable cause) {

    super(cause == null || cause.getMessage().isEmpty() || cause.getMessage() == null ? DEFAULT
        : cause.toString(), cause);
  }

  /**
   * 
   * @param message
   * @param cause
   */

  public InexistentElectionException(String message, Throwable cause) {
    super(message == null || message.isEmpty() ? DEFAULT : message, cause);
  }

  /**
   * 
   * @param message
   * @param cause
   * @param enableSuppress
   * @param writableStackTrace
   */

  protected InexistentElectionException(String message, Throwable cause, boolean enableSuppress,
      boolean writableStackTrace) {
    super((message == null || message.isEmpty() ? DEFAULT : message), cause, enableSuppress,
        writableStackTrace);
  }

  /**
   * 
   */

  public String getLocalizedMessage() {
    return ("InexistentElectionException : " + this.getMessage());
  }

}
