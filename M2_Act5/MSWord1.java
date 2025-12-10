package M2.OOP2;


public class MSWord1 extends Program {
	
	public MSWord1(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		System.out.println("Opening MS Word...");
		this.setIsRunning(true);
	}
	
	@Override
	public void stop() {
		System.out.println("Stopping MS Word...");
        this.setIsRunning(false);
	}
}
