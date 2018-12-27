package thread.test.producer;

public class OddEven {

	boolean odd;
	int count = 1;
	int MAX = 20;

	public void printOdd() {

		synchronized (this) {
			while (count < MAX) {
				while (!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (count % 2 != 00) {
					System.out.println(Thread.currentThread().getName() + " odd : " + count);
					count++;
					notify();
				}
				odd = false;
			}
		}
	}

	public void printEven() {

		synchronized (this) {
			while (count < MAX) {
				while (odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (count % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + " even: " + count);
					count++;
					notify();
				}
				odd = true;
			}
		}
	}

	public static void main(String[] args) {

		OddEven oep = new OddEven();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printEven();

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printOdd();

			}
		});

		t1.start();
		t2.start();

	}

}
