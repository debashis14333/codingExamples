package pojos;

import java.sql.Timestamp;

public class CabBooking {
	int cabBookingId;
	int cabId;
	int startCityId;
	int destinationCityId;
	Timestamp startTime;
	Timestamp endTime;

	public CabBooking(int cabBookingId, int cabId, int startCityId, int destinationCityId, Timestamp startTime, Timestamp endTime) {
		this.cabBookingId = cabBookingId;
		this.cabId = cabId;
		this.startCityId = startCityId;
		this.destinationCityId = destinationCityId;
		this.startTime = startTime;
		this.endTime = endTime;
		System.out.println("CabBooking created with cabBookingId : " + cabBookingId);
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public int getStartCityId() {
		return startCityId;
	}

	public void setStartCityId(int startCityId) {
		this.startCityId = startCityId;
	}

	public int getDestinationCityId() {
		return destinationCityId;
	}

	public void setDestinationCityId(int destinationCityId) {
		this.destinationCityId = destinationCityId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}
