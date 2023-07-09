/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PaymentForm extends Scene {
	Label pay;
	RadioButton cash;
	RadioButton credit;
	ToggleGroup tg = new ToggleGroup();
	Booking booking=new Booking();
	Label deposit;
	Label msg;
	Label l1;
	Label l2;
	Label l3;
	Label l4;
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	GridPane gp;
	Button confirm;
        Showing myShow;
	ArrayList<String> selectedSeats = new ArrayList<>();
	double total;

	public PaymentForm(Parent parent, double w, double h, Showing myShow,ArrayList<String>selectedSeats,double total) {
		super(parent, w, h);

		gp = new GridPane();
		//this.booking = book;
                this.myShow=myShow;
                this.selectedSeats=selectedSeats;
                this.total=total;

		pay = new Label("Method of Payment:");
		pay.setFont(Font.font("Times New Roman", 13));
		cash = new RadioButton("Cash");
		cash.setFont(Font.font("Times New Roman", 13));
		credit = new RadioButton("Credit");
		credit.setFont(Font.font("Times New Roman", 13));
		cash.setToggleGroup(tg);
		credit.setToggleGroup(tg);

		deposit = new Label();
		deposit.setFont(Font.font("Times New Roman", 13));
		msg = new Label();
		msg.setFont(Font.font("Times New Roman", 13));

		l1 = new Label("Card Name:");
		l2 = new Label("Card Number:");
		l3 = new Label("Expiry Date:");
		l4 = new Label("Security Code:");

		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		t4 = new TextField();

		confirm = new Button("Confirm");
		confirm.setFont(Font.font("Times New Roman", 13));
		confirm.setOnAction(new ConfirmHandler());
                
		cash.setOnAction(new CashHandler());
		credit.setOnAction(new CreditHandler());
		gp.add(pay, 0, 0);
		gp.add(cash, 0, 1);
		gp.add(credit, 0, 2);
		gp.add(deposit, 1, 5);
		gp.add(msg, 2, 12);
		gp.add(confirm, 2, 9);

		setRoot(gp);
	}

	class CashHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
                        booking.total=total;
			booking.paymentMethod = "Cash";
			double dep = Cash.calculateDeposit(booking.total);
			booking.deposit = dep;
			deposit.setText("You have to pay a deposit of " + dep);

		}

	}

	class CreditHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			booking.paymentMethod = "Credit";

			gp.add(l1, 1, 3);
			gp.add(l2, 1, 4);
			gp.add(l3, 1, 5);
			gp.add(l4, 1, 6);
			gp.add(t1, 2, 3);
			gp.add(t2, 2, 4);
			gp.add(t3, 2, 5);
			gp.add(t4, 2, 6);

		}

	}
        
        class CashOrCreditHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
                    booking.total=total;
                    if(tg.getSelectedToggle().equals(credit)){
			booking.paymentMethod = "Credit";

			gp.add(l1, 1, 3);
			gp.add(l2, 1, 4);
			gp.add(l3, 1, 5);
			gp.add(l4, 1, 6);
			gp.add(t1, 2, 3);
			gp.add(t2, 2, 4);
			gp.add(t3, 2, 5);
			gp.add(t4, 2, 6);
                    }
                    else{
                        booking.paymentMethod = "Cash";
			double dep = Cash.calculateDeposit(booking.total);
			booking.deposit = dep;
			deposit.setText("You have to pay a deposit of " + dep);
                        
                        l1.resize(0, 0);
                    }

		}

	}

	class ConfirmHandler implements EventHandler<ActionEvent> {
                  
		@Override
		public void handle(ActionEvent arg0) {
                    
                       booking=Customer.book(selectedSeats, myShow, total,booking.paymentMethod);
			msg.setText(" ");
			msg.setTextFill(Color.BLACK);
			if (booking.paymentMethod.equals("Credit")) {
				if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()
						|| t4.getText().isEmpty()) {
					msg.setText("Please fill all fields.");
					msg.setTextFill(Color.RED);
				} else {
					boolean valid = Credit.validateCard(t1.getText(), t2.getText(), t3.getText(), t4.getText());
					if (valid) {
						msg.setText("Your Booking is Successfull");
					} else {
						msg.setText("Not all fields are valid.");
						msg.setTextFill(Color.RED);
					}
				}
			} else {
				double dep = Cash.calculateDeposit(booking.total);
				booking.deposit = dep;
				deposit.setText("You have to pay a deposit of " + dep);
				msg.setText("Your Booking is Successfull");

			}
			Customer.bookings.add(booking);

		}

	}

}
