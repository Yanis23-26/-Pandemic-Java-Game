package pandemic;

public class ResearchStation {
	private String name;
	private City city;
	
	
	
	/**
	 * ResearchStation constructor
	 * @param name String, the research station name
	 * @param city City, the city where the research station is located 
	 */
	public ResearchStation(String name, City city ) {
		this.city=city;
		this.name=name;
	}
	
	/**
	 * returns the name of the research station
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * returns the city where research station is located
	 * @return the city
	 */
	public City getCity() {
		return this.city;
		
	}
	
	/**
	 * changes the city location of the research station
	 * @param city City, the new city of research station
	 */
	public void ChangeCity(City city) {
		this.city=city ;
		
	}
	
	public String toString() {
		return this.getName();
	}
	
	public boolean equals(Object o) {
		if(! (o instanceof ResearchStation )) {
			return false;
		}
		 ResearchStation r= (ResearchStation) o;
		return (this.getName().equals(r.getName()) && this.getCity()==r.getCity());
		}

}
