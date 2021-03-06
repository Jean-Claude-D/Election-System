package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Felicia Gorgatchov
 *
 */
public class Utilities {


  /**
   * this empty do-nothing constructor prevents the Utilities class from being instantiated
   */
  private Utilities() {

  }


  /**
   * converts an object into a byte stream so that this byte stream can later be reverted back into
   * a copy of that object
   * 
   * @param object -- an object of any kind
   * @param fileSpecification -- name of the file where the byte stream will be stored
   * @throws IOException -- when the object cannot be serialized into the specified file
   */
  public static void serializeObject(Object object, String fileSpecification) throws IOException {

    ObjectOutputStream out = null;

    try {
      out = new ObjectOutputStream(new FileOutputStream(fileSpecification));
      out.writeObject(object);

    } catch (IOException e) {
      // normally the exception would be logged to file then thrown
      throw new IOException("Error serializing object to \n" + fileSpecification + " " + e);

    } finally {
      if (out != null) {
        out.close();
      }
    }

  }// end serialize


  /**
   * reads a byte stream from a given file and converts it back into a copy of the original
   * serialized object
   * 
   * @param fileSpecification -- name of the file in which the bytestream we need is stored
   * @return object -- a copy of the original object that was previously serialized
   * @throws IOException -- when the bytestream could not be read from the specified file orthe file
   *         was not found
   * @throws ClassNotFoundException -- when the bytestream could not be read from the specified file
   *         or the file was not found
   */
  public static Object deserializeObject(String fileSpecification)
      throws IOException, ClassNotFoundException {

    ObjectInputStream in = null;

    try {
      Object obj = null;
      in = new ObjectInputStream(new FileInputStream(fileSpecification));
      if (in != null) {
        obj = in.readObject();
      }
      return obj;

    } catch (ClassNotFoundException | IOException e) {
      // normally the exception would be logged to file then thrown
      throw new IOException("Error deserializing object from " + fileSpecification + "\n" + e);

    } finally {
      if (in != null) {
        in.close();
      }
    }


  }// end deserialize



}// end Util class
