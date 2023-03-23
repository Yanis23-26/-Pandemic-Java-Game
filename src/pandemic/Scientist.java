package pandemic;

import pandemic.action.Action;
import pandemic.action.FindCureAction;

public class Scientist extends Player {

	public Scientist(String name, City city) {
		super(name, city);
	}

	@Override
	public Action initRoll() {
		
		return new FindCureAction();
	}

	

}
