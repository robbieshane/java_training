package M3.Activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class M3_Activity1 {

	public static void main(String[] args) {
		List<String> products = new ArrayList<>(Arrays.asList("Laptop", "Mouse", "Keyboard", "Monitor", "Printer"));
		
		System.out.println("All products:");
		for(int i=0; i<products.size(); i++) {
			System.out.println(i+1 + ". " + products.get(i));
		}
		
		products.add("Webcam");
		products.remove("Mouse");
		
		System.out.println("\nAfter adding and removing products:");
		for(int i=0; i<products.size(); i++) {
			System.out.println(i+1 + ". " + products.get(i));
		}
		
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter product name to search: ");
		String prodSearch = input.nextLine();
		if (!products.contains(prodSearch)) {
			System.out.println("Product not found.");
		}
		else System.out.println("Product found: " + prodSearch);
		
	}

}
