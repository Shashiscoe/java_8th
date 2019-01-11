package thread.test.misleneous;


public class PrintNumberSeq {

	public static void main(String[] args) {

		MyObject object = new MyObject();

		MyThread10 myThread10 = new MyThread10("MyThread1", object);
		MyThread11 myThread11 = new MyThread11("MyThread2", object);

		MyThread12 myThread12 = new MyThread12("MyThread3", object);

		myThread10.start();
		myThread11.start();
		myThread12.start();

		try {
			myThread10.join();
			myThread11.join();
			myThread12.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("done");
	}

}

class MyObject {
	volatile int counter = 1;
}

class MyThread10 extends Thread {

	private MyObject object = null;

	@Override
	public void run() {

		synchronized (object) {
			while (true) {
				while (object.counter != 1) {
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("one :: " + 1);
				object.counter = 2;
				object.notifyAll();

			}
		}
	}

	public MyThread10(String name, MyObject object) {
		super(name);
		this.object = object;
	}

}

class MyThread11 extends Thread {

	private MyObject object = null;

	@Override
	public void run() {

		synchronized (object) {
			while (true) {
				while (object.counter != 2) {
					try {
						object.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println("Two :: " + 2);
				object.counter = 3;
				object.notifyAll();
			}
		}

	}

	public MyThread11(String name, MyObject object) {
		super(name);
		this.object = object;
	}

}

class MyThread12 extends Thread {

	private MyObject object = null;

	@Override
	public void run() {

		synchronized (object) {
			while (true) {

				while (object.counter != 3) {
					try {
						object.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Three :: " + 3);
				object.counter = 1;
				object.notifyAll();

			}
		}

	}

	public MyThread12(String name, MyObject object) {
		super(name);
		this.object = object;
	}

}
