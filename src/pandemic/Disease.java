package pandemic;

public class Disease {
	private String name;//name of disease
	private int id;//id of Disease
	/**
	 * Disease constructor
	 * @param name String,the name of disease
	 * @param id int, id of disease
	 * @param sector 
	 */
	public Disease(String name, int id){
		this.name=name;
		this.id=id;
	}
	/**
	 * @return the name of disease
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @return the id of disease
	 */
	public int getId(){
		return this.id;
	}
	

	
	
	
	
		
    public boolean equals(Object o) {
		if(! (o instanceof Disease )) {
			return false;
		}
		 Disease d= (Disease) o;
		return (this.getName().equals(d.getName()) && this.getId()==d.getId());
		}
    
    public String toString() {
    	return this.getName();
    }

	


}
