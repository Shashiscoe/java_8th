package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import stream.Employee;

public class EmployeeTest {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(1, 1000, "Chandra Shekhar", 13000),
				new Employee(1, 1000, "Rajesh", 8000), new Employee(1, 1004, "Rahul", 9000),
				new Employee(1, 1001, "Suresh", 22000), new Employee(1, 1004, "Satosh", 8000));

		// 1. sum of salary for all the employee.

		int total = employees.stream().collect(Collectors.summingInt(Employee::getSalary));

		System.out.println("Total Employees Salary : " + total);

		total = employees.stream().collect(Collectors.summingInt(employee -> employee.getSalary()));

		System.out.println("Total Employees Salary : " + total);

		// 2. find the sum of salary for department 10000.

		int sumOfSalByDept = employees.stream().filter(employee -> employee.getDeptId() == 1000)
				.collect(Collectors.summingInt(Employee::getSalary));

		System.out.println("Total Employees Salary  for department id 10000: " + sumOfSalByDept);

		// 3. find the min and max salary for employee.

		// get employee with minimum income
		Employee employee = employees.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getSalary)))
				.get();
		System.out.println("Employee with minimum Salary " + employee);

		// get employee with maximum income
		employee = employees.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))).get();
		System.out.println("Employee with maximum Salary " + employee);

		// get employee with minimum income using lemda expression
		employee = employees.stream().collect(Collectors.minBy((e1, e2) -> e1.getSalary() - e2.getSalary())).get();
		System.out.println("Employee with minimum Salary " + employee);

		// get employee with maximum income using lemda expression
		employee = employees.stream().collect(Collectors.maxBy((e1, e2) -> e1.getSalary() - e2.getSalary())).get();
		System.out.println("Employee with maximum Salary " + employee);

		// 4. find the max employee salary for each department.
		Map<Integer, Employee> employeesMaxSalByDep = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.collectingAndThen(
						Collectors.maxBy((e1, e2) -> e1.getSalary() - e2.getSalary()), Optional::get)));

		System.out.println("Employee max salory by depID :: " + employeesMaxSalByDep);
	}

}
