package pandemic;

import java.util.*;

public class City {
	private String name;
	private Map<Disease, Double> infectionRate;
	private List <City>neighbors;
	private List<Player>players;
	private Sector sector;
	private ResearchStation researchStation;
	private boolean foyerInfection;
	
	public City(String name, Sector sector) {
		this.name= name;
		this.neighbors=new ArrayList<>();
		this.infectionRate= new HashMap<>();
		this.sector=sector;
		this.players=new ArrayList<>();
		this.researchStation=null;
		this.foyerInfection=false;
	}

	public String getName(){
		return this.name;
	}

	public int getinfectionRate(Disease disease){
		return this.infectionRate.get(disease);
	}

	public int getTotalinfectionRate(){
		int total =0;
		for (int i : this.infectionRate.values()){
			total+=i;
		}
		return total;
	}

	public List <City> getNeighborsCities(){
		return this.neighbors;
	}

	public List<Player> getCurrentPlayers(){
		return this.players;
	}

	public Sector getSector(){
		return this.sector;
	}

	public ResearchStation getResearchStation(){
		return this.researchStation;
	}

	public boolean isInfected(){
		for (int i : this.infectionRate.values()){
			if (i>0){
				return true;
			}
		}
		return false;
	}

	public void addInfection(Disease disease){
		int previousdiseaseInfc = this.getinfectionRate(disease);
		if(previousdiseaseInfc>2){
		this.infectionRate.put(disease,previousdiseaseInfc+1);
		this.foyerInfection=true;
		}
		else if(previousdiseaseInfc==3){
			this.foyerInfection=true;
		}
		else{
			this.infectionRate.put(disease,previousdiseaseInfc+1);
		}
	}

	public boolean hasResearchStation(){
		if(this.researchStation==null){
			return false;
		}
		else{
			return true;
		}
	}

	public ResearchStation addResearchStation(ResearchStation r){
		this.researchStation=r;
	}
}

