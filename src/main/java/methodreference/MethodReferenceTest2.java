package methodreference;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Here runnable run() method is refereed to m1() method by using method
 * reference.
 * 
 * @author ravi
 *
 */
public class MethodReferenceTest2 {

	public void m1() {

		AtomicInteger atomicInteger = new AtomicInteger();
		for (int i = 0; i < 10; i++) {
			System.out.println("Methid refrence :: " + atomicInteger.getAndIncrement());
		}
	}

	public static void main(String[] args) {

		Runnable runnable = new MethodReferenceTest2()::m1;

		Thread thread = new Thread(runnable);
		thread.start();

	}

}
