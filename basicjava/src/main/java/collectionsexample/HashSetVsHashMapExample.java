package collectionsexample;

import java.util.*;

import mypckage.*;

public class HashSetVsHashMapExample {
	/*
	 * From Dwijen Bhattacharjee to Everyone: 05:23 PM Given an list of strings,
	 * group the anagrams together.
	 * 
	 * An Anagram is a word or phrase formed by rearranging the letters of a
	 * different word or phrase, typically using all the original letters exactly
	 * once.
	 * 
	 * You can return the answer in any order. input
	 * 
	 * “abc”, “bca”, “mno”,xyz”, “zxy”, “zo”, “onm” , “cab”,
	 * 
	 * aab baa
	 * 
	 * output
	 * 
	 * “abc”, “bca”, “cab” “mno”, “onm” “xyz” ,”zxy” “zo"
	 * 
	 * 
	 * “abc”, “bca”, “cab” “zo” “xyz” ,”zxy” “mno”, “onm”
	 */

	public static void getUniqueEmployeesByMap(List<Employee> empList) {
		Map<Integer, Employee> empMap = new HashMap<>();
		for (Employee emp : empList) {
			System.out.println("HashCode of "+ emp.getId()+ " : "+Integer.valueOf(emp.getId()).hashCode());
			empMap.put(emp.getId(), emp);
		}
		System.out.println("EMP Map : " + empMap);
		System.out.println("EMP1 hashCode = " + empList.get(0).hashCode());
		System.out.println("EMP3 hashCode = " + empList.get(2).hashCode());
		
		System.out.println("EMP1 equals EMP3 = " + empList.get(0).equals(empList.get(2)));
		
	}

	public static void getUniqueEmployeesBySet(List<Employee> empList) {
		Set<Employee> empSet = new HashSet<>();
		for (Employee emp : empList) {
			empSet.add(emp);
		}
		System.out.println("EMP Set : " + empSet);
	}

	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Deb", 10000));
		empList.add(new Employee(2, "Ani", 20000));
		empList.add(new Employee(1, "Deb", 10000));
		System.out.println("Actual EmpList : " + empList);
		getUniqueEmployeesBySet(empList);
		getUniqueEmployeesByMap(empList);

//		System.out.println("Called");
//		List<String> inputList = new ArrayList<>();
//		// Arrays.asList(["abc", "bca", "mno","xyz", "zxy", "zo", "onm" , "cab" ]);
//		inputList.add("abc");
//		inputList.add("bca");
//		inputList.add("mno");
//		inputList.add("xyz");
//		inputList.add("zxy");
//		inputList.add("zo");
//		
//		System.out.println(getListOfAnagrams(inputList));
		// TODO Auto-generated method stub

	}

	public static List<List<String>> getListOfAnagrams(List<String> inputList) {

		Map<String, List<String>> anagramsMap = new HashMap<>();

		for (String input : inputList) {
			processString(input, anagramsMap);
		}

		//System.out.println(anagramsMap.values());
		List<List<String>> listsOfanagramList = new ArrayList<>();
		for(List<String> anagramList : anagramsMap.values())
			listsOfanagramList.add(anagramList);
		return listsOfanagramList;
	}

	public static void processString(String input, Map<String, List<String>> anagramsMap) {
		final int ALPHABET_SIZE = 26;
		int arr[] = new int[ALPHABET_SIZE];

		for (int i = 0; i < input.length(); i++) {
			arr[input.charAt(i) - 'a']++;
		}
		StringBuffer str = new StringBuffer();

		for (int i = 0; i < ALPHABET_SIZE; i++) {
			while (arr[i] > 0) {
				str.append('a' + i);
				arr[i]--;
			}
		}

		String key = str.toString();
		if (anagramsMap.containsKey(key)) {
			anagramsMap.get(key).add(input);
		} else {
			List<String> anagrams = new ArrayList<>();
			anagrams.add(input);
			anagramsMap.put(key, anagrams);
		}
	}

}
