package facebook;

import java.util.*;

public class StringProb {
	//words={"ab","bc","ca"}12,23,31 alphabet={a,b,c} return true
	//words={"ca","bc","ab","ac"}13,21,32,31 alphabet={c,b,a} return false
	//words={"caa","bccc","abb","acb"}133,2111,322,312 alphabet={c,b,a} return false
	public static boolean isSorted(List<String> words, List<String> alphabet)
	{
		return true;
	}
	
	public static boolean checkSorted(List<String> words)
	{
		for(int i=0; i<words.size()-1;i++)
		{
			if(words.get(i).compareTo(words.get(i+1))>0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr =  {"133","2111","322","312"};
		String[] arr2 =  {"133","312","322","2111"};
		//System.out.println("checkSorted() returned : " + checkSorted(Arrays.asList(arr)) );
		System.out.println("checkSorted() returned : " + checkSorted(Arrays.asList(arr2)) );
		Arrays.sort(arr2);
		System.out.println("After sorting : " + Arrays.toString(arr2));
		
	}

}
