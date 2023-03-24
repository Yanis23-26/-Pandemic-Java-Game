package pandemic.action;

import java.util.List;
import java.util.Scanner;

import pandemic.City;
import pandemic.Player;

public class MoveAction implements Action {

	
	
	
	/**
	 * deplacement du joueur apres choisir ca ville voisine 
	 * @param player 
	 */
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
    
	
	/**
	 * return the number of the choice of the player 
	 */
	private int getChoice() {
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		return choice;
	}
    
	
	
	/**
	 *  elle affiche dans le terminal les ville a choisir 
	 * @param list de neighbors 
	 */
	private void displayNeighbors(List<City> neighbors) {
		System.out.println("veuillez choisir la city ou aller selen le chiffre");
		int idx = 1;
		for(City n :neighbors ) {
			System.out.println(idx+"-" + n.getName());
			idx++;
		}
	}
    
	
	
	/**
	 *  return true si laction est possible 
	 *  false sinon 
	 */
	@Override
	public boolean isPossible(Player p) {
		
		return true;
	}

}
