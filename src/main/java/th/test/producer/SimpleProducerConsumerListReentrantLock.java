package th.test.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleProducerConsumerListReentrantLock {

	AtomicInteger counter = new AtomicInteger(1);
	List<Integer> list = new ArrayList<>(10);

	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void produce() {

		try {

			while (true) {
				lock.lock();

				if (list.size() == 10) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("start producing");
					list.add(counter.getAndIncrement());
					condition.signalAll();
				}
				lock.unlock();
			}
		} finally {
			lock.unlock();
		}

	}

	public void consume1() {

		try {

			while (true) {

				lock.lock();

				if (list.isEmpty()) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("consumer_1 start consuming - " + list.remove(list.size() - 1));
					condition.signalAll();
				}
				lock.lock();

			}

		} finally {
			lock.unlock();
		}

	}

	public void consume2() {

		try {
			while (true) {
				lock.lock();
				if (list.isEmpty()) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("consumer_2 start consuming - " + list.remove(list.size() - 1));
					condition.signalAll();
				}
				lock.unlock();
			}
		} finally {
			lock.unlock();
		}

	}

	public static void main(String[] args) {

		SimpleProducerConsumerListReentrantLock testExample = new SimpleProducerConsumerListReentrantLock();

		Thread producer = new Thread(() -> {
			testExample.produce();
		});

		Thread consumer1 = new Thread(() -> {
			testExample.consume1();
			;
		});

		Thread consumer2 = new Thread(() -> {
			testExample.consume2();
			;
		});

		producer.start();
		consumer1.start();
		consumer2.start();

	}
}
