package tesco;

import java.util.*;

public class Myclass {
	
	  public static int getNumber(int max)
	  {
	     int n = (int) (Math.random()*max);
	     return n;
	  }
	  
	  public static void printSongs(List<String>inputSongs, int coolDown)
	  {
	      Scanner scanner = new Scanner(System.in);
	      System.out.println("Enter command o/1: ");
	      int command = scanner.nextInt();
	      //Map<String,Integer>
	      
	      //System.out.println("command = " + command);
	      
	      List<String>lastKsongs = new ArrayList<>();
	      while(command==1)
	      {
	        int number = getNumber(inputSongs.size()); 
	        //System.out.println("Number = " + number);
	        if(lastKsongs.contains(inputSongs.get(number)))
	        {
	          continue;
	        }
	        else
	        {
	          String curentSong = inputSongs.get(number);
	          if(lastKsongs.size()>=coolDown)
	          {
	            lastKsongs.remove(0);
	            lastKsongs.add(curentSong) ;          
	          }
	          else
	          {
	            lastKsongs.add(curentSong);
	          }
	          System.out.println("Song to be played: " + curentSong);
	        }
	        //System.out.println("Enter command o/1: ");
	        command = scanner.nextInt();
	        
	      }
	    
	  }
	  
		public static void main (String[] args) {
			System.out.println("Hello Java");
	    String[] songs = {"s1","s2","s3","s4","s5","s6"};
	    printSongs(Arrays.asList(songs),3);
		}


}
