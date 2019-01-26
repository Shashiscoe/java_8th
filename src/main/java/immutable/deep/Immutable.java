package immutable.deep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Declare the class as final so it can’t be extended. Make all fields private
 * so that direct access is not allowed. Don’t provide setter methods for
 * variables Make all mutable fields final so that it’s value can be assigned
 * only once. Initialize all the fields via a constructor performing deep copy.
 * Perform cloning of objects in the getter methods to return a copy rather than
 * returning the actual object reference.
 *
 */
final public class Immutable {

	private String city;

	private final Mutable mutable;

	private List<String> states;

	public Immutable(String city, List<String> states, Mutable mutable) {
		super();
		this.city = city;
		this.states = new ArrayList<>(states);

		// providing deep cloning
		this.mutable = new Mutable();
		this.mutable.setName(mutable.getName());
		this.mutable.setCountry(mutable.getCountry());
	}

	public String getCity() {
		return city;
	}

	// avoid escaping reference , because here is the problem.
	public Mutable getMutable() {
		return mutable;
	}

	// avoid escaping actual reference , because here is the problem. public
	List<String> getStates() {
		return states;
	}

	/*// avoid escaping actual reference , because here is the problem.
	public List<String> getStates() {
		return Collections.unmodifiableList(states);
	}*/

	@Override
	public String toString() {
		return "Immutable [city=" + city + ", mutable=" + mutable + ", states=" + states + "]";
	}

}
