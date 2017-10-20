package election.business;

import java.time.LocalDate;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;
import lib.Email;
import lib.Name;
import lib.PostalCode;

public class DawsonVoterTest {

  private final String PASS =
      "==================================================================================TEST PASSED\n";
  private final String FAIL =
      "-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_TEST FAILED\n";

  private String[] validFName;
  private String[] validLName;
  private String[] validEmail;
  private String[] validPCode;

  private String[] inValidFName;
  private String[] inValidLName;
  private String[] inValidEmail;
  private String[] inValidPCode;

  private Name[] validNameObj;
  private Email[] validEmailObj;
  private PostalCode[] validPCodeObj;

  private Voter[] validVoter;

  private Object nullObj;
  private Object validObj;

  private String[][][] codeBreaker;


  public DawsonVoterTest(String[] validFName, String[] validLName, String[] validEmail,
      String[] validPCode, String[] inValidFName, String[] inValidLName, String[] inValidEmail,
      String[] inValidPCode) {
    // Verification

    if (validFName == null || validLName == null || validEmail == null || validPCode == null
        || inValidFName == null || inValidLName == null || inValidEmail == null
        || inValidPCode == null) {
      throw new IllegalArgumentException("All arguments must be non-null");
    }

    int length = validFName.length;

    if (inValidLName.length != length || inValidEmail.length != length
        || inValidPCode.length != length || validLName.length != length
        || validEmail.length != length || validPCode.length != length) {
      throw new IllegalArgumentException("Length of arrays of String must be of equal lengths");
    }

    // Instantiate String[]

    this.validFName = new String[validFName.length];
    for (int i = 0; i < this.validFName.length; i++) {
      this.validFName[i] = validFName[i];
    }

    this.validLName = new String[validLName.length];
    for (int i = 0; i < this.validLName.length; i++) {
      this.validLName[i] = validLName[i];
    }

    this.validEmail = new String[validEmail.length];
    for (int i = 0; i < this.validEmail.length; i++) {
      this.validEmail[i] = validEmail[i];
    }

    this.validPCode = new String[validPCode.length];
    for (int i = 0; i < this.validPCode.length; i++) {
      this.validPCode[i] = validPCode[i];
    }

    this.inValidFName = new String[inValidFName.length];
    for (int i = 0; i < this.inValidFName.length; i++) {
      this.inValidFName[i] = inValidFName[i];
    }

    this.inValidLName = new String[inValidLName.length];
    for (int i = 0; i < this.inValidLName.length; i++) {
      this.inValidLName[i] = inValidLName[i];
    }

    this.inValidEmail = new String[inValidEmail.length];
    for (int i = 0; i < this.inValidEmail.length; i++) {
      this.inValidEmail[i] = inValidEmail[i];
    }

    this.inValidPCode = new String[inValidPCode.length];
    for (int i = 0; i < this.inValidPCode.length; i++) {
      this.inValidPCode[i] = inValidPCode[i];
    }

    // Instatiate Name[] and Email[] and PostalCode[]

    this.validNameObj = new Name[this.validFName.length];
    for (int i = 0; i < this.validNameObj.length; i++) {
      this.validNameObj[i] = new Name(this.validFName[i], this.validLName[i]);
    }

    this.validEmailObj = new Email[this.validEmail.length];
    for (int i = 0; i < this.validEmailObj.length; i++) {
      this.validEmailObj[i] = new Email(this.validEmail[i]);
    }

    this.validPCodeObj = new PostalCode[this.validPCode.length];
    for (int i = 0; i < this.validPCodeObj.length; i++) {
      this.validPCodeObj[i] = new PostalCode(this.validPCode[i]);
    }

    // Instantiate Objects

    this.validObj = new Object();
    this.nullObj = null;

    // Instatiate the ultimate code breaker

    String[][] inValidFNameOnly =
        {this.inValidFName, this.validLName, this.validEmail, this.validPCode};
    String[][] inValidLNameOnly =
        {this.validFName, this.inValidLName, this.validEmail, this.validPCode};
    String[][] inValidEmailOnly =
        {this.validFName, this.validLName, this.inValidEmail, this.validPCode};
    String[][] inValidPCodeOnly =
        {this.validFName, this.validLName, this.validEmail, this.inValidPCode};

    this.codeBreaker =
        new String[][][] {inValidFNameOnly, inValidLNameOnly, inValidEmailOnly, inValidPCodeOnly};

  }

