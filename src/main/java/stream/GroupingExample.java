package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {

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

		Map<Integer, List<Employee1>> employeeGrp = employees.stream()
				.collect(Collectors.groupingBy(Employee1::getDeptId));

		System.out.println("show list oe employee details in each department :: " + employeeGrp);

		Map<Integer, Long> employeeCountPerGrp = employees.stream()
				.collect(Collectors.groupingBy(Employee1::getDeptId, Collectors.counting()));

		System.out.println("count number of employee in each department " + employeeCountPerGrp);
		
		
		

	}

}
