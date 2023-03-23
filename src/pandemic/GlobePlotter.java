package pandemic;

import pandemic.action.Action;
import pandemic.action.MoveAction;

public class GlobePlotter extends Player {

	public GlobePlotter(String name, City city) {
		super(name, city);
	}

	@Override
	public Action initRoll() {
		
		return new MoveAction();
	}

	

}
