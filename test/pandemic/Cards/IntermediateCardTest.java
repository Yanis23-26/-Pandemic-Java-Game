package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class IntermediateCardTest{
    /**
    ce test est effectué pour tester la méthode getCity()

    
    */
    @Test 
    public void getCityTest() {
        Disease covid =new Disease("covid19",2);		
		Sector europe = new Sector("EUROPE",covid,2);
        City paris =new City("paris",europe);
        IntermediateCard card1=new IntermediateCard(paris ,covid);
        assertEquals(paris,card1.getCity());

  
	}

    /**
    ce test est effectué pour tester le fonctionement de la méthode getDisease()
     */
	@Test
	public void getDiseaseTest() {
        Disease ebola=new Disease("Ebola",3);		
		Sector europe= new Sector("EUROPE",ebola,3);
        City paris=new City("paris",europe);
        IntermediateCard card2=new IntermediateCard(paris,ebola);
        assertEquals(ebola, card2.getDisease());
	}
   /**
   ce teste pour tester le fonctionement de la méthode equals
    */
   @Test
   public void equalsTest(){
    Disease ebola = new Disease("Ebola",2);
    Sector europe= new Sector("EUROPE",ebola,2);
    City Lille=new City("Lille",europe);


    Disease covid = new Disease("covid19",2);
    Sector europe= new Sector("EUROPE",covid,2);
    City paris=new City("paris",europe);

    IntermediateCard card1=new IntermediateCard(Lille,ebola);
    IntermediateCard card2=new IntermediateCard(Lille,ebola);

    assertTrue(card1.equals(card2));


    IntermediateCard card3=new IntermediateCard(Lille,ebola);
    IntermediateCard card4=new IntermediateCard(paris,covid);

    assertFalse(card3.equals(card4));

    



   }  





} 
