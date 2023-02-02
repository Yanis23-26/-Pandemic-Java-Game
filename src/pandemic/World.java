package pandemic;

import java.util.List;

public class World { // this class contains all the sectors 
	private List<sectors> sectors; // the list of sectors in the map
	    public World(){
        this.sectors=new Arraylist<>();
    }
	/** 
	fonction getSectors return the list of sectors
	@return  list of sectors
	
	*/
	
	public List<sector> getSectors(){
        return this.sectors;
    }
	/** 
	fonction addSector add the sector to the  list of sectors
	@param sector
	*/
	public void addSector(Sector sector){
        this.sectors.add(sector);
    }
	

}





