package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		numbers.forEach(System.out::print);

		numbers.forEach(item -> System.out.print(item));

		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> System.out.println("key : " + k + " value : " + v));

		items.forEach((k, v) -> {
			System.out.println("key : " + k + " value : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});

	}

}
