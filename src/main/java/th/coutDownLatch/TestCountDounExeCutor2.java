package th.coutDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDounExeCutor2 {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(10);

		ExecutorService executorService = Executors.newFixedThreadPool(1);

		for (int i = 0; i < 10; i++) {
			executorService.submit(() -> {
				countDownLatch.countDown();
				System.out.println(Thread.currentThread().getName() + " is  arrived. Remaning thread : "
						+ countDownLatch.getCount());

			});
		}

		try {
			countDownLatch.await();
			System.out.println(Thread.currentThread().getName()
					+ " is arrived .All Thread has  been arrived, now we can go ahead.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executorService.shutdown();

	}

}
