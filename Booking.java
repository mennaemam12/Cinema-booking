/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;
import java.util.ArrayList;
import java.util.Date;

public class Booking {
	public String custUsername;
	public String movieName;
        public String hallName;
	public Date timing;
	public ArrayList<String> reservedSeats = new ArrayList<>();
	public double total;
	public String paymentMethod;
	public double deposit = 0.0;
        public boolean depPaid=false;

}

