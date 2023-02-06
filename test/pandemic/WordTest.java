package pandemic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pandemic.*;




public class WorldTest {
    private List<Sector> sectors;
    private Sector sector;
    private Disease disease; 
    private int id;

    @test
    public void addSectorTest(){
        this.sectors=new ArrayList<>();
        this.sector=new Sector("sector1");
        this.disease= new Disease("gripe",this.sector,0);
        sectors.addSector(sector);
        assertEquals(sectors.length(),1);
        assertEquals(sectors[0],sector);


    }



   




   // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(pandemic.WorldTest.class);
   }
}



 