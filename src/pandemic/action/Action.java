package pandemic.action;

import pandemic.Player;

public interface Action {
	public void actOn(Player p);
	public boolean isPossible(Player p);
}
