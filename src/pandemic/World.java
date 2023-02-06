package pandemic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class World { // this class contains all the sectors 
	private List<Sector> sectors; // the list of sectors in the map

	public World() {
        this.sectors = new ArrayList<>();
        // creation de 4 sector

		Map<String,City> citiesMap = new HashMap<>();
		Map<String,JSONArray> neighborsMap = new HashMap<>();

		String filename = "./src/pandemic/carte2.json";
		FileReader reader = null;
		try {
			reader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			
			System.out.println("fichier introuvable");
			System.exit(0);
		}
	    JSONObject jsonData = new JSONObject(new JSONTokener(reader));
		Iterator<String> entries = jsonData.keys();
		
		    while (entries.hasNext()) {
		    	String entryKey = entries.next();
				if(entryKey.equals("cities")){
		    		JSONObject entry = jsonData.getJSONObject(entryKey);
		    		Iterator<String> datakeys = entry.keys();
		    		while (datakeys.hasNext()) {
						String cityString = datakeys.next();
						City city = new City(cityString, entry.getInt(cityString));
						citiesMap.put(cityString, city);
			    	}
		        }
				else if(entryKey.equals("neighbors")){
					JSONObject entry = jsonData.getJSONObject(entryKey);
		    		Iterator<String> datakeys = entry.keys();
		    		while (datakeys.hasNext()) {
						String cityString = datakeys.next();
						JSONArray neighbors ;
						neighbors = entry.getJSONArray(cityString);
						neighborsMap.put(cityString, neighbors);
			    	}
					
				}
		    }
		    System.out.println(citiesMap);
		    System.out.println(neighborsMap);
		    // ajouter pour vchaque ville ces neighbor 
		    
		    // ajouter les ville de les secteur
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
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





