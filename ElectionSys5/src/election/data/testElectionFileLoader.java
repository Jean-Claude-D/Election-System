package election.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class testElectionFileLoader {

	public static void main(String[] args) throws IOException {


		Path p= Paths.get("ElectionSys5/datafiles/unsorted/voter5.txt");
		List<String> l= Files.readAllLines(p);
		
		for (int i=0; i<l.size(); i++) {
			
			System.out.println(l.get(i));
		}

	}

}
