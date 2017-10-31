package election.data;

/**
 * Is thrown when an attempt to save a Voter object already in the database is made.
 * 
 * @author DesJC
 *
 */
public class DuplicateVoterException extends Exception {

  /**
   * The identifier of the class' version to avoid problems during deserialization.
   */
  private static final long serialVersionUID = 1L;


  /**
   * The default message used in case a message parameter is null or empty.
   */
  private static final String DEFAULT = "There cannot be two identical Voter objects";

  /**
   * Constructs a new DuplicateVoterException with the DEFAULT.
   */
  public DuplicateVoterException() {
    super(DEFAULT);
  }

  /**
   * Constructs a new DuplicateVoterException with the message parameter.
   * 
   * @param message the String message for this DuplicateVoterException, if non-null and non-empty,
   *        else the DEFAULT is used.
   */
  public DuplicateVoterException(String message) {
    // If message is empty, replace it with DEFAULT
    super(message == null || message.isEmpty() ? DEFAULT : message);
  }

  /**
   * Constructs a new DuplicateVoterException with the cause parameter.
   * 
   * @param cause the Throwable object that caused this DuplicateVoterException to be instantiated.
   */
  public DuplicateVoterException(Throwable cause) {
    // If cause's message is empty, replace it with DEFAULT
    super(cause == null || cause.toString().isEmpty() || cause.toString() == null ? DEFAULT
        : cause.toString(), cause);
  }

  /**
   * Constructs a new DuplicateVoterException with the message and cause parameters.
   * 
   * @param message the String message for this DuplicateVoterException, if non-null and non-empty,
   *        else the DEFAULT is used.
   * @param cause the Throwable object that caused this DuplicateVoterException to be instantiated.
   */
  public DuplicateVoterException(String message, Throwable cause) {
    super(message == null || message.isEmpty() ? DEFAULT : message, cause);
  }

  /**
   * Constructs a new DuplicateVoterException with the message, cause, enableSuppress and
   * writableStackTrace parameters.
   * 
   * @param message message the String message for this DuplicateVoterException, if non-null and
   *        non-empty, else the DEFAULT is used.
   * @param cause the Throwable object that caused this DuplicateVoterException to be instantiated.
   * @param enableSuppress whether this DuplicateVoterException is suppressed or not. If this object
   *        is suppressed, it may not always be thrown when multiple exceptions occur.
   * @param writableStackTrace whether this DuplicateVoterException has a stackTrace or not.
   */
  protected DuplicateVoterException(String message, Throwable cause, boolean enableSuppress,
      boolean writableStackTrace) {
    super((message == null || message.isEmpty() ? DEFAULT : message), cause, enableSuppress,
        writableStackTrace);
  }


  /**
   * Returns a localized description of this DuplicateVoterException
   */
  public String getLocalizedMessage() {
    return ("DuplicateVoterException : " + this.getMessage());
  }

}
