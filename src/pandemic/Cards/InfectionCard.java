package pandemic.Cards;
import pandemic.Board.*;

import pandemic.Roles.*;

public class InfectionCard extends Card{
    
 
    	/**
    	 * Make an infection card with a city and a virus
    	 * @param c the city associated with the card
    	 * @param disease the virus associated with the card
    	 */
    	public InfectionCard(City c,Disease d ){
    		super(c,d);
    	}
    	
    	/**
    	 * Allows you to manage what happens when the card is drawn :
    	 * it's give a virus's cube on the city associated with the card 
    	 */
    	public void comportement(Player p) {
    		this.city.addInfection(this.disease);
    	}
    	

} 