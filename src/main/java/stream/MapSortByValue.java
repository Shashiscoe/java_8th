package stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapSortByValue {

	public static void main(String[] args) {

		final Map<String, Integer> map = new HashMap<>();
		map.put("usa", 100);
		map.put("jobs", 200);
		map.put("software", 50);
		map.put("technology", 70);
		map.put("opportunity", 200);

		// sorting by key

		final Map<String, Integer> treMap = new TreeMap<>(map);

		treMap.forEach((k, v) -> System.out.println("treMap :: key :: " + k + " , value ::" + v));

		// sorting by value

		List<Map.Entry<String, Integer>> entrys = new LinkedList<>(map.entrySet());
		entrys.sort((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));

		final Map<String, Integer> sortedMapByValue = new LinkedHashMap<>();

		for (Entry<String, Integer> entry : entrys) {

			sortedMapByValue.put(entry.getKey(), entry.getValue());
		}

		sortedMapByValue.forEach((k, v) -> System.out.println("sortedMapByValue :: key :: " + k + " , value ::" + v));

		final Map<String, Integer> sortedMapByValue1 = entrys.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		sortedMapByValue1.forEach((k, v) -> System.out.println("sortedMapByValue1 :: key :: " + k + " , value ::" + v));

		final Map<String, Integer> sortedMapByValuedsc = map.entrySet().stream()
				.sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		sortedMapByValuedsc.forEach((k, v) -> System.out.println("sortedMapByValuedsc :: key :: " + k + " , value ::" + v));
		
		
		final Map<String, Integer> sortedMapByValueAsc = map.entrySet().stream()
				.sorted((Map.Entry.<String, Integer>comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		sortedMapByValueAsc.forEach((k, v) -> System.out.println("sortedMapByValueAsc :: key :: " + k + " , value ::" + v));

	}

}
