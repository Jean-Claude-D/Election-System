import election.business.DawsonItemBallot;

public class DawsonItemBallotTest {

	public static void main(String[] args) {
		
		
		int maxValue= 5;
		String choice= "Salad";
		int value= 2;
		
		
		DawsonItemBallot item1= new DawsonItemBallot(choice,maxValue);
		DawsonItemBallot item2= new DawsonItemBallot(choice,maxValue);
		
		System.out.println(item1.equals(null));		
		
		System.out.println(item1.equals(item2)); // Not Good
		System.out.println(item1.hashCode()); //Good
		System.out.println(item1.toString()); // Good
		
		item1.setValue(value); //good
		System.out.println(item1.getValue()); //good
		
		System.out.println(item1.getChoice()); //good
		System.out.println(item1.getMaxValue()); // good
		
		System.out.print(item1.compareTo(item2)); // good
		
	}

}
