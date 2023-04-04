package pandemic;
import static org.junit.Assert.*;
import org.junit.Test;


public class EpidemicCardTest {

		/*
         * pour tester la méthode getCity on doit :
         * - comparer deux villes identiques avec la méthode assertEquals(), celle définit seule , et celle définit dans la carte epidemic
         * - on définit la ville (lille). pour cela, il faut d'abord définir un secteur afin respecter les éléments du constructeur de City
         * - idem : pour définir un secteur il nous faut au préalable une maladie.
         * - on compare cette ville (lille) avec celle de la carte (ici card1) qui doit etre lille
         * - la creation de card1 nécessite egalement une ville (lille) et une maladie(covid)
         * - pour que le test soit juste, il faut que la fonction renvoie "True"
         */
    
        @Test  
	    public void getCityTest() {
            Disease covid =new Disease("covid19",2);		
		    Sector europe = new Sector("EUROPE",covid,2);
            City lille =new City("LILLE",europe);
            EpidemicCard card1 =new EpidemicCard(lille ,covid);
            assertEquals(lille,card1.getCity());
  
	    }




        /*
         * pour tester la méthode getDisease on doit :
         * - comparer deux maladies identiques avec la méthode assertEquals()
         * - on définit la Première maladie "ebola"
         * - on crée une carte d'epidemie card2 en respectant les elements de son constructeur
         * - pour que le test soit correct, il faut la methode assertEquals() renvoie True
         */
	    @Test
	    public void getDiseaseTest() {
            Disease ebola=new Disease("Ebola",3);		
		    Sector europe= new Sector("EUROPE",ebola,3);
            City lille=new City("LILLE",europe);
            EpidemicCard card2= new EpidemicCard(lille,ebola);
            assertEquals(ebola, card2.getDisease());
	    }
	    


        /*
         * pour tester la méthode comportement() on doit :
         * - On crée une infection à une ville donné. ici covid19 de id = 2
         * - On crée deux ville Lille et Lens qui appartiennet au secteur EUROPE
         * - "LILLE" est définie comme étant voisine de "LENS
         * - On crée une carte épidémie la ville "LILLE" et la maladie "covid19"
         * - On appelle la méthode comportement sur cette carte.
         * - Cette méthode devrait normalement provoquer une augmentation du taux d'infection dans les villes voisines "LENS"
         * - Le tuax d'infection de "LILLE" et "LENS" devrait passer à  3
         * - pour que le test soit correct, les 2 méthodes assertEquals doivent renvoyer "True"
         */
	    @Test
        public void ComportementTest(){
            Disease disease2=new Disease("covid19",2);		
		    Sector sector2= new Sector("EUROPE",disease2,2);
            City city1=new City("LILLE",sector2);
            City city2=new City("LENS",sector2);
            city1.addNeighbor(city2);
            EpidemicCard card1=new EpidemicCard(city1,disease2);
            card1.comportement();
            assertEquals(3,city1.getinfectionRate(disease2));
            assertEquals(3,city2.getinfectionRate(disease2));


        } 


}