  public static void main(String[] args) {
    // 7 voters

    System.out.println(
        "==================================================================================TEST BEGIN\n");
    System.out.println();
    System.out.println();
    System.out.println();

    String[] validFName = {"Jean-Claude", "Fel", "Maria", "Hoang", "Robert", "Joe", "Robin"};
    String[] validLName =
        {"Desrosiers", "Gorgacheva", "Hossein", "Nguyen", "Smith", "Allen", "Hood"};
    String[] validEmail = {"jcdMyEmail@domain.name", "Fel@gmail.qc.com", "Girl@Home.Sweet.Home",
        "Boy@Sweet.Home.Sweet", "regularGuy123@normal.domain.name.biz", "tiny@email",
        "right@middle.target"};
    String[] validPCode =
        {"G7B 1P9", "H1W 0J8", "L4K 2Y6", "P2N 0E3", "H7G 1T3", "G3Z 3T2", "J0L 2J9"};

    String[] inValidFName =
        {"Jean---Claude", "Fe\\%l", "Maria$..", "H0ang", "R*!bert", "J??oe", "Ro#bin"};
    String[] inValidLName =
        {"Des++rosiers", "     ", "H0ssein", "Ngu  yen", "Sm111th", "Al1len", "H8d"};
    String[] inValidEmail = {"jcdMyEmaildomain.name", "Fel@gmail........qc.com", "", "     ",
        ".regularGuy123@normal.domain.name.biz", "t..iny@email", "right.middle.target"};
    String[] inValidPCode =
        {"G7B   1P9", "H1W 0J", "4L2 K46Y", "ZP2N 0E3", "H7G_1T3", "G3Z.3T2", "J000L 2J9"};

    DawsonVoterTest test = new DawsonVoterTest(validFName, validLName, validEmail, validPCode,
        inValidFName, inValidLName, inValidEmail, inValidPCode);

    LocalDate now = LocalDate.now();

    test.Ctor();
    test.getter();
    test.equalsHash();
    test.tostring();
    test.eligible(new DawsonElection("test1", "SINGLE", now.getYear(), now.getMonthValue(),
        now.getDayOfMonth(), 2018, 12, 23, "", "", new StubTally(), "hello", "hi"), true);
    test.eligible(new DawsonElection("test1", "SINGLE", now.getYear(), now.getMonthValue(),
        now.getDayOfMonth(), 2018, 12, 23, "A", "A", new StubTally(), "hello", "hi"), false);
    test.compareto();

    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(
        "==================================================================================TEST END\n");
  }

  private void Ctor() {
    System.out.println("==================== TEST CTOR ====================");
    System.out.println();

    try {
      this.validVoter = new Voter[this.validNameObj.length];
      for (int i = 0; i < this.validVoter.length; i++) {
        this.validVoter[i] = new DawsonVoter(this.validFName[i], this.validLName[i],
            this.validEmail[i], this.validPCode[i]);
        System.out.println(this.validVoter[i]);
        System.out.println();
      }
      System.out.println(PASS);
    } catch (IllegalArgumentException e) {
      System.out.println(FAIL);
    }


    for (int i = 0; i < this.codeBreaker.length; i++) {
      for (int j = 0; j < this.codeBreaker[i][0].length; j++) {
        try {
          DawsonVoter inValidVoter = new DawsonVoter(this.codeBreaker[i][0][j],
              this.codeBreaker[i][1][j], this.codeBreaker[i][2][j], this.codeBreaker[i][3][j]);
          System.out.println(this.codeBreaker[i][0][j] + "*" + this.codeBreaker[i][1][j] + "*"
              + this.codeBreaker[i][2][j] + "*" + this.codeBreaker[i][3][j]);
          System.out.println(FAIL);
        } catch (IllegalArgumentException e) {
          System.out.println(this.codeBreaker[i][0][j] + "*" + this.codeBreaker[i][1][j] + "*"
              + this.codeBreaker[i][2][j] + "*" + this.codeBreaker[i][3][j]);
          System.out.println(PASS);
        }
      }
    }

  }

