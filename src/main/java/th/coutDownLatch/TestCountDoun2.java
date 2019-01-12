package th.coutDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDoun2 {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(10);

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {

				countDownLatch.countDown();
				System.out.println(Thread.currentThread().getName() + "  is Arrived. Remaning Thread : "
						+ countDownLatch.getCount());

			}).start();
		}

		try {
			countDownLatch.await();
			System.out.println("Now we can start, all thread has arrived");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
