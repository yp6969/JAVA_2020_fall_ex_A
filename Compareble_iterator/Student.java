package compare;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Student implements Comparable<Student> , Iterable<Integer>{
	
	private String name;
	private int avg;
	private int age;
	private List<Integer> grade_list = new ArrayList<Integer>();
	
	
	public Student(String name , int age , int avg) {
		this.name = name;
		this.age = age;
		this.avg = avg;
		
		grade_list.add(80);
		grade_list.add(75);
		grade_list.add(95);
		grade_list.add(87);
		grade_list.add(60);
		Collections.sort(grade_list);
	
	}
	
	/* compare by age */
	@Override
	public int compareTo(Student s) {
		return age > s.getAge()? 1:-1;
	}


	
	/* Anonymous class iterator to grade list
	 * implement the for loop 
	 * 
	 * for( Integer grade : (Student)s1 )     
	 */
	
	@Override
	public Iterator<Integer> iterator() {
		
		Iterator<Integer>c = new Iterator<Integer>() {
		
			int indx = 0;
			
			@Override
			public boolean hasNext() {
				
				return indx < grade_list.size();
			}

			@Override
			public Integer next() {
				
				return grade_list.get(indx++);
			}
			
		};
		return c;
		
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAvg() {
		return avg;
	}



	public void setAvg(int avg) {
		this.avg = avg;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}


	
	
}

