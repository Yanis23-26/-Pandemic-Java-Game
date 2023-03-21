package pandemic;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		World w = new World(); // creation des villes 
		//w.worldDisplay();
		Stack <InfectionCard> infectionCards = new Stack<InfectionCard>(); // creation de la pile des cartes d'infections
		Stack <PlayerCard> PlayerCards = new Stack<PlayerCard>(); // creation de la pile des  cartes Joueurs
		Stack <EpidemicCard> epidemicCards = new Stack<EpidemicCard>(); // creation de la pile des cartes epidemic
		
	}
}

