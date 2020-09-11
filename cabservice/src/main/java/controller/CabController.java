package controller;

import java.sql.Timestamp;
import java.util.*;

import cabUtils.CabComparator;
import enums.CabStates;
import pojos.*;

public class CabController {

	Map<Integer, Cab> allCabsMap;
	Map<Integer, City> allCitiesMap;
	Map<Integer, List<Integer>> cityToCabListMap;
	Map<Integer, List<CabBooking>> cabIdToBookingListMap;
	List<CabBooking> allCabBookingList;
	
	public CabController() {
		this.allCabsMap = new HashMap();
		this.allCitiesMap = new HashMap();
		this.cityToCabListMap = new HashMap();
		this.cabIdToBookingListMap = new HashMap();
		this.allCabBookingList = new ArrayList();
	}

	private boolean addToCityToCabListMap(int cityId, int cabId) {
		List<Integer> cabList = cityToCabListMap.get(cityId);
		if(cabList==null)
		{
			cabList = new ArrayList();
		}
		if(!cabList.contains(cabId))
		{
			cabList.add(cabId);	
		}
		cityToCabListMap.putIfAbsent(cityId, cabList);
		return true;
	}
	
	private boolean updateCityToCabListMap(int prevCityId, int newCityId, int cabId) {
		List<Integer> cabList = cityToCabListMap.get(prevCityId);
		cabList.remove(Integer.valueOf(cabId));
		cabList = cityToCabListMap.get(newCityId);
		if(cabList==null)
		{
			cabList = new ArrayList();
		}
		cabList.add(cabId);
		return true;
	}
	
	public boolean registerCab(int cabId, CabStates cabStates, int cityId) {
		if(allCabsMap.containsKey(cabId)) {
			System.out.println("Cab with cabId" + cabId + " already exists.");
			return false;
		}
		if(!allCitiesMap.containsKey(cityId)) {
			System.out.println("Please provide a valid cityId : " + cityId);
			return false;
		}
		Cab cab = new Cab(cabId, cabStates, cityId);
		allCabsMap.put(cabId, cab);
		addToCityToCabListMap(cityId, cabId);
		System.out.println("Registered Cab with Id : " + cabId);
		return true;
	}
	
	public boolean registerCity(int cityId, String cityName) {
		if(allCitiesMap.containsKey(cityId)) {
			System.out.println("City with cityId" + cityId + " already exists.");
			return false;
		}
		if(cityName==null || cityName.isEmpty()) {
			System.out.println("Please provide a valid cityName : " + cityName);
			return false;
		}
		City city = new City(cityId, cityName);
		allCitiesMap.put(cityId, city);
		System.out.println("Registered City with Id : " + cityId);
		return true;
	}
	
	public boolean changeCityForCab(int cabId, int cityId) {
		if(!allCabsMap.containsKey(cabId)) {
			System.out.println("Cab with cabId" + cabId + " does not exist.");
			return false;
		}
		if(!allCitiesMap.containsKey(cityId)) {
			System.out.println("City with cityId" + cityId + " does not exist.");
			return false;
		}
		
		Cab cab = allCabsMap.get(cabId);
		int previousCityId = cab.getCityId();
		int actualprevCityId = cab.getActualCityId();
		if(previousCityId==cityId || actualprevCityId==cityId)
		{
			return false;
		}
		if(cityId>0) {
			updateCityToCabListMap(actualprevCityId, cityId, cabId);
		}
		cab.setCityId(cityId);
		System.out.println("Changed City Id from : " + previousCityId+ " to " +cityId+" for cabId :" + cabId );
		return true;
	}
	
	public boolean changeCabState(int cabId, CabStates cabState) {
		if(!allCabsMap.containsKey(cabId)) {
			System.out.println("Cab with cabId" + cabId + " does not exist.");
			return false;
		}
		
		Cab cab = allCabsMap.get(cabId);
		CabStates previousCabState = cab.getCabState();
		if(previousCabState==cabState)
		{
			return false;
		}
		cab.setCabState(cabState);
		System.out.println("Changed CabState from : " + previousCabState+ " to " +cabState+" for cabId :" + cabId );
		return true;
	}
	
	public boolean bookCab(int startCityId, int endCityId, long startTime, long endTime) {
		if(!allCitiesMap.containsKey(startCityId)) {
			System.out.println("City with cityId" + startCityId + " does not exist.");
			return false;
		}
		if(!allCitiesMap.containsKey(endCityId)) {
			System.out.println("City with cityId" + endCityId + " does not exist.");
			return false;
		}
		
		List<Integer> cabIdList = cityToCabListMap.get(startCityId);
		List<Cab> idleCabList = new ArrayList();
		for(Integer cabId : cabIdList) {
			Cab cab = allCabsMap.get(cabId);
			if(cab.getCabState() == CabStates.IDLE)
				idleCabList.add(cab);
		}
		if(idleCabList.isEmpty())
		{
			System.out.println("Could not book a cab as No Cab Available in cityID : " + startCityId);
			return false;
		}
		Collections.sort(idleCabList, new CabComparator());
		createCabBooking(startCityId, endCityId, idleCabList.get(0), startTime, endTime);
		return true;
	}
	
	private void createCabBooking(int startCityId, int endCityId, Cab cab, long startTime, long endTime) {
		int cabBookingId = allCabBookingList.size() + 1;
		CabBooking cabBooking = new CabBooking(cabBookingId, cab.getCabId(), startCityId, endCityId, new Timestamp(startTime), new Timestamp(endTime));
		allCabBookingList.add(cabBooking);
		changeCabState(cab.getCabId(), CabStates.ONTRIP);
		System.out.println("Booked Cab with Id : "+ cab.getCabId() + "BookingID:" + cabBookingId + " StartCity :" + startCityId +" EndCity :" + endCityId +" startTime :" + startTime +" endTime :" + endTime);
	}
	
	public void processCabManagementInput(List<CabManagementInput> userInputList) {
		for(CabManagementInput userInput:userInputList ) {

			int cabId = userInput.getCabId();
			CabStates cabState = userInput.getCabState();
			int cityId = userInput.getCityId();
			
			if(!allCabsMap.containsKey(cabId)) {
				System.out.println("Cab with cabId" + cabId + " does not exist.");
			}
			if(!allCitiesMap.containsKey(cityId)) {
				System.out.println("City with cityId" + cityId + " does not exist.");
			}
			changeCityForCab(cabId, cityId);
			changeCabState(cabId, cabState);
		}
	}
	
}
