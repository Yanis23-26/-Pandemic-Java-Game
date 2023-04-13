package pandemic.actions;

import java.util.List;

import pandemic.Board.City;
import pandemic.Cards.Card;
import pandemic.Cards.PlayerCard;
import pandemic.Roles.*;

public class BuildAction implements Action {

	@Override
	public void actOn(Player p) {
		p.getCity().addResearchStation();

	}

	@Override
	public boolean isPossible(Player p) {
		// on récupère toutes les cartes joueur du joueur
		List<PlayerCard> all =p.getCard(); 
		// on récupère la ville où se trouve le joueur
		City city = p.getCity();
		// on vérifie si le joueur possède une carte joueur associée à la ville où il se trouve
		for (PlayerCard c : all) {
			if(c.getCity().equals(city)) {
				return true;
			}
		}
		 // si aucune carte joueur n'est associée à la ville, l'action n'est pas possible
		return false;
	}

}
