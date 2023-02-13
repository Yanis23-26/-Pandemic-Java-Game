package pandemic;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class WorldTest {
	

	@Test
	public void testAddSector() {
		World world = new World();
		Sector sector = new Sector("test", new Disease("test", 0),0);
		world.addSector(sector);
		List<Sector> sectors = world.getSectors();
		assertEquals(sectors.size(), 5);
		assertEquals(sectors.get(4), sector);
	}

	@Test
	public void testGetSectors() {
		World world = new World();
		List<Sector> sectors = world.getSectors();
		assertEquals(sectors.size(), 4);
	}
	
	@Test
	public void testInitWorld() {
		final int NB_VILLES = 48;
		int nbVilles=0;
		final int NB_VILLES_SECTOR = 12;
		int nbVillesSector = 0;
		final int NB_SECTOR = 4;
		int nbSector=0;
		World world = new World();
		
		for(Sector sector : world.getSectors()) {
			nbSector+=1;
			for(City city : sector.getCities()) {
				nbVilles+=1;
			}
		}
		
		for(City city : world.getSectors().get(0).getCities()) {
			nbVillesSector+=1;
		}
		
		assertEquals(NB_VILLES,nbVilles);
		assertEquals(NB_VILLES_SECTOR,nbVillesSector);
		assertEquals(NB_SECTOR,nbSector);
		
		
		
	}
}


