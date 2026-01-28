package M6Activities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class M6_Activity2 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity2(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void runM6Activity2(EntityManager em) {
		
		try {
			em.getTransaction().begin();

			Student newStudent = new Student();
			newStudent.setName("Juan Dela Cruz");
			newStudent.setAge(50);
			newStudent.setEmail("juandelacruz@gmail.com");

			em.persist(newStudent);
			em.getTransaction().commit();
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
    		EntityManagerUtil.getInstance().shutdownFactory();
		}

	}

}
