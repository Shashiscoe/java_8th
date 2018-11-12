package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenCollection {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		System.out.println("numbers :: " + numbers);

		// with java 1.8 stream

		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		System.out.println("evenNumbers ::with stream concept -- " + evenNumbers);

		// before java 8 same we can get by using

		List<Integer> oddNumbers = new ArrayList<Integer>();

		for (Integer number : numbers) {
			if (number % 2 != 0) {
				oddNumbers.add(number);
			}
		}

		System.out.println("oddNumbers  :: without stream concept --" + oddNumbers);
	}

}
