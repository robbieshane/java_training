package M6Activities;

import jakarta.persistence.EntityManager;

public class M6_Activity1 {
	
	public static void main(String[] args) {
		testConnection();
   }
   
   static void testConnection() {
    	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
    	try {
    		if(em.isOpen()) {
    			System.out.println("entity manager open, ready to create transaction");
    		}
    		
    	} finally {
    		EntityManagerUtil.getInstance().closeEntityManager(em);
    		EntityManagerUtil.getInstance().shutdownFactory();
    	}
  }

}
