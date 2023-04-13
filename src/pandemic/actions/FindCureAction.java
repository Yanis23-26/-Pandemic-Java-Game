package pandemic.actions;

import java.util.*;

import pandemic.Board.Disease;
import pandemic.Cards.*;
import pandemic.Roles.*;



public class FindCureAction implements Action {
    
    @Override
    public boolean isPossible(Player player) {
    	
        // Condition 1 : vérifier si le joueur est dans une ville qui a une station de recherche.
        if (!player.getCity().hasResearchStation()) {
            return false;
        }
        
        //Condition 2: vérifier si le joueur dispose de 5 cartes joueur de la meme maladie.
        
        // Récupère toutes les cartes joueur de la main du joueur
        List<PlayerCard> playerCards = player.getPlayerCards();
        
        // Compte le nombre de cartes joueur pour chaque maladie
        Map<Disease, Integer> CardCounts = new HashMap<>();
        for (PlayerCard card : playerCards) {
            if (card instanceof PlayerCard) {
                Disease disease = card.getDisease(); 
                if (!CardCounts.containsKey(disease)) {
                    CardCounts.put(disease, 0);
                    // si la maladie jamais rencontré avant, initialise la valeur de la maladie à 0.
                }
                int count = CardCounts.get(disease);
                CardCounts.put(disease, count + 1);
                // incrémenter le nombre de cartes joueur pour cette maladie
            }
        }
        
        // Vérifie si le joueur possède au moins 5 cartes joueur pour une même maladie
        for (int count : CardCounts.values()) {
            if (count >= 5) {
                return true;
            }
        }
        
        return false;
    }


    @Override
    public void actOn(Player player) {
       // TODO Auto-generated method stub
    }
}
