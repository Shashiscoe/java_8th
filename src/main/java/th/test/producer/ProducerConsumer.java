package th.test.producer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	
	public static void main(String[] args) {
		
		
		Queue<Integer> queue = new LinkedList<>();
		
		Producer producer = new Producer(queue );
		Consumer consumer = new Consumer(queue);
		
		producer.start();
		consumer.start();

	}
	

	
}
