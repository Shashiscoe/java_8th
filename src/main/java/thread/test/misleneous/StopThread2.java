package thread.test.misleneous;

import java.util.concurrent.atomic.AtomicInteger;

public class StopThread2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		System.out.println("start");

		MyThread1 myThread = new MyThread1();
		myThread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myThread.stop();
	}

}

class MyThread1 extends Thread {

	AtomicInteger atomicInteger = new AtomicInteger();

	public void run() {

		System.out.println("start run");

		while (true) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("value :: " + atomicInteger.getAndIncrement());

		}

	}

}