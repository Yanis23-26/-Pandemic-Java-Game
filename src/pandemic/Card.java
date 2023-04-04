package pandemic;

// cette interface décrit le comportement général des cartes utilisés.
public interface Card{


    /**
     * cette méthode retourne le nom de la ville liée à la carte.
     * @return the city
     */
    public City getCity() ;


    /**
    * cette méthode décrit le comportement de la carte.
    */
    public void comportement();
    


    /**
     * cette méthode retourne la maladie liée à la carte
     *@return the disease 
     */
    public Disease getDisease();



}  