package election.business;

public class InvalidVoterException extends RuntimeException {

  private static final long serialVersionUID = 0;
  private static final String DEFAULT = "This Voter is Not Valid";

  /**
   * Constructs a default InvalidVoterException with the DEFAULT message.
   * 
   */
  public InvalidVoterException() {
    super(DEFAULT);
  }

  /**
   * Constructs a new InvalidVoterException with the message parameter.
   * 
   * @param message the String that will be displayed when the Exception is catch.
   */
  public InvalidVoterException(String message) {
    // Return the DEFAULT message when String message is null or empty
    super(message == null || message.isEmpty() ? DEFAULT : message);
  }

  /**
   * Constructs a new InvalidVoterException with the cause parameter.
   * 
   * @param cause the Throwable object that caused this DuplicateVoterException to be instantiated.
   */
  public InvalidVoterException(Throwable cause) {
    // If cause's message is empty, replace it with DEFAULT
    super(cause == null || cause.getMessage().isEmpty() || cause.getMessage() == null ? DEFAULT
        : cause.toString(), cause);
  }

  /**
   * Constructs a new InvalidVoterException with the message and cause parameters.
   * 
   * @param message the String that will display when the exception is caught. Return DEFAULT
   *        message when message is null or empty.
   * @param cause the Throwable object that caused this DuplicateVoterException to be instantiated.
   */
  public InvalidVoterException(String message, Throwable cause) {
    super(message == null || message.isEmpty() ? DEFAULT : message, cause);
  }

  /**
   * Constructs a new InvalidVoterException with the message, cause, enableSuppress and
   * writableStackTrace parameters.
   * 
   * @param message the String that will display when the exception is caught. Return DEFAULT
   *        message when message is null or empty.
   * @param cause the Throwable object that caused this DuplicateVoterException to be instantiated.
   * @param enableSuppress determine if the InvalidVoterException will be throw or not.
   * @param writableStackTrace determine if the InvalidVoterException has a strack trace or not.
   */
  protected InvalidVoterException(String message, Throwable cause, boolean enableSuppress,
      boolean writableStackTrace) {
    super((message == null || message.isEmpty() ? DEFAULT : message), cause, enableSuppress,
        writableStackTrace);
  }


  /**
   * Returns a localized description of this InvalidVoterException.
   */
  public String getLocalizedMessage() {
    return ("DuplicateVoterException : " + this.getMessage());
  }
}


