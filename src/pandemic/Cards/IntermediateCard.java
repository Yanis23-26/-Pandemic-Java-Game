package pandemic.Cards;

import pandemic.Board.City;
import pandemic.Board.Disease;

public abstract class IntermediateCard implements Card{
	
	protected City city;
	protected Disease disease;
	
	public IntermediateCard(City city, Disease disease) {
		this.city = city;
		this.disease = disease;
	}
	
	public City getCity() {
		return this.city;
	}
	
	public Disease getDisease() {
		return this.disease;
	}
	
	public abstract void comportement();	
	
	
	public boolean equals(Object o) {
		if(!(o instanceof IntermediateCard)) {
			return false;
		}
		IntermediateCard other = (IntermediateCard) o;
		return this.city.getName().equals(other.getCity().getName()) && this.disease.equals(other.getDisease());
	
	

}
