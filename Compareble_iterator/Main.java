package compare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	

	public static void main(String[] args) {
		
		List<Student> l1 = new ArrayList<Student>();
		l1.add(new Student("a" , 20, 80));
		l1.add(new Student("b" , 18, 85));
		l1.add(new Student("c" , 19, 78));
		
		/*sort by grade implements comparator in differet class*/
		Collections.sort( l1 , new My_comperator());
		
		/*sort by grade implements comparator in anunimos class*/
		Collections.sort( l1 , new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAvg() > o2.getAvg() ? 1:-1;
			}
			 
		});
		
		
		/* Iterator excersise */
		
		Student s1 = new Student("d", 23, 88);
		
		for(Integer grade : s1) {
			System.out.println(grade);
		}
	}
	
	
	

}
