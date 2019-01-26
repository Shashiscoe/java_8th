package immutable.shalow;

public class ShalowCopyTest {

	public static void main(String[] args) {

		Mutable mutable = new Mutable();
		mutable.setName("ravi");

		Immutable immutable_1 = new Immutable("delhi", mutable);
		Immutable immutable_2 = new Immutable("mumbai", mutable);

		System.out.println("Before mutating :: " + immutable_1);
		System.out.println("Before mutating :: " + immutable_2);

		// start mutating object , because here we are able to get reference for actual
		// object.
		Mutable mutable1 = immutable_1.getMutable();
		mutable1.setName("guddu");

		Mutable mutable2 = immutable_2.getMutable();
		mutable2.setName("dinesh");

		System.out.println("After mutating mutating :: " + immutable_1);
		System.out.println("After mutating mutating :: " + immutable_2);

	}

}

/**
 * Declare the class as final so it can’t be extended. Make all fields private
 * so that direct access is not allowed. Don’t provide setter methods for
 * variables Make all mutable fields final so that it’s value can be assigned
 * only once. Initialize all the fields via a constructor performing deep copy.
 * Perform cloning of objects in the getter methods to return a copy rather than
 * returning the actual object reference.
 *
 */
final class Immutable {

	private String city;

	private final Mutable mutable;

	public Immutable(String city, Mutable mutable) {
		super();
		this.city = city;
		this.mutable = mutable;
	}

	public String getCity() {
		return city;
	}

	// avoid escaping reference , because here is the problem.
	public Mutable getMutable() {
		return mutable;
	}

	@Override
	public String toString() {
		return "Immutable [city=" + city + ", mutable=" + mutable + "]";
	}

}

class Mutable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Mutable [name=" + name + "]";
	}

}