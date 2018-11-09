package methodreference;

/**
 * MethodReference is used for code re-usability, because we have already
 * equivalent implementation m2 as static and m3 as non-static method so no need
 * to implement m1 once again.MethodReference is alternative for lemda
 * expression, we can replace lemda expression with method reference.
 * 
 * @author ravi
 *
 */
public class MethodReferenceTest {

	public static void main(String[] args) {

		// method reference example for static method
		Interf interf = Test::m2;
		interf.m1();

		// method reference example for non-static method
		Interf interf2 = new Test()::m3;
		interf2.m1();

	}

}

interface Interf {

	public void m1();
}

class Test {

	public static void m2() {
		System.out.println("Method reference example for static method");
	}

	public void m3() {
		System.out.println("Method reference example for non-static method");
	}

}