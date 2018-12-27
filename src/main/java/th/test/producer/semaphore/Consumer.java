package th.test.producer.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {

	Queue<Integer> queue = null;
	Semaphore consumerSem = null;
	Semaphore producerSem = null;

	Consumer(Queue<Integer> queue, Semaphore consumerSem, Semaphore producerSem) {
		this.queue = queue;
		this.consumerSem = consumerSem;
		this.producerSem = producerSem;
	}

	public void run() {

		while (true) {
			try {
				consumerSem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Integer value = queue.poll();
			System.out.println("value :: " + value);
			producerSem.release();
		}
	}

}
