package pandemic.Roles;

import pandemic.actions.*;
import pandemic.Board.*;

public class Scientist extends Player {

	public Scientist(String name, City city) {
		super(name, city);
	}

	@Override
	public Action initRoll() {
		
		return new FindCureAction();
	}

	

}
