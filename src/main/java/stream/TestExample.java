package stream;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// 1.submit Runnable
		Future<?> future1 = executorService.submit(() -> System.out.println("ravi"));
		Future<?> future2 = executorService.submit(() -> System.out.println("amit"));

		// 1.submit Callable
		Future<Integer> future3 = executorService.submit(() -> 4 + 6);
		Future<Integer> future4 = executorService.submit(() -> 6 - 4);

		executorService.shutdown();

		System.out.println(future1.get());
		System.out.println(future2.get());
		System.out.println(future3.get());
		System.out.println(future4.get());
	}
}
