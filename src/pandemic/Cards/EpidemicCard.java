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

	public void drawCard(){
		cards.pop();
	} 

 

	

  
	/**
	 * Allows you to manage what happens when the card is drawn
	 */
	public void comportement() {
			// on tire une carte infection 
			// on augmente le taux global d'infection 
			// on melange les cartes d'infections

			InfectionCard card=this.cards.drawCard();//on tire une carte de la pile cards
			card.comportement();
			City city=card.getCity();  
			 // on augmente le taux d'infection en utilisant le comportement de la calss InfectionCard
			city.infectNeighbors(card.getDisease()); //on infecte les villes voisines
			Collections.shuffle(cards); // on mélange la pile des cartes
			
			
	}


} 
