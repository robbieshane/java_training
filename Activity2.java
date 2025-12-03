package com.bpi.hello;

import java.util.Scanner;

public class M1_Activity2 {

	public static void main(String[] args) {
		// Activity 2
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your age: ");
		String age = input.nextLine();
		int inAge = Integer.parseInt(age);
		double dbAge = inAge;
		System.out.println("Your age as int: " + inAge);
		System.out.println("Your age as double: " + dbAge);
		// end of Activity 2
	}

}
