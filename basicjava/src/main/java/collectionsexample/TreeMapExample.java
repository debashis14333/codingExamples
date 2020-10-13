package collectionsexample;

import java.util.*; 


public class TreeMapExample { 
    public static void main(String[] args) 
    { 
  
        // Creating an empty TreeMap 
        TreeMap<Integer, String> tree_map =  
                 new TreeMap<Integer, String>(); 
  
        // Mapping string values to int keys 
        tree_map.put(10, "Geeks"); 
        tree_map.put(15, "4"); 
        tree_map.put(20, "Geeks"); 
        tree_map.put(25, "Welcomes"); 
        tree_map.put(30, "You"); 
  
        // Displaying the TreeMap 
        System.out.println("The original map is: "
                           + tree_map); 
        System.out.println("The original map is: "
                + tree_map.ceilingKey(16)); 
        System.out.println("The original map is: "
                + tree_map.floorKey(16)); 
        
        // Displaying the submap 
        System.out.println("The subMap is " +  
                        tree_map.subMap(100, 200)); 
        // Displaying the submap 
        System.out.println("The subMap is " +  
                        tree_map.subMap(400, 200)); 
    } 
} 