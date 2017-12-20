package election.ui.tui;

import java.io.IOException;
import java.util.Scanner;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionOffice;
import election.business.interfaces.Voter;
import election.data.DuplicateVoterException;
import election.data.InexistentElectionException;
import election.data.InexistentVoterException;
import lib.Email;
import lib.Name;
import lib.PostalCode;

public class TextController {
  private ElectionOffice model;

  private enum Command {
    FIND_VOTER, REGISTER_VOTER, DISPLAY_WINNERS, LAUNCH_ELECTION, STOP
  }

  public TextController(ElectionOffice model) {
    this.model = model;
  }

  /**
   * Main loop of the menu system
   * 
   * @author Maja, Jaya
   * @throws InexistentVoterException
   * @throws DuplicateVoterException
   * @throws InexistentElectionException
   **/
  public void run() {
    Scanner keyboard = new Scanner(System.in);
    // recall: enum static method values returns an
    // array with all enum values
    Command[] commands = Command.values();
    String menu = createMenu(commands);
    Command choice;

    do {
      System.out.print(menu);
      choice = getUserChoice(commands, keyboard);
      switch (choice) {
        case FIND_VOTER:
          try {
            voterInfo(keyboard);
          } catch (InexistentVoterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          break;
        case REGISTER_VOTER:
          try {
            newVoter(keyboard);
          } catch (DuplicateVoterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          break;
        case DISPLAY_WINNERS:
          try {
            getWinner(keyboard);
          } catch (InexistentElectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          break;
        case LAUNCH_ELECTION:
          electionInfoLaunch(keyboard);
          break;
        case STOP:
          // nothing
      }
    } while (choice != Command.STOP);

    // When stopped, need to disconnect
    try {
      this.model.closeOffice();
    } catch (IOException ioe) {
      System.out.println("An error occured when closing the database.");
    }
  }


  /**
   * Private method used to retrieve a voter from the model based on their email.
   *
   * @author Felicia Gorgatchov
   * 
   * @param keyboard : input from the user placed into a scanner object
   * @return Voter object
   * @throws InexistentVoterException
   */
  private Voter voterInfo(Scanner keyboard) throws InexistentVoterException {
    keyboard.nextLine();
    String email = getEmail(keyboard);

    return model.findVoter(email);
  }

  // Private method that is invoked to create a new Voter object and
  // add to the model.
  // Note that there are other private methods below that can be
  // helpful.
  private void newVoter(Scanner keyboard) throws DuplicateVoterException {
    keyboard.nextLine();
    String firstName = getFirstName(keyboard);
    String lastName = getLastName(keyboard);
    String email = getEmail(keyboard);
    String postalCode = getPostalcode(keyboard);

    model.registerVoter(firstName, lastName, email, postalCode);


  }

  // Private method used to ask the user for the name of an election
  // and return the list of winners, if possible.
  // Note that there are other private methods below that can be
  // helpful.
  private void getWinner(Scanner keyboard) throws InexistentElectionException {
    keyboard.nextLine(); // consume any previous value
    Election e = getElection(keyboard);

    model.getWinner(e);
  }


  private Election getElection(Scanner keyboard) throws InexistentElectionException {

    boolean invalid;
    String name;
    Election found = null;

    do {
      invalid = false;
      name = getInput(keyboard, "\nPlease enter the name of the election: ");

      try {
        found = this.model.findElection(name);
      } catch (InexistentElectionException e) {
        System.out.println("\nNo election found with that name!");
        System.out.println("Please try again.");
        invalid = true;
      }
    } while (invalid);

    return found;
  }


  // Private method used to ask the user for the name of an election
  // and launch the JavaFX voting booth application.
  private Election electionInfoLaunch(Scanner keyboard) {
    keyboard.nextLine(); // consume any previous value

    // get name
    String name = getInput(keyboard, "\nPlease enter the name of the election: ");
    Election e;

    // get Election
    try {
      e = this.model.findElection(name);
    } catch (InexistentElectionException iee) {
      System.out.println("\nNo election found with that name!");
      System.out.println("Please try again.");
      return null;
    }
    // launch the JavaFX application
    // Assumes that the election.ui.gui.MainApp class has been compiled
    new Thread() {
      @Override
      public void run() {
        election.ui.gui.MainApp.initContext(model, e);
        javafx.application.Application.launch(election.ui.gui.MainApp.class);
      }
    }.start();


    return e;
  }

  // Private helper method to ask for an email string.
  // Invokes the Email constructor for validation. If the
  // string is invalid, it repeatedly asks the user
  private String getEmail(Scanner keyboard) {
    boolean invalid;

    String email;

    do {
      invalid = false;
      email = getInput(keyboard, "Please enter the email address: ");
      try {
        @SuppressWarnings("unused")
        Email emailObj = new Email(email);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid email!" + e.getMessage());
        System.out.print("Please try again: ");
        invalid = true;
      }
    } while (invalid);
    return email;
  }


  // Private helper method to ask for first name
  // Invokes the Email constructor for validation. If the
  // string is invalid, it repeatedly asks the user
  private String getFirstName(Scanner keyboard) {
    boolean invalid;
    String firstName;

    do {
      invalid = false;
      firstName = getInput(keyboard, "Please enter your first name: ");
      try {
        @SuppressWarnings("unused")
        Name nameObject = new Name(firstName, "Test");

      } catch (IllegalArgumentException e) {
        System.out.println("Invalid name " + e.getMessage());
        System.out.println("Please try again: ");

        invalid = true;
      }
    } while (invalid);
    return firstName;
  }


  // Private helper method to ask for last name
  // Invokes the Email constructor for validation. If the
  // string is invalid, it repeatedly asks the user
  private String getLastName(Scanner keyboard) {
    boolean invalid;
    String lastName;

    do {
      invalid = false;
      lastName = getInput(keyboard, "Please enter your last name: ");
      try {
        @SuppressWarnings("unused")
        Name nameObject = new Name("Test", lastName);

      } catch (IllegalArgumentException e) {
        System.out.println("Invalid name " + e.getMessage());
        System.out.print("Please try again: ");

        invalid = true;
      }
    } while (invalid);
    return lastName;
  }

  // Private helper method to ask for a postal code string.
  // Invokes the PostalCode constructor for validation. If the
  // string is invalid, it repeatedly asks the user
  private String getPostalcode(Scanner keyboard) {
    boolean invalid;
    String postalCode;

    do {
      invalid = false;
      postalCode = getInput(keyboard, "Please enter your postal code: ");
      try {
        @SuppressWarnings("unused")
        PostalCode postal = new PostalCode(postalCode);

      } catch (IllegalArgumentException e) {
        System.out.println("Invalid postal code " + e.getMessage());
        System.out.print("Please try again: ");

        invalid = true;
      }
    } while (invalid);

    return postalCode;
  }

  // Helper method for string input
  private String getInput(Scanner keyboard, String message) {
    System.out.print(message);
    return keyboard.nextLine();
  }

  // helper method for integer input
  private int getInt(Scanner keyboard, String message, int highest) {
    System.out.print(message);
    boolean done = false;
    int result = -1;
    while (!done) {
      // user entered something that is not an int
      if (!keyboard.hasNextInt()) {
        // consume the invalid token, including any leading whitespace
        keyboard.next();
        System.out.print("Invalid – Enter only a whole number ");
      } else {
        result = keyboard.nextInt();
        if (result > highest || result < 0) {
          System.out.print("Invalid – Enter number less than or equal to " + highest);
        } else
          done = true;
      }
    }
    return result;
  }


  // Helper method that displays the menu based on the enum values
  private String createMenu(Command[] commands) {
    String menu = "\nDawson Election Office Menu\nSelect a choice from the menu:\n";
    int numChoices = commands.length;
    for (int i = 0; i < numChoices; i++)
      menu += "\t" + (i + 1) + " - " + commands[i] + "\n";
    menu += "\nEnter your choice: ";

    return menu;
  }

  // Helper method that validates that the user choice of menu item is
  // valid.
  private Command getUserChoice(Command[] commands, Scanner keyboard) {
    boolean invalid;
    int maxChoiceValue = commands.length;
    int userChoice = 0;
    do {
      try {
        invalid = false;
        userChoice = keyboard.nextInt();
        if (userChoice <= 0 || userChoice > maxChoiceValue) {
          System.out.print(
              "Invalid choice! Enter a number in " + " the range of 1 to " + maxChoiceValue + " ");
          invalid = true;
        }
      } catch (java.util.InputMismatchException e) {
        System.out.print("Invalid choice! You must enter a" + " numeric value in the range of 1 to "
            + maxChoiceValue + " ");
        invalid = true;
        keyboard.nextLine(); // consume the invalid value
      }
    } while (invalid);
    return commands[userChoice - 1];
  }

}
