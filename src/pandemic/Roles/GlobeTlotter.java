package pandemic.Roles;
import pandemic.Game;
import pandemic.actions.*;
import pandemic.Board.*;

public class GlobeTlotter extends Player {

	public GlobeTlotter(String name, City city,Game game) {
		super(name, city,game);
	}

	@Override
	public Action initRoll() {
		
		return new MoveAction();
	}

	
	

}
