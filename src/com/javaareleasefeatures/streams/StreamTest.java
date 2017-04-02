package com.javaareleasefeatures.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest {

	private List<String> peopleArray = Arrays.asList("david", "kevin", "john", "eoin", "linda", "sophie", "meg", "dan", "debbie" );
	private int[] numArray = {12,3,45,6789,123,45,69,87,6,543,2,132,5,41,5,5,5,5,67,984,6,51};
	
	public static void main(String[] args) {
		new StreamTest().testStream();
	}
	
	public void testStream(){
		//skip first 10 ints and return the unique ints left
		int[] resultArray = Arrays.stream(numArray).skip(10).distinct().toArray();
		
		//perform stream operation on list of strings to (1)filter names beginning with "d", (2)store them in a map while changing them to uppercase, (3)sort & (4)then print
		System.out.println("\nusing stream to filter names starting with 'd', map to UPPERCASE, sort and then print");
		peopleArray
			.stream()
			.filter(s -> s.startsWith("d"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
		
		//print each element in a list, from a stream
		System.out.println("\nprinting each element in a list using a stream");
		peopleArray.stream().forEach(x -> System.out.println(x));
		
		//create a map, store entries and then print each entry
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1st value");
		map.put(2, "2nd value");
		map.put(3, "3rd value");
		map.put(4, "4th value");
		map.put(5, "5th value");
		System.out.println("\nuse stream to print each entry in a map");
		map.entrySet().forEach(x -> System.out.println(x));
		
		System.out.println("\nuse 'Stream.of()' to print each element in int array");
		Stream.of(peopleArray).forEach(x -> System.out.println(x));
	}

}
