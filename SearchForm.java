/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import static cinemaproject.CustomerForm.availMovies;
import static cinemaproject.CustomerForm.movies;
import static cinemaproject.CustomerForm.myBookings;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author concept
 */
public class SearchForm extends Scene{
    static Button myBookings;
	static Label movies;
	static ArrayList<Movie> availMovies;
	BookSeats displayHall;
	GridPane gp = new GridPane();
        static TextField search=new TextField();
        
        
    public static void find(String s){
        search.setText(s);
    }    
    public SearchForm(Parent parent, double d, double d1) {
        super(parent, d, d1);
        
        GridPane pane = new GridPane();
		Label welc = new Label(
				"Welcome " + User.currUser.name.substring(0, User.currUser.name.indexOf(' ')) + "!");
		welc.setFont(Font.font("Times New Roman", 20));
		pane.add(welc, 0, 0);
                pane.add(search, 1, 0);
		movies = new Label("Available Movies: ");
		movies.setFont(Font.font("Times New Roman", 17));
		pane.add(movies, 0, 2);
		availMovies = Customer.getAvailMovies();
                
                search.setOnKeyPressed(new SearchHandler());
                
		int x = 3;
		int y = 3;
		int z = 4;
		int c = 1;
                
		for (int i = 0; i < availMovies.size(); i++) {
                    
                    if(availMovies.get(i).movieName.contains(search.getText())
                       || availMovies.get(i).movieGenre.contains(search.getText())){
			Label movie = new Label("POSTER " + availMovies.get(i).movieName.toUpperCase());
			Label name = new Label("Name: " + availMovies.get(i).movieName);
			Label genre = new Label("Genre: " + availMovies.get(i).movieGenre);
			name.setFont(Font.font("Times New Roman", 16));
			genre.setFont(Font.font("Times New Roman", 16));
			pane.add(movie, 0, x);
			pane.add(name, 1, y);
			pane.add(genre, 1, y + 1);

			for (int j = 0; j < User.showings.size(); j++) {
				if (User.showings.get(j).movie.movieName.equals(availMovies.get(i).movieName)) {
					Date da = User.showings.get(j).timing;
                                        String pattern = "EEEEE";
                                        String patt= "MMMMM yyyy";
                                        String p="dd-MM-yy";
                                        SimpleDateFormat day=new SimpleDateFormat(p);
                                        String dayInInt=day.format(da);
                                        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
                                        SimpleDateFormat sd=new SimpleDateFormat(patt);
                                        String time="HH:mm";
                                        SimpleDateFormat st=new SimpleDateFormat(time);
					Button b = new Button();
                                        b.setText(sdf.format(da)+" "+ dayInInt.substring(0, dayInInt.indexOf('-'))+
                                         " "+sd.format(da)+"\nFrom: "+st.format(da)
                                        +"\nTo: "+st.format(User.showings.get(j).movieEnds));
					b.setOnAction(new BookHandler(User.showings.get(j)));
					pane.add(b, c, z);
					c += 1;
				}
			}
			x += 3;
			y += 3;
			z += 3;
			c = 1;
		}
                
                }
		myBookings = new Button("My Bookings");
		myBookings.setFont(Font.font("Times New Roman", 16));
		for (int i = 0; i < Customer.bookings.size(); i++) {
			if (Customer.bookings.get(i).custUsername.equals(User.currUser.username)) {
				myBookings.setOnAction(new MyBookingsHandler());
				pane.add(myBookings, 5, 0);
				break;
			}
		}

		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(23);
		setRoot(pane);
    }
    
    class BookHandler implements EventHandler<ActionEvent> {
		Showing myShow;

		public BookHandler(Showing myShow) {
			this.myShow = myShow;
			this.myShow.hall = new Hall(myShow.hall);
		}

		@Override
		public void handle(ActionEvent e) {
			gp.setPadding(new Insets(20));
			displayHall = new BookSeats(gp, 400, 400, myShow);
			CinemaProject.stage.setScene(displayHall);
			CinemaProject.stage.setTitle("Movie " + myShow.movie.movieName + " Hall " + myShow.hall.hallName);
		}

	}

	class MyBookingsHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			GridPane pane = new GridPane();
			ViewBookingForm form = new ViewBookingForm(pane, 700, 700);
			CinemaProject.stage.setTitle("My Bookings");
			CinemaProject.stage.setScene(form);

		}
	}
        
        class SearchHandler implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent t) {
            GridPane pane = new GridPane();
            CustomerForm form=null;
            try {
                form = new CustomerForm(pane, 450, 450);
            } catch (InterruptedException ex) {
                Logger.getLogger(SearchForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            CinemaProject.stage.setTitle("Customer");
            CinemaProject.stage.setScene(form);
        }

        
            
        }

}
