package th.test.executerp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnableJob implements Runnable {

	private int num1;
	private int num2;

	RunnableJob(int num1, int num2) {

		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public void run() {

		System.out.println("sum of number is :" + (num1 + num2));
	}

}

class CallableJob implements Callable<Integer> {

	private int num1;
	private int num2;

	CallableJob(int num1, int num2) {

		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public Integer call() {

		return num1 + num2;
	}

}

public class ExecutorTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Future<?> future1 = executorService.submit(new RunnableJob(10, 20));
		Future<?> future2 = executorService.submit(new CallableJob(40, 50));

		executorService.shutdown();

		System.out.println(future1.get());
		System.out.println(future2.get());

	}

}
