package pojos;

import enums.CabStates;

public class CabManagementInput {
	int cabId;
	CabStates cabState;
	int cityId;
	
	public CabManagementInput(int cabId, CabStates cabState, int cityId) {
		this.cabId = cabId;
		this.cabState = cabState;
		this.cityId = cityId;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public CabStates getCabState() {
		return cabState;
	}

	public void setCabState(CabStates cabState) {
		this.cabState = cabState;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
}
