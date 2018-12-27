package th.test.producer.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {

		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);

		producer.start();
		consumer.start();

	}

}
