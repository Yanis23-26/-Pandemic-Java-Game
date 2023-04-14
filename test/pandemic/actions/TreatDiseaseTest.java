package pandemic.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pandemic.Game;
import pandemic.Board.City;
import pandemic.Board.Disease;
import pandemic.Board.Sector;
import pandemic.Cards.PlayerCard;
import pandemic.Roles.Doctor;
import pandemic.Roles.GlobeTrotter;
import pandemic.Roles.Player;

public class TreatDiseaseTest {
	
	private static Game game;
	private String path;
	
	
	// test n°1 : 
	@Test
	public void testActOnPlayerWithoutResearchStation() {
		// Création de la ville et du joueur
    	Disease flue = new Disease("Influenza", 1);
    	Disease grippe = new Disease("Grippe",2);
		Sector europe = new Sector("Europe", flue,1);
        City berlin = new City("Berlin", europe);
        City paris = new City("Paris", europe);
        PlayerCard playerCard = new PlayerCard(berlin, flue);
        
        Player anes =new GlobeTrotter("Anes Seghir",berlin,game);
        
	    TreateDiseaseAction action = new TreateDiseaseAction();
	    action.actOn(anes);
	    // Vérifier que la méthode n'a pas eu d'effet sur la ville
	    assertEquals(0, berlin.getDiseases().size());
	}
	
	


	
	


}
