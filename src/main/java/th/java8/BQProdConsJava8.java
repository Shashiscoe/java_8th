package th.java8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BQProdConsJava8 {

	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		AtomicInteger atomicInteger = new AtomicInteger(1);

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		executorService.submit(() -> {

			while (true) {
				queue.put(atomicInteger.getAndIncrement());
				System.out.println("producer :: ");
			}
		});

		executorService.submit(() -> {

			while (true) {
				System.out.println("producer :: " + queue.take());
			}
		});

		executorService.shutdown();
	}

}
