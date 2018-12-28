package thread.test.misleneous;

/**
 * ThreadA is printing "A" continuously. (ThreadA.java) ThreadB is printing "B"
 * continuously. (ThreadB.java) ThreadC is printing "C" continuously.
 * (ThreadC.java). desired output is A B C A B C A B C A B C A B C......
 */
public class RunThreadInSequence {

	public static void main(String[] args) throws InterruptedException {

		shareFlag shareFlag = new shareFlag();

		ThreadA threadA = new ThreadA(shareFlag, "First");
		ThreadB threadB = new ThreadB(shareFlag, "Second");
		ThreadC threadC = new ThreadC(shareFlag, "Third");

		threadA.start();
		threadB.start();
		threadC.start();

		threadA.join();
		threadB.join();
		threadC.join();

		System.out.println("done");
	}

}

class ThreadA extends Thread {

	shareFlag shareFlag = null;

	public ThreadA(shareFlag shareFlag, String name) {
		super(name);
		this.shareFlag = shareFlag;
	}

	public void run() {
		synchronized (shareFlag) {

			for (int i = 0; i < 20; i++) {

				while (shareFlag.flag != 1) {
					try {
						shareFlag.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				shareFlag.flag = 2;
				System.out.print("A");
				shareFlag.notifyAll();
			}
		}
	}

}

class ThreadB extends Thread {

	shareFlag shareFlag = null;

	public ThreadB(shareFlag shareFlag, String name) {
		super(name);
		this.shareFlag = shareFlag;
	}

	public void run() {
		synchronized (shareFlag) {

			for (int i = 0; i < 20; i++) {

				while (shareFlag.flag != 2) {
					try {
						shareFlag.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				shareFlag.flag = 3;
				System.out.print("B");
				shareFlag.notifyAll();
			}
		}
	}
}

class ThreadC extends Thread {

	shareFlag shareFlag = null;

	public ThreadC(shareFlag shareFlag, String name) {
		super(name);
		this.shareFlag = shareFlag;
	}

	public void run() {
		synchronized (shareFlag) {

			for (int i = 0; i < 20; i++) {

				while (shareFlag.flag != 3) {
					try {
						shareFlag.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				shareFlag.flag = 1;
				System.out.print("C");
				shareFlag.notifyAll();
			}
		}
	}
}

class shareFlag {

	public volatile int flag = 1;

}