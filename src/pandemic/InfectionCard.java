package pandemic;


public class InfectionCard implements Card{
    private City city;
    private Disease disease;
    

    public InfectionCard(City city,Disease disease){
        this.city=city;
        this.disease=disease;
    }
    /**
    *@return the city 
     */

    public City getCity(){
        return this.city;
    }
    
    public Disease getDisease() {
    	return this.disease;
    }
    /**
    * this function describe the comportement of card
     */

    public void Comportement(){
        this.city.addInfection(disease);
       
    }  
} 