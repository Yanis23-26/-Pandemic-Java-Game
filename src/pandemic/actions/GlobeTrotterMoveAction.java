package pandemic.actions;

import java.util.List;
import java.util.Scanner;

import pandemic.Board.City;
import pandemic.Roles.Player;

public class GlobeTrotterMoveAction implements Action {

    /**
     * @param p the player, pour le joueur
     * return true si l'action est possible false sinon
     */
    @Override
    public boolean isPossible(Player p) {
        System.out.println("Voici les villes disponibles : ");
        displayCities(p.getGame().getWorld().getAllCities()); // affiche toutes les villes
        City destination = p.getGame().getWorld().getAllCities().get(getChoice()-1); // pour récuperer le choix du joueur
        if (destination == null) {
            System.out.println("Le joueur n'a pas pu se déplacer.");
            return false;
        }
        return true;
    }
    
    
    /**
     * Déplace le joueur vers la ville de destination choisie.
     * 
     * @param player
     */
    @Override
    public void actOn(Player p) {
        City currentCity = p.getCity();
        int choice=this.getChoice();
        while(choice<1 || choice> p.getGame().getWorld().getAllCities().size()) {
			System.out.println("Désolé vous ne pouvez pas aller vers cette ville");
			choice=this.getChoice();
		}
        City destination =p.getGame().getWorld().getAllCities().get(choice-1); 
		p.setCity(destination);
		destination.addPlayer(p);
		//Affichage 
		System.out.println("The player : " + p.getName() + " moved from " + currentCity.getName()+ " to "  + destination.getName() +"\n");

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
     * Elle affiche dans le terminal les villes disponibles.
     * 
     * @param list
     *            de neighbors
     */
    private void displayCities(List<City> cities) {
        int idx = 1;
        for (City c : cities) {
            System.out.println(idx + "- " + c.getName());
            idx++;
        }
    }

}
