package pandemic;

public class InfectionCard implements Card{
    private City city;
    private Disease disease;
    

    public InfectionCard(City city,Disease disease){
        this.city=city;
        this.disease=disease;
    }


    /**
    * Cette méthode retourne la ville associée à la carte d'infection.
    * @return la ville associée à la carte
    */

    public City getCity(){
        return this.city;
    }
    

    /**
    * Cette méthode retourne la maladie associée à la carte.
    * @return la maladie associée à la carte d'infection
    */
    public Disease getDisease() {
    	return this.disease;
    }
    

    /**
     * décrit le comportement de la carte d'infection
     */

    public void comportement(){
        this.city.addInfection(disease); 
        //cette carte infecte une ville avec une maladie.
       
    }  
} 