package election.business;

public class DawsonBallotItemTest {

  public static void main(String[] args) {


    // Variable I have created to create 3 DawsonBallotItem Object


    int maxValue = 5;
    String choice = "Salad";
    int value = 2;
    int value1 = 3;
    String choice2 = "Fries";


    // Created 3 object to test the methods within the DawsonBallotItem

    DawsonBallotItem item1 = new DawsonBallotItem(choice, maxValue);
    DawsonBallotItem item2 = new DawsonBallotItem(choice, maxValue);
    DawsonBallotItem item3 = new DawsonBallotItem(choice2, value1);


    // All the methods tested within the DawsonBallotItem

    System.out.println(item1.equals(null)); // good, it returns False
    System.out.println(item1.equals(item3));// good
    System.out.println(item1.equals(item2)); // Good
    System.out.println(item1.hashCode()); // Good
    System.out.println(item1.toString()); // Good
    System.out.println(item3.toString());// Good

    item1.setValue(value); // good
    System.out.println(item1.getValue()); // good
    System.out.println(item3.getChoice());// good
    System.out.println(item1.getChoice()); // good
    System.out.println(item1.getMaxValue()); // good

    System.out.print(item1.compareTo(item2)); // good

  }

}
