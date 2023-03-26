package pandemic;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Stack;
import java.util.Collections;

public class Main {
	
	public static void shufflePlayerCards(Stack<PlayerCard> playerCards) {
	    Collections.shuffle(playerCards);
	}
	
	public static void shuffleInfectionCards(Stack<InfectionCard> iCards) {
	    Collections.shuffle(iCards);
	}


	public static void main(String[] args) throws FileNotFoundException {
		
		// une fonction pour melanger les cartes 
		
		
		World w = new World(); // creation des villes 
		int overallInfectionRate = 2; // le taux global d'infection
		//w.worldDisplay();
		Stack <InfectionCard> infectionCards = new Stack<InfectionCard>(); // creation de la pile des cartes d'infections
		Stack <PlayerCard> playerCards = new Stack<PlayerCard>(); // creation de la pile des  cartes Joueurs
		Stack <EpidemicCard> epidemicCards = new Stack<EpidemicCard>(); // creation de la pile des cartes epidemic
		
		//creation des cartes
		
		for(Sector sector : w.getSectors()) {
			epidemicCards.push(eCard = new EpidemicCard())
			for(City city : sector.getCities()) {
				PlayerCard pCard = new PlayerCard(city,sector.getSectorDisease());
				InfectionCard iCard = new InfectionCard(city,sector.getSectorDisease());
				playerCards.push(pCard);
				infectionCards.push(iCard);
			
			}
		}
		
		// La ville sur laquelle les 4 joueurs vont se trouver :
		City city = w.getSectors().get(0).getCities().get(0);
		// creation des joueurs 
		GlobePlotter manil = new GlobePlotter("manil",city);
		Doctor yanis = new Doctor("yanis",city);
		Expert rayane = new Expert("rayane",city);
		Scientist anes = new Scientist("anes",city);
		
		// melange des cartes 
		
		shufflePlayerCards(playerCards);
		shuffleInfectionCards(infectionCards);
		
		// on tire de cartes Infection 
		// carte infection 1 
		InfectionCard iCard1 = infectionCards.pop();
		// carte infection 2 
		InfectionCard iCard2 = infectionCards.pop();
		
		
		// chaque joueurs tire deux cartes
		
		manil.addCard(playerCards.pop());
		manil.addCard(playerCards.pop());
		
		yanis.addCard(playerCards.pop());
		yanis.addCard(playerCards.pop());
		
		rayane.addCard(playerCards.pop());
		rayane.addCard(playerCards.pop());
		
		anes.addCard(playerCards.pop());
		anes.addCard(playerCards.pop());
		
		
		
		
		
			
		
		
	}
}

