/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Credit extends Payment {
	private String cardName;
	private int cardNumber;
	private String expiryDate;
	private int securityCode;

	@Override
	public void confirmPayment() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Card Name:");
		cardName = scanner.nextLine();
		System.out.println("Enter card Number:");
		cardNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter expiry date:");
		expiryDate = scanner.nextLine();
		System.out.println("Enter security code:");
		securityCode = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Payment is successfull.");
		PrintWriter write = new PrintWriter(new FileWriter("Transactions.txt"));
		write.println("Fully paid.");
		write.close();

		scanner.close();
	}

	public static boolean validateCard(String cardName, String cardNumber, String expiryDate, String secCode) {
		if (!cardName.contains(" ")) {
			return false;
		}
		if (cardNumber.length() < 16 && !(cardNumber.charAt(4) == ' ') && !(cardNumber.charAt(9) == ' ')
				&& !(cardNumber.charAt(14) == ' '))
			return false;
		if (!(expiryDate.charAt(2) == '/'))
			return false;
		if (secCode.length() < 3)
			return false;
		return true;
	}
}
