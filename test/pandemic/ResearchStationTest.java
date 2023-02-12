
package pandemic;
import static org.junit.Assert.*;


public class ResarchStationTest {  

  @Test
  public void testGetName() {
    City city = new City("Villeneuve d'Ascq");   //we create a city
    ResearchStation researchStation = new ResearchStation("RS1", city); //we create a research station on the city created just before
    assertEquals("RS1", researchStation.getName()); //should be true
  }

  @Test
  public void testGetCity() {
    City city = new City("Villeneuve d'Ascq");  //we create a city
    ResearchStation researchStation = new ResearchStation("RS1", city); //we create a research station
    assertEquals(city, researchStation.getCity()); //should be true, to confirme that the getCity method work perfectlly
  }

  @Test
  public void testChangeCity() {
    City city1 = new City("Villeneuve d'Ascq"); //we create a first city
    City city2 = new City("Dunkerque"); //we create a seconde city
    ResearchStation researchStation = new ResearchStation("RS1", city1); // we create a research station "RS1" on the first city
    researchStation.ChangeCity(city2); //we change the place of the RS1, from city1 to city2
    assertEquals(city2, researchStation.getCity()); //should be true. after change, the city of RS1 should be Dunkerque
  }
}









}
