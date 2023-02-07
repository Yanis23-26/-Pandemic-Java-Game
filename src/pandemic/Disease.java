package pandemic;

public class Disease {
	private String name;
	private int id;
	
	
	
	public Disease(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	public String getName() {
		return this.name;
	}
	public int getSector(){
		return this.id;
	}

	
}
