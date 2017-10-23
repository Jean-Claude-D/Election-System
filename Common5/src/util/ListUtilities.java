package util;

import java.io.IOException;
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

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void sort(Comparable[] list, Comparator sortOrder)
      throws IllegalArgumentException, NullPointerException {
    if (list == null) {
      throw new NullPointerException("Cannot sort null array");
    }
    Arrays.sort(list, sortOrder);

  }
}


