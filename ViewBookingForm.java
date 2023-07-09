/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class ViewBookingForm extends Scene {
	Label msg;
        Alert alert;
	public ViewBookingForm(Parent arg0, double arg1, double arg2) {
		super(arg0, arg1, arg2);

		GridPane gp = new GridPane();
		Booking bk = null;
		String name = User.currUser.name.substring(0, User.currUser.name.indexOf(' '));
		Label title = new Label(name + "'s Bookings");
		title.setFont(Font.font("Times New Roman", 20));
		gp.add(title, 0, 0);
		int x = 1;
		int y = 0;
		for (int i = 0; i < Customer.bookings.size(); i++) {
			if (Customer.bookings.get(i).custUsername.equals(User.currUser.username)) {
				bk = Customer.bookings.get(i);
				Label l1 = new Label("Movie: " + bk.movieName);
				l1.setFont(Font.font("Times New Roman", 13));
				Label l2 = new Label("Total: $" + bk.total);
				l2.setFont(Font.font("Times New Roman", 13));
				Label l3 = new Label("Payment Method: " + bk.paymentMethod);
				l3.setFont(Font.font("Times New Roman", 13));
				Button cancel = new Button("Cancel");
				for (int k = 0; k < User.showings.size(); k++) {
					if (User.showings.get(k).movie.movieName.equals(bk.movieName)
							&& User.showings.get(k).timing.equals(bk.timing)) {
						cancel.setOnAction(new CancelBookingHandler(User.showings.get(k), Customer.bookings.get(i)));
					}
				}

				gp.add(l1, 0, x);
				gp.add(l2, 0, x + 1);
				gp.add(l3, 0, x + 2);
				gp.add(cancel, 1, x + 2);

				if (bk.paymentMethod.equals("Cash")) {
					Label l4 = new Label("Deposit To Be Paid: " + bk.deposit);
					l4.setFont(Font.font("Times New Roman", 13));
					gp.add(l4, 0, x + 3);
				}
				y = x + 4;
				for (int j = 0; j < bk.reservedSeats.size(); j++) {
					Label l = new Label(bk.reservedSeats.get(j));
					l.setFont(Font.font("Times New Roman", 13));
					gp.add(l, 0, j + y);
				}

			}
			x = x + 1 + (y + bk.reservedSeats.size());
		}
		msg = new Label();
		gp.add(msg, x + 1, y + 1);
		gp.setPadding(new Insets(15));
		gp.setHgap(25);
		setRoot(gp);
	}

	class CancelBookingHandler implements EventHandler<ActionEvent> {
		Showing myShow;
		Booking myBooking;

		public CancelBookingHandler(Showing show, Booking book) {
			this.myShow = show;
			this.myShow.hall = new Hall(show.hall);
			this.myBooking = book;
		}

		@Override
		public void handle(ActionEvent arg0) {
			
		Customer.cancelBooking(myShow, myBooking,alert,msg);
				
		}

	}
}


