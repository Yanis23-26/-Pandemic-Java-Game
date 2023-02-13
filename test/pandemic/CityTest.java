package pandemic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CityTest {
	
	

	
	@Test
	public void testGetName() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		City city = new City("Lille",sector1);
		assertEquals("Lille", city.getName());
	}

	@Test
	public void testGetinfectionRate() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		City city = new City("Lille", sector1);
		city.initDisease(disease1);
		city.addInfection(disease1);
		assertEquals(1, city.getinfectionRate(disease1));
	}

	@Test
	public void testGetTotalinfectionRate() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		Disease disease2 = new Disease("maladie2",2);
		City city = new City("Paris", sector1);
        city.initDisease(disease1);
        city.initDisease(disease2);
		city.addInfection(disease1);
		city.addInfection(disease2);
		assertEquals(2, city.getTotalinfectionRate());
	}

	@Test
	public void testGetNeighborsCities() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		Sector sector2= new Sector("AISIA",disease1,2);
		City city1 = new City("Budapest", sector1);
		City city2 = new City("London", sector2);
		city1.addNeighbor(city2);
		assertEquals(1, city1.getNeighborsCities().size());
		assertEquals("London", city1.getNeighborsCities().get(0).getName());
	}

	@Test
	public void testGetSector() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		City city = new City("New York", sector1);
		assertEquals(sector1, city.getSector());
	}

	@Test
	public void testGetResearchStation() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		City city = new City("Mexico", sector1);
		ResearchStation researchStation = new ResearchStation("Station1",city);
		city.addResearchStation(researchStation);
		assertEquals(city.getResearchStation(),researchStation);
	}

	@Test
	public void testIsInfected() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		City city = new City("Madrid", sector1);
		Disease disease3 = new Disease("maladie3",3);
		city.initDisease(disease3);
		city.addInfection(disease3);
		assertTrue(city.isInfected());
	}

	@Test
	public void testAddInfection() {
		Disease disease2 =new Disease("maladie2",2);
		Sector sector2= new Sector("EUROPE",disease2,2);
		City city = new City("Barcelone",sector2);
		city.initDisease(disease2);
		assertEquals(0, city.getinfectionRate(disease2));
		city.addInfection(disease2);
		assertEquals(1, city.getinfectionRate(disease2));
	}

	@Test
	public void testRemoveInfection() {
		Disease disease1 = new Disease("maladie1",1);
		Sector sector1= new Sector("EUROPE",disease1,1);
		City city = new City("Dubai", sector1);
		city.initDisease(disease1);
		city.addInfection(disease1);
		city.removeInfection(disease1);
		assertEquals(0, city.getinfectionRate(disease1));
	}
	
	 @Test
	    public void testEquals() {
			Disease disease1 = new Disease("maladie1",1);
			Sector sector1= new Sector("EUROPE",disease1,1);
		    Disease disease2 =new Disease("maladie2",2);
			Sector sector2= new Sector("EUROPE",disease2,2);
	        City c1 = new City("Paris", sector1);
	        City c2 = new City("Paris", sector1);
	        assertTrue(c1.equals(c2));

	        City c3 = new City("Londres", sector2);
	        assertFalse(c1.equals(c3));

	        // Test with different name but same sector
	        City c4 = new City("New York", sector2);
	        assertFalse(c1.equals(c4));

	        // Test with different sector but same name
	        City c5 = new City("Paris", sector2);
	        assertFalse(c1.equals(c5));

	        // Test with null object
	        assertFalse(c1.equals(null));

	        // Test with object of different class
	        Object o = new Object();
	        assertFalse(c1.equals(o));
	    }


	

}
