package pandemic.action;

import java.util.List;
import java.util.Scanner;

import pandemic.City;
import pandemic.Player;

public class MoveAction implements Action {

	@Override
	public void actOn(Player p) {
		City currentCity = p.getCity();
		List <City> neighbors = currentCity.getNeighborsCities();
		displayNeighbors(neighbors);
		int choice = getChoice();
		City destination =neighbors.get(choice-1); 
		p.setCity(destination);
		destination.addPlayer(p);

	}

	private int getChoice() {
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		return choice;
	}

	private void displayNeighbors(List<City> neighbors) {
		System.out.println("veuillez choisir la city ou aller selen le chiffre");
		int idx = 1;
		for(City n :neighbors ) {
			System.out.println(idx+"-" + n.getName());
			idx++;
		}
	}

	@Override
	public boolean isPossible(Player p) {
		
		return true;
	}

}
