package pandemic;

public class PlayerCardTest {


    public static void main(String[] args) {
        // Création d'une carte joueur pour la ville de Paris
        City paris = new City("Paris");
        PlayerCard playerCard = new PlayerCard("Paris Card", paris);
        
        // Vérification de la ville associée à la carte joueur
        City city = playerCard.getCity();
        if (city.equals(paris)) {
            System.out.println("Test passed: the player card is associated with the correct city");
        } else {
            System.out.println("Test failed: the player card is not associated with the correct city");
        }
    }

}