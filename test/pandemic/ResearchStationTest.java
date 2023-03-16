package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResearchStationTest {

	
	  @Test
	  public void testGetName() {
		Disease disease1 = new Disease("Influenza",1);          // we create a disease
		Sector sector1= new Sector("EUROPE",disease1,1);        // we create a sector
	    City city1 = new City("Villeneuve d'Ascq",sector1);     // we create a city
	    ResearchStation researchStation = new ResearchStation("RS1", city1); // we create a RS on that city
	    assertEquals("RS1", researchStation.getName());         // the name of the RS should be "RS1"
	  }

	  @Test
	  public void testGetCity() {
		Disease disease2 = new Disease("covid19",2);
		Sector sector2= new Sector("ASIA",disease2,2);
	    City city2 = new City("Pekin",sector2);                 // we create a city
	    ResearchStation researchStation = new ResearchStation("RS2", city2); // we create a RS on that city
	    assertEquals(city2, researchStation.getCity());         // the city of "RS2" should be "Pekin"
	  }

	  @Test
	  public void testChangeCity() {
		Disease disease1 = new Disease("H1N1",1);
	    Sector sector1= new Sector("EUROPE",disease1,1);
	    City city1 = new City("Lille",sector1);               // we create a first city "Lille"
	    City city2 = new City("Paris",sector1);               // we create a second city "Paris"
	    ResearchStation researchStation = new ResearchStation("RS1", city1); // we create "RS1" on "Lille" 
	    researchStation.changeCity(city2);                    // we change the city of RS1, from "Lille" to "Paris"
	    assertEquals(city2, researchStation.getCity());       // after the change, the city of RS should be "Paris", not "Lille" 
	  }
	  

}
