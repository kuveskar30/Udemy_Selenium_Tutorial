package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreamsTutorial {
public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>(Arrays.asList("Rahul","ab","kiran","Bob","Ram","Raghu","Disha"));
		//there is no life for intermediate op if there is no terminal op
		//terminal op will execute only if intermediate op(filter) returns true
		//filter gives subset of results
		//we can create stream
		//how to use filter in stream api
		long count = names.stream().filter(s ->s.startsWith("R")).count();
		  
		System.out.println(count);
		
		long count2 = Stream.of("Rahul","ab","kiran","Bob","Ram","Raghu","Disha").filter(s ->{
			s.startsWith("R");
			return false;//it will return 0 as output
//			return true;//it is counting all names
			}).count();
		System.out.println(count2);
		System.out.println("*****");
		//print with length>4 and limit to 2 results
		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		System.out.println("*****");
		//print with last letter b and convert to uppercase
		names.stream().filter(s->s.endsWith("b")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("*****");
		//sort covert to uppercase and print
		List<String> names1 = Arrays.asList("Rahul","ab","kiran","Bob","Ram","Raghu","Disha");
		names1.stream().filter(s->s.startsWith("R")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("*****");
		names1.stream().filter(s->s.startsWith("R")).sorted().map(s->s.toLowerCase()).forEach(s->System.out.println(s));
		System.out.println("*****");
		//merging 2 different lists
		Stream<String> new_stream = Stream.concat(names.stream(), names1.stream());
//		new_stream.sorted().forEach(s->System.out.println(s));
		//after modification on stream we can't perform further operation on stream
		System.out.println("*****");
		boolean flag = new_stream.anyMatch(s->s.equalsIgnoreCase("ram"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		System.out.println("*****");
		//take list convert to stream perform operation again convert result to list
		List<String> ls = Stream.of("Rahul","ab","kiran","Bob","Ram","Raghu","Disha").filter(s->s.startsWith("R"))
		.collect(Collectors.toList());
		
		System.out.println(ls);
		//sorted unique values
		List<Integer> values = Arrays.asList(1,5,2,2,6,8,6,4,9,4);
		values.stream().sorted().distinct().forEach(s->System.out.println(s));
	}

}
