package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class EpidemicCardTest {
   private Stack<InfectionCard> cards;
   /**
   ce test est effectué pour tester la méthode addCard()
   */
   @Test
   public void  addCardTest(){
    cards=new Stack<>();
    Disease ebola=new Disease("Ebola",3);		
	Sector europe= new Sector("EUROPE",ebola,3);
    City Lyon=new City("Lyon",europe);
    InfectionCard card1=new InfectionCard(Lyon,ebola);
    cards.addCard(card1);

    assertTrue(cards.contains(card1));
    
   } 
   /**
   ce test est effectué pour vérifier le comportement de la méthode DrawnCard()
   */
   @Test 
   public void DrawnCardTest(){
    cards=new Stack<>();
    Disease ebola=new Disease("Ebola",3);		
	Sector europe= new Sector("EUROPE",ebola,3);
    City Lyon=new City("Lyon",europe);
    InfectionCard card1=new InfectionCard(Lyon,ebola);
    cards.addCard(card1);

    cards.DrawnCard();

    assertFalse(cards.contains(card1));

   } 
    /**
    ce test est effectué pour vérifier le fonctionement de la méthode comportement
    */
   @Test
   public void ComportementTest(){
       cards=new Stack<>();
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
       EpidemicCard card5=new EpidemicCard();

       cards.addCard(card1);
       cards.addCard(card2);
       cards.addCard(card3);
       cards.addCard(card4);

       card5.comportement();
       assertFalse(cards.contains(card4));
       assertEquals(ebola.getId(),2);
       assertFalse(cards.get(0),card3);

   }   
	    

}
