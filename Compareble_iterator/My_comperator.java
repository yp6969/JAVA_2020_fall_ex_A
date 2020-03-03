package compare;

import java.util.Comparator;

public class My_comperator implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getAvg() > s2.getAvg() ? 1:-1;
	}
	
}
