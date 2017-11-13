package util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


// skeleton provides the imports, plus methods saveListToTextFile and the Comparator sort overload

public class ListUtilities {
  private static final Charset CHARACTER_ENCODING = StandardCharsets.UTF_8;

  // TODO constructor here
  /**
   * @author Felicia Gorgatchov
   */
  private ListUtilities() {

  }


  /**
   * Takes a List and search for the element that matched the key
   * 
   * @param database which is the List that will be searched.
   * @param key the element that the method looks for in the List.
   * @return an int. -1 if there is no match. Otherwise the index position of the List that matched
   *         the key
   */
  public static <T extends Comparable<? super T>> int binarySearch(List<T> database, T key) {
    if (database.size() == 0) {
      return -1;
    }

    int mid = database.size() / 2;

    if (database.get(mid).compareTo(key) == 0) {
      return mid;
    }

    if (database.get(mid).compareTo(key) > 0) {

      List<T> cutHalf = database.subList(0, mid);
      return binarySearch(cutHalf, key);
    } else {
      List<T> cutHalf = database.subList(mid + 1, database.size());
      return binarySearch(cutHalf, key);
    }
  }



  /**
   * Takes in a list of objects and writes them to a given file. This method overwrites data in file
   * and uses UTF8 character set.
   * 
   * @param objects Array of items to be written to file.
   * @param filename filename and location of the file where list of items will be written.
   * @throws IOException if an I/O error occurs writing to or creating the file
   */
  public static void saveListToTextFile(Object[] objects, String filename) throws IOException {
    saveListToTextFile(objects, filename, false, CHARACTER_ENCODING);
  }

  /**
   * Takes in a list of objects and writes them to a given file. This method uses UTF8 character
   * set.
   * 
   * @param objects Array of items to be written to file.
   * @param filename filename and location of the file where list of items will be written.
   * @param append boolean indicating if the file is overwritten or if the items are written to the
   *        end of the file.
   * @throws IOException if an I/O error occurs writing to or creating the file
   */
  public static void saveListToTextFile(Object[] objects, String filename, boolean append)
      throws IOException {
    saveListToTextFile(objects, filename, append, CHARACTER_ENCODING);
  }

  /**
   * Takes in a list of objects and writes them to a given file.
   * 
   * @param objects Array of items to be written to file.
   * @param filename filename and location of the file where list of items will be written.
   * @param append boolean indicating if the file is overwritten or if the items are written to the
   *        end of the file.
   * @param characterEncoding the Charset to be used when encoding
   * @throws IOException if an I/O error occurs writing to or creating the file
   */
  public static void saveListToTextFile(Object[] objects, String filename, boolean append,
      Charset characterEncoding) throws IOException {

    Path path = Paths.get(filename);
    OpenOption option;
    if (append) {
      option = StandardOpenOption.APPEND;
    } else {
      option = StandardOpenOption.CREATE;
    }

    // create list of strings
    List<String> toWrite = new ArrayList<String>();
    for (Object obj : objects) {
      if (obj != null) {
        toWrite.add(obj.toString());
      }
    }
    // write list to file
    Files.write(path, toWrite, characterEncoding, StandardOpenOption.WRITE, option);
  }

