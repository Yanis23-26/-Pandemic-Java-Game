package pandemic;

public abstract class Card {
	
	/** the city associated with the card*/
	protected City city;
	/** the disease associated with the card*/
	protected Disease disease;
	
	
	/**
	 * Make a card with a city and a virus
	 * @param c the city of the card
	 * @param d the disease of the card
	 */
	public Card(City c,Disease d) {
		this.city = c;
		this.disease = d;
	}
	
	/**
	 * give the city associated with the card
	 * @return the city associated with the card
	 */
	public City getCity() {
		return this.city;
	}
	
	/**
	 * give the disease associated with the card
	 * @return the disease associated with the card
	 */
	public Disease getDisease() {
		return this.disease;
	}
	
	
	/**
	 * Allows you to manage what happens when the card is drawn.
	 */
	public abstract void comportement(Player p);
	
	 
	/**
	 * equals method for the Cardcity
	 * @param o the object to compare with the actual city 
	 * @return boolean, true if the two cities are equals, false else
	 */
	public boolean equals(Object o){
		if(! (o instanceof Card)){
			return false;
		}
		Card other = (Card) o;
		return this.city.getName().equals(other.getCity().getName()) && this.disease==other.getDisease();
	}
}




