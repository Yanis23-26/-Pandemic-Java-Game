package pandemic.Cards;
import pandemic.Board.*;
import pandemic.Roles.*;

public class InfectionCard extends IntermediateCard{
    
    /**
     * Crée une carte d'infection associée à une ville et à une maladie spécifiques.
     * @param city La ville associée à la carte.
     * @param disease La maladie associée à la carte.
     */
    public InfectionCard(City city, Disease disease){
        super(city, disease);
    }
    	
    /**
     * Ajoute une infection à la ville associée à la carte.
     */
    public void comportement(Player p) {
        this.getCity().addInfection(this.getDisease());
        //Affichage
		System.out.println("The player "+ p.getName() + " has drawn an infection card indicating the city of :"+ this.getCity() +",and disease : "+ this.getDisease());
    }
}



