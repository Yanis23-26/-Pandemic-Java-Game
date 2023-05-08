package pandemic.actions;

import java.util.*;
import java.util.Map.Entry;

import pandemic.Board.*;
import pandemic.Cards.*;
import pandemic.Roles.*;

public class DoctorTreatDiseaseAction implements Action {
	/**
	 * return the number of the choice of the player 
	 */
	public int getChoice() {
		System.out.println("veuillez choisir la maladie selon le chiffre");
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
		Map<Disease, Integer> diseases = currentCity.getDiseases();
		List<Disease> diseasesWhithCubes = new ArrayList<Disease>();
		for(Entry<Disease, Integer> entry : diseases.entrySet()) {
			if(entry.getValue() >0) {
				diseasesWhithCubes.add(entry.getKey());
			}
		}

		displayDiseases(diseasesWhithCubes);
		int choice=this.getChoice();
		while(choice<1 || choice>diseasesWhithCubes.size()) {
			System.out.println("Désolé vous ne pouvez pas choisir cette maladie");
			choice=this.getChoice();
		}
        Disease chosenDisease =diseasesWhithCubes.get(choice-1); 
			for(int i=0; i<diseases.get(chosenDisease); i++) {
				try {
					currentCity.removeInfection(chosenDisease);
					p.getGame().IncreaseNbOfCubes();
					System.out.println("The player : " + p.getName() + " has removed all cubes of "+chosenDisease.getName()+"\n");
				} catch (CityException e) {
					e.printStackTrace();
				}

			}
			if(chosenDisease.getNbCubes()==24) {
				// eradiquer la maladie
				System.out.println(""+chosenDisease.getName()+" est eradiquée \n");
			}
		//Affichage 
		

	}
    
	

    
	
	
	/**
	 *  elle affiche dans le terminal les ville a choisir 
	 * @param list de neighbors 
	 */
	private void displayDiseases(List<Disease> diseases) {
		int idx = 1;
		for(Disease n :diseases ) {
			System.out.println(idx+"-" + n.getName());
			idx++;
		}
	}

	@Override
	public boolean isPossible(Player p) {
		City currentCity = p.getCity();
		Map<Disease, Integer> diseases = currentCity.getDiseases();
		List<Disease> diseasesWhithCubes = new ArrayList<Disease>();
		for(Entry<Disease, Integer> entry : diseases.entrySet()) {
			if(entry.getValue() >0) {
				diseasesWhithCubes.add(entry.getKey());
			}
		}
		if(diseasesWhithCubes.size()>0) {
			return true;
		}
		else {
			return false;
		}
	}
}