  private void getter() {

    System.out.println("==================== TEST GETTER ====================");
    System.out.println();
    for (int i = 0; i < this.validVoter.length; i++) {
      if (validVoter[i].getName().equals(this.validNameObj[i])) {
        System.out.println(this.validNameObj[i]);
        System.out.println(PASS);
      } else {
        System.out.println(this.validNameObj[i]);
        System.out.println(FAIL);
      }
    }

    for (int i = 0; i < this.validVoter.length; i++) {
      if (validVoter[i].getEmail().equals(this.validEmailObj[i])) {
        System.out.println(this.validEmailObj[i]);
        System.out.println(PASS);
      } else {
        System.out.println(this.validEmailObj[i]);
        System.out.println(FAIL);
      }
    }

    for (int i = 0; i < this.validVoter.length; i++) {
      if (validVoter[i].getPostalCode().equals(this.validPCodeObj[i])) {
        System.out.println(this.validPCodeObj[i]);
        System.out.println(PASS);
      } else {
        System.out.println(this.validPCodeObj[i]);
        System.out.println(FAIL);
      }
    }
  }

  private void equalsHash() {

    System.out.println("==================== TEST EQUALS & HASH ====================");
    System.out.println();
    DawsonVoter sameVoter;
    for (int i = 0; i < this.validVoter.length; i++) {
      sameVoter = new DawsonVoter(this.validVoter[i].getName().getFirstName(),
          this.validVoter[i].getName().getLastName(), this.validVoter[i].getEmail().toString(),
          this.validVoter[i].getPostalCode().toString());
      if (sameVoter.equals(this.validVoter[i])
          && sameVoter.hashCode() == this.validVoter[i].hashCode()
          && this.validVoter[i].equals(sameVoter) && !this.validVoter[i].equals(nullObj)) {
        System.out.println(sameVoter);
        System.out.println(PASS);
      } else {
        System.out.println(sameVoter);
        System.out.println(FAIL);
      }
    }
  }

  private void tostring() {

    System.out.println("==================== TEST TOSTRING ====================");
    System.out.println();
    for (int i = 0; i < this.validVoter.length; i++) {
      if (this.validVoter[i].toString()
          .equals(this.validVoter[i].getEmail().toString() + '*'
              + this.validVoter[i].getName().getFirstName() + '*'
              + this.validVoter[i].getName().getLastName() + '*'
              + this.validVoter[i].getPostalCode().toString())) {
        System.out.println(this.validVoter[i]);
        System.out.println(PASS);
      } else {
        System.out.println(this.validVoter[i]);
        System.out.println(FAIL);
      }
    }
  }

  private void eligible(Election election, int voterIndex, boolean isValid) {
    System.out.println("==================== TEST ISELIGIBLE ====================");
    System.out.println();
    if (this.validVoter[voterIndex].isEligible(election) == isValid) {
      System.out.println(this.validVoter[voterIndex]);
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println(election);
      System.out.println(PASS);
    } else {
      System.out.println(this.validVoter[voterIndex]);
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println(election);
      System.out.println(FAIL);
    }
  }

  private void eligible(Election election, boolean isValid) {
    for (int i = 0; i < this.validVoter.length; i++) {
      this.eligible(election, i, isValid);
    }
    System.out.println();
    System.out.println();
    System.out.println();
  }

  private void compareto() {

    System.out.println("==================== TEST COMPARETO ====================");
    System.out.println();
    DawsonVoter sameVoter;
    for (int i = 0; i < this.validVoter.length; i++) {
      sameVoter = new DawsonVoter(this.validVoter[i].getName().getFirstName(),
          this.validVoter[i].getName().getLastName(), this.validVoter[i].getEmail().toString(),
          this.validVoter[i].getPostalCode().toString());
      if (this.validVoter[i].compareTo(sameVoter) == 0) {
        System.out.println(sameVoter);
        System.out.println(PASS);
      } else {
        System.out.println(sameVoter);
        System.out.println(FAIL);
      }
    }
  }
}


