package th.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaPhoreProdConsJava8 {

	public static void main(String[] args) {

		AtomicInteger atomicInteger = new AtomicInteger(1);
		List<Integer> list = new ArrayList<>();

		Semaphore prod = new Semaphore(1);
		Semaphore cons = new Semaphore(0);

		System.out.println("start main Thread");

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(() -> {

			while (true) {

			
				prod.acquire();
				System.out.println("producer :: " + list.add(atomicInteger.getAndIncrement()));
				cons.release();
			}

		});

		executorService.submit(() -> {
			while (true) {
				cons.acquire();
				System.out.println("conusmer :: " + list.size() + "  ::  " + list.get(list.size() - 1));
				prod.release();
			}
		});

		executorService.shutdown();

	}

}
