/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cash extends Payment {
	private double totalPrice;
	private double deposit;
	private double restAmount;

	public static double depositRate;

	public static void readDepositRate() throws FileNotFoundException {
		File file = new File("Deposit Percentage.txt");
		if (file.exists()) {
			Scanner in = new Scanner(file);
			depositRate = in.nextDouble();
		}
		in.close();
	}

	@Override
	public void confirmPayment() throws IOException {
		Scanner scanner = new Scanner(new FileReader("Deposit Percentage.txt"));
		PrintWriter print = new PrintWriter(new FileWriter("Transactions.txt"));
		double depositPercentage = scanner.nextDouble();
		deposit = totalPrice * (depositPercentage / 100);
		restAmount = totalPrice - deposit;
		System.out.println("Total Price: $" + totalPrice);
		System.out.println("You have to deposit: $" + deposit);
		System.out.println("The remaining amount to be paid on entrance: $" + restAmount);
		print.println("Deposit $" + deposit + " needs to be paid.");
		print.close();
	}

	public static double calculateDeposit(double total) {
		double deposit = total * (depositRate / 100);
		return deposit;
	}

}
