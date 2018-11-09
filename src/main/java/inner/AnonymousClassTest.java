package inner;



public class AnonymousClassTest {
	
	

	public static void main(String[] args) {

		System.out.println("start execution");

		// Approach-1- anonymous class extending concrete class.

		Concrete concrete = new Concrete() {
			public void dislplay() {
				System.out.println("over ride concret class method");
			}

		};

		concrete.dislplay();

		// 2nd approach - anonymous class extending abstract class.

		Abstract abstract1 = new Abstract() {

			@Override
			public void dislplay_2() {
				System.out.println("proive implementation for abstract class method");

			}

			public void show() {

				System.out.println("over ride for abstract class method");
			}

		};

		abstract1.dislplay();
		abstract1.dislplay_2();
		abstract1.show();

		// 3rd approach - anonymous class implementing interface class.

		Inter inter = new Inter() {

			@Override
			public void m3() {
				System.out.println("=====m3====");

			}

			@Override
			public void m2() {
				System.out.println("=====m2====");

			}

			@Override
			public void m1() {
				System.out.println("=====m1====");

			}
		};
		inter.m1();
		inter.m2();
		inter.m3();

		// 4th approach -anonymous class implementing functional interface.

		Inter2 inter2 = new Inter2() {

			@Override
			public void m1() {
				System.out.println("===== functional interface m1 using inner class=====");

			}
		};

		inter2.m1();

		// 5th approach -lemda expression implementing functional interface.

		Inter2 inter22 = () -> {
			System.out.println("===== functional interface m1 using lemda expression class=====");
		};

		inter22.m1();

	}

}

class Concrete {

	public void show() {

		System.out.println("Concreet show");
	}

	public void dislplay() {
		System.out.println("Concreet dislplay");
	}
}

abstract class Abstract {

	public void show() {

		System.out.println("Abstract show");
	}

	public void dislplay() {
		System.out.println("Abstract dislplay");
	}

	public abstract void dislplay_2();
}

interface Inter {
	public void m1();

	public void m2();

	public void m3();
}

@FunctionalInterface
interface Inter2 {
	public void m1();

}