package election.data;

/**
 * Is thrown when an attempt to save an Election object already in the database is made.
 * 
 * @author DesJC
 *
 */
public class DuplicateElectionException extends Exception {

  /**
   * The identifier of the class' version to avoid problems during deserialization.
   */
  private static final long serialVersionUID = 1L;


  /**
   * The default message used in case a message parameter is null or empty.
   */
  private static final String DEFAULT = "There cannot be two identical Election objects";

  /**
   * Constructs a new DuplicateElectionException with the DEFAULT.
   */
  public DuplicateElectionException() {
    super(DEFAULT);
  }

  /**
   * Constructs a new DuplicateElectionException with the message parameter.
   * 
   * @param message the String message for this DuplicateElectionException, if non-null and
   *        non-empty, else the DEFAULT is used.
   */
  public DuplicateElectionException(String message) {
    // If message is empty, replace it with DEFAULT
    super(message == null || message.isEmpty() ? DEFAULT : message);
  }

  /**
   * Constructs a new DuplicateElectionException with the cause parameter.
   * 
   * @param cause the Throwable object that caused this DuplicateElectionException to be
   *        instantiated.
   */
  public DuplicateElectionException(Throwable cause) {
    // If cause's message is empty, replace it with DEFAULT
    super(cause == null || cause.getMessage().isEmpty() || cause.getMessage() == null ? DEFAULT
        : cause.toString(), cause);
  }

  /**
   * Constructs a new DuplicateElectionException with the message and cause parameters.
   * 
   * @param message the String message for this DuplicateElectionException, if non-null and
   *        non-empty, else the DEFAULT is used.
   * @param cause the Throwable object that caused this DuplicateElectionException to be
   *        instantiated.
   */
  public DuplicateElectionException(String message, Throwable cause) {
    super(message == null || message.isEmpty() ? DEFAULT : message, cause);
  }

  /**
   * Constructs a new DuplicateElectionException with the message, cause, enableSuppress and
   * writableStackTrace parameters.
   * 
   * @param message message the String message for this DuplicateElectionException, if non-null and
   *        non-empty, else the DEFAULT is used.
   * @param cause the Throwable object that caused this DuplicateElectionException to be
   *        instantiated.
   * @param enableSuppress whether this DuplicateElectionException is suppressed or not. If this
   *        object is suppressed, it may not always be thrown when multiple exceptions occur.
   * @param writableStackTrace whether this DuplicateElectionException has a stackTrace or not.
   */
  protected DuplicateElectionException(String message, Throwable cause, boolean enableSuppress,
      boolean writableStackTrace) {
    super((message == null || message.isEmpty() ? DEFAULT : message), cause, enableSuppress,
        writableStackTrace);
  }


  /**
   * Returns a localized description of this DuplicateVoterException
   */
  public String getLocalizedMessage() {
    return ("DuplicateElectionException : " + this.getMessage());
  }

}
