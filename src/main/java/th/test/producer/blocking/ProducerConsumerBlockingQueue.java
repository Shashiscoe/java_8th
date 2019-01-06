package th.test.producer.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerBlockingQueue {

	AtomicInteger counter = new AtomicInteger(1);
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public void produce() {

		while (true) {

			System.out.println("start producing");
			try {
				queue.put(counter.getAndIncrement());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void consume1() {

		while (true) {

			try {
				System.out.println("consumer_1 " + queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void consume2() {
		synchronized (this) {

			while (true) {

				try {
					System.out.println("consumer_2 " + queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		ProducerConsumerBlockingQueue testExample = new ProducerConsumerBlockingQueue();

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
