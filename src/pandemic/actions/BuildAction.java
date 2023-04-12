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
		List<PlayerCard> all =p.getCard(); 
		City city = p.getCity();
		for (PlayerCard c : all) {
			if(c.getCity().equals(city)) {
				return true;
			}
		}
		
		return false;
	}

}
