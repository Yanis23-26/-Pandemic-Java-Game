package pandemic.actions;

import java.util.List;

import pandemic.Board.City;
import pandemic.Cards.Card;
import pandemic.Cards.PileCardPlayer;
import pandemic.Cards.PlayerCard;
import pandemic.Roles.*;
import pandemic.Game;
public class BuildAction implements Action {

	@Override
	public boolean isPossible(Player p) {
		if((p.getGame().getactualNbOfStations()==6) && (p.getCity().hasResearchStation()) ) {
			return false;
		}
		// on récupère toutes les cartes joueur du joueur.
		List<PlayerCard> playerCards = p.getCards(); 
		// on récupère la ville où se trouve le joueur
		City city = p.getCity();
		// on vérifie si le joueur possède une carte joueur associée à la ville où il se trouve
		for (PlayerCard card : playerCards) {
			if(card.getCity().equals(city)) {
				return true;
			}
		}
		 // si aucune carte joueur n'est associée à la ville, l'action n'est pas possible
		return false;
	}
	
	@Override
	public void actOn(Player p) {
		if(isPossible(p)) {
			// ajout d'une station de recherche à la ville du joueur	
			p.getCity().addResearchStation();
			//Affichage 
			System.out.println("The player : " + p.getName() + " has créated a research station in " + p.getCity()+ "!");
			
			
			// déffausser la carte joueur qui à permit au joueur de créer cette station de recherche
			// p.getGame().discardPlayerCard(card);
			List<PlayerCard> playerCards = p.getCards(); 
			City city = p.getCity();
			for (PlayerCard card : playerCards) {
				if(card.getCity().equals(city)) {
					p.getGame().discardPlayerCard(card);
					// ça risque de deffausser plus d'une carte !!! 
				}
			}
			
		}
		    
		else {
		System.out.println(" Impossible to build a research station, the conditions are not met !!!");
		}
	}}



