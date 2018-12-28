package thread.test.misleneous;

public class JoinTestExample {

	public static void main(String[] args) {

		Mythread4 mythread4 = new Mythread4();
		Mythread5 mythread5 = new Mythread5();
		Mythread6 mythread6 = new Mythread6();
		Mythread7 mythread7 = new Mythread7();

		mythread4.start();
		mythread5.start();
		mythread6.start();
		mythread7.start();

		try {
			mythread4.join();
			mythread5.join();
			mythread6.join();
			mythread7.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done main :- " + Thread.currentThread().getName());

	}

}

class Mythread4 extends Thread {

	public void run() {

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread name :- " + Thread.currentThread().getName());

		}

	}
}

class Mythread5 extends Thread {

	public void run() {

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread name :- " + Thread.currentThread().getName());

		}

	}
}

class Mythread6 extends Thread {

	public void run() {

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread name :- " + Thread.currentThread().getName());

		}

	}
}

class Mythread7 extends Thread {

	public void run() {

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread name :- " + Thread.currentThread().getName());

		}

	}
}