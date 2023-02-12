package pandemic;

import java.util.*;

public class City {  
	private String name;     // the name of the city
	private Map<Disease, Integer> infectionRate;  // infectionRate of each disease
	private List <City>neighbors;  // the neighbors cities of the city
	//private List<Player>players;  // the current players on this city
	private int nbSector;  // the sector which the city belongs to 
	private ResearchStation researchStation;  //the researchStation of the city
	private boolean foyerInfection;  // is the city  a foyerInfection or not
	
	public City(String name, int nbSector) {  // we create a city with a name and a sector
		this.name= name;	
		this.neighbors=new ArrayList<>();
		this.infectionRate= new HashMap<>();
		
		this.nbSector=nbSector;
		//this.players=new ArrayList<>();
		this.researchStation=null;
		this.foyerInfection=false;
	}
	
	

	/**
	 * return the name of the city
	 * @return a string which is the name of the city
	 */
	public String getName(){ 
		return this.name;
	}

	/**
	 * return the infectionRate of a specified disease
	 * @param disease // the disease we want to get its infectionRate
	 * @return a int (0 or 1 or 2 or 3) which represent the number of cubes of this disease in the city
	 */
	public int getinfectionRate(Disease disease){
		return this.infectionRate.get(disease);
	}

	/**
	 * return the infectionRate of all the diseases
	 * @return a int represent the number of cubes of all the diseases in the city
	 */
	public int getTotalinfectionRate(){
		int total =0;
		for (int i : this.infectionRate.values()){
			total+=i;
		}
		return total;
	}

	/**
	 * return the list of the neighbors cities
	 * @return a List<City>
	 */
	public List <City> getNeighborsCities(){
		return this.neighbors;
	}
	
	/*
	/**
	 * return the list of the current players on this city
	 * @return a List<Player>
	
	public List<Player> getCurrentPlayers(){
		return this.players;
	}
	*/

	/**
	 * @return the sector of this city
	 */
	public int getSector(){
		return this.nbSector;
	}

	/**
	 * @return the researchStation of this city or null if there is no researchStation
	 */
	public ResearchStation getResearchStation(){
		return this.researchStation;
	}
	
	public void addNeighbor(City city){
		this.neighbors.add(city);
	}

	/**
	 * @return True if there is at least one cube of any disease , false other ways
	 */
	public boolean isInfected(){
		for (int i : this.infectionRate.values()){
			if (i>0){
				return true;
			}
		}
		return false;
	}

	/** add one cube of the disease given in param
	 * if the number of cubes of this disease is already 3 it will infect all the neighbors
	 * it will add a cube other ways
	 * and the city will be a foyerInfection
	 * @param disease
	 */
	public void addInfection(Disease disease){
		int previousdiseaseInfc = this.getinfectionRate(disease);
		if(previousdiseaseInfc==3){
			this.foyerInfection=true;
			this.infectNeighbors(disease);
		}
		else{
			this.infectionRate.put(disease,previousdiseaseInfc+1);
		}
	}

	/**
	 * remove one cube of the disease given in param
	 * if the number of cubes was 3 the city will no longer be a foyerInfection
	 * @param disease
	 */
	public void removeInfection(Disease disease){
		int previousdiseaseInfc = this.getinfectionRate(disease);
		if(previousdiseaseInfc>2){
			this.infectionRate.put(disease, previousdiseaseInfc-1);
			this.foyerInfection=false;
		}
		else{
			this.infectionRate.put(disease, previousdiseaseInfc-1);
		}
	}

	/**
	 * @return True if the city has a researchStation false if not 
	 */
	public boolean hasResearchStation(){
		if(this.researchStation==null){
			return false;
		}
		else{
			return true;
		}
	}

	/** add new researchStation to the city
	 * @param r
	 */
	public void addResearchStation(ResearchStation r){
		this.researchStation=r;
	}

	/**
	 * remove the researchStation of this city
	 */
	public void removeResearchStation(){
		this.researchStation=null;
	}

	/**
	 * @return True if the city is a FoyerIfection False otherways
	 */
	public boolean isFoyerInfection(){
		return this.foyerInfection;
	}

	/** it will addInfection to every nighbor city of this city
	 * @param disease
	 */
	public void infectNeighbors(Disease disease){
		for (City city : this.neighbors){
			city.addInfection(disease);
		}
	}
	
	public void initDisease(Disease d) {
		this.infectionRate.put(d, 0);
	}
	
	public String toString() {
		return this.name;
	}
	

}

