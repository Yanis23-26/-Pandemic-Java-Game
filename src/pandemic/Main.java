package pandemic;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		World w = new World();
		System.out.println("");
		for (Sector s : w.getSectors()) {
			System.out.println(s);
			System.out.println(s.getCities());
		}
		System.out.println("");
		for(Sector s : w.getSectors()) {
		System.out.println(s);
		System.out.println("");
			for(City c : s.getCities()) {
				System.out.println(c);
				System.out.println("LES VILLES VOISINES");
				System.out.println(c.getNeighborsCities());
				System.out.println("");
			}
		}
		
	}
}

