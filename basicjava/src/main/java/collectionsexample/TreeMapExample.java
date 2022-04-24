package collectionsexample;

import java.util.*; 

//Treemap article https://www.programiz.com/java-programming/treemap  
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
        tree_map.put(20, "Geeks2"); 
        tree_map.put(25, "Welcomes"); 
        tree_map.put(30, "You"); 
  
        // Displaying the TreeMap 
        System.out.println("The original map is: "
                           + tree_map); 
        System.out.println("The Ceil Key is: "
                + tree_map.ceilingKey(16)); 
        System.out.println("The Ceil Value is: "
                + tree_map.ceilingEntry(16).getValue()); 
        System.out.println("The Ceil Value is: "
                + tree_map.ceilingEntry(50)); 
        Map.Entry<Integer, String> ceilEntry = tree_map.ceilingEntry(25);
        System.out.println("The Ceil Value is: "
                + ceilEntry.getValue()); 
        
        System.out.println("The floor key is: "
                + tree_map.floorKey(16)); 
        
        // Displaying the submap 
        System.out.println("The subMap is " +  
                        tree_map.subMap(100, 200)); 
        // Displaying the submap 
        System.out.println("The subMap is " +  
                        tree_map.subMap(10, 20));
        // Displaying the submap 
        System.out.println("The subMap is " +  
                        tree_map.subMap(10, true, 20, true));
        // Displaying the submap 
        System.out.println("The subMap is " +  
                        tree_map.subMap(400, 200)); 
    } 
} 