package pandemic.Roles;

import pandemic.actions.*;
import pandemic.Board.*;

public class Expert extends Player {

	public Expert(String name, City city) {
		super(name, city);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action initRoll() {
		// TODO Auto-generated method stub
		return new BuildAction();
	}

}
