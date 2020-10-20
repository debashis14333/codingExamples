package mypckage;

import java.util.ArrayList;
import java.util.List;

public class MyClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(12);
		myList.add(0, 8);
		System.out.println("Hello " + myList);
	}

}
