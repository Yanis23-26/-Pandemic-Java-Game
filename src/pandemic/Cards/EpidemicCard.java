package pandemic.Cards;
import pandemic.Board.*;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card{
	private Stack<card> cards; //une pile qui prends des objets de type card


	public EpidemicCard(){
		cards=new Stack<>();
	}


	/**
	cette fonction ajoute des cards dans la pile des cards

	*/
     public void addCard(InfectionCard card){
		cards.push(card)	 
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
