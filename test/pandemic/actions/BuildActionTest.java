package pandemic.actions;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void buildAvtionTest() {
    	Disease disease = new Disease("Influenza", 1);
		Sector sector1 = new Sector("Europe", disease,1);
        City city = new City("Paris", sector1);
        PlayerCard playerCard = new PlayerCard(city, null);
        Player rayane =new GlobePlotter("rayane",city,game);
        rayane.addPlayerCard(playerCard);
        
        
        BuildAction buildAction = new BuildAction();
        assertFalse(buildAction.isPossible(rayane));
        
        // pose de la carte joueur
        rayane.addPlayerCard(playerCard);
        
        // vérification que l'action est possible après avoir posé la carte joueur
        assertTrue(buildAction.isPossible(rayane));
        
        // exécution de l'action
        buildAction.actOn(rayane);
        
        // vérification que la ville contient maintenant une station de recherche
        assertTrue(city.hasResearchStation());
    }

}
