package pandemic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class World { // this class contains all the sectors 
	private List<Sector> sectors; // the list of sectors in the map

	public World(){
        this.sectors = new ArrayList<>();

		Map<String,City> citiesMap = new HashMap<>();
		Map<String,List<City>> neighborsMap = new HashMap<>();

		String filename = "carte2.json";
		FileReader reader = new FileReader(filename);
	    JSONObject jsonData = new JSONObject(new JSONTokener(reader));
		Iterator<String> entries = jsonData.keys();
		    while (entries.hasNext()) {
		    	String entryKey = entries.next();
				if(entryKey.equals("cities")){
		    		JSONObject entry = jsonData.getJSONObject(entryKey);
		    		Iterator<String> datakeys = entry.keys();
		    		while (datakeys.hasNext()) {
						String cityString = datakeys.next();
						City city = new City(city, entry.getInt(cityString));
						citiesMap.put(cityString, city);
			    	}
		        }
				else if(entryKey.equals("neighbors"){
					JSONObject entry = jsonData.getJSONObject(entryKey);
		    		Iterator<String> datakeys = entry.keys();
		    		while (datakeys.hasNext()) {
						String cityString = datakeys.next();
						List<City> neighbors = new ArrayList<>();
						neighbors = entry.getJSONArray(cityString);
						neighborsMap.put(cityString, neighbors);
			    	}
					
				}
    }
	/** 
	fonction getSectors return the list of sectors
	@return  list of sectors
	
	*/
	
	public List<Sector> getSectors(){
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





