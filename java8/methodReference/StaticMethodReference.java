package methodReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StaticMethodReference {	
	//create static method to compare with name
	public static int compareByName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}	
	//create static method to compare with age
	public static int compareByAge(Person a, Person b) {
		return a.getAge().compareTo(b.getAge());
	}	
	public static void main(String[] args) {		
		//create a list of person
		List<Person> personList=Arrays.asList(new Person("Vinay",25),new Person("Raju",35),new Person("Aman",20));		
		System.out.println("Sort by name: ");	
		//sort array by name using static method reference
		Collections.sort(personList,StaticMethodReference::compareByName);		
		// Using streams over above object of Person type
		personList.stream().map(x->x.getName()).forEach(System.out::println);		
		System.out.println("Sort by age: ");		
		//sort array by name using static method reference
		Collections.sort(personList,StaticMethodReference::compareByAge);	
		// Using streams over above object of Person type
		personList.stream().map(x->x.getName()).forEach(System.out::println);		
	}
}
