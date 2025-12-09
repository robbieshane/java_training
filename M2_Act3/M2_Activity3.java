package M2.OOP1;

public class M2_Activity3 {

	public static void main(String[] args) {
		Car boy = new Car();
		Car girl = new Car("Princess","Chevrolet","red");
		
		boy.setOwner("Robbie");
		boy.setBrand("Honda");
		boy.setColor("black");
		
		String carBrand = girl.getBrand();
		System.out.println("The brand of her is car is " + carBrand);
		
		boy.whatCar();
		girl.whatCar();

	}

}
