package pandemic.Cards;
import pandemic.Roles.*;

import pandemic.Game;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card, PileCardPlayer{

	public void comportement(Player p){
			// on tire une carte infection 
			// on augmente le taux global d'infection 
			// on melange les cartes d'infections
			Game game=p.getGame();
			try {
				game.DrawAInfectionCardWhenEpidemic(p);
			} catch (InterruptedException e) {
				// le jeu est terminé
				System.out.println("#############################");
		        System.out.println("#                           #");
		        System.out.println("#         Game Over         #");
		        System.out.println("#                           #");
		        System.out.println("#############################");
		        System.out.println("#############################");
		        System.out.println("#                           #");
		        System.out.println(" THE CUBES STOCK IS EMPTY !  ");
		        System.out.println("#                           #");
		        System.out.println("#############################");
		        try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        System.exit(0);
			}
			game.IncreasedInfectionRate();
			game.shuffleInfectionCards(game.getDrawInfection());
			
			//Affichage
			System.out.println("The player "+ p.getName() + " has drawn an epidemic card.");




			
			
	}


} 
