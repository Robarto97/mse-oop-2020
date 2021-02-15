
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSys {

	@Test
	public void testLargeness() {
		Human student = new Student();
		student.setLargeness(140, 181.5, 50.0, 75.0);
		assertTrue(student.getHeight()>0 && student.getLength()>0 && student.getWeight()>0 && student.getWidth()>0);
	}
	
	@Test
	public void testStudentAverageScoreCalculator() {
		Student student = new Student();
		double[] marks = new double[] { 2, 3, 4, 5, 6 };
		student.setMarks(marks);
		assertEquals(4, student.AverageMark(), 0);
	}
}
