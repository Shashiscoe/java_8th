package collection.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {

	
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		map.put("A", "ravi");
		map.put("B", "raj");
		map.put("C", "mukesh");
		map.put("D", "ankit");
		map.put("K", "mohit");
		map.put("P", "vimal");

		List<Map.Entry<String, String>> entries = new LinkedList<>(map.entrySet());

		entries.sort((Map.Entry<String, String> e1, Map.Entry<String, String> e2) -> {
			return e1.getValue().compareTo(e2.getValue());
		});

		System.out.println(entries);

		LinkedHashMap<String, String> sortedMap = entries.stream().collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap<String, String>::new));

		System.out.println(sortedMap);

	}

}
