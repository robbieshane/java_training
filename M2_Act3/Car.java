package M2.OOP1;

public class Car {
	private String owner;
	private String brand;
	private String color;
	
	public Car() {
		
	}
	public Car(String owner, String brand, String color) {
		this.owner = owner;
		this.brand = brand;
		this.color = color;
	}
	
	// setters and getters'
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwner() {
		return this.owner;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return this.brand;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return this.color;
	}
	
	public void whatCar() {
		System.out.println(this.owner + " owns a " + this.color + " " + this.brand + " car.");
	}
	
	
}
