package th.java8;

import java.util.concurrent.Semaphore;

public class Test {

	public static void main(String[] args) {
		Semaphore cons1 = new Semaphore(0);
		
		System.out.println(cons1.availablePermits());
		
		cons1.release();
		System.out.println(cons1.availablePermits());
		
		cons1.release();
		
		System.out.println(cons1.availablePermits());
	}

}
