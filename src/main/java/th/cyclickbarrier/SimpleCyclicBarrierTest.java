package th.cyclickbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SimpleCyclicBarrierTest {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {

			System.out.println("We all have reached,Now we can start _ 2");

		});

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {

				try {
					System.out.println(Thread.currentThread().getName() + " is arrived. Reaaning thread for waiting"
							+ cyclicBarrier.getNumberWaiting());
					cyclicBarrier.await();
					
					System.out.println(Thread.currentThread().getName() + " , We all have reached,Now we can start _ 1");
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
			

		}

	}
}
