package pandemic.Cards;
import pandemic.Board.*;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card{
	private Stack<InfectionCard> cards; //une pile qui prends des objets de type card


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
	*@param nb c'est le nombre de cartes qu'il faut ajouter
	*@param card c'est une carte de type infectioncard 
	*/

	public void PileCard(int nb,InfectionCard card){
		for(int i=0;i<nb+1,i++){
			cards.push(card);
		}  
		
	}  

	/**
	cette  fonction permet de tirer une carte de la pile 

	 */

	public void DrawCard(InfectionCard card){
		cards.pop(card);
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
