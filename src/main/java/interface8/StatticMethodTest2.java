package interface8;

/**
 * static method inside interface is used to provide generalize utility
 * methods.by Default it is not available to implementation class , so there is
 * no overriding possible.thats's why we can call only by using interface name
 * only.
 * 
 * @author ravi
 *
 */
public class StatticMethodTest2 {

	public static void main(String[] args) {

		// only way to call static method of interface
		Interf7.display();

		// only way to call static method of interface
		Interf8.display();

		Test6 test6 = new Test6();
		test6.display(); // compile time error
		Test6.display(); // compile time error

	}

}

interface Interf7 {

	public static void display() {
		System.out.println("Interf5 static method in side interface");
	}

}

interface Interf8 {

	public static void display() {
		System.out.println("Interf6 static method in side interface");
	}

}

/**
 * here display() is its personal method not overridden method.
 * 
 * @author ravi
 *
 */
class Test6 implements Interf7, Interf8 {

	public static void display() {
		System.out.println("Test6 static method in side interface");
	}

}

/**
 * here private static display() is its personal method not overridden method.
 * 
 * @author ravi
 *
 */
class Test7 implements Interf7, Interf8 {

	private static void display() {
		System.out.println("Test6 static method in side interface");
	}

}

/**
 * here non static display() is its personal method not overridden method.
 * 
 * @author ravi
 *
 */
class Test8 implements Interf7, Interf8 {

	public void display() {
		System.out.println("Test6 static method in side interface");
	}

}