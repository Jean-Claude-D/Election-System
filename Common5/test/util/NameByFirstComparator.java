package util;

import java.util.Comparator;
import lib.Name;

class NameByFirstComparator implements Comparator<Name> {

  public int compare(Name n1, Name n2) {
    if ((n1 == null) || (n2 == null)) {
      throw new IllegalArgumentException("Object Name is Null");
    }
    int check = n1.getLastName().compareToIgnoreCase(n2.getLastName());

    if (check != 0) {
      return check;
    }
    return n1.getFirstName().compareToIgnoreCase(n2.getFirstName());
  }
}
