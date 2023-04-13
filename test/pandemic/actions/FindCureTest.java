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
        City alger = new City("MADROD",	afrique);
        City cairo = new City("LONDON",afrique);
        
        //créer une station de recherhce à lille
        lille.addResearchStation();
        
        Player yanis = new Doctor("yanis",lille,game);
        
        // j'ajoute 5 carte joueur au player yanis qui ont la meme maladie.
        yanis.addPlayerCard(new PlayerCard(lille,covid));             
		yanis.addPlayerCard(new PlayerCard(paris,covid));
		yanis.addPlayerCard(new PlayerCard(berlin,covid));
		yanis.addPlayerCard(new PlayerCard(alger,covid));   
		yanis.addPlayerCard(new PlayerCard(cairo,covid));   
		
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
	
	

	/* Test n°5 pour vérifier si la méthode actOn guérit la maladie si le joueur possède 5 cartes de la même maladie */
	@Test
	public void testActOnWith5CardsOfSameDisease() {
		// Maladie
		Disease covid = new Disease("COVID-19", 1);

		// Secteur
		Sector europe = new Sector("EUROPE", covid, 1);

		// Villes
		City lille = new City("LILLE", europe);
		City paris = new City("PARIS", europe);
		City berlin = new City("BERLIN", europe);
		City madrid = new City("MADRID", europe);
		City london = new City("LONDON", europe);

		// Créer une station de recherche à Lille
		lille.addResearchStation();

		// Créer un joueur avec 5 cartes de la même maladie
		Player player = new Scientist("Alice", lille, game);
		player.addPlayerCard(new PlayerCard(lille, covid));
		player.addPlayerCard(new PlayerCard(paris, covid));
		player.addPlayerCard(new PlayerCard(berlin, covid));
		player.addPlayerCard(new PlayerCard(madrid, covid));
		player.addPlayerCard(new PlayerCard(london, covid));

		// Trouver un remède
		FindCureAction action = new FindCureAction();
		action.actOn(player);

		// Vérifier si la maladie a été guérie
		assertTrue(covid.hasAntiDote());
	}
	
	
    /*test n°6 : tester acton() avec seulement 4 cartes*/
	@Test
	public void testActOnWithNotEnoughCardsOfSameDisease() {
	    // Maladie
	    Disease covid = new Disease("COVID-19", 1);
	    Disease flue = new Disease("INFLUENZA", 2);

	    // Secteur
	    Sector europe = new Sector("EUROPE", covid, 1);
	    Sector asia = new Sector("ASIA", flue,2);

	    // Villes
	    City lille = new City("LILLE", europe);
	    City paris = new City("PARIS", europe);
	    City berlin = new City("BERLIN", europe);
	    City tokyo = new City("MADRID", asia);
	    City pekin = new City("LONDON", asia);

	    // Créer une station de recherche à Lille
	    lille.addResearchStation();

	    // Créer un joueur avec moins de 5 cartes de la même maladie
	    Player player = new Scientist("Alice", lille, game);
	    player.addPlayerCard(new PlayerCard(lille, covid));
	    player.addPlayerCard(new PlayerCard(paris, covid));
	    player.addPlayerCard(new PlayerCard(berlin, covid));
	    player.addPlayerCard(new PlayerCard(pekin, covid));

	    // Trouver un remède
	    FindCureAction action = new FindCureAction();
	    action.actOn(player);

	    // Vérifier si la maladie n'a pas été guérie
	    assertFalse(covid.hasAntiDote());
	}
	
	/*test n°7 : tester le fonctionnement de actOn si on à pas de station de recherche */
	@Test
	public void testActOnWithoutResearchStation() {
	    // Maladie
	    Disease covid = new Disease("COVID-19", 1);
	    Disease flue = new Disease("INFLUENZA", 2);

	    // Secteur
	    Sector europe = new Sector("EUROPE", covid, 1);
	    Sector asia = new Sector("ASIA", flue,2);

	    // Villes
	    City lille = new City("LILLE", europe);
	    City paris = new City("PARIS", europe);
	    City berlin = new City("BERLIN", europe);
	    City tokyo = new City("MADRID", asia);
	    City pekin = new City("LONDON", asia);

	    // Créer un joueur avec 5 cartes de la même maladie
	    Player player = new Scientist("Alice", lille, game);
	    player.addPlayerCard(new PlayerCard(lille, covid));
	    player.addPlayerCard(new PlayerCard(paris, covid));
	    player.addPlayerCard(new PlayerCard(berlin, covid));
	    player.addPlayerCard(new PlayerCard(tokyo, covid));
	    player.addPlayerCard(new PlayerCard(pekin, covid));

	    // Trouver un remède
	    FindCureAction action = new FindCureAction();
	    action.actOn(player);

	    // Vérifier si la maladie n'a pas été guérie
	    assertFalse(covid.hasAntiDote());
	}
	 
	/* test n°8 : teste de la fonction actOn avec d'autres players */
	@Test
	public void testActOnWithOtherPlayerCards() {
	    // Créer une maladie
	    Disease covid = new Disease("COVID-19", 1);

	    // Créer des secteurs
	    Sector europe = new Sector("Europe", covid, 1);
	    Sector asia = new Sector("Asia", covid, 2);

	    // Créer des villes dans chaque secteur
	    City paris = new City("Paris", europe);
	    City madrid = new City("Madrid", europe);
	    City shanghai = new City("Shanghai", asia);
	    City tokyo = new City("Tokyo", asia);

	    // Ajouter des cartes de joueur pour deux joueurs différents
	    Player anes = new Scientist("Alice", paris, game);
	    Player rayane = new GlobePlotter("Bob", madrid, game);

	    anes.addPlayerCard(new PlayerCard(paris, covid));
	    anes.addPlayerCard(new PlayerCard(madrid, covid));
	    rayane.addPlayerCard(new PlayerCard(shanghai, covid));
	    rayane.addPlayerCard(new PlayerCard(tokyo, covid));

	    // Vérifier que la maladie n'a pas encore de remède
	    assertFalse(covid.hasAntiDote());

	    // Essayer de trouver un remède avec les cartes des deux joueurs
	    FindCureAction action = new FindCureAction();
	    action.actOn(anes);

	    // Vérifier que la maladie n'a pas de remède après l'action
	    assertFalse(covid.hasAntiDote());
	}

	
	
}
