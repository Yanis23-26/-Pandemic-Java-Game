package pandemic.actions;

import java.util.List;
import java.util.Scanner;

import pandemic.Board.City;
import pandemic.Roles.Player;

public class GlobeTrotterMoveAction implements Action {
	
	
	
	
	/**
	 *@param p  
	 *  return true si laction est possible 
	 *  false sinon 
	 */
	@Override
	public boolean isPossible(Player p) {
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
		List <City> allCities = p.getGame().getWorld().getAllCities();
		displayAllCities(allCities);
		int choice=this.getChoice();
		while(choice<1 || choice>allCities.size()) {
			System.out.println("Désolé vous ne pouvez pas aller vers cette ville");
			choice=this.getChoice();
		}
        City destination =allCities.get(choice-1); 
		p.setCity(destination);
		destination.addPlayer(p);
		//Affichage 
		System.out.println("The player : " + p.getName() + " moved from " + currentCity.getName()+ " to "  + destination.getName() +"\n");

	}
    
	

    
	
	
	/**
	 *  elle affiche dans le terminal les ville a choisir 
	 * @param list de neighbors 
	 */
	private void displayAllCities(List<City> allCities) {
		int idx = 1;
		for(City n :allCities ) {
			System.out.println(idx+"-" + n.getName());
			idx++;
		}
	}
}
