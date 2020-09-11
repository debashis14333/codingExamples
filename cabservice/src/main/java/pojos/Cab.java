package pojos;

import java.sql.Timestamp;

import enums.CabStates;

public class Cab {
	int cabId;
	CabStates cabState;
	int cityId;
	Timestamp cabStateChangedLast;
	Boolean active;

	public Cab(int cabId, CabStates cabStates, int cityId) {
		this.cabId = cabId;
		this.cabState = cabStates;
		this.cityId = cityId;
		this.active = true;
		this.cabStateChangedLast = new Timestamp(System.currentTimeMillis());
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
		if (this.cabState != cabState) {
			this.cabState = cabState;
			this.cabStateChangedLast = new Timestamp(System.currentTimeMillis());
		}
	}

	public int getCityId() {
		if(this.cabState == CabStates.ONTRIP) {
			return -1;
		}
		return cityId;
	}

	public int getActualCityId() {
		return cityId;
	}
	
	public void setCityId(int cityId) {
		if(cityId < 0) {
			return;
		}
		this.cityId = cityId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public long getIdleTime() {
		if (this.cabState == CabStates.IDLE) {
			return System.currentTimeMillis() - this.cabStateChangedLast.getTime();
		}
		return 0L;
	}

}
