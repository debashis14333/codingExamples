package absinterface;

abstract class E {
	int a;
	static int b;
	final int c=100;
	
	abstract void abstractMethod();
	private void abstractMethod1() {
		System.out.println("I am an abstractMethod1.");
	}
	public void abstractMethod2() {
		abstractMethod1();
	}
}

class N extends E {
	public void abstractMethod() {
		System.out.println("I am an abstractMethod.");
	}
}

interface A {
	int a=10;
	static int b=20;
	void a();// bydefault, public and abstract

	void b();

	void c();

	void d();
}

//Creating abstract class that provides the implementation of one method of A interface  
abstract class B implements A {
	public void c() {
		System.out.println("I am C");
	}
}

//Creating subclass of abstract class, now we need to provide the implementation of rest of the methods  
class M extends B {
	public void a() {
		System.out.println("I am a");
	}

	public void b() {
		System.out.println("I am b");
	}

	public void d() {
		System.out.println("I am d");
	}
	
	public void printInts() {
		System.out.println(a + ", " + b);
	}
}

//Creating a test class that calls the methods of A interface  
public class AbstractInterfaceTest {
	public static void main(String args[]) {
		A a = new M();
		a.a();
		a.b();
		a.c();
		a.d();
		M m=(M)a;
		m.printInts();

		E e = new N();
		e.abstractMethod();
		e.abstractMethod2();
	}
}
