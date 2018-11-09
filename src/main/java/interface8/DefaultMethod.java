package interface8;

public class DefaultMethod {

	public static void main(String[] args) {

		
		// Test2 class uses interface default method
		Test2 test2 = new Test2();
		test2.m1();

		// Test1 class override interface default method
		Test1 test1 = new Test1();
		test1.m1();

	}

}

interface Interf {

	default void m1() {
		System.out.println("default method in interface ");
	}

}

class Test2 implements Interf {

}

class Test1 implements Interf {

	public void m1() {
		System.out.println("default method overide in class ");
	}

}
