package util;

import java.util.Comparator;

import lib.Name;
import lib.PostalCode;
import lib.Email;

public class ListUtilitiesTest {
	
	public static void main (String [] args) {
		
//----- Variables for Jean-Claude ---------------------------------------------------------------------------------
		
//----- Variables for Cao Hoang -----------------------------------------------------------------------------------
		
//----- Variables for Felicia -------------------------------------------------------------------------------------	
		
		boolean expectValid = true;
		boolean expectInvalid = false;
		
		Name fel = new Name("Felicia","Gorgatchov");
		Name jc = new Name("Jean-Claude","Desrosiers");
		Name maria = new Name("Maria","Hossain");
		Name hoang = new Name("Cao Hoang","Nguyen");
		Name[] nameSortTestGood1 = {maria,hoang,jc,fel};
		Name[] nameSortTestGood2 = {hoang,fel,maria,jc};
		Name[] nameSortTestNotFull = {fel,null,jc,null};
		Name[] nameSortTestNull = {null,null,null,null};
		
		PostalCode pc1 = new PostalCode("J4X 2G3");
	    PostalCode pc2 = new PostalCode("H3H1M6");
	    PostalCode pc3 = new PostalCode("X0B 1K0");
	    PostalCode pc4 = new PostalCode("V5K0A4");
	    PostalCode[] pcSortTestGood = {pc4,pc3,pc2,pc1};
		PostalCode[] pcSortTestGood2 = {pc4,pc2,pc3,pc1};
		PostalCode[] pcSortTestNotFull = {pc3,null,pc1,null};
		PostalCode[] pcSortTestNull = {null,null,null,null,null};
		
	    Email email1 = new Email("felicia.gorgatchov@gmail.com");
	    Email email2 = new Email("rick_C-137@ricksanchez.com");
	    Email email3 = new Email("mclovin81@memes.fr");
	    Email email4 = new Email("12zebulon34@");
	    Email email5 = new Email("78hola@mexico.mx");
	    Email email6 = new Email("42@whatislife.com");
	    Email email7 = new Email("zebulon@somehostID.ca");
	    Email[] emailSortTestGood = {email1,email2,email3,email4,email5,email6,email7};
		Email[] emailSortTestGood2 = {email3,email5,email1,email7,email2,email6};
		Email[] emailSortTestGood3 = {email1,email2,email3,email7};
		Email[] emailSortTestGood4 = {email4,email5,email6};
		Email[] emailSortTestNotFull = {email1,email5,email4,email7,email2,null,email3};
		Email[] emailSortTestNull = {null,null,null,null,null};
		
	    System.out.println(
	            "\n-------NAME------------------------------------------------------------------------------------------------------------------");
	    sortTest(nameSortTestGood1,expectValid);
	    sortTest(nameSortTestGood2,expectValid);
	    sortTest(nameSortTestNotFull,expectInvalid);
	    sortTest(nameSortTestNull,expectInvalid);
	   	   
		System.out.println(
	            "\n-------POSTALCODE-------------------------------------------------------------------------------------------------------------------");
		sortTest(pcSortTestGood,expectValid);
		sortTest(pcSortTestGood2,expectValid);
		sortTest(pcSortTestNotFull,expectInvalid);
		sortTest(pcSortTestNull,expectInvalid);
	    
		System.out.println(
	            "\n-------EMAIL------------------------------------------------------------------------------------------------------------------");
		sortTest(emailSortTestGood,expectValid);
		sortTest(emailSortTestGood2,expectValid);
		sortTest(emailSortTestGood3,expectValid);
		sortTest(emailSortTestGood4,expectValid);
		sortTest(emailSortTestNotFull,expectInvalid);
		sortTest(emailSortTestNull,expectInvalid);
		
		
	}//end main
	
	
	
	
//TEST METHODS -------------------------------------------------------------------------------------------------
	//part 4
	@SuppressWarnings({"rawtypes","unchecked"})
	private static void sortTest(Comparable[] list, boolean expectedResult) {
		System.out.println("TESTING SELECTION SORT ON" + list.getClass());
		
	}
	
	@SuppressWarnings({"rawtypes","unchecked"})
	private static void mergeTest(Comparable[] list1, Comparable[] list2, String test, boolean expectedResult) {
		
	}
	
	//comparator, part 5
	@SuppressWarnings({"rawtypes","unchecked"})
	private static void sortTest(Comparable[] list, Comparator sortOrder, boolean expectedResult) {
		
	}
	
	
}//end of test class -------------------------------------------------------------------------------------------
