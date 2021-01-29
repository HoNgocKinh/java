package test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static Predicate<Point> OUT_OF_RANGE = (p) -> {
		return p.x >= 8 || p.y >= 8 || p.x < 0 || p.y < 0; 
	};
	
	public static void main(String[] args) {
		
//		List<Point> pieces = new ArrayList<>();
//		pieces.add(new Point(0,0));
//		pieces.add(new Point(1,1));
//		pieces.add(new Point(2,2));
//		pieces.add(new Point(3,3));
//		pieces.add(new Point(4,4));
//		pieces.add(new Point(5,5));
		
		List<Integer> list1  = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		List<Integer> list2  = new ArrayList<>();
		list2.add(4);
		
		list2.add(5);
		list2.add(6);
		
		List<Integer> list3 = Stream.of(list1, list2).flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(list3);
		
//		Optional<Point> p1 = pieces.stream().filter(p -> p.x == 3)
//						.findFirst()
//						.filter(p -> p.y == 2)
//						.orElseGet(() -> );
		
//		System.out.println(p1);
	}
}
