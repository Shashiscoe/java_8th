package collection.test;

import java.util.HashMap;
import java.util.Map;

public class TestMapAterModifyKey_1 {

	public static void main(String[] args) {

		Map<Person1, Person1> map = new HashMap<>();

		Person1 person = new Person1("ravi", 29, "sasaram");

		map.put(person, person);

		System.out.println(" before modifying  Pesrson object by using key " + map.get(person)
				+ " ,person  hashCode :: " + map.get(person).hashCode());

		System.out.println(" before modifying  Pesrson object " + map + " ,person  hashCode :: " + person.hashCode());

		// modifying
		person.setAge(20);

		// hashCode will not be changed , it remains same, so value corresponding to
		// this key will updated value. it call hascode() of object class that is native
		// API, which calculate hashCode on the basis of memory location.
		System.out.println(" after modifying  Pesrson object by using key " + map.get(person) + " ,person  hashCode :: "
				+ map.get(person).hashCode());

		
		//But in both the case map contains updated value, because we are changing the same object.
		System.out.println(" after modifying  Pesrson object " + map + " ,person  hashCode ::" + person.hashCode());
	}

}

class Person1 {

	private String name;
	private int age;
	private String city;

	public Person1(String name, int age, String city) {
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
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}