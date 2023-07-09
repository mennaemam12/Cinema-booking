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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author concept
 */
public class ViewTransactionsForm extends Scene{
    
    public ViewTransactionsForm(Parent parent, double d, double d1) {
        super(parent, d, d1);
        GridPane pane=new GridPane();
        int x,y=0;
        
        Label bookings=new Label("Bookings:");
        bookings.setFont(Font.font("Times New Roman", 20));
        pane.add(bookings,0,0);
        
        ArrayList<String>usernames=new ArrayList<>();
        for(int i=0;i<User.bookings.size();i++){
            if(!usernames.contains(User.bookings.get(i).custUsername)){
                x=0;
                String user=User.bookings.get(i).custUsername;
                Label name=new Label(user);
                
                pane.add(name,x+1,y+1);
                name.setFont(Font.font("Times New Roman", 16));
                usernames.add(user);
                for(int j=i;j<User.bookings.size();j++){
                    if(User.bookings.get(j).custUsername.equals(user)){
                        Label movie=new Label("Movie Name: "+User.bookings.get(j).movieName);
                        movie.setFont(Font.font("Times New Roman", 13));
                        Label hall=new Label("Hall Name: "+User.bookings.get(j).hallName);
                        hall.setFont(Font.font("Times New Roman", 13));
                        Label total=new Label("Total: "+User.bookings.get(j).total);
                        total.setFont(Font.font("Times New Roman", 13));
                        Label payment=new Label("Payment Method: "+User.bookings.get(j).paymentMethod);
                        payment.setFont(Font.font("Times New Roman", 13));
                        
                        pane.add(movie, x+1, y+3);
                        pane.add(hall, x+1, y+4);
                        pane.add(total, x+1, y+5);
                        pane.add(payment, x+1, y+6);
                        
                        if(User.bookings.get(j).paymentMethod.equals("Cash")){
                            Label deposit = new Label("Deposit: " + User.bookings.get(j).deposit);
                            Button depPayment=new Button();
                            if(User.bookings.get(j).depPaid==false){
                                depPayment.setText("Not Paid");
                            depPayment.setOnAction(new Pay(User.bookings.get(j),
                            depPayment)); 
                            }
                            else{
                                depPayment.setText("Paid");
                                depPayment.setDisable(true);
                            }
                                
			    deposit.setFont(Font.font("Times New Roman", 13));
			    pane.add(deposit, x+1, y+7);
                            pane.add(depPayment, x+2, y+7);
                        }
                        Label l=new Label();
                        String seats="Reserved seats: ";
                        for (int k = 0; k < User.bookings.get(j).reservedSeats.size(); k++) {
                            seats+=User.bookings.get(j).reservedSeats.get(k);
                            seats+=" ";
			}
                        l.setText(seats);
                        pane.add(l, x+1, y+8);
                    }
                    x+=3;
                    
                }
                y+=9;
            }
        }
        pane.setPadding(new Insets(15));
        pane.setHgap(25);
        pane.setVgap(5);
        setRoot(pane);
    }
    
    class Pay implements EventHandler<ActionEvent>{
        Booking booking;
        Button b;
        public Pay(Booking booking,Button b){
            this.booking=booking;
            this.b=b;
        } 
        
        @Override
        public void handle(ActionEvent t) {
            for(int i=0;i<User.bookings.size();i++){
                if(booking.custUsername.equals(User.bookings.get(i).custUsername)
                 &&booking.movieName.equals(User.bookings.get(i).movieName)
                 &&booking.timing.equals(User.bookings.get(i).timing)){
                    User.bookings.get(i).depPaid=true;
                    b.setText("Paid");
                }
            }
        }
        
    }

  
    
    
    
}
