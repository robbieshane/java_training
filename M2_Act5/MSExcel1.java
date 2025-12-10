package M2.OOP2;


public class MSExcel1 extends Program{
	
	public MSExcel1(String name) {
		this.setName(name);
	}
	public MSExcel1() {
		
	}
	
	@Override
	public void run() {
		String message = "Opening MS Excel...";
        this.setIsRunning(true);
		
		System.out.println(message);
	}
	
	@Override
	public void stop() {
		String message = "Stopping MS Excel...";
        this.setIsRunning(false);
		
		System.out.println(message);
	}
}
