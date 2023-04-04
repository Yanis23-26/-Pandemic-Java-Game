package pandemic.Cards;
import pandemic.Board.*;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card{
	
	
	
	public void EpidimicCard(City c,Disease d) {
		
		super(c,d);
		
	}
  
	/**
	 * Allows you to manage what happens when the card is drawn
	 */
	public void comportement() {
			// on tire une carte infection 
			// on augmente le taux global d'infection 
			// on melange les cartes d'infections
			this.city.addInfection(disease);
			this.city.infectNeighbors(disease);
			
			
	}


} 
