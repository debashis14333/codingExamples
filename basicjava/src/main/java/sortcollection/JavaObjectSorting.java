package sortcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaObjectSorting {

    /**
     * This class shows how to sort primitive arrays, 
     * Wrapper classes Object Arrays
     * @param args
     */
    public static void main(String[] args) {
        //sort primitives array like int array
        int[] intArr = {5,9,1,10};
        Arrays.sort(intArr);
        
        Integer[] intArr1 = {5,9,1,10};
        Arrays.sort(intArr1,Collections.reverseOrder());
        
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(intArr1));
        
        //sorting String array
        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        
        //sorting list of objects of Wrapper classes
        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList, Collections.reverseOrder());
        System.out.println(strList);
        for(String str: strList) System.out.print(" "+str);
    }
}
