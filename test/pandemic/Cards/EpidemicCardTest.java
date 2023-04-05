package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class EpidemicCardTest {
   
   /**
   ce test est effectué pour tester la méthode addCard()
   */
   @Test
   public void  addCardTest(){
    EpidemicCard epidemicCard=new EpidemicCard();
    Disease ebola=new Disease("Ebola",3);		
	Sector europe= new Sector("EUROPE",ebola,3);
    City Lyon=new City("Lyon",europe);
    InfectionCard card1=new InfectionCard(Lyon,ebola);
    epidemicCard.addCard(card1);

    assertTrue(epidemicCard.cards.contains(card1));
    
   } 
   /**
   ce test est effectué pour vérifier le comportement de la méthode DrawnCard()
   */
   @Test 
   public void drawnCardTest(){
    EpidemicCard epidemicCard=new EpidemicCard();
    Disease ebola=new Disease("Ebola",3);		
	Sector europe= new Sector("EUROPE",ebola,3);
    City Lyon=new City("Lyon",europe);
    InfectionCard card1=new InfectionCard(Lyon,ebola);
    epidemicCard.addCard(card1);

    epidemicCard.drawCard();

    assertFalse(epidemicCard.cards.contains(card1));

   } 
    /**
    ce test est effectué pour vérifier le fonctionement de la méthode comportement
    */
   @Test
   public void ComportementTest(){
       EpidemicCard epidemicCard=new EpidemicCard();
       //card1
       Disease ebola=new Disease("Ebola",1);		
	   Sector europe= new Sector("EUROPE",ebola,1);
       City Lyon=new City("Lyon",europe);
       InfectionCard card1=new InfectionCard(Lyon,ebola);

       //card2
       Disease covid=new Disease("covid19",1);		
	   Sector europe= new Sector("EUROPE",covid,1);
       City nice=new City("nice",europe);
       InfectionCard card2=new InfectionCard(nice,covid);

       //card3
       Disease covid=new Disease("covid19",1);		
	   Sector europe= new Sector("EUROPE",covid,1);
       City lille=new City("lille",europe);
       InfectionCard card3=new InfectionCard(lille,covid);

       //card4
       Disease ebola=new Disease("Ebola",1);		
	   Sector europe= new Sector("EUROPE",ebola,1);
       City paris=new City("paris",europe);
       InfectionCard card4=new InfectionCard(paris,ebola);
       

       epidemicCard.addCard(card1);
       epidemicCard.addCard(card2);
       epidemicCard.addCard(card3);
       epidemicCard.addCard(card4);

       epidemicCard.comportement();
       assertFalse(epidemicCard.cards.contains(card4));
       assertEquals(ebola.getId(),2);
       assertEquals(epidemicCard.cards.get(0),card3);

   }   
	    

}
