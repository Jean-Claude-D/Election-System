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
  private ListUtilities() {

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
    Arrays.sort(list, sortOrder);
  }

  /*
   * Efficiently merges two sorted lists of objects in ascending natural order. If the duplicate
   * objects are in both lists, the object from list1 is merged into the resulting list, and both
   * objects are written to the duplicate file.
   *
   * Precondition: Assumes that the lists are not null and that both lists contain objects that can
   * be compared to each other and are filled to capacity.
   *
   *
   * @param list1 A naturally sorted list of objects. Assumes that the list contains no duplicates
   * and that its capacity is equal to its size.
   * 
   * @param list2 A naturally sorted list of objects. Assumes that the list contains no duplicates
   * and that its capacity is equal to its size.
   * 
   * @param duplicateFileName The name of the file in datafilesduplicates to which duplicate pairs
   * will be appended.
   *
   * @throws IllegalArgumentException if either parameter is not full to capacity.
   *
   * @throws NullPointerException if the either list is null.
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static Comparable[] merge(Comparable[] list1, Comparable[] list2, String duplicateFileName)
      throws IOException {

    // To use resizeable feature of ArrayList (the .trimToSize() used at the end)
    List<Comparable> list3 = new ArrayList<Comparable>(list1.length + list2.length);

    for (int iterat1 = 0, iterat2 = 0; (iterat1 < list1.length) || (iterat2 < list2.length);) {
      int comparison = list1[iterat1].compareTo(list2[iterat2]);

      if (comparison > 0) { // If list1 > list2
        list3.add(list2[iterat2++]);
      } else {
        if (comparison == 0) { // If list1 == list2
          String[] duplicate = {list1[iterat1].toString() + " (merged)", list2[iterat2].toString()};

          saveListToTextFile(duplicate, duplicateFileName, true, CHARACTER_ENCODING);

          iterat2++; // If we find a duplicate, no need to check list2 in next iteration
        }

        // If list1 >= list2, then we add list1 to list3
        list3.add(list1[iterat1++]);

      }

      if (iterat1 == list1.length && iterat2 != list2.length) {

      } else if (iterat1 != list1.length && iterat2 == list2.length) {

      }

    }

    ((ArrayList) list3).trimToSize();

    /*
     * Because Comparable is an interface, we cannot instantiate an array of it, so we instantiate
     * an array with the same base type of list1 by using reflection
     */
    Comparable[] resultList = list3.toArray(
        (Comparable[]) Array.newInstance(list1.getClass().getComponentType(), list3.size()));


    return resultList;
  }

}

