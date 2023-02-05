package pandemic;

import java.util.*;

public class City {
	private String name;
	private Map<Disease, Double> infectionRate;
	private List <City>neighbors;
	private List<Player>players;
	private Sector sector;
	
	public City(String name, Sector sector) {
		this.name= name;
		this.neighbors=new ArrayList<>();
		this.infectionRate= new HashMap<>();
		this.sector=sector;
		this.players=new ArrayList<>();
	}
}
