package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DistinctExample {

	public static void main(String[] args) {

		Employee1 employee1 = new Employee1(1, 101, "ravi", 600);
		Employee1 employee2 = new Employee1(2, 101, "ravi", 700);
		Employee1 employee3 = new Employee1(3, 102, "amit", 800);
		Employee1 employee4 = new Employee1(4, 102, "amit", 900);

		List<Employee1> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);

		System.out.println("unique employee by name " + employees.stream().distinct().collect(Collectors.toList()));
		System.out.println("unique employee by name count " + employees.stream().distinct().count());

	}

}

class Employee1 {
	private int id;
	private int deptId;
	private String name;
	private int salary;

	public Employee1(int id, int deptId, String name, int salary) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getDeptId() {
		return deptId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", deptId=" + deptId + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Employee1 other = (Employee1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
