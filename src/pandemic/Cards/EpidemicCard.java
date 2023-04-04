package pandemic.Cards;



public class EpidemicCard implements Card, PileCardPlayer{
	
	// "Sur la carte epidémie, il n ya pas d'information particulière" sujet du projet
	

	
	public EpidemicCard() {
		super();
	}
	
	
	
	/**
	 * Permet de gérer ce qui se passe lorsqu'un joueur tire une carte epidémie
	 */
	public void comportement() {
		/* Comportement triple : 
 		1- Augmente le taux globale d'infection 
 		2- Declenche une phase d'infection quelque soit la valeur du taux
 		3- Mélange des cartes de la defausse
		*/
		
		
		
	}
}
   /*
   this.city.addInfection(disease);
   this.city.infectNeighbors(disease);
   InfectionDeck.getInstance().shuffle();
   */

