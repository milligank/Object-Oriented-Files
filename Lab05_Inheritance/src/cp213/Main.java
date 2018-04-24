package cp213;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Testing class in simple example of inheritance / polymorphism.
 *
 * @author kathleen milligan
 * @version 2017-06-09
 */
public class Main {

    public static void main(final String[] args) {

	// Create examples of Person, Student, Professor,
	// InstructionalAssistant.
	final Person person1 = new Person("Snord", "Cranston");
	final Student student1 = new Student("Sharma", "Priyanka", "7384737");
	final Professor prof1 = new Professor("Hakim", "Abdul", "History");
	final InstructionalAssistant ia1 = new InstructionalAssistant("Chin",
		"Li-meng", "9857478", "CP213");
	final CAS term = new CAS("McGarrity", "Ivan", "English", "201709");
	

	// Defines an unsorted list of Person objects. (Uses generics).
	final ArrayList<Person> people = new ArrayList<Person>();
	final ArrayList<CAS> teachers = new ArrayList<CAS>();

	// Add all above to the list of Person objects. Shows polymorphism -
	// since all have base class of Person, we are allowed to store all of
	// them in the same list.
	people.add(person1);
	people.add(student1);
	people.add(prof1);
	people.add(ia1);
	people.add(term);
	
	teachers.add(person1);
	teachers.add(student1);
	teachers.add(prof1);
	teachers.add(ia1);
	teachers.add(term);

	System.out.println("People:");
	System.out.println();

	for (final Person person : people) {
	    // Again shows polymorphism - calls print() appropriate to actual
	    // object type, not just Person print().
	    person.print();
	    System.out.println();
	}
	System.out.println("-----------------");
	// Defines a sorted set of Person objects. Sorted according to Person
	// compareTo method - sort applies to all child classes.
	final TreeSet<Person> set = new TreeSet<Person>();
	set.addAll(people);

	System.out.println("Sorted People:");
	System.out.println();

	for (final Person person : set) {
	    // Print all objects in sorted order by name.
	    person.print();
	    System.out.println();
	}
	
	for (final Person teacher : teachers) {
        teacher.print();
        System.out.println();
    }
    
   
    }
}
