package th.cyclickbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTestNoBarrierAction {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 10; i++) {
			executorService.submit(() -> {

				try {
					System.out.println(Thread.currentThread().getName() + " is arrived. Reaaning thread for waiting"
							+ cyclicBarrier.getNumberWaiting());
					cyclicBarrier.await();

					System.out
							.println(Thread.currentThread().getName() + " , We all have reached,Now we can start _ 1");
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

		}

		executorService.shutdown();
	}
}
