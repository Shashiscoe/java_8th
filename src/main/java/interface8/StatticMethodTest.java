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
public class StatticMethodTest {

	public static void main(String[] args) {

		// only way to call static method of interface
		Interf5.display();

		// only way to call static method of interface
		Interf6.display();

		Test5 test5 = new Test5();
		// test5.display); //compile time error
		// display); //compile time error

	}

}

interface Interf5 {

	public static void display() {
		System.out.println("Interf5 static method in side interface");
	}

}

interface Interf6 {

	public static void display() {
		System.out.println("Interf6 static method in side interface");
	}

}

class Test5 implements Interf5, Interf6 {

}