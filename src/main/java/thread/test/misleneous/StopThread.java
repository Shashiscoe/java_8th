package thread.test.misleneous;

import java.util.concurrent.atomic.AtomicInteger;

public class StopThread {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("start");

		MyThread myThread = new MyThread();
		myThread.start();

		Thread.sleep(1000);

		myThread.stopThread();

	}

}

class MyThread extends Thread {

	private volatile boolean isStop = false;

	AtomicInteger atomicInteger = new AtomicInteger();

	public void run() {

		System.out.println("start run");

		while (!isStop) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("value :: " + atomicInteger.getAndIncrement());

		}

	}

	public void stopThread() {
		isStop = true;
	}
}