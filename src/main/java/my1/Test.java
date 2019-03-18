package my1;

public class Test  implements Cloneable {

	public static void main(String[] args) throws CloneNotSupportedException {

		System.out.println(new Test().m1());

	}

	private Test  m1() throws CloneNotSupportedException {
		return (Test) super.clone();
		
	}

}
