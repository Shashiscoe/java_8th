package inner;


import java.util.concurrent.atomic.AtomicInteger;

/*
 *Note: anonymous class is more pawor full than lemda expression, we can not replace all the anonymous class with lemda expression, but we can replace some the 
 *anonymous class with lemda expression.  We can replace anonymous inner class with lemda express if and if only if, when anonymous inner class provide 
 *implementation of interface which has exactly one abstract method.
 */

/**
 * @author ravi
 *
 */
public class InnerAndLemda {

	public static void main(String[] args) {

		System.out.println("Test");

		byUsingAnonimousInnerClass();
		byUsingLemdaExpression();

	}

	/**
	 * 
	 */
	private static void byUsingAnonimousInnerClass() {

		// by using anonymous inner class

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				AtomicInteger atomicInteger = new AtomicInteger();
				for (int i = 0; i < 10; i++) {
					System.out.println("byUsingAnonimousInnerClass :: " + atomicInteger.incrementAndGet());
				}
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
		

	}

	/**
	 * 
	 */
	private static void byUsingLemdaExpression() {

		// 1st-approach

		
		Runnable runnable = () -> {

			AtomicInteger atomicInteger = new AtomicInteger();
			for (int i = 0; i < 10; i++) {
				System.out.println("byUsingAnonimousInnerClass :: " + atomicInteger.incrementAndGet());
			}

		};

		Thread thread = new Thread(runnable);
		thread.start();

		// 2nd-approach Passing directly in Thread class

		new Thread(() -> {

			AtomicInteger atomicInteger = new AtomicInteger();
			for (int i = 0; i < 10; i++) {
				System.out.println("byUsingAnonimousInnerClass :: " + atomicInteger.incrementAndGet());
			}

		}).start();
	}

}
