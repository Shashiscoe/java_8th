package thread.test.misleneous;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class StopThread3 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.out.println("start");

		MyThread2 myThread = new MyThread2();
		myThread.start();

		Thread.sleep(1000);

		myThread.interrupt();
	}

}

class MyThread2 extends Thread {

	AtomicInteger atomicInteger = new AtomicInteger();

	public void run() {

		System.out.println("start run");

		while (!Thread.currentThread().isInterrupted()) {

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