package pandemic.actions;

import pandemic.*;
import pandemic.Board.*;
import pandemic.Roles.*;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class MoveActionTest {
	private static Game game;
    private String path;
	@Before
    public void init() throws FileNotFoundException {
        this.path="./src/pandemic/carte2.json";
        this.game= new Game(path);

    }
	@Test
    public void actOn() {
		 City city = game.getWorld().getSectors().get(0).getCities().get(0);
         Player anes=new Doctor("ANES",city,game);
         game.getPlayers().add(anes);


		 List <City> neighbors = city.getNeighborsCities();// récuperer les viles voisines de cette ville
        

		 MoveAction moveAction = new MoveAction();
		 
         moveAction.getChoice().actOn(anes); // Exécuter l'action de déplacement


		 assertEquals(neighbors.get(1), anes.getCity()); // Vérifier que le joueur a été déplacé à la ville choisie

    }

   @Test
   public void isPossibleTest() {
    	 City city = game.getWorld().getSectors().get(0).getCities().get(0);
         Player anes=new Doctor("ANES",city,game);
         game.getPlayers().add(anes);

        List <City> neighbors = city.getNeighborsCities();// récuperer les viles voisines de cette ville
        

		 MoveAction moveAction = new MoveAction();
		 
         moveAction.getChoice().actOn(anes); // Exécuter l'action de déplacement


		 assertEquals(neighbors.get(1), anes.getCity()); // Vérifier que le joueur a été déplacé à la ville choisie

         assertEquals(true,moveAction.isPossible(anes));// on vérifie si le déplacement est bien effectué
    
   } 




}
