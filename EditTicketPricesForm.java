/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EditTicketPricesForm extends Scene {
	Admin admin = new Admin();

	Label EditTicketPrices = new Label();
	Label silverPrice = new Label();
	TextField tfsilverPrice = new TextField();
	Label goldPrice = new Label();
	TextField tfgoldPrice = new TextField();
	Label platinumPrice = new Label();
	TextField tfplatinumPrice = new TextField();
	Button done = new Button();
	Button back = new Button();
	Label msg = new Label();

	Alert alert = new Alert(Alert.AlertType.ERROR);

	public EditTicketPricesForm(Parent parent, double d, double d1) {
		super(parent, d, d1);

		GridPane pane = new GridPane();

		EditTicketPrices.setText("Edit ticket Prices: ");
		EditTicketPrices.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));

		silverPrice.setText("Silver Price: ");
		silverPrice.setFont(Font.font("Times New Roman", 15));

		goldPrice.setText("Gold Price: ");
		goldPrice.setFont(Font.font("Times New Roman", 15));

		platinumPrice.setText("Platinum Price: ");
		platinumPrice.setFont(Font.font("Times New Roman", 15));

		done.setText("Done");
		done.setFont(Font.font("Times New Roman", 16));
		done.setOnAction(new Done2Handler());

		back.setText("Back");
		back.setFont(Font.font("Times New Roman", 16));
		back.setOnAction(new BackHandler());

		msg.setFont(Font.font("Times New Roman", 15));
                msg.setTextFill(Color.RED);

		pane.add(EditTicketPrices, 0, 0);
		pane.add(silverPrice, 0, 1);
		pane.add(tfsilverPrice, 1, 1);
		pane.add(goldPrice, 0, 2);
		pane.add(tfgoldPrice, 1, 2);
		pane.add(platinumPrice, 0, 3);
		pane.add(tfplatinumPrice, 1, 3);
		pane.add(done, 2, 4);
		pane.add(back, 2, 5);
		pane.add(msg, 1, 4);

		pane.setPadding(new Insets(5));
		pane.setHgap(5);
		pane.setVgap(15);

		setRoot(pane);

	}

	class Done2Handler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			if (tfsilverPrice.getText().isEmpty() || tfgoldPrice.getText().isEmpty()
					|| tfplatinumPrice.getText().isEmpty()) {
				msg.setText("All Fields Required");
			} else {
                            
                            boolean valid=true;
                            int silverPrice=0;
                            int goldPrice=0;
                            int platPrice=0;
                            try{
                                silverPrice = Integer.parseInt(tfsilverPrice.getText());
				goldPrice = Integer.parseInt(tfgoldPrice.getText());
				platPrice = Integer.parseInt(tfplatinumPrice.getText());
                            }catch(NumberFormatException x){
                                valid=false;
                                msg.setText("Integers are Required");
                            }
                            
		            if(valid){

				try {
					admin.setTicketPrices(silverPrice, goldPrice, platPrice, msg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                            }

			}
		}
	}

	class BackHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
	            GridPane pane=new GridPane();
                    AdminForm form=new AdminForm(pane,450,350);
                    CinemaProject.stage.setTitle("Admin");
                    CinemaProject.stage.setScene(form);
		}
	}

}
