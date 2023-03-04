package pandemic;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class PlayerTest{
    
   @Test 
   public void testEquals(){
    Player p1 = new Player('Anes',1);
    Player p2= new Player('Manil',2);
    Player p3= new Player('Anes',1);
    Player p4= new Player('Anes',1);

    assertFalse(p1.equals(p2));
    assertTrue(p3.equals(p4));
   } 
} 