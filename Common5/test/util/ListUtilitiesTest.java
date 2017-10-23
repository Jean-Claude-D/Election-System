package util;

import java.util.Comparator;

public class ListUtilitiesTest {

  public static void main(String[] args) {

    // ----- Variables for Jean-Claude
    // ---------------------------------------------------------------------------------

    mergeTest(null, null, null, null, false, null);

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
      String duplicateFileNameTest, boolean expectedValid, Class expectedException) {
    final String FAIL = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST FAILED";
    final String PASS = "\n\t\t\t\t\t\t\t\t\t\t\t\t\tTEST PASS";

    System.out.println(
        "==================================================================================================================");

    System.out.println("BEGIN mergeTest with :");
    System.out.println("duplicateFileName : " + duplicateFileNameTest);

    System.out.println("list1 :");
    if (list1 != null) {
      System.out.println('[');
      for (Comparable c : list1) {
        System.out.println(c == null ? "null" : c);
      }
      System.out.println(']');
    } else {
      System.out.println("null");
    }


    System.out.println("list2 : ");
    if (list2 != null) {
      System.out.println('[');
      for (Comparable c : list2) {
        System.out.println(c == null ? "null" : c);
      }
      System.out.println(']');
    } else {
      System.out.println("null");
    }

    System.out.println("expected : ");
    System.out.println('[');
    for (Comparable c : expectedList) {
      System.out.println(c == null ? "null" : c);
    }
    System.out.println(']');

    System.out.println(expectedValid ? "Expected to be valid" : "Should not be valid");

    System.out.println(expectedException == null ? "No exception expected"
        : expectedException.getName() + " expected");

    try {

      Comparable[] list3 = ListUtilities.merge(list1, list2, duplicateFileNameTest);

      if (list3.length == expectedList.length && expectedValid) {
        for (int i = 0; i < list3.length; i++) {
          if (!(list3[i].compareTo(expectedList[i]) == 0)) {
            System.out.println('[' + list3[i].toString() + ']' + " should equal " + '['
                + expectedList[i].toString() + ']' + FAIL);

            return;
          }
        }

        System.out.println("All Voters successfully have been read from " + duplicateFileNameTest
            + " and matched expectedVoters" + PASS);
      } else if (expectedValid) {
        System.out.println("voters length (" + list3.length + ") and expectedVoters length ("
            + expectedList.length + ") are not equal" + FAIL);
      } else if (!expectedValid) {
        System.out
            .println(duplicateFileNameTest + " did not throw any exception and should have" + FAIL);
      }

    } catch (Exception e) {
      if (expectedValid) {
        System.out
            .println("Data was supposed to be valid, but throwed " + e.getClass().getName() + FAIL);
        e.getStackTrace();

        return;
      }

      if (e.getClass().equals(expectedException)) {
        System.out.println(e.getClass().toString() + " was successfully catched" + PASS);

        return;
      }

      System.out.println("The expected error was '" + expectedException.toString() + "' but '"
          + e.getClass().toString() + "' was thrown" + FAIL);
    }


  }

  // comparator, part 5
  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void sortTest(Comparable[] list, Comparator sortOrder, boolean expectedResult) {

  }


}// end of test class
 // -------------------------------------------------------------------------------------------
