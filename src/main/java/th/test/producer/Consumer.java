package th.test.producer;

import java.util.Queue;

public class Consumer extends Thread {

	Queue<Integer> queue = null;

	Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {

		synchronized (queue) {
			while (true) {
				if (queue.size() == 0) {
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
					System.out.println("value :: " + queue.poll());
					queue.notifyAll();
				}

			}
		}

	}
}
