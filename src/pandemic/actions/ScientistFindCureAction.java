package pandemic.actions;

import java.util.*;

import pandemic.Board.*;
import pandemic.Cards.*;
import pandemic.Roles.*;



/* Comme le sujet l'indique, le joueur scientifique n'a besoin que de 4 cartes pour trouver un remède */
public class ScientistFindCureAction implements Action {
	
	
	
	
    @Override
    public boolean isPossible(Player player) {
    	
        // Condition 1 : vérifier si le joueur au role "Scientist" est dans une ville qui a une station de recherche.
        if (!player.getCity().hasResearchStation()) {
        	return false;
        }        
        //Condition 2: vérifier si le joueur "Scientist" dispose de 4 cartes joueurs de la meme maladie.        
        // Récupère toutes les cartes joueur de la main du joueur
        List<PlayerCard> playerCards = player.getCards();        
        // Compte le nombre de cartes joueur pour chaque maladie
        Map<Disease, Integer> cardCounts = new HashMap<>();
        for (PlayerCard card : playerCards) {
            if (card instanceof PlayerCard) {
                Disease disease = card.getDisease(); 
                if (!cardCounts.containsKey(disease)) {
                    cardCounts.put(disease, 0);
                    // si la maladie jamais rencontré avant, initialise la valeur de la maladie à 0.
                }
                int count = cardCounts.get(disease);
                cardCounts.put(disease, count + 1);
                // incrémenter le nombre de cartes joueur pour cette maladie
            }
        }        
        // Vérifie si le "Scientist" possède au moins 4 cartes joueur pour une même maladie
        for (int count : cardCounts.values()) {
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void actOn(Player player) {
        // Si le "Scientist" dispose de 4 cartes de la même maladie,le remède de cette maladie est trouvé
        if (isPossible(player)) {
        	
        	
            List<PlayerCard> playerCards = player.getCards();
            Map<Disease, Integer> CardCounts = new HashMap<>();
            for (PlayerCard card : playerCards) {
                if (card instanceof PlayerCard) {
                    Disease disease = card.getDisease();
                    if (!CardCounts.containsKey(disease)) {
                        CardCounts.put(disease, 0);
                    }
                    int count = CardCounts.get(disease);
                    CardCounts.put(disease, count + 1);
                }
            }
            // Trouver la maladie pour laquelle le joueur a 4 cartes.
            for (Map.Entry<Disease, Integer> entry : CardCounts.entrySet()) {
                if (entry.getValue() >= 4) {
                    Disease disease = entry.getKey();
                    // Défausser les 4 cartes de cette maladie.
                  //Affichage console
                	System.out.println("The Scientist " + player.getName() + " has cured the disease " + disease + " ^_^");
                    for (int i = 0; i < 4; i++) {
                        player.discardFourCardsOfDisease(disease);
                    }
                    // Ajouter le remède pour cette maladie.
                    disease.findAnAntidote();
                   
                }
            }
        }
        else {
        	System.out.println(" Impossible to cure the disease, the conditions are not met !!! ");
        }
    }

}
