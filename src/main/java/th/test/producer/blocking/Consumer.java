package th.test.producer.blocking;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	BlockingQueue<Integer> blockingQueue = null;

	Consumer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {

		while (true) {

			try {
				Integer value = blockingQueue.take();
				System.out.println("value :: " + value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
