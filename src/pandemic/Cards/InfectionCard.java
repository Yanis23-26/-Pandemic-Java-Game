package pandemic.Cards;
import pandemic.Board.*;

import pandemic.Roles.*;

public class InfectionCard extends IntermediateCard{
    
 
    	
    	public InfectionCard(City city,Disease disease ){
    		super(city,disease);
    	}
    	
    	
    	public void comportement() {
    		this.city.addInfection(this.disease);
    		
    	}

	

} 