package pandemic.actions;


import pandemic.*;
import pandemic.Board.*;
import pandemic.Cards.*;
import pandemic.Roles.*;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.*;

public class FindCureTest {
	private static Game game;
	private String path;
	   
	// s'exécute avant chaque test
	@Before        
	public void init() throws FileNotFoundException {
		this.path="./src/pandemic/carte2.json";
	    FindCureTest.game= new Game(path);
	   }


	

	// test1: pour vérifier si un joueur possède 5 cartes de la même maladie, permet de guerrir cette maladie.
	@Test
	public void testIsPossibleWith5CardsOfSameDisease() {
		
		// maladies
		Disease ebola= new Disease("Ebola",0);
		Disease covid = new Disease("COVID_19",1);
		
		// secteurs
		Sector afrique = new Sector("AFRIQUE",ebola,0);
		Sector europe = new Sector("EUROPE",covid,1);
		
		// villes
		City lille = new City("LILLE",europe);
        City paris = new City("PARIS",europe);
        City berlin = new City("BERLIN",europe);
        City cairo = new City("CAIRO",afrique);
        City alger = new City("ALGER",afrique);
        
        //créer une station de recherhce à lille
        
        
        Player yanis = new Doctor("yanis",lille,game);
        
        // j'ajoute 5 carte joueur au player yanis qui ont la meme maladie.
        yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(berlin,covid));
		yanis.addPlayerCard(new PlayerCard(alger,covid));   
		yanis.addPlayerCard(new PlayerCard(cairo,covid));   
		
		// je teste le bon fonctionnement de la méthode isPossible.
		FindCureAction findCure = new FindCureAction();
		assertFalse(findCure.isPossible(yanis));
	}
	
	
	
	
	
}
