package election.data;

import java.io.IOException;
import java.util.List;
import election.business.interfaces.Election;
import election.business.interfaces.ElectionFactory;
import election.data.interfaces.ElectionDAO;
import election.data.interfaces.InexistentElectionException;
import election.data.interfaces.ListPersistenceObject;
import election.data.*;

public class ElectionListDB implements ElectionDAO {


  private List<Election> database;
  private final ListPersistenceObject listPersistenceObject;
  private final ElectionFactory factory;

  public ElectionListDB(ListPersistenceObject listPersistenceObject) {}

  public ElectionListDB (ListPersistenceObject
      listPersistenceObject, ElectionFactory factory)


  @Override
  public void disconnect() throws IOException {


    saveElectionDatabase(database);
    database = null;

  }



}



}
