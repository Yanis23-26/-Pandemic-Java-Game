package pandemic;

public class PlayerCard implements Card{

    private City city;
    private Disease disease;


    // le constructeur
    public PlayerCard(City city, Disease disease){
        this.city = city;
        this.disease = disease ;
    }


    /**
     * retourne la ville associée à la carte joueur.
     * @return le nom de la ville associé à cette carte joueur. 
     */ 
    public City getCity(){
        return this.city;
    }



    /**
     * Retourne le nom de la carte joueur.
     * @return le nom de la carte joueur
     */
    public Disease getDisease(){
        return this.disease;
    }


    public void comportement() {
        // la carte joueur n'a pas de comportement particulier
    }




} 