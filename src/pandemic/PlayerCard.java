package pandemic;

public class PlayerCard extends Card{

    	/**
    	 * Make a player card with a city and a virus
    	 * @param c the city associated with the card
    	 * @param d the disease associated with the card
    	 */
    	public PlayerCard(City c,Disease d) {
    		super(c,d);
    	}
    	
    	
    	/**
    	 * Allows you to manage what happens when the card is drawn :
    	 * it's give the card to the player
    	 * @param p the player who drawn the card
    	 */
    	public void comportement(Player p) {
    		p.addCard(this);
    	}


		

		





} 