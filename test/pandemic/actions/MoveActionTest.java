package pandemic.actions;

import pandemic.*;

import pandemic.Board.*;

import pandemic.Roles.*;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;





public class MoveActionTest {

    private static Game game;
    private List<City> cities;





    /* Dans le but d'éviter les répétitions, j'ai opté à la declaration de

    mon petit monde à 10 villes avant d'entamer les tests */

    // les maladies

    Disease ebola = new Disease("EBOLA",0);
    Disease covid = new Disease("COVID_19",1);
    Disease flue = new Disease("INFLUENZA",2);



    // les secteurs

    Sector afrique = new Sector("AFRIQUE",ebola,0);
    Sector europe = new Sector("EUROPE",covid,1);
    Sector asia = new Sector("ASIA", flue,2);



    // je crée un petit monde avec 10 villes

    City lille = new City("LILLE",europe);
    City paris = new City("PARIS",europe);
    City bruxelles = new City("BRUXELLES", europe);
    City london = new City("LONDON",europe);
    City tokyo = new City("TOKYO",asia);
    City pekin = new City("PEKIN",asia);
    City bumbai = new City("BUMBAI",asia);
    City alger = new City("ALGER", afrique);
    City cairo = new City("CAIRO",afrique);
    City marrakech = new City("MARAKECH",afrique);



    // les joueurs

    Player yanis = new Doctor("Yanis GHERDANE",lille,game);
    Player manil = new Doctor("Manil DIAF",paris,game);
    Player anes = new Doctor("Anes Seghir",tokyo,game);
    Player rayane = new Doctor("Rayane SLIMANI",alger,game);

    @Before
    public void defineMyWolrd() throws Exception {

        //Je crée une liste de toutes mes villes
        this.cities = new ArrayList<>();
        //definir toutes mes villes en suivant un ordre alphabétique.

        this.cities.add(alger);
        this.cities.add(bruxelles);
        this.cities.add(bumbai);
        this.cities.add(cairo);
        this.cities.add(lille);
        this.cities.add(london);
        this.cities.add(marrakech);
        this.cities.add(paris);
        this.cities.add(pekin);
        this.cities.add(tokyo); 

        //définir les differents voisinages.

        lille.addNeighbor(paris);
        lille.addNeighbor(bruxelles);
        lille.addNeighbor(paris);
        paris.addNeighbor(alger);
        alger.addNeighbor(cairo);
        alger.addNeighbor(marrakech);
        tokyo.addNeighbor(pekin);
        tokyo.addNeighbor(bumbai);
        pekin.addNeighbor(bumbai);
        cairo.addNeighbor(bumbai);

    }

    

    // sert à afficher les villes voisines.

    public void displayNeighbors(List<City> neighbors) {

        System.out.println("Choose the number of town where you want to go ! \n");

        int i = 1;
        for(City n :neighbors ) {

            System.out.println("City n°"+ i +": " + n.getName());
            i++;

        }

    }

    // récupère les villes

    private List<City> getAllCities() {

        return this.cities;

    }

    

    //affiche toutes les villes, suivant un ordre alphabétique

    public void displayAllCities(List<City> cities) {

        System.out.println(" Choose a number of town where you want to go ! \n");

        int i = 0;

        for(City n :cities) {

        System.out.println("City n°"+ i +": " + n.getName());

        i++;

        }

    }

    public int getChoice() {

        try (Scanner scan = new Scanner(System.in)) {
        int choice = scan.nextInt();
        return choice;
        }

    }

    

    

    ////////////////////// LES TESTS /////////////////////////////////////////



    // Test n°1 : isPossible() si la destination est une ville voisine.

    @Test

    public void testActOnIfDestinationIsNeighbor() {

        // je positionne yanis à lille.
        yanis.setCity(lille);
        lille.addPlayer(yanis);

        //afficher les villes voisines ou se trouve yanis

        //displayNeighbors(yanis.getCity().getNeighborsCities());

        

        //J'affiche toutes les villes possibles pour le joueur qui devrait choisir.

        displayAllCities(getAllCities());

        City destination = yanis.getCity().getNeighborsCities().get(this.getChoice());

        MoveAction action = new MoveAction();

        action.actOn(yanis);

        // Vérifier si la maladie n'a pas été guérie

        assertTrue(yanis.getCity() == lille);

    }



 



}