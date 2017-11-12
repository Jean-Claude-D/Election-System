package election.data;

import java.io.IOException;
import java.util.List;
import election.business.DawsonElectionFactory;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.InexistentElectionException;
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
  public Election getElection(String name) throws InexistentElectionException {

    String type = null;
    int startYear = 0;
    int startMonth = 0;
    int startDay = 0;
    int endYear = 0;
    int endMonth = 0;
    int endDay = 0;
    String startRange = null;
    String endRange = null;
    String choice = null;

    Election dummy = DawsonElectionFactory.DAWSON_ELECTION.getElectionInstance(name, type,
        startYear, startMonth, startDay, endYear, endMonth, endDay, startRange, endRange, choice);


    int index = ListUtilities.binarySearch(database, dummy);

    if (index == -1) {

      throw new InexistentElectionException("This election does not exist.");

    }


    return database.get(index);

  }



}


