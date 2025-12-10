package M2.OOP2;


public abstract class Program {
	
	private String name;
	private boolean isRunning = false;
	
	public Program() {
		
	}
	
	public Program(String name) {
		this.name = name;
	}
	
	abstract void run();
	abstract void stop();
   
   public void setName(String name) {
	   this.name = name;
   }
   public String getName() {
	   return this.name;
   }
   public void setIsRunning(boolean isRunning) {
	   this.isRunning = isRunning;
   }
   public boolean getIsRunning() {
	   return isRunning;
   }
	
	
	
}
