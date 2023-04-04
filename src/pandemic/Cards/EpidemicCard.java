package pandemic.Cards;
import pandemic.Board.*;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card{
	private Stack<InfectionCard> cards; //une pile qui prends des objets de type InfectionCard


	public EpidemicCard(){
		cards=new Stack<>();
	}


	/**
	cette fonction ajoute des cards dans la pile des cards
	*@param card;
	 
	*/
	
	public void addCard(InfectionCard card){
		cards.push(card);	 
	}

 

	/**
	cette  fonction permet de tirer une carte de la pile 
	*/

	public void DrawnCard(){
		cards.pop();
	} 

 

	

  
	/**
	 * Allows you to manage what happens when the card is drawn
	 */
	public void comportement() {
			// on tire une carte infection 
			// on augmente le taux global d'infection 
			// on melange les cartes d'infections

			InfectionCard card=this.cards.DrawnCard(); //on tire une carte de la pile cards 
			card.comportement(); // on augmente le taux d'infection en utilisant le comportement de la calss InfectionCard
			card.getCity().infectNeighbors(card.getDisease()); //on infecte les villes voisines
			this.cards.shuffle(); // on mélange la pile des cartes
			
			
	}


} 
