package singlton.demo;

public class EagerLoading {

	public static void main(String[] args) throws CloneNotSupportedException {
		EagerSinglton.eagerSinglton.show();

		EagerSinglton.eagerSinglton.clone();

	}

}

class EagerSinglton {

	public static EagerSinglton eagerSinglton = new EagerSinglton();

	public void show() {
		System.out.println("lazy loading example");
	}

	protected Object readResolve() {
		return eagerSinglton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}