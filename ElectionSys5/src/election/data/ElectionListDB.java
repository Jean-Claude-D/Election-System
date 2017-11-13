package election.data;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import election.business.DawsonElectionFactory;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.ListPersistenceObject;
import util.ListUtilities;

public class ElectionListDB implements ElectionDAO {


  private List<Election> database;
  private final ListPersistenceObject listPersistenceObject;
  private final ElectionFactory factory;

  public ElectionListDB(ListPersistenceObject listPersistenceObject) {}

  public ElectionListDB(ListPersistenceObject listPersistenceObject, ElectionFactory factory) {}


  @Override
  public void disconnect() throws IOException {


    listPersistenceObject.saveElectionDatabase(database);
    database = null;

  }

  @Override
  public Election getElection(String name) /* throws InexistentElectionException */ {


    String type = "SINGLE";
    int startYear = LocalDateTime.now().getYear();
    int startMonth = LocalDateTime.now().getMonthValue();
    int startDay = LocalDateTime.now().getDayOfMonth();
    int endYear = LocalDateTime.now().getYear() + 1;
    int endMonth = LocalDateTime.now().getMonthValue();
    int endDay = LocalDateTime.now().getDayOfMonth();
    String startRange = null;
    String endRange = null;
    String choice = "A";
    String choice2 = "B";

    Election dummy =
        DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name, type, startYear, startMonth,
            startDay, endYear, endMonth, endDay, startRange, endRange, choice, choice2);


    int index = ListUtilities.binarySearch(database, dummy);

    if (index == -1) {

      throw new IllegalArgumentException(
          "This election does not exist."); /* jjjjjjjjjjjjjjjjjjjjjjjj */

    }


    return database.get(index);

  }



}


