package pandemic;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		World w = new World();
		System.out.println(w.getSectors());
	}

}
