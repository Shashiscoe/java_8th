package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(1, 1000, "Chandra Shekhar", 6000),
				new Employee(1, 1000, "Rajesh", 8000), new Employee(1, 1004, "Rahul", 9000),
				new Employee(1, 1001, "Suresh", 12000), new Employee(1, 1004, "Satosh", 8000));

		// 1. sum of salary for all the employee.

		int total = employees.stream().collect(Collectors.summingInt(Employee::getSalary));

		System.out.println("Total Employees Salary : " + total);

		total = employees.stream().collect(Collectors.summingInt(employee -> employee.getSalary()));

		System.out.println("Total Employees Salary : " + total);
	}

}
