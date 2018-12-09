package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapTest {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "ravi_1", "delhi_1"));
		persons.add(new Person(2, "ravi_2", "delhi_2"));
		persons.add(new Person(3, "ravi_3", "delhi_3"));
		persons.add(new Person(4, "ravi_4", "delhi_4"));
		persons.add(new Person(5, "ravi_5", "delhi_5"));

		Map<Integer, String> map1 = persons.stream().collect(Collectors.toMap(Person::getId, Person::getName));

		Map<Integer, String> map2 = persons.stream()
				.collect(Collectors.toMap(person -> person.getId(), person -> person.getAddress()));

		map1.forEach((k, v) -> System.out.println("map1 :: key :: " + k + ", value :: " + v));
		map2.forEach((k, v) -> System.out.println("map2 :: key :: " + k + ", value :: " + v));

	}

}

class Person {

	private int id;
	private String name;
	private String address;

	public Person(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
