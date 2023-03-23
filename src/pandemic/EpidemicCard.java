package pandemic;

public class EpidemicCard implements Card{
    private  City city;
    private Disease disease;
    
    public EpidemicCard(City cityName;Disease disease){
        this.city=city;
        this.disease=disease;
    }
    /**
    *@return the city 
     */ 

    public City getCity(){
        return this.city;
    }
    /**
    @return the disease

    */
    public Disease getDisease(){
        return this.disease;
    } 

    public void Comportement(){
        this.city.addInfection(disease);
        this.city.infectNeighbors(disease);

    }  

} 