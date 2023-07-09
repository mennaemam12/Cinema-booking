/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EditDepositForm extends Scene {
    
    Label editDeposit = new Label();
    Label deposit = new Label();
    TextField depositRate = new TextField();
    Button done = new Button();
    Button back = new Button();
    Label msg = new Label();
    public EditDepositForm(Parent parent, double d, double d1) 
    {
        super(parent, d, d1);
        
        GridPane pane = new GridPane();
        
        editDeposit.setText("Edit Deposit Rate");
        editDeposit.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
        
        deposit.setText("Deposit Rate");
        deposit.setFont(Font.font("Times New Roman",15));
        
        done.setText("Done");
        done.setFont(Font.font("Times New Roman",15));
        done.setOnAction(new DoneHandler());
        
        back.setText("Back");
        back.setFont(Font.font("Times New Roman",15));
        back.setOnAction(new BackHandler());
        
        msg.setFont(Font.font("Times New Roman",15));
        msg.setTextFill(Color.RED);
        
        pane.add(editDeposit,0,0);
        pane.add(deposit,0,1);
        pane.add(depositRate,1,1);
        pane.add(done,2,2);
        pane.add(back,2,3);
        pane.add(msg,1,2);
        
        pane.setPadding(new Insets(5));
        pane.setHgap(5);
        pane.setVgap(15);
        
        setRoot(pane);
    }
    
    class DoneHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) 
        {
            if (depositRate.getText().isEmpty()) {
				msg.setText("No Deposit Entered");
            }
            else{
                boolean validDep=true;
                try{
                    double dep=Double.parseDouble(depositRate.getText());
                }
                catch(NumberFormatException x){
                    msg.setText("Numeric Percentage is Required ");
                    validDep=false;
                }
                
                if(validDep){
                try {
                    double depositrate = Double.parseDouble(depositRate.getText());
                    Admin.setDepositPercentage(depositrate,msg);
                } catch (IOException ex) {
                    Logger.getLogger(EditDepositForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        }
        
    }
    
    class BackHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			GridPane pane = new GridPane();
                        AdminForm form = new AdminForm(pane,300,400);
			CinemaProject.stage.setScene(form);
                        CinemaProject.stage.show();
		}
	}
    
    
}
