package M2.OOP2;

public class Car extends Vehicle implements Refuelable{
	public Car(int numberOfWheels, String brand) {
		super(numberOfWheels, brand);
	}
	
	public Car() {
		
	}
	

	@Override
    public void startEngine() {
        System.out.println(getBrand() + " car engine started");
    }

    @Override
    public void refuel() {
        System.out.println(getBrand() + " car now refueled");
    }
    

}
