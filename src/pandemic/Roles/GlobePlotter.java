package pandemic.Roles;

import pandemic.actions.*;
import pandemic.Board.*;

public class GlobePlotter extends Player {

	public GlobePlotter(String name, City city) {
		super(name, city);
	}

	@Override
	public Action initRoll() {
		
		return new MoveAction();
	}

	
	

}
