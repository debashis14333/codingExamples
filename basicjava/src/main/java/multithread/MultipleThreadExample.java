package multithread;

public class MultipleThreadExample {

	private static volatile int i = 0;

	public static void f() {
		for (int j = 0; j < 10; j++) {
			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(MultipleThreadExample::f);
		Thread t2 = new Thread(MultipleThreadExample::f);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(i);
	}
}
