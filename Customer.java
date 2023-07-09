/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import javafx.scene.control.ToggleButton;

public class Customer extends User implements Serializable{

	Scanner in = new Scanner(System.in);

	public static void fillTicketPrices() throws FileNotFoundException, IOException {
		File file = new File("Ticket Prices.txt");
		if (file.exists()) {
			Scanner readTicket = new Scanner(file);
			while (readTicket.hasNextDouble()) {
				Ticket.silverPrice = readTicket.nextDouble();
				Ticket.goldPrice = readTicket.nextDouble();
				Ticket.platinumPrice = readTicket.nextDouble();
			}
			readTicket.close();
		}

	}

	public static void displayHall(Hall hall, ToggleButton[][] seats) {

		for (int i = 0; i < hall.rows; i++) {
			for (int j = 0; j < hall.columns; j++) {
				seats[i][j] = new ToggleButton();
				seats[i][j].setText(hall.seats[i][j].seatName);
			}
			System.out.println();
		}
	}

	public static ArrayList<Movie> getAvailMovies() {
		ArrayList<Movie> availMovies = new ArrayList<>();
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).inShow.equals("true"))
				availMovies.add(movies.get(i));
		}
		return availMovies;
	}

	public void search() throws FileNotFoundException, IOException, ParseException {
		System.out.println("Enter movie name: ");
		String name = in.nextLine();
		Showing myShow = new Showing();
		boolean found = false;
		for (int i = 0; i < showings.size(); i++) {
			if (showings.get(i).movie.movieName.equals(name)) {
				found = true;
				System.out.println("Movie Genre: " + showings.get(i).movie.movieGenre);
				break;
			}
		}
		if (!found) {
			System.out.println("Movie is currently not available.");
		}

	}

	public static Booking book(ArrayList<String> selectedSeats, Showing myShow, double total,String payMethod) {
		Booking booking = new Booking();
		booking.custUsername = User.currUser.username;
		booking.movieName = myShow.movie.movieName;
                booking.hallName=myShow.hall.hallName;
		booking.total = total;
                booking.paymentMethod=payMethod;
		booking.timing = myShow.timing;
		for (int i = 0; i < myShow.hall.rows; i++) {
			for (int j = 0; j < myShow.hall.columns; j++) {
				if (selectedSeats.contains(myShow.hall.seats[i][j].seatName)) {
					myShow.hall.seats[i][j].isReserved = "true";
					myShow.seatsReserved++;
					if (myShow.seatsReserved == myShow.hall.rows * myShow.hall.columns)
						myShow.isFull = "true";
					booking.reservedSeats.add(myShow.hall.seats[i][j].seatName);
				}
			}
		}
		for (int i = 0; i < showings.size(); i++) {
			if (myShow.movie.movieName.equals(showings.get(i).movie.movieName)
					&& myShow.timing.equals(showings.get(i).timing)) {
				showings.remove(showings.get(i));
				showings.add(myShow);
			}
		}
		return booking;

	}

	public static void printBookings() throws FileNotFoundException {
		PrintWriter write = new PrintWriter("Bookings.txt");
		for (int i = 0; i < bookings.size(); i++) {
			write.println(bookings.get(i).custUsername);
			write.println(bookings.get(i).movieName);
                        write.println(bookings.get(i).hallName);
			write.println(bookings.get(i).total);
			write.println(bookings.get(i).paymentMethod);
			write.println(bookings.get(i).deposit);
                        write.println(bookings.get(i).depPaid);
			write.println(bookings.get(i).timing);
			write.println(bookings.get(i).reservedSeats.size());
			for (int j = 0; j < bookings.get(i).reservedSeats.size(); j++)
				write.println(bookings.get(i).reservedSeats.get(j));
		}
		write.close();
	}

	public static void fillBookingsArray() throws IOException, FileNotFoundException, ParseException {
		File file = new File("Bookings.txt");
		if (file.exists()) {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				Booking book = new Booking();
				book.custUsername = in.nextLine();
				book.movieName = in.nextLine();
                                book.hallName=in.nextLine();
				book.total = Double.parseDouble(in.nextLine());
				book.paymentMethod = in.nextLine();
				book.deposit = Double.parseDouble(in.nextLine());
                                book.depPaid=Boolean.parseBoolean(in.nextLine());

				String stringdate = in.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
				Date date = sdf.parse(stringdate);
				book.timing = date;

				int num = Integer.parseInt(in.nextLine());
				for (int i = 0; i < num; i++) {
					book.reservedSeats.add(in.nextLine());
				}
				bookings.add(book);

			}
			in.close();
		}

	}

	public static void cancelBooking(Showing myShow, Booking myBooking,Alert alert,Label msg) {
            boolean cancel=true;
            Date timing=myBooking.timing;
            Date today=new Date();
            String pattern="dd-MM-yy";
            String time="HH";
            SimpleDateFormat st=new SimpleDateFormat(time);
            SimpleDateFormat sdf=new SimpleDateFormat(pattern);
            if(sdf.format(timing).equals(sdf.format(today))){
                if(Integer.parseInt(st.format(timing))-Integer.parseInt(st.format(timing))<2){
                    cancel=false;
                }
            }
            
            if(cancel){
                
                alert = new Alert(AlertType.WARNING);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Are you sure you want to cancel this booking?");
                alert.setContentText("You will be refunded $" + myBooking.total + " via " + myBooking.paymentMethod);
                alert.getButtonTypes().remove(ButtonType.OK);
                alert.getButtonTypes().add(ButtonType.YES);
                alert.getButtonTypes().add(ButtonType.CANCEL);
		for (int i = 0; i < myShow.hall.rows; i++) {
			for (int j = 0; j < myShow.hall.columns; j++) {
				if (myBooking.reservedSeats.contains(myShow.hall.seats[i][j].seatName)) {
					myShow.hall.seats[i][j].isReserved = "false";
				}
			}
		}

		System.out.println(myBooking.movieName + " " + myBooking.timing);

		for (int i = 0; i < Customer.bookings.size(); i++) {
			if (Customer.bookings.get(i).equals(myBooking))
				Customer.bookings.remove(i);
		}
                
               msg.setText("Booking Cancelled Successfully.");
            }
            else{
                alert=new Alert(AlertType.ERROR);
                alert.setHeaderText("");
                alert.setContentText("Booking cannot be cancelled immediately before Showing");
                alert.showAndWait();
            }

	}

}
