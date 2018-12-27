package th.test.producer.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

	private AtomicInteger count = new AtomicInteger();

	BlockingQueue<Integer> blockingQueue = null;

	Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {

		while (true) {
			try {
				blockingQueue.put(count.getAndIncrement());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
