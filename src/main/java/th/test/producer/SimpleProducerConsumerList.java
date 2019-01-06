package th.test.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleProducerConsumerList {

	AtomicInteger counter = new AtomicInteger(1);
	List<Integer> list = new ArrayList<>(10);

	public void produce() {

		synchronized (this) {
			while (true) {

				if (list.size() == 10) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("start producing");
					list.add(counter.getAndIncrement());
					notifyAll();
				}

			}
		}

	}

	public void consume1() {

		synchronized (this) {
			while (true) {

				if (list.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("consumer_1 start consuming - " + list.remove(list.size() - 1));
					notifyAll();
				}

			}

		}

	}

	public void consume2() {
		synchronized (this) {

			while (true) {

				if (list.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("consumer_2 start consuming - " + list.remove(list.size() - 1));
					notifyAll();
				}

			}
		}
	}

	public static void main(String[] args) {

		SimpleProducerConsumerList testExample = new SimpleProducerConsumerList();

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
