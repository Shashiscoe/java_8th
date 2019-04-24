package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		Employee employee1 = new Employee(1, "ravi", "CS", 500, "india", "bihar", "sasaram");
		Employee employee2 = new Employee(2, "ravi", "CS", 500, "india", "bihar", "sasaram");
		Employee employee3 = new Employee(3, "ravi", "IT", 600, "india", "bihar", "sasaram");
		Employee employee4 = new Employee(4, "ravi", "IT", 600, "india", "bihar", "sasaram");
		Employee employee5 = new Employee(5, "ravi", "CS", 500, "US", "bihar", "sasaram");
		Employee employee6 = new Employee(6, "ravi", "CS", 500, "US", "bihar", "sasaram");
		Employee employee7 = new Employee(7, "ravi", "IT", 600, "US", "bihar", "sasaram");
		Employee employee8 = new Employee(8, "ravi", "IT", 600, "US", "bihar", "sasaram");

		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);

		employees.add(employee5);
		employees.add(employee6);
		employees.add(employee7);
		employees.add(employee8);

		
	}

}

class Employee {

	private int id;
	private String name;
	private String dep;
	private double salory;
	private String country;
	private String state;
	private String city;

	public Employee(int id, String name, String dep, double salory, String country, String state, String city) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
		this.salory = salory;
		this.country = country;
		this.state = state;
		this.city = city;
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

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public double getSalory() {
		return salory;
	}

	public void setSalory(double salory) {
		this.salory = salory;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
