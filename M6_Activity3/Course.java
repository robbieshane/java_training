package M6Activities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "course_name", columnDefinition = "VARCHAR(50)", length = 50)
	private String courseName;
	
	@Column(name = "grade", columnDefinition = "VARCHAR(2)", length = 2)
	private String grade;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	// setters
	public void setID(long id) {
		this.id = id;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	// getters
	public long getID() {
		return this.id;
	}
	public String getCourseName() {
		return this.courseName;
	}
	public String getGrade() {
		return this.grade;
	}
	public Student getStudent() {
		return this.student;
	}
}
