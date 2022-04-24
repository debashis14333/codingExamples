package collectionsexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(12);
		arrayList.add(8);
		arrayList.add(6);
		arrayList.add(10);
		
		System.out.println("ArrayList size = " + arrayList.size());
		System.out.println("ArrayList Content = " + arrayList);
		
		arrayList.add(2, 4);
		System.out.println("ArrayList size = " + arrayList.size());
		System.out.println("ArrayList Content = " + arrayList);
		
		arrayList.remove(2);
		arrayList.add(2, 18);
		System.out.println("ArrayList size = " + arrayList.size());
		System.out.println("ArrayList Content normal = " + arrayList);
		System.out.println("ArrayList Content toString()= " + arrayList.toString());
		System.out.println("ArrayList 4th element= " + arrayList.get(3));
			
		Integer[] arr = new Integer[arrayList.size()];
		arr = arrayList.toArray(arr);
		System.out.println("Array Content = " + Arrays.toString(arr));
		//List<Integer> arrayList
	}

}
