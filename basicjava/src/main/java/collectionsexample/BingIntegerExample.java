package collectionsexample;

import java.math.BigInteger;

public class BingIntegerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger bigInteger1 = new BigInteger("223334445566778889999");
		BigInteger bigInteger2 = new BigInteger("1");
		
		BigInteger bigInteger3 = bigInteger1.add(bigInteger2);
		System.out.println("After addition : " + bigInteger3);
		
	}

}
