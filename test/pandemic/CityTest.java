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
		city.resetAlreadyInfectedDuringRound();
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
		city.addResearchStation();
		assertTrue(city.hasResearchStation());
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
	public void removeInfectionTest() {
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

	 @Test
	 public void addInfectionTest() {
	        // Create a new city
		    Disease disease1 = new Disease("maladie1",1);
		    Sector sector1= new Sector("EUROPE",disease1,1);
		    City city = new City("Paris", sector1);
	        city.initDisease(disease1);

	        // Add one cube of disease to the city
	        city.addInfection(disease1);
	        city.resetAlreadyInfectedDuringRound();
	        
	        // Check that the infection rate of the disease is now 1
	        assertEquals(1, city.getinfectionRate(disease1));

	        // Add two more cubes of disease to the city
	        city.addInfection(disease1);
	        city.resetAlreadyInfectedDuringRound();
	        city.addInfection(disease1);
	        city.resetAlreadyInfectedDuringRound();
	        
	        // Check that the infection rate of the disease is now 3
	        assertEquals(3, city.getinfectionRate(disease1));
	        
	        // Try to add one more cube of disease to the city
	        city.addInfection(disease1);
	        
	        // Check that the city is now a foyerInfection
	        assertTrue(city.isFoyerInfection());
	        
	        // Check that all the neighbors of the city have been infected
	        for (City neighbor : city.getNeighborsCities()) {
	            assertEquals(1, neighbor.getinfectionRate(disease1));
	        }
	    }
	 

		
		// test propagation
		@Test
		public void testAddInfectionOnPropagation() {
			Disease disease1 =new Disease("maladie1",1);
			Sector sector1= new Sector("EUROPE",disease1,1);
			City city1 = new City("Madrid",sector1);
			city1.initDisease(disease1);
			Sector sector2= new Sector("EUROPE",disease1,2);
			City city2 = new City("Barcelone",sector2);
			city2.initDisease(disease1);
			city1.addNeighbor(city2);
			city2.addNeighbor(city1);
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			assertEquals(3, city1.getinfectionRate(disease1));
			assertEquals(1,city2.getinfectionRate(disease1));
		}
		
		// test propagation in the case where two nighbors cities are  both foyerInfection
		@Test
		public void testPropagationOnNeighborsWhoAreFoyerInfection() {
			// creation de l'environement villes et maladies et villes voisines
			Disease disease1 =new Disease("maladie1",1);
			Sector sector1= new Sector("EUROPE",disease1,1);
			City city1 = new City("Madrid",sector1);
			city1.initDisease(disease1);
			Sector sector2= new Sector("EUROPE",disease1,2);
			City city2 = new City("Barcelone",sector2);
			city2.initDisease(disease1);
			City city3 = new City("lisbon",sector1);
			city3.initDisease(disease1);
			
			// ajout des villes voisines
			city1.addNeighbor(city2);
			city2.addNeighbor(city1);
			city2.addNeighbor(city3);
			
			//lancer d'infection jusqua ce que un foyerInfection se declanche en city1 et city2
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			assertEquals(1,city2.getinfectionRate(disease1));
			city2.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city2.resetAlreadyInfectedDuringRound();
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city2.resetAlreadyInfectedDuringRound();
			
			
			assertEquals(3, city1.getinfectionRate(disease1));
			assertEquals(3, city2.getinfectionRate(disease1));
			
			
			city1.addInfection(disease1);
			city1.resetAlreadyInfectedDuringRound();
			city2.resetAlreadyInfectedDuringRound();
			
			
			assertEquals(3, city1.getinfectionRate(disease1));
			assertEquals(3, city2.getinfectionRate(disease1));
			assertEquals(1, city3.getinfectionRate(disease1));
			
			
		}
	 

	

	
	 
	 
	 
	 
	 
}
