package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DoubleValueCollection {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		System.out.println("numbers :: " + numbers);

		// with java 1.8 stream

		List<Integer> doubleNumbersSt = numbers.stream().map(n -> n * 2).collect(Collectors.toList());

		System.out.println("doubleNumbersSt ::double value with stream concept -- " + doubleNumbersSt);

		// before java 8 same we can get by using

		List<Integer> doubleNumbers = new ArrayList<Integer>();

		for (Integer number : numbers) {

			doubleNumbers.add(number * 2);

		}

		System.out.println("doubleNumbers  :: double value stream concept --" + doubleNumbers);
	}

}
