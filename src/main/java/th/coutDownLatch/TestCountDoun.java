package th.coutDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDoun {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(5);


		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "  is Arrived. Remaning Thread : "
						+ countDownLatch.getCount());
				countDownLatch.countDown();

			}).start();
		}

		
		Thread thread = new Thread(() -> {

			try {
				countDownLatch.await();
				System.out.println("Now we can start, all thread has arrived");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		thread.start();
	}

}
