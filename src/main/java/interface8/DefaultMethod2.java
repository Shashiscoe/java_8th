package interface8;

public class DefaultMethod2 {

	public static void main(String[] args) {

		// Test3 class override interface default method
		Test3 test3 = new Test3();
		test3.m1();

		// calling directly interface default method by using super.
		test3.dilsplay();

	}

}

interface Interf1 {

	default void m1() {
		System.out.println("Interf1 default method in interface ");
	}

}

interface Interf2 {

	default void m1() {
		System.out.println("Interf2 default method in interface ");
	}

}

/**
 * in this case Test1 class must override same default method coming from
 * Interf1 and Interf2.
 * 
 * @author ravi
 *
 */
class Test3 implements Interf1, Interf2 {

	public void m1() {
		System.out.println("Test1 default method overide in class ");
	}

	public void dilsplay() {
		Interf1.super.m1();
		Interf2.super.m1();
	}
}
