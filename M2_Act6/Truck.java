package M2.OOP2;

public class Truck extends Vehicle implements Refuelable{
	public Truck(int numberOfWheels, String brand) {
		super(numberOfWheels, brand);
	}
	
	public Truck() {
		
	}
	
	@Override
    public void startEngine() {
        System.out.println(getBrand() + " truck engine started");
    }

    @Override
    public void refuel() {
        System.out.println(getBrand() + " truck now refueled");
    }

}
