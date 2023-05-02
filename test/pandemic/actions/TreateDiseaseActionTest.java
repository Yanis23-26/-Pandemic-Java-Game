package pandemic.actions;
import pandemic.*;
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
import pandemic.Roles.GlobeTrotter;
import pandemic.Roles.Player;
import pandemic.actions.BuildAction;


import org.junit.Test;



public class TreateDiseaseActionTest {
	private Game game;
	private String path;
	@Before        
	public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	}

    @Test
    public void testActOn() {
      
    	
        /*
    	// Create a city with two diseases
    	
    	Disease maladie0 = new Disease("maladie0", 0);
    	Disease maladie1 = new Disease("maladie1", 1);
    	Sector sector0 = new Sector("sector0",maladie0,0);
    	City city0 = new City("city0",	sector0);
    	
        city0.addDiseaseCube(maladie0,0);
        city0.addDiseaseCube(maladie1,1);
        */
        // Create a player in that city with some cards
    
        
        // Create a TreateDiseaseAction and perform it
        TreateDiseaseAction action = new TreateDiseaseAction();
        Player rayane1;
		action.actOn(rayane1);
        
        Disease maladie0;
		City city;
		// Check that the correct diseases were treated
        assertEquals(1, city.getDiseaseCount(maladie0));
        Disease maladie1;
		assertEquals(2, city.actOn(maladie1));
    }

    @Test
    public void testIsPossible() {
        // Create a city with a research station and a disease
        
        
        
        
        // Create a TreateDiseaseAction and check if it's possible
        TreateDiseaseAction action = new TreateDiseaseAction();
        Disease flue = new Disease("Influenza", 1);
    	Disease grippe = new Disease("Grippe",2);
		Sector europe = new Sector("Europe", flue,1);
        City lille = new City("Lille", europe);
        PlayerCard playerCard = new PlayerCard(lille, flue);
        
        Player rayane =new GlobeTrotter("Manil Diaf",lille,game);
        assertTrue(action.isPossible(rayane));
    }

}
