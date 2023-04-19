package pandemic.actions;

import pandemic.Board.*;
import pandemic.Roles.*;
import org.junit.Before;
import pandemic.Game;

import org.junit.Test;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;





public class MoveActionTest {

  	private Game game;
	private String path;
	@Before        
	public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	}
    

    ////////////////////// LES TESTS /////////////////////////////////////////



    // Test n°1 : isPossible() si la destination est une ville voisine et si le déplacement peut être effectuer

    @Test

    public void testActOnIfDestinationIsNeighbor1() {

        City tokyo = game.getWorld().getSectors().get(0).getCities().get(2);

        // le joueur anes

        Player anes = new Doctor("Anes Seghir",tokyo,game);

        MoveAction action = new MoveAction();
        
        assertEquals(true,action.isPossible(anes));


    }

    @Test

    public void testActOnIfDestinationIsNeighbor2() {

        City lille = game.getWorld().getSectors().get(0).getCities().get(0); 

        // le joueur yanis

        Player yanis = new Doctor("Yanis GHERDANE",lille,game);

        MoveAction action = new MoveAction();
        
        assertEquals(true,action.isPossible(yanis));


    }

    @Test

    public void testActOnIfDestinationIsNeighbor3() {

        City paris = game.getWorld().getSectors().get(0).getCities().get(1);

        // le joueur manil

        Player manil = new Doctor("Manil DIAF",paris,game);

        MoveAction action = new MoveAction();

        assertEquals(true,action.isPossible(manil));


    }

    @Test

    public void testActOnIfDestinationIsNeighbor4() {

        City alger = game.getWorld().getSectors().get(0).getCities().get(3);

        // le joueur rayane

        Player rayane = new Doctor("Rayane SLIMANI",alger,game);

        MoveAction action = new MoveAction();
        
        assertEquals(true,action.isPossible(rayane));


    }



 



}