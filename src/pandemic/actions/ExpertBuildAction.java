package pandemic.actions;

import pandemic.Roles.Player;

/*Comme indiqué sur le sujet, l'expert n'a pas besoin de carte pour construire une station de recherche*/
public class ExpertBuildAction implements Action {
	
	
	// l'expert n'a pas besoin de condition particulières pour construire une station de recherche, par contre leur nombre est limité.
	@Override
	public boolean isPossible(Player p) {
		if((p.getGame().getactualNbOfStations()==6) && (p.getCity().hasResearchStation()) ) {
			return false;
		}
		return true;
	}


	@Override
	public void actOn(Player p) {
		// TODO Auto-generated method stub
		if(isPossible(p)) {
			p.getCity().addResearchStation();
			//Affichage 
			System.out.println("The Expert '" + p.getName() + "' has créated a research station in " + p.getCity()+ "!");
		}
		else {
			System.out.println(" Impossible to build a research station, the conditions are not met !!!");
		}
		
	}

	
}
