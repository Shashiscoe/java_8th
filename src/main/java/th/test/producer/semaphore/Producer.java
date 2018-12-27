package th.test.producer.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

	private AtomicInteger count = new AtomicInteger();

	Queue<Integer> queue = null;
	Semaphore consumerSem = null;
	Semaphore producerSem = null;

	Producer(Queue<Integer> queue, Semaphore consumerSem, Semaphore producerSem) {
		this.queue = queue;
		this.consumerSem = consumerSem;
		this.producerSem = producerSem;
	}

	public void run() {

		while (true) {
			try {
				producerSem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			queue.add(count.getAndIncrement());
			consumerSem.release();
		}
	}

}
