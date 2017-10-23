package util;

import java.util.Comparator;
import java.util.Arrays;

import lib.Name;
import lib.PostalCode;
import lib.Email;

public class ListUtilitiesTest {

<<<<<<< HEAD
	public static void main(String[] args) {

		// ----- Variables for Jean-Claude
		// ---------------------------------------------------------------------------------

		// ----- Variables for Cao Hoang
		// -----------------------------------------------------------------------------------
		
		Name person1 = new Name("Jean-Claude", "French");
    Name person2 = new Name("Cao Hoang", "Vietnam");
    Name person3 = new Name("Maria", "Morocco");
    Name person4 = new Name("Felicia", "Bulgaria");
    Name person5 = new Name("Our-Team", "Canada");
    Name person6 = new Name("Bob", "French");

    Name[] listNameTest = new Name[] {person1, person2, person3, person4, person5, person6};

    Name[] listNameCheck = new Name[] {person4, person5, person6, person1, person3, person2};

    sortTest(listNameTest, new NameByFirstComparator(), listNameCheck, true);

		// ----- Variables for Felicia
		// -------------------------------------------------------------------------------------

		boolean expectValid = true;
		boolean expectInvalid = false;

		Comparable[] predictException = new Comparable[10];

		Name fel = new Name("Felicia", "Gorgatchov");
		Name ivo = new Name("Ivaylo", "Gorgatchov");
		Name jc = new Name("Jean-Claude", "Desrosiers");
		Name maria = new Name("Maria", "Hossain");
		Name hoang = new Name("Cao Hoang", "Nguyen");
		Name[] nameSortTestGood1 = { maria, ivo, hoang, jc, fel };		
		Name[] nameSortTestGood2 = { hoang, fel, maria, jc, ivo };		
		Name[] nameSortTestNotFull = { fel, null, jc, null };
		Name[] nameSortTestNull = { null, null, null, null };
		
		Name[] namePrediction = { jc, fel, ivo, maria, hoang };

		PostalCode pc1 = new PostalCode("J4X 2G3");
		PostalCode pc2 = new PostalCode("H3H1M6");
		PostalCode pc3 = new PostalCode("H3H 5B2");
		PostalCode pc4 = new PostalCode("X0B1K0");
		PostalCode pc5 = new PostalCode("V5K 0A4");
		PostalCode[] pcSortTestGood = { pc4, pc3, pc5, pc2, pc1 };
		PostalCode[] pcSortTestGood2 = { pc4, pc2, pc3, pc5, pc1 };
		PostalCode[] pcSortTestNotFull = { pc3, null, pc1, null };
		PostalCode[] pcSortTestNull = { null, null, null, null, null };
		
		PostalCode[] postalCodePrediction = {pc2, pc3, pc1, pc5, pc4};

		Email email1 = new Email("felicia.gorgatchov@gmail.com"); //2
		Email email2 = new Email("rick_C-137@ricksanchez.com"); //5
		Email email3 = new Email("mclovin81@memes.fr"); //3
		Email email4 = new Email("12zebulon34@bruh.uk");//1
		Email email5 = new Email("78hola@mexico.mx"); //4
		Email email6 = new Email("42@whatislife.com"); //7
		Email email7 = new Email("zebulon@somehostID.ca"); // 6
		
		Email[] emailSortTestGood = { email1, email2, email3, email4, email5, email6, email7 };
		Email[] emailSortTestGood2 = { email3, email5, email1, email7, email2, email6 };
		Email[] emailSortTestGood3 = { email1, email2, email3, email7 };
		Email[] emailSortTestGood4 = { email4, email5, email6 };
		Email[] emailSortTestNotFull = { email1, email5, email4, email7, email2, null, email3 };
		Email[] emailSortTestNull = { null, null, null, null, null };
		
		Email[] emailPrediction = { email4, email1, email3, email5, email2, email7, email6 };

		System.out.println(
				"\n-------NAME------------------------------------------------------------------------------------------------------------------");
		sortTest(nameSortTestGood1, namePrediction, expectValid);
		sortTest(nameSortTestGood2, namePrediction, expectValid);
		sortTest(nameSortTestNotFull, predictException, expectInvalid);
		sortTest(nameSortTestNull, predictException, expectInvalid);

		System.out.println(
				"\n-------POSTALCODE-------------------------------------------------------------------------------------------------------------------");
		sortTest(pcSortTestGood, postalCodePrediction, expectValid);
		sortTest(pcSortTestGood2, postalCodePrediction, expectValid);
		sortTest(pcSortTestNotFull, predictException, expectInvalid);
		sortTest(pcSortTestNull, predictException, expectInvalid);

		System.out.println(
				"\n-------EMAIL------------------------------------------------------------------------------------------------------------------");
		sortTest(emailSortTestGood, emailPrediction, expectValid);
		sortTest(emailSortTestGood2, emailPrediction, expectValid);
		sortTest(emailSortTestGood3, emailPrediction, expectValid);
		sortTest(emailSortTestGood4, emailPrediction, expectValid);
		sortTest(emailSortTestNotFull, predictException, expectInvalid);
		sortTest(emailSortTestNull, predictException, expectInvalid);

	}// end main

