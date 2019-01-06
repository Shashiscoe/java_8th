package th.test.producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleProducerConsumerQueue {

	AtomicInteger counter = new AtomicInteger(1);
	Queue<Integer> queue = new LinkedList<>();

	public void produce() {

		synchronized (this) {
			while (true) {

				if (queue.size() == 10) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("start producing");
					queue.add(counter.getAndIncrement());
					notifyAll();
				}

			}
		}

	}

	public void consume1() {

		synchronized (this) {
			while (true) {

				if (queue.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("consumer_1 start consuming - " + queue.poll());
					notifyAll();
				}

			}

		}

	}

	public void consume2() {
		synchronized (this) {

			while (true) {

				if (queue.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("consumer_2 start consuming - " + queue.poll());
					notifyAll();
				}

			}
		}
	}

	public static void main(String[] args) {

		SimpleProducerConsumerQueue testExample = new SimpleProducerConsumerQueue();

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
