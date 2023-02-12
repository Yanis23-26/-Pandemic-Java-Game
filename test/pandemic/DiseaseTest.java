package pandemic;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiseaseTest {
	@Test
	  /**
	   * Test the getName method of the Disease class
	   */

	  public void testGetName() {
	    Disease disease = new Disease("Influenza", 1);
	    assertEquals("Influenza", disease.getName());
	  }

	  @Test
	  /**
	   * Test the getId method of the Disease class
	   */

	  public void testGetId() {
	    Disease disease = new Disease("Influenza", 1);
	    assertEquals(1, disease.getId());
	  }


}