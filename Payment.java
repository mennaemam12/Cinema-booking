/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.io.IOException;
import java.util.Scanner;

public abstract class Payment {
	public String paymentType;
	public static Scanner in = new Scanner(System.in);

	public abstract void confirmPayment() throws IOException;

}
