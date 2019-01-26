package immutable.deep;

import java.util.ArrayList;
import java.util.List;

public class DeepCopyTest {

	public static void main(String[] args) {

		Mutable mutable = new Mutable();
		mutable.setName("ravi");
		mutable.setCountry("India");

		List<String> states = new ArrayList<>();
		states.add("Bihar");
		states.add("UP");

		Immutable immutable_1 = new Immutable("delhi", states, mutable);
		Immutable immutable_2 = new Immutable("mumbai", states, mutable);

		System.out.println("Before mutating :: " + states);
		System.out.println("Before mutating :: " + mutable);
		System.out.println("Before mutating :: " + immutable_1);
		System.out.println("Before mutating :: " + immutable_2);

		// start mutating object , because here we are able to get reference for actual
		// object.
		Mutable mutable1 = immutable_1.getMutable();
		mutable1.setName("guddu");

		Mutable mutable2 = immutable_2.getMutable();
		mutable2.setName("dinesh");

		// modified list

		immutable_1.getStates().set(0, "Bangal");

		System.out.println("====================================================");

		System.out.println("Before mutating :: " + states);
		System.out.println("After mutating :: " + mutable);
		System.out.println("After mutating mutating :: " + immutable_1);
		System.out.println("After mutating mutating :: " + immutable_2);

	}

}
