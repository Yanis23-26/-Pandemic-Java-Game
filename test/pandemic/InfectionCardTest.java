package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfectionCardTest {

	    // the class that test the class "Sector"
		
		@Test
	    public void getCityTest() {
            Disease disease2=new Disease("covid19",2);		
		    Sector sector2= new Sector("EUROPE",disease2,2);
            City city1=new City("LILLE",sector2);
            InfectionCard card1=new InfectionCard(city1,disease2);
            assertEquals(city1,card1.getCity());
  
	    }

	    @Test
	    public void getDiseaseTest() {
            Disease disease2=new Disease("covid19",2);		
		    Sector sector2= new Sector("EUROPE",disease2,2);
            City city1=new City("LILLE",sector2);
            InfectionCard card1=new InfectionCard(city1,disease2);
            assertEquals(disease2,card1.getDisease());
	    }

	    @Test
        public void ComportementTest(){
            Disease disease2=new Disease("covid19",2);		
		    Sector sector2= new Sector("EUROPE",disease2,2);
            City city1=new City("LILLE",sector2);
            InfectionCard card1=new InfectionCard(city1,disease2);
            card1.comportement();
            assertEquals(3,city1.getinfectionRate(disease2));


        } 


}
