package thread.test.misleneous;

import java.util.concurrent.atomic.AtomicInteger;

public class InterrupTest {

	public static void main(String[] args) {

		MyThread3 myThread3 = new MyThread3();

		myThread3.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myThread3.interrupt();
	}

}

class MyThread3 extends Thread {

	AtomicInteger atomicInteger = new AtomicInteger(0);

	public void run() {
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been intruupted : -" +e.getMessage());
			e.printStackTrace();
		}
		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("value :: " + atomicInteger.getAndIncrement());
		}

	}

}