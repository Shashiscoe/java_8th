package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {

	public static void main(String[] args) {
		// creating a list of Strings
		List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

		// The lambda expression passed to
		// reduce() method takes two Strings
		// and returns the the longer String.
		// The result of the reduce() method is
		// an Optional because the list on which
		// reduce() is called may be empty.
		Optional<String> longestString = words.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

		// Displaying the longest String
		longestString.ifPresent(System.out::println);

		// Creating list of integers
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

		// Finding sum of all elements
		int sum = nums.stream().reduce(0, (num1, num2) -> num1 + num2);

		// Displaying sum of all elements
		System.out.println("The sum of all elements is " + sum);

		Optional<Integer> max = nums.stream().reduce((num1, num2) -> num1 > num2 ? num1 : num2);

		max.ifPresent(System.out::println);
	}

}
