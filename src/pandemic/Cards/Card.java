package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;

public interface Card{


	/**
	* Represente the result of the drawned card
	*/
	public void comportement();
	
	 
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
		return this.city==other.getCity() && this.disease==other.getDisease();
	}
	
}




