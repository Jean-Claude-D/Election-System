package election.ui.gui;

import election.business.interfaces.Ballot;
import election.business.interfaces.BallotItem;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionOffice;
import election.business.interfaces.Voter;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SingleBallotFormGUI {

  private ElectionOffice model;
  private Election election;
  private Voter voter;
  private Ballot ballot;

  private ToggleGroup group;
  private Text actionTarget;

  private Stage primaryStage;
  private VoterEmailFormGUI gui;

  public SingleBallotFormGUI(ElectionOffice model, Election election, Voter v, Ballot b,
      VoterEmailFormGUI gui) {
    this.model = model;
    this.election = election;
    this.voter = v;
    this.ballot = b;
    this.gui = gui;
    this.actionTarget = new Text("");
    initialize();
  }

  /**
   * The stage and the scene are created in the start.
   *
   * @param primaryStage
   */
  public void start(Stage primaryStage) {
    // Set Window's Title
    this.primaryStage = primaryStage;
    primaryStage.setTitle("Get Ballot");
    GridPane root = createUserInterface();
    Scene scene = new Scene(root, 500, 475);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Create the user interface as the root
   *
   * @return
   */
  private GridPane createUserInterface() {
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
    grid.setGridLinesVisible(true);

    Text scenetitle = new Text("Welcome to " + this.election.getName());
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 0, 0, 2, 1);

    BallotItem[] choices = this.ballot.getBallotItems();

    RadioButton[] btns = new RadioButton[choices.length];
    this.group = new ToggleGroup();

    for (int i = 0; i < choices.length; i++) {
      btns[i] = new RadioButton(choices[i].getChoice());
      btns[i].setUserData(i);
      btns[i].setToggleGroup(group);
      // Offset by 1 so we don't overlap with title
      grid.add(btns[i], 1, i + 1);
    }

    Button btn = new Button("Cast vote");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(btn);
    // Offset by 1 so button appears below choices
    grid.add(hbBtn, 1, choices.length + 1);

    actionTarget.setId("actiontarget");
    grid.add(actionTarget, 0, choices.length + 2, 2, 1);


    btn.setOnAction(this::castButtonHandler);

    return grid;
  }

  /**
   * Event handler for the Cast Button
   *
   * @param e
   */
  private void castButtonHandler(ActionEvent e) {
    try {
      if (group.getSelectedToggle() != null) {
        int chosen = (Integer) group.getSelectedToggle().getUserData();
        this.ballot.selectBallotItem(chosen, 1);

        /*
         * System.out.println((this.ballot == this.election.getBallot(voter)) ?
         * ("They equal hdugwv") : ("They dont ksniibfy"));
         */

        /*
         * System.out .println((this.model.findElection(this.election.getName()) ==
         * this.ballot.getElection()) ? ("They equal!") : ("They dont"));
         */

        model.castBallot(this.voter, this.ballot);
        actionTarget.setText("Thank you for voting");
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> gui.start(this.primaryStage));
        pause.play();
      } else {
        System.err.println("Null selection?");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  /**
   * This code binds the properties of the data bean to the JavaFX controls. Changes to a control is
   * immediately written to the bean and a change to the bean is immediately shown in the control.
   */
  private void initialize() {
    // actionTarget = new Text();
  }
}
