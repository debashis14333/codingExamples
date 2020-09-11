package cabUtils;

import java.util.Comparator;

import pojos.Cab;

public class CabComparator implements Comparator<Cab> {
	
	public int compare(Cab o1, Cab o2) 
	{
		return (int) (o2.getIdleTime() - o1.getIdleTime());
	};

}
