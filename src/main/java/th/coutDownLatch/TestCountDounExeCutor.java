package th.coutDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDounExeCutor {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(10);

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(() -> {
			try {
				countDownLatch.await();
				System.out.println(Thread.currentThread().getName()
						+ " is arrived .All Thread has  been arrived, now we can go ahead.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		for (int i = 0; i < 10; i++) {
			executorService.submit(() -> {
				countDownLatch.countDown();
				System.out.println(Thread.currentThread().getName() + " is  arrived. Remaning thread : "
						+ countDownLatch.getCount());

			});
		}

		executorService.shutdown();

	}

}
