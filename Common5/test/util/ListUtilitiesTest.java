package util;

import java.util.Arrays;
import java.util.Comparator;
import lib.Email;
import lib.Name;
import lib.PostalCode;

public class ListUtilitiesTest {

  public static void main(String[] args) {

    // ----- Variables for Jean-Claude -------------------------------------------------------------------------------

    Comparable[] c1 = new Integer[10];
    c1[0] = -936;
    c1[1] = -615;
    c1[2] = -501;
    c1[3] = -268;
    c1[4] = 30;
    c1[5] = 520;
    c1[6] = 568;
    c1[7] = 607;
    c1[8] = 757;
    c1[9] = 778;

    Comparable[] c2 = new Integer[10];
    c2[0] = -640;
    c2[1] = -421;
    c2[2] = -356;
    c2[3] = -213;
    c2[4] = -147;
    c2[5] = 324;
    c2[6] = 383;
    c2[7] = 669;
    c2[8] = 811;
    c2[9] = 893;



    Comparable[] c2Copy = new Integer[c2.length];
    for (int i = 0; i < c2.length; i++) {
      c2Copy[i] = c2[i];
    }

    Comparable[] c3 = new Integer[9];
    c3[0] = -876;
    c3[1] = -404;
    c3[2] = -96;
    c3[3] = 22;
    c3[4] = 338;
    c3[5] = 536;
    c3[6] = 785;
    c3[7] = 790;
    c3[8] = 893;

    Comparable[] ca = new Comparable[20];
    ca[0] = -936;
    ca[1] = -640;
    ca[2] = -615;
    ca[3] = -501;
    ca[4] = -421;
    ca[5] = -356;
    ca[6] = -268;
    ca[7] = -213;
    ca[8] = -147;
    ca[9] = 30;
    ca[10] = 324;
    ca[11] = 383;
    ca[12] = 520;
    ca[13] = 568;
    ca[14] = 607;
    ca[15] = 669;
    ca[16] = 757;
    ca[17] = 778;
    ca[18] = 811;
    ca[19] = 893;

    Comparable[] cb = new Comparable[19];
    cb[0] = -936;
    cb[1] = -876;
    cb[2] = -615;
    cb[3] = -501;
    cb[4] = -404;
    cb[5] = -268;
    cb[6] = -96;
    cb[7] = 22;
    cb[8] = 30;
    cb[9] = 338;
    cb[10] = 520;
    cb[11] = 536;
    cb[12] = 568;
    cb[13] = 607;
    cb[14] = 757;
    cb[15] = 778;
    cb[16] = 785;
    cb[17] = 790;
    cb[18] = 893;

    Comparable[] cc = new Integer[18];
    cc[0] = -876;
    cc[1] = -640;
    cc[2] = -421;
    cc[3] = -404;
    cc[4] = -356;
    cc[5] = -213;
    cc[6] = -147;
    cc[7] = -96;
    cc[8] = 22;
    cc[9] = 324;
    cc[10] = 338;
    cc[11] = 383;
    cc[12] = 536;
    cc[13] = 669;
    cc[14] = 785;
    cc[15] = 790;
    cc[16] = 811;
    cc[17] = 893; // Duplicate

    mergeTest(c1, c2, ca, "datafiles/duplicates/duplicate.txt", true, null);
    mergeTest(c2, c1, ca, "datafiles/duplicates/duplicate.txt", true, null);

    mergeTest(c1, c3, cb, "datafiles/duplicates/duplicate.txt", true, null);
    mergeTest(c3, c1, cb, "datafiles/duplicates/duplicate.txt", true, null);

    mergeTest(c1, c2Copy, ca, "datafiles/duplicates/duplicate.txt", true, null);
    mergeTest(c2Copy, c1, ca, "datafiles/duplicates/duplicate.txt", true, null);

    mergeTest(c2, c3, cc, "datafiles/duplicates/duplicate.txt", true, null);
    mergeTest(c3, c2, cc, "datafiles/duplicates/duplicate.txt", true, null);

    mergeTest(c2, c2Copy, c2, "datafiles/duplicates/duplicate.txt", true, null);
    mergeTest(c2Copy, c2, c2, "datafiles/duplicates/duplicate.txt", true, null);

    mergeTest(c3, c2Copy, cc, "datafiles/duplicates/duplicate.txt", true, null);
    mergeTest(c2Copy, c3, cc, "datafiles/duplicates/duplicate.txt", true, null);



    // ----- Variables for Cao Hoang -------------------------------------------------------------------------------

    Name person1 = new Name("Jean-Claude", "French");
    Name person2 = new Name("Cao Hoang", "Vietnam");
    Name person3 = new Name("Maria", "Morocco");
    Name person4 = new Name("Felicia", "Bulgaria");
    Name person5 = new Name("Our-Team", "Canada");
    Name person6 = new Name("Bob", "French");

    Name[] listNameTest = new Name[] {person1, person2, person3, person4, person5, person6};

    Name[] listNameCheck = new Name[] {person4, person5, person6, person1, person3, person2};


    System.out.print("Testing sort with comparator :  ");
    sortTest(listNameTest, new NameByFirstComparator(), listNameCheck, true);

    // ----- Variables for Felicia ----------------------------------------------------------------------------------

    boolean expectInvalid = false;
    boolean expectValid = true;

    Comparable[] predictException = new Comparable[10];

    Name fel = new Name("Felicia", "Gorgatchov");
    Name ivo = new Name("Ivaylo", "Gorgatchov");
    Name jc = new Name("Jean-Claude", "Desrosiers");
    Name maria = new Name("Maria", "Hossain");
    Name hoang = new Name("Cao Hoang", "Nguyen");
    Name[] nameSortTestGood1 = {maria, ivo, hoang, jc, fel};
    Name[] nameSortTestGood2 = {hoang, fel, maria, jc, ivo};
    Name[] nameSortTestNotFull = {fel, null, jc, null};
    Name[] nameSortTestNull = {null, null, null, null};

    Name[] namePrediction = {jc, fel, ivo, maria, hoang};

    PostalCode pc1 = new PostalCode("J4X 2G3");
    PostalCode pc2 = new PostalCode("H3H1M6");
    PostalCode pc3 = new PostalCode("H3H 5B2");
    PostalCode pc4 = new PostalCode("X0B1K0");
    PostalCode pc5 = new PostalCode("V5K 0A4");
    PostalCode[] pcSortTestGood = {pc4, pc3, pc5, pc2, pc1};
    PostalCode[] pcSortTestGood2 = {pc4, pc2, pc3, pc5, pc1};
    PostalCode[] pcSortTestNotFull = {pc3, null, pc1, null};
    PostalCode[] pcSortTestNull = {null, null, null, null, null};

    PostalCode[] postalCodePrediction = {pc2, pc3, pc1, pc5, pc4};

    Email email1 = new Email("felicia.gorgatchov@gmail.com");
    Email email2 = new Email("rick_C-137@ricksanchez.com");
    Email email3 = new Email("mclovin81@memes.fr");
    Email email4 = new Email("12zebulon34@bruh.uk");
    Email email5 = new Email("78hola@mexico.mx");
    Email email6 = new Email("42@whatislife.com");
    Email email7 = new Email("zebulon@somehostID.ca");

    Email[] emailSortTestGood = {email1, email2, email3, email4, email5, email6, email7};
    Email[] emailSortTestGood2 = {email3, email5, email1, email7, email2, email6};
    Email[] emailSortTestGood3 = {email1, email2, email3, email7};
    Email[] emailSortTestGood4 = {email4, email5, email6};
    Email[] emailSortTestNotFull = {email1, email5, email4, email7, email2, null, email3};
    Email[] emailSortTestNull = {null, null, null, null, null};

    Email[] emailPrediction = {email4, email1, email3, email5, email2, email7, email6};
    Email[] emailPrediction2 = {email1, email3, email5, email2, email7, email6};
    Email[] emailPrediction3 = {email1, email3, email2, email7};
    Email[] emailPrediction4 = {email4, email5, email6};

    System.out.println(
        "\n-----NAME--------------------------------------------------------------------------------------------------");
    sortTest(nameSortTestGood1, namePrediction, expectValid);
    sortTest(nameSortTestGood2, namePrediction, expectValid);
    sortTest(nameSortTestNotFull, predictException, expectInvalid);
    sortTest(nameSortTestNull, predictException, expectInvalid);

    System.out.println(
        "\n-----POSTALCODE--------------------------------------------------------------------------------------------");
    sortTest(pcSortTestGood, postalCodePrediction, expectValid);
    sortTest(pcSortTestGood2, postalCodePrediction, expectValid);
    sortTest(pcSortTestNotFull, predictException, expectInvalid);
    sortTest(pcSortTestNull, predictException, expectInvalid);

    System.out.println(
        "\n-----EMAIL-------------------------------------------------------------------------------------------------");
    sortTest(emailSortTestGood, emailPrediction, expectValid);
    sortTest(emailSortTestGood2, emailPrediction2, expectValid);
    sortTest(emailSortTestGood3, emailPrediction3, expectValid);
    sortTest(emailSortTestGood4, emailPrediction4, expectValid);
    sortTest(emailSortTestNotFull, predictException, expectInvalid);
    sortTest(emailSortTestNull, predictException, expectInvalid);



  }// end main ----------------------------------------------------------------------------------------------

