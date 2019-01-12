package th.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaPhoreProdConsJava_1 {

	public static void main(String[] args) {

		AtomicInteger atomicInteger = new AtomicInteger(1);
		List<Integer> list = new ArrayList<>();

		Semaphore semaphore = new Semaphore(1,true);
		
		System.out.println("start main Thread");

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(() -> {

			while (true) {

				semaphore.acquire();
				System.out.println("producer :: " + list.add(atomicInteger.getAndIncrement()));
				semaphore.release();
			}

		});

		executorService.submit(() -> {
			while (true) {
				semaphore.acquire();
				System.out.println("conusmer :: " + list.size() + "  ::  " + list.get(list.size() - 1));
				semaphore.release();
			}
		});

		executorService.shutdown();

	}

}
