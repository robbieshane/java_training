package M3.Activities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class M3_Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> productToPriceMap = new HashMap<>();
		
		productToPriceMap.put("Pasta", 250);
		productToPriceMap.put("Ham", 500);
		productToPriceMap.put("Cheese", 95);
		productToPriceMap.put("Fruit Cocktail", 150);
		productToPriceMap.put("Heavy Cream", 75);
		
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		Scanner prodSearch = new Scanner(System.in);
		Scanner newProd = new Scanner(System.in);
		Scanner newPrice = new Scanner(System.in);
		while(!exit){
			System.out.println("Select an option:");
			System.out.println("1. Search a product");
			System.out.println("2. Add a product");
			System.out.println("3. Print all products and prices");
			System.out.println("4. Find the cheapest product");
			System.out.println("5. Exit");
			System.out.println("");
			System.out.print("> ");
			int choice = input.nextInt();
			
			String prod = "";
			switch(choice){
				case 1:
					System.out.print("\nEnter product name to search: ");
					prod = prodSearch.nextLine();
					if(productToPriceMap.containsKey(prod)) {
						System.out.println("Product found! Price: " + productToPriceMap.get(prod));
					}
					else System.out.println("Product not found!");
					break;
					
				case 2:
					System.out.print("\nEnter product name to add: ");
					String addProd = newProd.nextLine();
					System.out.print("Enter price: ");
					Integer addPrice = newPrice.nextInt();
					productToPriceMap.put(addProd, addPrice);
					System.out.println("Product added: " + addProd);
					break;
					
				case 3:
					System.out.println("All products and prices:");
					for(Map.Entry<String,Integer> products : productToPriceMap.entrySet()) {
						System.out.println(products.getKey() + " - " + products.getValue());
					}
					break;
					
				case 4:
					String cheapestProduct = null;
					Integer cheapestPrice = 99999 ;
					for(Map.Entry<String,Integer> products : productToPriceMap.entrySet()) {
						if (products.getValue() < cheapestPrice) {
							cheapestPrice = products.getValue();
							cheapestProduct = products.getKey();
						}
					}
					System.out.println("Cheapest product: " + cheapestProduct + " - " + cheapestPrice);
					break;
				
				case 5:
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
