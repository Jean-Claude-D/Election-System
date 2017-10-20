package election.business;

import election.business.interfaces.BallotItem;

/**
 * 
 * @author Maria Hossain
 * @since Oct. 2nd 2017
 */
public class DawsonBallotItem implements BallotItem {


  private String choiceString;
  private int value;
  private final int maxValue;
  private static final long serialVersionUID = 42031768871L;


  /**
   * 
   * The constructor takes in 2 parameter to create the DawsonBallotItem which is the Choice and the
   * MaxValue
   * 
   * @param choiceString
   * @param maxValue
   */


  public DawsonBallotItem(String choiceString, int maxValue) {

    this.choiceString = choiceString;
    this.maxValue = maxValue;
    this.value = 0;
    validateBallotItem();


  }

  /**
   * 
   * This is the copy constructor that takes a DawsonBallotItem Object as a parameter
   * DawsonBallotItem objet.
   * 
   * @param item
   */

  public DawsonBallotItem(BallotItem item) {

    this.choiceString = getChoice();
    this.value = getValue();
    this.maxValue = getMaxValue();
    validateBallotItem();

  }

  /**
   * 
   * This method makes sure that the choice is not null and that the maxValue is not lower than 1
   */

  public void validateBallotItem() {

    if (choiceString == null || maxValue < 1) {

      throw new IllegalArgumentException(
          "The max vlaue is smaller than 1 and the choice is empty. Please enter a valid choice");
    }

  }

  /**
   * This methods check that the object is of the same instance as DawsonBallotItem
   * 
   * And that the choice is the same
   * 
   */

  @Override

  public final boolean equals(Object dawsonBallotItem) {

    if (dawsonBallotItem == null) {
      return false;
    }

    if (this instanceof DawsonBallotItem) {

      if (this.choiceString.equals(((DawsonBallotItem) dawsonBallotItem).getChoice())) {


        return true;


      }

    }
    return false;
  }

  /**
   * 
   * This method returns the hash code of the choice.
   */

  @Override

  public int hashCode() {

    return this.getChoice().toLowerCase().hashCode();

  }

  /**
   * 
   * This overriden toString() method return a string that has the value and choice with a '*'
   * delimeter.
   * 
   * For example it returns
   * 
   * choice*value
   */

  @Override

  public String toString() {

    String choice = this.getChoice();
    int Value = this.getValue();



    return (choice + "*" + Value);


  }

  /**
   * 
   * Method set the value field to another value. It makes sure it is not greater than MaxValue
   */



  public void setValue(int value) {

    if (!(0 <= value && value <= maxValue)) {

      throw new IllegalArgumentException(
          "The value should be grater than 0 and the value should not be greater than the Max Value ");
    }

    this.value = value;
  }

  /**
   * 
   * Returns the current choice
   */

  public String getChoice() {

    return this.choiceString;
  }


  /**
   * 
   * Returns the current value
   */
  public int getValue() {

    return value;
  }


  /**
   * 
   * Returns the current MaxValue
   */

  public int getMaxValue() {

    return maxValue;
  }

  /**
   * 
   * Returns int that represent if one choice is greater than the lexicographical order
   * 
   * 0=equal 1= Greater than -1= Less than
   * 
   * @param item
   * @return
   */

  public int compareTo(DawsonBallotItem item) {

    return this.getChoice().compareToIgnoreCase(item.getChoice());

  }

  /**
   * 
   * Compare an object to the BollotItem
   */

  public int compareTo(BallotItem bItem) {

    return (this.compareTo(bItem));
  }

}
