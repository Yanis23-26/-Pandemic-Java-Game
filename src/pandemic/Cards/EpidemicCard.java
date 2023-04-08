package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;
import java.util.Stack;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card{

	public void comportement(Player p) {
			// on tire une carte infection 
			// on augmente le taux global d'infection 
			// on melange les cartes d'infections
			Game game=new Game();
			game.DrawAInfectionCard(p);
			game.p.IncreasedInfectionRate();
			game.p.shuffleInfectionCard(game.getDrawInfection());




			
			
	}


} 
