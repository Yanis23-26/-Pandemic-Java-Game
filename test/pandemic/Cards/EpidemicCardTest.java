package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class EpidemicCardTest {
   	   private Game game;
	   private String path;
	   @Before        
	   public void init() throws FileNotFoundException {
		  this.path="./src/pandemic/carte2.json";
	      this.game= new Game(path);
	   }

      @Test
      public void comportement(){
        Disease covid19=new Disease("covid19",2);		
		Sector europe= new Sector("EUROPE",covid19,2);
        City Lille=new City("LILLE",europe);
        Player anes=new Doctor("ANES",Lille,game);

        Disease ebola=new Disease("ebola",2);		
		Sector afrique= new Sector("AFRIQUE",ebola,2);
        City Tizi=new City("Tizi",afrique);
        Player rayane=new Scientist("RAYANE",Tizi,game);

        Disease HepatiteE=new Disease("HepatiteE",2);		
		Sector europe2= new Sector("EUROPE2",HepatiteE,2);
        City Lyon=new City("Lyon",europe2);
        Player manil=new Expert("MANIL",Lyon,game);

        Disease grippe=new Disease("grippe",2);		
		Sector amerique= new Sector("AMERIQUE",grippe,2);
        City california=new City("california",amerique);
        Player yanis=new GlobePlotter("YANIS",california,game);

        EpidemicCard epidemiccard=new EpidemicCard();

        InfectionCard card1=new InfectionCard(Lille,covid19);
        InfectionCard card2=new InfectionCard(Tizi,ebola);
        InfectionCard card3=new InfectionCard(Lyon,HepatiteE);
        InfectionCard card4=new InfectionCard(california,grippe);

        Stack<InfectionCard> infectioncards=game.getDrawInfection();
        infectioncards.push(card1);
        infectioncards.push(card2);
        infectioncards.push(card3);
        infectioncards.push(card4);

        epidemiccard.comportement(anes);

        assertEquals(infectioncards,infectioncards.contains(card4));
        assertEquals(3,california.getInfectionRate(grippe));



      }  
  
   
	    

}
