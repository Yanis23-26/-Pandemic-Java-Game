package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

public class EpidemicCardTest {

		
		@Test
	    public void getCityTest() {
            Disease disease2=new Disease("covid19",2);		
		    Sector sector2= new Sector("EUROPE",disease2,2);
            City city1=new City("LILLE",sector2);
            EpidemicCard card1=new EpidemicCard(city1,disease2);
            assertEquals(city1,card1.getCity());
  
	    }

	    @Test
	    public void getDiseaseTest() {
            Disease disease2=new Disease("covid19",2);		
		    Sector sector2= new Sector("EUROPE",disease2,2);
            City city1=new City("LILLE",sector2);
            EpidemicCard card1=new EpidemicCard(city1,disease2);
            assertEquals(disease2,card1.getDisease());
	    }

	    @Test
        public void ComportementTest(){
            Disease disease2=new Disease("covid19",2);		
		    Sector sector2= new Sector("EUROPE",disease2,2);
            City city1=new City("LILLE",sector2);
            City city2=new City("LENS",sector2);
            city1.addNeighbor(city2);
            EpidemicCard card1=new EpidemicCard(city1,disease2);
            card1.comportement();
            assertEquals(3,city1.getinfectionRate(disease2));
            assertEquals(3,city2.getinfectionRate(disease2));


        } 


}
