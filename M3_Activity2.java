package M3.Activities;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class M3_Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> products = new HashSet<>();

		products.add("Laptop");
		products.add("Monitor");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Printer");
		
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		Scanner prodSearch = new Scanner(System.in);
		while(!exit){
			System.out.println("Select an option:");
			System.out.println("1. Search a product");
			System.out.println("2. Add a product");
			System.out.println("3. Print all products and count");
			System.out.println("4. Exit");
			System.out.println("");
			System.out.print("> ");
			int choice = input.nextInt();
			
			String prod = "";
			switch(choice){
				case 1:
					System.out.print("Enter product name to search: ");
					prod = prodSearch.nextLine();
					if(!products.contains(prod)) {
						System.out.println("Product not found!");
					}
					else System.out.println("Product found: " + prod);
					break;
					
				case 2:
					System.out.print("Enter product name to add: ");
					prod = prodSearch.nextLine();
					products.add(prod);
					System.out.println("Product added: " + prod);
					break;
					
				case 3:
					System.out.println("All products:");
					for(String produce : products) {
						System.out.println(produce);
					}
					System.out.println("Total unique products: " + products.size());
					break;
				
				case 4:
					System.out.println("Exiting...");
					exit = true;
					break;
					
				default:
					System.out.println("\nInvalid input.");
					break;
			}
			System.out.println("");
			
		}
		
	}

}
