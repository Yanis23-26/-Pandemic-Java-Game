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
       Disease ebola1=new Disease("Ebola",1);		
	   Sector europe1= new Sector("EUROPE",ebola1,1);
       City Lyon=new City("Lyon",europe1);
       InfectionCard card1=new InfectionCard(Lyon,ebola1);

       //card2
       Disease covid2=new Disease("covid19",1);		
	   Sector europe2= new Sector("EUROPE",covid2,1);
       City nice=new City("nice",europe2);
       InfectionCard card2=new InfectionCard(nice,covid2);

       //card3
       Disease covid3=new Disease("covid19",1);		
	   Sector europe3= new Sector("EUROPE",covid3,1);
       City lille=new City("lille",europe3);
       InfectionCard card3=new InfectionCard(lille,covid3);

       //card4
       Disease ebola4=new Disease("Ebola",1);		
	   Sector europe4= new Sector("EUROPE",ebola4,1);
       City paris=new City("paris",europe4);
       InfectionCard card4=new InfectionCard(paris,ebola4);
       

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
