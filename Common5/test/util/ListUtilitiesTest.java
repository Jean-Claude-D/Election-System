package util;

import java.util.Comparator;
import lib.Name;

public class ListUtilitiesTest {
	
	public static void main (String [] args) {
		
//----- Variables for Jean-Claude ---------------------------------------------------------------------------------
		
	  Name person1 = new Name("Jean-Claude", "French");
	  Name person2 = new Name("Cao Hoang", "Vietnam");
	  Name person1 = new Name("Maria", "Morocco");
	  Name person1 = new Name("Felicia", "Bulgaria");
	  Name person1 = new Name("Our-Team", "Canada");
		
//----- Variables for Felicia -------------------------------------------------------------------------------------		
		
	}//end main
	
	
	
	
//TEST METHODS -------------------------------------------------------------------------------------------------
	//part 4
	@SuppressWarnings({"rawtypes","unchecked"})
	private static void sortTest(Comparable[] list, boolean expectedResult) {
		
	}
	
	@SuppressWarnings({"rawtypes","unchecked"})
	private static void mergeTest(Comparable[] list1, Comparable[] list2, String test, boolean expectedResult) {
		
	}
	
	//comparator, part 5
	@SuppressWarnings({"rawtypes","unchecked"})
	private static void sortTest(Comparable[] list, Comparator sortOrder, boolean expectedResult) {
	  ListUtilities.sort(list, sortOrder);
		
	}
	
	
}//end of test class -------------------------------------------------------------------------------------------
