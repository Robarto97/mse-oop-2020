import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Robart Petrov
 *
 */
public class Student extends Human {
	private int FN;
	private double[] marks = new double[5];
	private float average;
	private final String space = "\s";
	private final String tab = "\t";
	List<Student> students;
	
	public Student() {
		students = new ArrayList<Student>();
	}
	
	public int getFN() {
		return FN;
	}
	public void setFN(int fN) {
		FN = fN;
	}
	public double[] getMarks() {
		return marks;
	}
	public void setMarks(double[] marks) {
		this.marks = marks;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	
	public boolean addStudent(Student student) {
		return this.students.add(student);
	}
	
	/**
	 * Calculating the average marks for every student
	 * 
	 * @return
	 */
	public float AverageMark() {
		int count = 0;
		float sum = 0;
		for (int i = 0; i < marks.length; i++) {
			if (marks[i] > 0) {
				count++;
				sum += marks[i];
			}
		}
		average = sum / count ;
		return average;
	}
	
	/**
	 * Convert the data to String
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getFirstName()).append(space);
		builder.append(this.getLastName()).append(tab);
		builder.append(this.getEGN()).append(tab);
		builder.append(this.getHeight()).append(tab);
		builder.append(this.getWeight()).append(tab);
		builder.append(this.getFN()).append(tab);
		String scores = "";
		for (int i=0; i<marks.length; i++) {
			scores += marks[i] + space;
		}
		builder.append(scores).append(tab);
		builder.append(this.getLength()).append(tab);
		builder.append(this.getWidth()).append(tab);

		return builder.toString();
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	/**
	 * Print the data in file
	 * @param path
	 */
	public void studInfoToFile(String path) {
		try {
			@SuppressWarnings("resource")
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, false), "UTF-8"));
			final String[] stud = new String[] { "" };
			this.getStudents().forEach(student -> {
				String stringdata = student.toString();
				stud[0] += stringdata + "\n";
			});
			writer.write(stud[0]);
			writer.flush();
		} catch (Exception e) {
			throw new RuntimeException("File write failed.", e);
		}
	}
	
}
