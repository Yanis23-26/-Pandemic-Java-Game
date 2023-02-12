package pandemic;
import static org.junit.Assert.*;


public class SectorTest {
   // this class is the class that test the class Sector methods
   @Test
    public void getSectorNameTest() {
        Disease redDisease = new Disease("Red", 0);       //we create a disease
        Sector sector = new Sector("Europe", redDisease); // we create a sector with the disease created just before
        assertEquals("Europe", sector.getSectorName());  //should be true because the disease "Red" is the "Europe" disease
    }

    @Test
    public void getSectorDiseaseTest() {
        Disease red = new Disease("Red", 0);    // we create a disease 
        Sector sector = new Sector("America", red); // we create a sector with the disease created just before
        assertEquals(red, sector.getSectorDisease()); //should be True
    }

    @Test
    public void getCitiesTest() {
        Disease bleu = new Disease("Bleu", 0); // we create a  disease 
        Sector sector = new Sector("Asia", bleu); // we create a sector with the disease created just before
        assertNotNull(sector.getCities());        //should return 
    }


    @Test
    public void addCityTest() {
        Disease bleu = new Disease("Bleu", 0);     // we create a disease
        Sector sector = new Sector("Europe", bleu); // we create a sector
        City city = new City("Lille");             // we create a city 
        sector.addCity(city);         		//we add the city created just before to the sector 
        assertEquals(1, sector.getCities().size()); //should be true, because we created only one city on this sector
    }
    
}
