package pandemic;

// cette classe represente la carte de l'epidemie
public class EpidemicCard implements Card{
    private  City city;
    private Disease disease;
    

    //constructeur de la classe EpidemicCard
    public EpidemicCard(City city ,Disease disease){
        this.city=city;
        this.disease=disease;
    }

    /**
     * retourne la ville associé à la carte epidemie.
     * @return the city 
     */ 

    public City getCity(){
        return this.city;
    }
    /**
     * retourne la maladie associé à la carte epidemie.
     * @return the disease
    */
    public Disease getDisease(){
        return this.disease;
    } 


    /**
     * propage la maladie dans la ville et ses villes voisines.
     */
    public void comportement(){
        this.city.addInfection(disease); // ajoute une infection à la ville ciblé par la carte epidemie
        this.city.infectNeighbors(disease); // infecte les villes voisines de la ville ciblé par la carte épidemie
    }  

} 