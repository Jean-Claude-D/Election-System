package election.data;

public class InexistentElectionException extends Exception {

  private static final long serialVersionUID = 1L;

  private static final String DEFAULT = "This election does not exist.";

  public InexistentElectionException() {
    super(DEFAULT);
  }

  public InexistentElectionException(String message) {

    super(message == null || message.isEmpty() ? DEFAULT : message);
  }

  public InexistentElectionException(Throwable cause) {

    super(cause == null || cause.getMessage().isEmpty() || cause.getMessage() == null ? DEFAULT
        : cause.toString(), cause);
  }

  public InexistentElectionException(String message, Throwable cause) {
    super(message == null || message.isEmpty() ? DEFAULT : message, cause);
  }

  protected InexistentElectionException(String message, Throwable cause, boolean enableSuppress,
      boolean writableStackTrace) {
    super((message == null || message.isEmpty() ? DEFAULT : message), cause, enableSuppress,
        writableStackTrace);
  }

  public String getLocalizedMessage() {
    return ("InexistentElectionException : " + this.getMessage());
  }

}
