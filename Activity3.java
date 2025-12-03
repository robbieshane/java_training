package com.bpi.hello;

import java.util.Scanner;

public class M1_Activity3 {
	public static int add(int one, int two) {
		return one + two;
	}
	public static int subtract(int one, int two) {
		return one - two;
	}
	public static int multiply(int one, int two) {
		return one * two;
	}
	
	public static void main(String[] args) {
		// Activity 3
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first integer: ");
		int first = input.nextInt();
		System.out.print("Enter second integer: ");
		int second = input.nextInt();
		//int sum = first + second;
		//int diff = first - second;
		//int prod = first * second;
		//System.out.println("Sum: " + sum);
		//System.out.println("Difference: " + diff);
		//System.out.println("Product: " + prod);
		System.out.println("Sum: " + add(first,second));
		System.out.println("Difference: " + subtract(first,second));
		System.out.println("Product: " + multiply(first,second));
		// end of Activity 3

	}

}