	// TEST METHODS
	// -------------------------------------------------------------------------------------------------
	// part 4
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void sortTest(Comparable[] list, Comparable[] prediction,boolean expectedResult) {
		String uglyClassName = list.getClass().getName();
		String className = list.getClass().getName().substring(uglyClassName.lastIndexOf('.')+1, uglyClassName.indexOf(";"));
		System.out.println("\nSELECTION SORT TEST ON -- " + className);
		
		try{
		      System.out.println("\n\tPassing: " + Arrays.toString(list));
		      System.out.println("\n\tExpected Result: " + Arrays.toString(prediction));
		      ListUtilities.sort(list);
		      for(int i = 0; i < list.length; i++){
		    	  if(list[i] == prediction[i]) {
		    	  }
		    	  else {
		    		  System.out.println("\n\tResult: " + Arrays.toString(list));
		    		  System.out.println("\n\t ==== FAILED TEST ===");
		    		  return;
		    	  }
		      }
		      System.out.println("\n\tResult: " + Arrays.toString(list));
    		  System.out.println("\n\t ==== PASSED TEST ===");
			
		}catch(IllegalArgumentException iae) {
			if (expectedResult == true) {
		        System.out.println("\n\tResult: " + iae);
		        System.out.println("\n\t ==== TEST FAILED exception thrown when data is valid ==== ");
		      } else {
		        System.out.println("\n\tResult: " + iae);
		        System.out.println("\n\t ==== PASSED TEST exception caught successfully ==== ");
		      }
			
		}catch(NullPointerException npe) {
			if (expectedResult == true) {
		        System.out.println("\n\tPassing: " + Arrays.toString(list));
		        System.out.println("\n\tResult: " + npe);
		        System.out.println("\n\t ==== TEST FAILED exception thrown when data is valid ==== ");
		      } else {
		        System.out.println("\n\tPassing: " + Arrays.toString(list));
		        System.out.println("\n\tResult: " + npe);
		        System.out.println("\n\t ==== PASSED TEST exception caught successfully ==== ");
		      }
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void mergeTest(Comparable[] list1, Comparable[] list2, String test, boolean expectedResult) {

	}

	// comparator, part 5
  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void sortTest(Comparable[] list, Comparator sortOrder, Comparable[] expectList,
      boolean expectedResult) {
    ListUtilities.sort(list, sortOrder);

    for (int i = 0; i < list.length; i++) {
      if ((sortOrder.compare(list[i], expectList[i]) == 0) != expectedResult) {
        System.out.println("TEST FAILED");
        return;
      }
    }
    System.out.println("TEST PASSED");

  }

}// end of test class
	// -------------------------------------------------------------------------------------------
=======
  public static void main(String[] args) {

    // ----- Variables for Jean-Claude
    // ---------------------------------------------------------------------------------

    // ----- Variables for Cao Hoang
    // -----------------------------------------------------------------------------------

    // ----- Variables for Felicia
    // -------------------------------------------------------------------------------------

  }// end main



  // TEST METHODS
  // -------------------------------------------------------------------------------------------------
  // part 4
  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void sortTest(Comparable[] list, boolean expectedResult) {

  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void mergeTest(Comparable[] list1, Comparable[] list2, Comparable[] expectedList,
      String duplicateFileNameTest, boolean expectedResult, Class expectedException) {

  }

  // comparator, part 5
  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void sortTest(Comparable[] list, Comparator sortOrder, boolean expectedResult) {

  }


}// end of test class
 // -------------------------------------------------------------------------------------------
>>>>>>> Begin test for merge ListUtilities
