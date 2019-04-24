package thread.test.misleneous;

public class PrintNumberSeq1 {

	volatile int counter = 1;

	public static void main(String[] args) {

		System.out.println("start");
		PrintNumberSeq1 test = new PrintNumberSeq1();

		Thread thread1 = new Thread(

		() -> {

			synchronized (test) {

				while (true) {
					if (test.counter != 1) {
						try {
							test.wait();
						} catch (Exception e) {
							// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(1);
			test.counter = 2;
			test.notifyAll();
		}
	}
}

}		);

		Thread thread2 = new Thread(

		() -> {

			synchronized (test) {

				while (true) {
					if (test.counter != 2) {
						try {
							test.wait();
						} catch (Exception e) {
							// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(2);
			test.counter = 3;
			test.notifyAll();
		}
	}
}

}		);

		Thread thread3 = new Thread(

		() -> {

			synchronized (test) {

				while (true) {
					if (test.counter != 3) {
						try {
							test.wait();
						} catch (Exception e) {
							// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(3);
			test.counter = 1;
			test.notifyAll();
		}
	}
}

}		);

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
