package board;

import java.util.ArrayList;
import java.util.List;

public class City {
	private String name;
	private Double infectionRate;
	private List <City>neighbors;
	private List <Disease> diseases;
	private Player currentPlayer;
	private Sector sector;
	
	public City(String name) {
		this.name= name;
		this.infectionRate=infectionRate;
		this.neighbors=new ArrayList<>();
		this.diseases= new ArrayList<>();
		this.sector=sector;
		this.currentPlayer=currentPlayer;
	}
	public String getName() {
		return this.name;
	}
	public Double getInfectionRate() {
		 return this.infectionRate;
	}
	public void addCity(City city) {
		this.neighbors.add(city);
	}
	
	
	public void addDiseases(Disease disease){
		this.diseases.add(disease);
	}
	
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	 
	
}
