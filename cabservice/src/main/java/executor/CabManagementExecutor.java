package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.CabController;
import enums.CabStates;
import pojos.CabManagementInput;

public class CabManagementExecutor {

	public static void main(String[] args) {
		CabController cabController = new CabController();
		onBoardCities(cabController);
		onBoardCabs(cabController);
		changeCitiesForCabs(cabController);
		changeStatesForCabs(cabController);
		bookCabs(cabController);
		processUserInput(cabController);
	}

	private static void onBoardCities(CabController cabController) {
		cabController.registerCity(1, "Hyderabad");
		cabController.registerCity(2, "Bangalore");
		cabController.registerCity(3, "Mumbai");
		cabController.registerCity(4, "Pune");
		System.out.println("Cities are onboarded");
//		cabController.registerCity(5, "Delhi");
//		cabController.registerCity(6, "Chennai");

	}

	private static void onBoardCabs(CabController cabController) {
		cabController.registerCab(100, CabStates.IDLE, 1);
		cabController.registerCab(101, CabStates.IDLE, 2);
		cabController.registerCab(102, CabStates.IDLE, 3);
		cabController.registerCab(103, CabStates.IDLE, 4);
		cabController.registerCab(104, CabStates.IDLE, 1);
		cabController.registerCab(105, CabStates.IDLE, 2);
		cabController.registerCab(106, CabStates.IDLE, 1);
		cabController.registerCab(107, CabStates.IDLE, 2);
		System.out.println("Cabs are onboarded");
	}

	private static void changeCitiesForCabs(CabController cabController) {
		cabController.changeCityForCab(100, 2);
		cabController.changeCityForCab(101, 2);
		cabController.changeCityForCab(102, 1);
		cabController.changeCityForCab(103, 1);
		cabController.changeCityForCab(104, 1);
		cabController.changeCityForCab(105, 2);
		cabController.changeCityForCab(106, 2);
		System.out.println("Changed Cities for Cabs");
	}

	private static void changeStatesForCabs(CabController cabController) {
		cabController.changeCabState(100, CabStates.ONTRIP);
		cabController.changeCabState(105, CabStates.ONTRIP);
		cabController.changeCabState(105, CabStates.IDLE);
		cabController.changeCabState(100, CabStates.IDLE);
		System.out.println("Changed States for Cabs");
	}

	private static void bookCabs(CabController cabController) {
		int isContinueBooking = 1;
		Scanner sc = new Scanner(System.in);
		while (isContinueBooking == 1) {
			System.out.println("Enter start & end city for cab Booking.");
			int startCityId = sc.nextInt();
			int endCityId = sc.nextInt();
			System.out.println("Enter startTime & endTime for cab Booking.");
			long startTime = sc.nextLong();
			long endTime = sc.nextLong();
			cabController.bookCab(startCityId, endCityId, startTime, endTime);
			System.out.println("To continue press 1");
			isContinueBooking = sc.nextInt();
		}

		// cabController.bookCab(2, 3);
		// cabController.bookCab(1, 4);
		System.out.println("Booked the given Cabs");
	}

	private static void processUserInput(CabController cabController) {
		List<CabManagementInput> userInputList = new ArrayList();
		userInputList.add(new CabManagementInput(100, CabStates.ONTRIP, 2));
		userInputList.add(new CabManagementInput(100, CabStates.IDLE, 2));
		userInputList.add(new CabManagementInput(100, CabStates.IDLE, 1));
		userInputList.add(new CabManagementInput(100, CabStates.IDLE, 2));
		userInputList.add(new CabManagementInput(100, CabStates.IDLE, 2));
		userInputList.add(new CabManagementInput(100, CabStates.IDLE, 1));
		cabController.processCabManagementInput(userInputList);
		System.out.println("Processed user input for Cab Management.");
	}

}
