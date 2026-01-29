package M6Activities;

import jakarta.persistence.EntityManager;

public class M6_Activity3 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			persistOneToMany(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}

	}
	
	static void runBidirectional(EntityManager em) {

		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 1L);
		
		student.getCourses().forEach(course -> System.out.print(course.getCourseName()));
		
		em.getTransaction().commit();
	}

	static void persistOneToMany(EntityManager em) {
		
		em.getTransaction().begin();
				
		Student student1 = em.find(Student.class, 6L);
				
		Course newCourse = new Course();
		newCourse.setCourseName("Math");
		newCourse.setGrade("80");
		newCourse.setStudent(student1);
		em.persist(newCourse);
		
		Course newCourse1 = new Course();
		newCourse1.setCourseName("English");
		newCourse1.setGrade("82");
		newCourse1.setStudent(student1);
		em.persist(newCourse1);
		
		em.getTransaction().commit();


	}

}
