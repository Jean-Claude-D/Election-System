package util;

import java.util.Comparator;
import lib.Name;

public class ListUtilitiesTest {

  public static void main(String[] args) {

    // ----- Variables for Jean-Claude
    // ---------------------------------------------------------------------------------

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

  }// end main



  // TEST METHODS
  // -------------------------------------------------------------------------------------------------
  // part 4
  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void sortTest(Comparable[] list, boolean expectedResult) {

  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void mergeTest(Comparable[] list1, Comparable[] list2, String test,
      boolean expectedResult) {

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
}
