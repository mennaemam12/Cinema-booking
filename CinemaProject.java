/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemaproject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author concept
 */
public class CinemaProject extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, ClassNotFoundException, InvocationTargetException {
       User.fillCustomerArray();
       User.fillAdminArray();
       User.fillMovieArray();
       User.fillHallsArray();
       User.fillShowingsArray();
       Customer.fillTicketPrices();
       Cash.readDepositRate();
       Customer.fillBookingsArray();
		
       launch(args);
       User.printAdminFile();
       User.printCustomerFile();
       Admin.printMovieArray();
       Admin.printHallArray();
       User.editShowingFile();
       Customer.printBookings();
    }
    
    public static Stage stage=new Stage();;
    @Override
    public void start(Stage primaryStage){
        
        GridPane pane = new GridPane();
        LoginForm form = new LoginForm(pane,1000,600);
        
        stage.setTitle("Login Form");
        stage.setScene(form);
        stage.show();
    }
    
}
