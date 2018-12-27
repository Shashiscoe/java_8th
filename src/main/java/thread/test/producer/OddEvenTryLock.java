package thread.test.producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenTryLock {

	boolean odd;
	int count = 1;
	int MAX = 20;

	final ReentrantLock lock = new ReentrantLock();
	private final Condition oddCond = lock.newCondition();
	private final Condition evenCond = lock.newCondition();

	public void printOdd() {

		if (lock.tryLock()) {
			while (count < MAX) {
				while (!odd) {
					try {
						oddCond.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (count % 2 != 00) {
					System.out.println(Thread.currentThread().getName() + " odd : " + count);
					count++;
					evenCond.signalAll();
				}
				odd = false;
			}
			lock.unlock();
		}

	}

	public void printEven() {

		if (lock.tryLock()) {
			while (count < MAX) {
				while (odd) {
					try {
						evenCond.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (count % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + " even: " + count);
					count++;
					oddCond.signalAll();
				}
				odd = true;
			}
			lock.unlock();
		}

	}

	public static void main(String[] args) {

		OddEvenTryLock oep = new OddEvenTryLock();
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
