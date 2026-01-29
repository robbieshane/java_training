package M6Activities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "name", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
		private String name;

		@Column(name = "age", columnDefinition = "INT")
		private int age;

		@Column(name = "email", unique = true, length = 100, columnDefinition = "VARCHAR(100)")
		private String email;
		
		@OneToMany(mappedBy = "student")
		private List<Course> courses;
		
		// setters
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public void setEmail(String email) {
			this.email = email;
		} 
		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
		
		// getters
		public String getName() {
			return this.name;
		}
		public int getAge() {
			return this.age;
		}
		public String getEmail() {
			return this.email;
		}
		public List<Course> getCourses() {
			return courses;
		}

}