  // TEST METHODS -------------------------------------------------------------------------------------------
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  private static void sortTest(Comparable[] list, Comparable[] prediction, boolean expectedResult) {
    String uglyClassName = list.getClass().getName();
    String className = list.getClass().getName().substring(uglyClassName.lastIndexOf('.') + 1,
        uglyClassName.indexOf(";"));
    System.out.println("\nSELECTION SORT TEST ON -- " + className);

    try {
      System.out.println("\n\tPassing: " + Arrays.toString(list));
      System.out.println("\n\tExpected Result: " + Arrays.toString(prediction));
      ListUtilities.sort(list);
      for (int i = 0; i < list.length; i++) {
        if (list[i] == prediction[i]) {
        } else {
          System.out.println("\n\tResult: " + Arrays.toString(list));
          System.out.println("\n\t ==== FAILED TEST ===");
          return;
        }
      }
      System.out.println("\n\tResult: " + Arrays.toString(list));
      System.out.println("\n\t ==== PASSED TEST ===");

    } catch (IllegalArgumentException iae) {
      if (expectedResult == true) {
        System.out.println("\n\tResult: " + iae);
        System.out.println("\n\t ==== TEST FAILED exception thrown when data is valid ==== ");
      } else {
        System.out.println("\n\tResult: " + iae);
        System.out.println("\n\t ==== PASSED TEST exception caught successfully ==== ");
      }

    } catch (NullPointerException npe) {
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
    if (expectedList != null) {
      System.out.println('[');
      for (Comparable c : expectedList) {
        System.out.println(c == null ? "null" : c);
      }
      System.out.println(']');
    } else {
      System.out.println("null");
    }

    System.out.println(expectedValid ? "Expected to be valid" : "Should not be valid");

    System.out.println(expectedException == null ? "No exception expected"
        : expectedException.getName() + " expected");

    try {

      Comparable[] list3 = ListUtilities.merge(list1, list2, duplicateFileNameTest);

      for (int i = 0; i < list3.length; i++)
        System.out.println("at [" + i + "] :" + list3[i].toString());

      if (list3.length == expectedList.length && expectedValid) {
        for (int i = 0; i < list3.length; i++) {
          if (!(list3[i].compareTo(expectedList[i]) == 0)) {
            System.out.println('[' + list3[i].toString() + ']' + " should equal " + '['
                + expectedList[i].toString() + ']' + FAIL);

            return;
          }
        }


        System.out.println(PASS);

      } else if (expectedValid) {
        System.out.println("list3 length (" + list3.length + ") and expectedList length ("
            + expectedList.length + ") are not equal" + FAIL);
      } else if (!expectedValid) {
        System.out
            .println(duplicateFileNameTest + " did not throw any exception and should have" + FAIL);
      }

    } catch (Exception e) {
      if (expectedValid) {
        System.out
            .println("Data was supposed to be valid, but throwed " + e.getClass().getName() + FAIL);
        e.printStackTrace();

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


}