  /**
   * sorts a List of objects in ascending natural order using selection sort precondition: assumes
   * that the List is not null and that the List's capacity is equal to the List's size
   * 
   * @author Felicia Gorgatchov
   * 
   * @param list a list of objects. assumes that the list's capacity is equal to the list's size
   * @throws IllegalArgumentException if the parameter is not full to capacity
   * @throws NullPointerException if the list is null
   */



  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void sort(Comparable[] list) throws IllegalArgumentException, NullPointerException {
    if (list == null) {
      throw new NullPointerException("Cannot sort null array");
    }
    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        throw new IllegalArgumentException("Cannot sort. Array not full to capacity.");
      }
    }

    for (int i = 0; i < list.length; i++) {
      int min = i;
      for (int j = i + 1; j < list.length; j++) {
        if (list[j].compareTo(list[min]) < 0) {
          min = j;
        }
      }
      Comparable temp = list[min];
      list[min] = list[i];
      list[i] = temp;

    }
  }

  /**
   * Sorts a list of objects in the given order.
   *
   * Precondition: Assumes that the list is not null and that the list's capacity is equal to the
   * list's size.
   *
   * @author Cao Hoang Nguyen
   *
   * @param list A list of objects. Assumes that the list's capacity is equal to the list's size.
   * @param sortOrder A Comparator object that defines the sort order
   *
   * @throws IllegalArgumentException if the parameter is \* not full to capacity.
   *
   * @throws NullPointerException if the list or sortOrder \* are null.
   */

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void sort(Comparable[] list, Comparator sortOrder)
      throws IllegalArgumentException, NullPointerException {
    if (list == null) {
      throw new NullPointerException("Cannot sort null array");
    }

    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        throw new IllegalArgumentException("Your Array Is Not Filled To Capacity");
      }
    }
    Arrays.sort(list, sortOrder);
  }

  /**
   * Efficiently merges two sorted lists of objects in ascending natural order. If the duplicate
   * objects are in both lists, the object from list1 is merged into the resulting list, and both
   * objects are written to the duplicate file.
   *
   * Precondition: Assumes that the lists are not null and that both lists contain objects that can
   * be compared to each other and are filled to capacity.
   *
   * @author Jean-Claude Desrosiers
   *
   * @param list1 A naturally sorted list of objects. Assumes that the list contains no duplicates
   *        and that its capacity is equal to its size.
   * 
   * @param list2 A naturally sorted list of objects. Assumes that the list contains no duplicates
   *        and that its capacity is equal to its size.
   * 
   * @param duplicateFileName The name of the file in datafilesduplicates to which duplicate pairs
   *        will be appended.
   *
   * @throws IllegalArgumentException if either parameter is not full to capacity.
   *
   * @throws NullPointerException if the either list is null.
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static Comparable[] merge(Comparable[] list1, Comparable[] list2, String duplicateFileName)
      throws IOException {

    /*
     * We want the returned array to be of the same base type than the lists passed, in order to
     * cast the result when this method is called, so we instantiate an array with the same base
     * type of list1 by using reflection.
     */
    Comparable[] finalList = (Comparable[]) Array.newInstance(list1.getClass().getComponentType(),
        list1.length + list2.length);

    int iteratFinal = 0;
    int iterat1 = 0;
    int iterat2 = 0;

    while (iterat1 < list1.length && iterat2 < list2.length) {
      int comparison = list1[iterat1].compareTo(list2[iterat2]);

      // If list1 > list2
      if (comparison > 0) {

        finalList[iteratFinal++] = (list2[iterat2++]);

      } else {
        // If list1 == list2
        if (comparison == 0) {
          String[] duplicate = {list1[iterat1].toString() + " (merged)", list2[iterat2].toString()};

          saveListToTextFile(duplicate, duplicateFileName, true, CHARACTER_ENCODING);

          // If we find a duplicate, no need to check list2 in next iteration
          iterat2++;
        }

        // If list1 >= list2, then we add list1 to list3
        finalList[iteratFinal++] = (list1[iterat1++]);

      }
    }

    /*
     * Copy the rest of list1 or list2 into finalList (if either is not already copied into
     * finalList)
     */
    if (iterat1 != list1.length) {
      System.arraycopy(list1, iterat1, finalList, iteratFinal, list1.length - iterat1);
      iteratFinal += (list1.length - iterat1);
    } else if (iterat2 != list2.length) {
      System.arraycopy(list2, iterat2, finalList, iteratFinal, list2.length - iterat2);
      iteratFinal += (list2.length - iterat2);
    }

    Comparable[] trimmed = new Comparable[iteratFinal];

    System.arraycopy(finalList, 0, trimmed, 0, iteratFinal);

    return trimmed;
  }

  /**
   * 
   * This Binary search method uses loops through the array of comparable by starting from the
   * middle index and see if matches with the parameter. If it does not match it returns the point
   * of insertion which is a negative number . The key parameter that we pass matches than it will
   * return the index in which the key is located in the Comparable Array.
   * 
   * @author Maria Hossain
   * @param database parameter is a Comparable ARRAY
   * @param key must be of the comparable object
   * @return middle in negative, which is the point of insertion
   */

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static int binarySearch(Comparable[] database, Comparable key) {

    int low = 0;
    int high = database.length;
    int middle = (low + high) / 2;

    while (high > low) {

      middle = (low + high) / 2;


      if (database[middle].compareTo(key) == 0) {

        return middle;
      }

      if (database[middle].compareTo(key) >= 1) {

        high = middle;
      }

      if (database[middle].compareTo(key) <= -1) {

        low = middle + 1;
      }
    }

    return -(middle);

  }

}

