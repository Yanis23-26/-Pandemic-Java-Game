package pandemic.actions;
import pandemic.Roles.*;
import pandemic.Board.*;

import java.util.List;
import java.util.Scanner;



public class MoveAction implements Action {
	
	
	private int choice=0;
	
	/**
	 *@param p  
	 *  return true si laction est possible 
	 *  false sinon 
	 */
	@Override
	public boolean isPossible(Player p) {
		City currentCity = p.getCity();
		List<City> neighbors = currentCity.getNeighborsCities();
		displayNeighbors(neighbors);
		City destination = neighbors.get(getChoice()-1);
		actOn(p);
		if (!neighbors.contains(destination)) {
			System.out.println("The player could not move \n !");
			return false;
		}
		return true;

}
	
	/**
	 * return the number of the choice of the player 
	 */
	public int getChoice() {
		System.out.println("veuillez choisir la city ou aller selon le chiffre");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		return choice;
	} 


	/**
	 * deplacement du joueur apres choisir ca ville voisine 
	 * @param player 
	 */
	@Override
	public void actOn(Player p) {
		City currentCity = p.getCity();
		List <City> neighbors = currentCity.getNeighborsCities();
		displayNeighbors(neighbors);
		int choice=this.getChoice()-1;
        City destination =neighbors.get(choice); 
		p.setCity(destination);
		destination.addPlayer(p);
		//Affichage 
		System.out.println("The player : " + p.getName() + " moved from " + currentCity.getName()+ " to "  + destination.getName() +"\n");

	}
    
	

    
	
	
	/**
	 *  elle affiche dans le terminal les ville a choisir 
	 * @param list de neighbors 
	 */
	private void displayNeighbors(List<City> neighbors) {
		int idx = 1;
		for(City n :neighbors ) {
			System.out.println(idx+"-" + n.getName());
			idx++;
		}
	}
     
	
	

}
