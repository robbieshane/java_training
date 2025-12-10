package M2.OOP2;

public abstract class Vehicle {
	private int numberOfWheels;
	private String brand;
	
	public Vehicle() {
		
	}
	public Vehicle(int numberOfWheels, String brand) {
		this.numberOfWheels = numberOfWheels;
		this.brand = brand;
	}
	
	// abstract method
	abstract void startEngine();
	
	// concrete method
	public void destroy() {
        System.out.println("Vehicle now destroyed");
    }

	
	// getters and setters
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	public int getNumberOfWheels() {
		return this.numberOfWheels;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return this.brand;
	}
	
}
