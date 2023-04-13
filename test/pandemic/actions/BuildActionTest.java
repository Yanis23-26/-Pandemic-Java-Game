package pandemic.actions;
import java.io.FileNotFoundException;

import org.junit.Before;

import pandemic.Game;
import pandemic.Board.City;
import pandemic.Board.Disease;
import pandemic.Board.Sector;
import pandemic.Cards.PlayerCard;
import pandemic.Roles.Doctor;
import pandemic.Roles.GlobePlotter;
import pandemic.Roles.Player;
import pandemic.actions.BuildAction;

public class BuildActionTest {
	   private static Game game;
	   private static GlobePlotter rayane1;
	   private String path;
	   @Before        
	   public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	   }

    
    	Disease disease = new Disease("Influenza", 1);
		Sector sector1 = new Sector("Europe", disease,1);
        
		// création d'une ville et d'une carte joueur associée à cette ville
        City city = new City("Paris", sector1);
        PlayerCard playerCard = new PlayerCard(city, null);
        
        // création d'un joueur avec la ville associée à la carte joueur précédente
        Player rayane =new GlobePlotter("rayane",city,game);
        // ajout de la carte joueur à la main du joueur
        rayane1.addCard(playerCard);
        
        // création d'une action BuildAction
        BuildAction buildAction = new BuildAction();
        
        // vérification que l'action n'est pas possible avant d'avoir posé la carte joueur
        assert !buildAction.isPossible(rayane);
        
        // pose de la carte joueur
        rayane.addCard(playerCard);
        
        // vérification que l'action est possible après avoir posé la carte joueur
        assert buildAction.isPossible(rayane);
        
        // exécution de l'action
        buildAction.actOn(rayane);
        
        // vérification que la ville contient maintenant une station de recherche
        assert city.hasResearchStation()==true;
    }

}
