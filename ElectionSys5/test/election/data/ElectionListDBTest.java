package election.data;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import election.data.interfaces.ListPersistenceObject;
import util.ListUtilities;

/**
 * 
 * @author DesJC
 *
 */
public class ElectionListDBTest {

  private ElectionListDBTest() {}

  public static void main(String[] args) {
    testToString();
  }

  public static void testToString() {
    setup();

    ListPersistenceObject file = new SequentialTextFileList(null,
        "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

    ElectionListDB electionDB = new ElectionListDB(file);

    System.out.println(electionDB.toString());
    teardown();
  }

  public static void testToString() {
    setup();

    ListPersistenceObject file = new SequentialTextFileList(null,
        "datafiles/testfiles/testElections.txt", "datafiles/testfiles/testTally.txt");

    ElectionListDB electionDB = new ElectionListDB(file);

    System.out.println(electionDB.toString());
    teardown();
  }

  public static void setup() {
    String[] elecs = new String[2];
    elecs[0] =
        "Presidental race*2020*11*1*2020*11*1***single*2" + "\nDonald Trump" + "\nAnyone Else";
    elecs[1] =
        "Favourite program*2018*5*1*2019*5*31*H4G*H4G*single*2" + "\nGame of Thrones" + "\nNarcos";
    // TODO add more elections if needed, but the must be in sorted order

    String[] tallies = new String[2];
    tallies[0] = "Presidental race*2" + "\n100*0" + "\n0*102";
    tallies[1] = "Favourite program*2" + "\n1000*0" + "\n0*560";

    Path dir;

    // make the testfiles directory
    try {
      dir = Paths.get("datafiles/testfiles");

      if (!Files.exists(dir)) {
        Files.createDirectory(dir);
      }

      ListUtilities.saveListToTextFile(elecs, "datafiles/testfiles/testElections.txt");
      ListUtilities.saveListToTextFile(tallies, "datafiles/testfiles/testTally.txt");
    } catch (InvalidPathException | FileAlreadyExistsException e) {
      System.err.println("could not create testfiles directory " + e.getMessage());
    } catch (IOException e) {
      System.err.println("could not create testfiles in setup() " + e.getMessage());
    }
  }

  public static void teardown() {
    Path file;

    try {
      file = Paths.get("datafiles/testfiles/testVoters.txt");
      Files.deleteIfExists(file);
      file = Paths.get("datafiles/testfiles/testElections.txt");
      Files.deleteIfExists(file);
      file = Paths.get("datafiles/testfiles/testTally.txt");
      Files.deleteIfExists(file);
    } catch (InvalidPathException | IOException e) {
      System.err.println("could not delete test files " + e.getMessage());
    }
  }

}
