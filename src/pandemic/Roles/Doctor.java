package pandemic.Roles;

import pandemic.actions.*;
import pandemic.Board.*;
public class Doctor extends Player {

	public Doctor(String name, City city) {
		super(name, city);
		
	}

	

	@Override
	public Action initRoll() {
		
		return new TreateDiseaseAction();
	}

}
