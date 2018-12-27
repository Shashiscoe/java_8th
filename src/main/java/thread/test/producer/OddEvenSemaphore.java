package thread.test.producer;

import java.util.concurrent.Semaphore;

public class OddEvenSemaphore {

	int count = 1;
	int MAX = 20;

	// creating instance of 2 semaphores , one is for even and another for odd
	Semaphore evenSemaphore = new Semaphore(0);
	Semaphore oddSemaphore = new Semaphore(1);

	public void printOdd() {

		while (count < MAX) {

			try {
				oddSemaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (count % 2 != 00) {
				System.out.println(Thread.currentThread().getName() + " odd : " + count);
				count++;
			}
			evenSemaphore.release();
		}

	}

	public void printEven() {

		while (count < MAX) {

			try {
				evenSemaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (count % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " even: " + count);
				count++;
			}

			oddSemaphore.release();
		}

	}

	public static void main(String[] args) {

		OddEvenSemaphore oep = new OddEvenSemaphore();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printEven();

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printOdd();

			}
		});

		t1.start();
		t2.start();

	}

}
