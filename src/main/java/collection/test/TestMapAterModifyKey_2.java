package collection.test;

import java.util.HashMap;
import java.util.Map;

public class TestMapAterModifyKey_2 {

	public static void main(String[] args) {

		Map<Person, Person> map = new HashMap<>();

		Person person = new Person("ravi", 29, "sasaram");

		map.put(person, person);

		System.out.println(" before modifying  Pesrson object by using key " + map.get(person)
				+ " ,person  hashCode :: " + map.get(person).hashCode());
		
		System.out.println(" before modifying  Pesrson object " + map + " ,person  hashCode :: " + person.hashCode());

		//modifying
		person.setAge(20);

		// hashCode will be changed, so value corresponding to this key will be null.
		System.out.println(" after modifying  Pesrson object by using key " + map.get(person));

		System.out.println(" after modifying  Pesrson object " + map + " ,person  hashCode ::" + person.hashCode());
	}

}

class Person {

	private String name;
	private int age;
	private String city;

	public Person(String name, int age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
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
		if (age != other.age)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}