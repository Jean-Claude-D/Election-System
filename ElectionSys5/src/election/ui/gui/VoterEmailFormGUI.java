package election.ui.gui;

import election.business.ElectionType;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionOffice;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Form that gets the voter email, finds the Voter in the model If the voter is eligible for the
 * election, instantiate and start a SingleBallotFormGUI
 */
public class VoterEmailFormGUI {

  private ElectionOffice model;
  private Election election;

  private Stage primaryStage;

  // TODO add any additional properties

  /**
   * Constructor validates that the parameters are not null and the election has
   * ElectionType.SINGLE. Invokes the initialize() method
   * 
   * @throws IllegalArgumentException if the conditions are not met.
   */
  public VoterEmailFormGUI(ElectionOffice model, Election election) {
    if (model == null) {
      throw new IllegalArgumentException("The model parameter cannot be null");
    } else if (election == null) {
      throw new IllegalArgumentException("The election parameter cannot be null");
    } else if (election.getElectionType() != ElectionType.SINGLE) {
      throw new IllegalArgumentException("The Election must be of ElectionType SINGLE");
    }

    this.model = model;
    this.election = election;

  }

  /**
   * The stage and the scene are created in the start.
   *
   * @param primaryStage
   */
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    // Set Window's Title
    primaryStage.setTitle("Get Voter Email");
    GridPane root = createUserInterface();
    Scene scene = new Scene(root, 500, 275);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Create the user interface as the root
   *
   * @return GridPane with the UI
   */
  private GridPane createUserInterface() {
    GridPane grid = new GridPane();
  }

  /**
   * Event handler for the Sign In Button
   *
   * @param e
   */
  private void signInButtonHandler(ActionEvent e) {

    // TODO
  }

  /**
   * This method is usually used for data binding of a "data bean" class to the JavaFX controls. A
   * "bean" class is a simple class with getters and setters for all properties. Changes to a
   * control are immediately set on the bean and a change to the bean is immediately shown in the
   * control.
   */
  private void initialize() {

  }
}
