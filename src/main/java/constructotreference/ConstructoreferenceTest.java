package constructotreference;

public class ConstructoreferenceTest {

	ConstructoreferenceTest() {
		System.out.println("ConstructoreferenceTest object creation");
	}

	public static void main(String[] args) {

		// construct reference
		Interf interf = ConstructoreferenceTest::new;
		ConstructoreferenceTest constructoreferenceTest = interf.m1();

		System.out.println(" constructoreferenceTest :: " + constructoreferenceTest);

	}

}

interface Interf {

	public ConstructoreferenceTest m1();
}