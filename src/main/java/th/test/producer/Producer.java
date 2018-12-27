package th.test.producer;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

	private AtomicInteger count = new AtomicInteger();

	Queue<Integer> queue = null;

	Producer(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		
		synchronized (queue) {
			while (true) {
				if (queue.size() == 10) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					queue.add(count.incrementAndGet());
					queue.notifyAll();
				}

			}
		}

	}
}
