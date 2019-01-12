package th.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleProdConsJava8 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		AtomicInteger atomicInteger = new AtomicInteger(1);

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(() -> {

			synchronized (list) {
				while (true) {
					try {
						while (list.size() == 10) {
							list.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}

					list.add(atomicInteger.getAndIncrement());
					System.out.println("Producer");
					list.notifyAll();
				}
			}

		});

		executorService.submit(() -> {

			synchronized (list) {
				while (true) {

					try {
						while (list.isEmpty()) {
							list.wait();
						}
					} catch (InterruptedException e) {
						System.out.println(e);
					}
					System.out.println("Consumer :: " + list.remove(list.size() - 1));
					list.notifyAll();
				}
			}

		});

		executorService.shutdown();
	}

}
