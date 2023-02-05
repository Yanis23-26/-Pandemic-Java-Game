package pandemic;

public class Disease {
	private String name;
	private Sector sector;
	private int id;
	
	
	
	public Disease(String name,Sector sector, int id) {
		this.name=name;
		this.sector=sector;
		this.id=id;
	}
	
	public String getName() {
		return this.name;
	}
	public Sector getSector(){
		return this.sector;
	}
	public int getId() {
		return this.id;
	}
	
}
