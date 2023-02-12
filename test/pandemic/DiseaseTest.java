package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiseaseTest {
	@Test
	  public void testGetName() {
	    Disease disease = new Disease("Influenza", 1);
	    assertEquals("Influenza", disease.getName());
	  }
	 
	  @Test
	  public void testGetId() {
	    Disease disease = new Disease("Influenza", 1);
	    assertEquals(1, disease.getId());
	  }

	
}
