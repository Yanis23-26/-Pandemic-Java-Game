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
	   
		
	@Before
    public void init() throws FileNotFoundException {
        this.path="./src/pandemic/carte2.json";
        this.game= new Game(path);

    }


	

	/* test1: pour vérifier si un joueur possède 5 cartes de la même maladie, permet de guerrir cette maladie */
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
        City madrid = new City("MADROD",europe);
        City london = new City("LONDON",europe);
        
        //créer une station de recherhce à lille
        lille.addResearchStation();
        
        Player yanis = new Doctor("yanis",lille,game);
        
        // j'ajoute 5 carte joueur au player yanis qui ont la meme maladie.
        yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(berlin,covid));
		yanis.addPlayerCard(new PlayerCard(madrid,covid));   
		yanis.addPlayerCard(new PlayerCard(london,covid));   
		
		/* je teste le bon fonctionnement de la méthode isPossible, qui devrait retourner vrai car on à respecter les deux conditions
		5 cartes de la meme maladie dans la main  du player + une station de recherche dans la ville du player*/
		FindCureAction findCure = new FindCureAction();
		assertTrue(findCure.isPossible(yanis));
	}
	

	/*test n°2: pour vérifier que la méthode isPossible lorsqu'on n'a pas de station à la ville du player.*/
	@Test
	public void testIsPossibleWithNoResearchStation(){

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

		//On ne met pas de station de recherche à lille
		
		Player yanis = new Doctor("yanis",lille,game);

		// j'ajoute 5 carte joueur au player yanis qui ont la meme maladie.
		yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(berlin,covid));
		yanis.addPlayerCard(new PlayerCard(alger,covid));   
		yanis.addPlayerCard(new PlayerCard(cairo,covid));   

		/* je teste le bon fonctionnement de la méthode isPossible de devrait retourner 
		false en cas d'absence de station de recherche à lille */
		
		FindCureAction findCure = new FindCureAction();
		assertFalse(findCure.isPossible(yanis));
		}

	/* Test n°3 : ce test va tester la méthode isPossible si on à moins de 5 cartes */
	@Test
	public void testIsPossibleWithLessThan5Cards() {
		// maladies
		Disease ebola= new Disease("Ebola",0);
		Disease covid = new Disease("COVID_19",1);

		// secteurs
		Sector afrique = new Sector("AFRIQUE",ebola,0);
		Sector europe = new Sector("EUROPE",covid,1);

		// villes
		City lille = new City("LILLE",europe);
		lille.addResearchStation();             //créer une station de recherhce à lille
		City paris = new City("PARIS",europe);
		City berlin = new City("BERLIN",europe);
		City cairo = new City("CAIRO",afrique);
		City alger = new City("ALGER",afrique);


		Player yanis = new Doctor("yanis",lille,game);

		// j'ajoute seulement 4 cartes joueur au Joueur (player) de meme maladie.
		yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(berlin,covid));
		yanis.addPlayerCard(new PlayerCard(cairo,covid));   

		// je teste le bon fonctionnement de la méthode isPossible.
		FindCureAction findCure = new FindCureAction();
		assertFalse(findCure.isPossible(yanis));
	}
	
	/* Test n°4 : ce test va tester la méthode isPossible si on à moins de 5 cartes de la meme maladie */
	@Test
	public void testIsPossibleWithLessThan5CardsOfSameDisease() {
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
		
		lille.addResearchStation();             //créer une station de recherhce à lille

		Player yanis = new Doctor("yanis",lille,game);

		// j'ajoute seulement 4 cartes joueur au Joueur (player) de meme maladie.
		yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(berlin,covid));
		yanis.addPlayerCard(new PlayerCard(cairo,covid)); 
		yanis.addPlayerCard(new PlayerCard(alger,ebola));
		
		

		// je teste le bon fonctionnement de la méthode isPossible.
		FindCureAction findCure = new FindCureAction();
		assertFalse(findCure.isPossible(yanis));
	}
	
	
	
	
	
	
}
