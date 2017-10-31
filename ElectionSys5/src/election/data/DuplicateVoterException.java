package election.data;

public class DuplicateVoterException extends Exception {

  /**
   * Used to identify a class' version to avoid problems during deserialization
   */
  private static final long serialVersionUID = 1L;

  private static final String DEFAULT = "defaultMsg";

  public DuplicateVoterException() {
    super(DEFAULT);
  }

  public DuplicateVoterException(String message) {
    super(message == null || message.isEmpty() ? DEFAULT : message);
  }

  public DuplicateVoterException(Throwable cause) {
    super(cause == null ? DEFAULT : cause.toString(), cause);
  }

  public DuplicateVoterException(String message, Throwable cause) {
    super(message == null || message.isEmpty() ? DEFAULT : message, cause);
  }

  public DuplicateVoterException(String message, Throwable cause, boolean enableSupress,
      boolean writableStackTrace) {
    super((message == null || message.isEmpty() ? DEFAULT : message), cause, enableSupress,
        writableStackTrace);
  }

  public String getLocalizedMessage() {
    return ("DuplicateVoterException : " + this.getMessage());
  }

}
