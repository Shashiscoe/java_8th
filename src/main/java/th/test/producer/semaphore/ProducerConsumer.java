package th.test.producer.semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumer {

	public static void main(String[] args) {

		Semaphore consumerSem = new Semaphore(0);
		Semaphore producerSem = new Semaphore(1);

		Queue<Integer> queue = new LinkedList<>();

		Producer producer = new Producer(queue, consumerSem, producerSem);
		Consumer consumer = new Consumer(queue, consumerSem, producerSem);

		producer.start();
		consumer.start();

	}

}
