package thread.test.misleneous;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumberSeq2 {

	volatile int counter = 1;

	public static void main(String[] args) {

		System.out.println("start");
		PrintNumberSeq2 test = new PrintNumberSeq2();

		Lock lock = new ReentrantLock();

		Condition condition = lock.newCondition();

		Thread thread1 = new Thread(

		() -> {

			// synchronized (test) {

				try {
					lock.lock();
					while (true) {
						if (test.counter != 1) {
							try {
								condition.await();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println(1);
							test.counter = 2;
							condition.signalAll();
						}
					}
				} finally {
					lock.unlock();
				}

				// }

			});

		Thread thread2 = new Thread(

		() -> {

			// synchronized (test) {

				try {
					lock.lock();
					while (true) {
						if (test.counter != 2) {
							try {
								condition.await();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println(2);
							test.counter = 3;
							condition.signalAll();
						}
					}
				} finally {
					lock.unlock();
				}

				// }

			});

		Thread thread3 = new Thread(

		() -> {

			// synchronized (test) {

				try {
					lock.lock();
					while (true) {
						if (test.counter != 3) {
							try {
								condition.await();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println(3);
							test.counter = 1;
							condition.signalAll();
						}
					}
				} finally {
					lock.unlock();
				}

				// }

			});

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
