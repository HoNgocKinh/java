package behaviors.iterators.java_enhance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		
		
		Set<String> set = new HashSet<>();
		set.add("Phat Ml");
		set.add("Phat Ml");
		set.add("Phat Ml1");
		set.add("Phat Ml2");
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "A");
		map.put("2", "B");
		map.put("3", "C");
		
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
//		showInfo(set.iterator());
//		showInfo(list.iterator());
		showInfo(map.entrySet().iterator());
	}
	
	private static void showInfo(Iterator<?> iterator) {
		
		iterator.forEachRemaining(System.out::println);
	}
}
