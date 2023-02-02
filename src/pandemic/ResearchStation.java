package pandemic;

public class ResearchStation {
	private String name;
	private City city;
	
	
	
	public ResearchStation(String name, City city ) {
		this.city=city;
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	public City getCity() {
		return this.city;
		
	}
	
	public void ChangeCity(City city) {
		this.city=city ;
		
	}

}
