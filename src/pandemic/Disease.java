package pandemic;

public class Disease {
	private String name;//name of disease
	private int id;//id of Disease

 
	/**
	 * Disease constructor
	 * @param name String,the name of disease
	 * @param id int, id of disease
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


}
