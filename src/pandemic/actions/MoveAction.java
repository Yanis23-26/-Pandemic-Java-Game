package pandemic.actions;
import pandemic.Roles.*;
import pandemic.Board.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;



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
	/*public int getChoice() {
		System.out.println("veuillez choisir la city ou aller selon le chiffre");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		return choice;
	} */
	public int getChoice() {
	    Scanner scan = new Scanner(System.in);
	    int choice = 0;
	    boolean isValidInput = false;
	    while (!isValidInput) {
	        System.out.println("Veuillez choisir la ville où aller en entrant le chiffre correspondant :");
	        if (scan.hasNextInt()) {
	            choice = scan.nextInt();
	            isValidInput = true;
	        } else {
	            System.out.println("Désolé, votre choix doit être un entier. Veuillez réessayer.");
	            scan.next(); // consomme la ligne invalide pour éviter une boucle infinie
	        }
	    }
	    return choice;
	}


	/**
	 * deplacement du joueur apres choisir ca ville voisine 
	 * @param player 
	 */
	@Override
	public void actOn(Player p) {
		City currentCity = p.getCity();
		if(p instanceof Doctor) {
			Map<Disease, Integer> diseases = currentCity.getDiseases();
			List<Disease> diseasesWhithCubes = new ArrayList<Disease>();
			for(Entry<Disease, Integer> entry : diseases.entrySet()) {
				if(entry.getValue() >0) {
					diseasesWhithCubes.add(entry.getKey());
				}
			} 
				for(Disease d : diseasesWhithCubes) {
					if(d.hasAntiDote()) {
					try {
						currentCity.removeInfection(d);
						p.getGame().IncreaseNbOfCubes();
						System.out.println("The doctor : " + p.getName() + " has removed all cubes of "+d.getName()+"\n");
					} catch (CityException e) {
						e.printStackTrace();
					}

				}
				if(d.getNbCubes()==24) {
					// eradiquer la maladie
					System.out.println(""+d.getName()+" est eradiquée \n");
				}
			//Affichage
				}
			

		}
		List <City> neighbors = currentCity.getNeighborsCities();
		displayNeighbors(neighbors);
		int choice=this.getChoice();
		while(choice<1 || choice>neighbors.size()) {
			System.out.println("Désolé vous ne pouvez pas aller vers cette ville");
			choice=this.getChoice();
		}
        City destination =neighbors.get(choice-1); 
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
