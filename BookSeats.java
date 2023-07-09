/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class BookSeats extends Scene {
	Showing myShow;
	ToggleButton[][] seats;
	ArrayList<String> selectedSeats = new ArrayList<>();
	double total;
	Ticket ticket = new Ticket();
	Button confirm;
	Label msg;

	public BookSeats(Parent parent, double w, double h, Showing myShowing) {
		super(parent, w, h);
		this.myShow = myShowing;
		this.myShow.hall = new Hall(myShowing.hall);
		GridPane gp = new GridPane();
		seats = new ToggleButton[myShow.hall.rows][myShow.hall.columns];
		Customer.displayHall(myShow.hall, seats);
		for (int i = 0; i < myShow.hall.rows; i++) {
			for (int j = 0; j < myShow.hall.columns; j++) {
				if (this.myShow.hall.seats[i][j].isReserved.equals("true"))
					seats[i][j].setDisable(true);
				else
					seats[i][j].setOnAction(new BookSeatHandler(i, j));
				seats[i][j].setFont(Font.font("Times New Roman", 16));
				gp.add(seats[i][j], j, i);
				GridPane.setMargin(seats[i][j], new Insets(5));
			}
		}
		msg = new Label();
		confirm = new Button("Confirm");
		confirm.setFont(Font.font("Times New Roman", 16));
		msg.setFont(Font.font("Times New Roman", 16));
		gp.add(confirm, 5, 12);
		confirm.setOnAction(new ConfirmBookingHandler(myShow));
		gp.add(msg, 5, 13);
		setRoot(gp);

	}

	class BookSeatHandler implements EventHandler<ActionEvent> {
		public int i, j;

		public BookSeatHandler(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public void handle(ActionEvent e) {

			if (seats[i][j].isSelected()) {
				selectedSeats.add(myShow.hall.seats[i][j].seatName);
				if (myShow.hall.seats[i][j].seatName.contains("S")) {
					total += Ticket.silverPrice;
					msg.setText("Your Total: " + total);
				} else if (myShow.hall.seats[i][j].seatName.contains("G")) {
					total += Ticket.goldPrice;
					msg.setText("Your Total: " + total);
				} else {
					total += Ticket.platinumPrice;
					msg.setText("Your Total: " + total);
				}
			}

			if (!seats[i][j].isSelected()) {
				selectedSeats.remove(myShow.hall.seats[i][j].seatName);
				if (myShow.hall.seats[i][j].seatName.contains("S")) {
					total -= Ticket.silverPrice;
					msg.setText("Your Total: " + total);
				} else if (myShow.hall.seats[i][j].seatName.contains("G")) {
					total -= Ticket.goldPrice;
					msg.setText("Your Total: " + total);
				} else {
					total -= Ticket.platinumPrice;
					msg.setText("Your Total: " + total);
				}
			}

		}

	}

	class ConfirmBookingHandler implements EventHandler<ActionEvent> {

		Showing myShow;

		public ConfirmBookingHandler(Showing myShow) {
			this.myShow = myShow;
			this.myShow.hall = myShow.hall;
			this.myShow.hall = new Hall(myShow.hall);
		}

		@Override
		public void handle(ActionEvent arg0) {
			if (!selectedSeats.isEmpty()) {
				GridPane gp = new GridPane();
                                PaymentForm payment = new PaymentForm(gp, 400, 400,myShow, selectedSeats,total);
				CinemaProject.stage.setScene(payment);
				CinemaProject.stage.setTitle("Payment");

			}

		}
	}
}