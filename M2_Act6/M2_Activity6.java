package M2.OOP2;

public class M2_Activity6 {

	public static void main(String[] args) {
		Car car = new Car(4, "Toyota");
		Truck truck = new Truck(10, "Isuzu");
		
		// car
		car.startEngine();
		car.refuel();
		destroyVehicle(car);
		
		System.out.println("");
		
		// truck 
		truck.startEngine();
		truck.refuel();
		destroyVehicle(truck);
		
	}
	
	private static void destroyVehicle(Vehicle vehicle) {
		vehicle.destroy();
	}
}
