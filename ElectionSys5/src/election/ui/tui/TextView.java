package election.ui.tui;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import election.business.interfaces.Election;
import election.business.interfaces.Voter;

public class TextView implements Observer {

  public TextView(Observable model) {
    model.addObserver(this);
  }

  public void voterInfo(Voter v) {

    System.out.println("\nVoter information\n");

    System.out
        .println("Name:" + "\t\t" + v.getName().getFirstName() + " " + v.getName().getLastName());

    System.out.println("Email:" + "\t\t" + v.getEmail());

    System.out.println("Postal code:" + "\t\t" + v.getPostalCode());
  }

  public void electionInfo(Election e) {


    System.out.println("\nElection information\n");

    System.out.println("Name:" + "\t\t" + e.getName());

    System.out.println("Start Date:" + "\t\t" + e.getStartDate());

    System.out.println("End Date:" + "\t\t" + e.getEndDate());
  }

  public void winnerInfo(List<String> w) {


    if (w.isEmpty()) {
      System.out.println("We have no winner yet.");
    } else {
      System.out.println("The winner is:" + "\t\t" + w.toString());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public void update(Observable model, Object object) {
    if (object instanceof Voter) {
      voterInfo((Voter) object);
    } else if (object instanceof Election) {
      electionInfo((Election) object);
    } else if (object instanceof List<?>) {
      winnerInfo((List<String>) object);
    }
  }
}
