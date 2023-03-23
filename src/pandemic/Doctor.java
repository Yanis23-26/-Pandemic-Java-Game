package pandemic;

import pandemic.action.Action;
import pandemic.action.TreateDiseaseAction;

public class Doctor extends Player {

	public Doctor(String name, City city) {
		super(name, city);
		
	}

	

	@Override
	public Action initRoll() {
		
		return new TreateDiseaseAction();
	}

}
