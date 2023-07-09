/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import static cinemaproject.CinemaProject.stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author concept
 */
public class AdminForm extends Scene{
  
    Button home=new Button("Home");
    Button logout=new Button("Log Out");
    Button seatsStatus=new Button("View Seats Status");
    Button depositRate=new Button("Edit Deposit Rate");
    Button ticketsPrices=new Button("Edit tickets Prices");
    Button transactions=new Button("View Transactions");
    Label user=new Label();
    static GridPane pane=new GridPane();
    GridPane pane2=new GridPane();
    
    
    public AdminForm(Parent parent, double d, double d1) {
        super(parent, d, d1);
        
        
        user.setText("Logged in as:\n"+LoginForm.currUser.username);
        user.setFont(Font.font("Arial",FontWeight.BOLD,13));
        user.setTextFill(Color.WHITE);
        Image ui=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/user.png");
        ImageView u=new ImageView(ui);
        u.setPreserveRatio(true);
        u.setFitHeight(30);
        user.setGraphic(u);
        user.setGraphicTextGap(10);
        user.setTranslateX(10);
        
        MenuItem addMovie = new MenuItem("Movie");
        MenuItem addHall = new MenuItem("Hall");
        MenuItem addShowing = new MenuItem("Showing");
        
        addMovie.setStyle(" -fx-text-fill: #74175E; -fx-font-weight:bold; -fx-font-size:20px;");
        addHall.setStyle(" -fx-text-fill: #74175E; -fx-font-weight:bold; -fx-font-size:20px;");
        addShowing.setStyle(" -fx-text-fill: #74175E; -fx-font-weight:bold; -fx-font-size:20px;");
          
        addMovie.setOnAction(new AddMovieHandler());
        addHall.setOnAction(new AddHallHandler());
        addShowing.setOnAction(new AddShowingHandler());

        MenuButton add = new MenuButton("Add", null, addMovie, addHall, addShowing);
        add.setBackground(null);
        add.setTextFill(Color.WHITE);
        add.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        add.setGraphicTextGap(10);
        add.setCursor(Cursor.HAND);
        setEffect(add);
        add.setStyle(" -fx-background-color: #74175E; -fx-background-radius: 10px;");
        
        Image img=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/add2.png");
        ImageView view=new ImageView(img);
        view.setPreserveRatio(true);
        view.setFitHeight(30);
        add.setGraphic(view);
        
        MenuItem removeMovie = new MenuItem("Movie");
        MenuItem removeHall = new MenuItem("Hall");
        MenuItem removeShowing = new MenuItem("Showing");
        
        removeMovie.setStyle(" -fx-text-fill: #74175E; -fx-font-weight:bold; -fx-font-size:20px;");
        removeHall.setStyle(" -fx-text-fill: #74175E; -fx-font-weight:bold; -fx-font-size:20px;");
        removeShowing.setStyle(" -fx-text-fill: #74175E; -fx-font-weight:bold; -fx-font-size:20px;");
        
        removeMovie.setOnAction(new RemoveMovieHandler());
        removeHall.setOnAction(new RemoveHallHandler());
        removeShowing.setOnAction(new RemoveShowingHandler());
        
        MenuButton remove = new MenuButton("Remove", null, removeMovie, removeHall, removeShowing);
        remove.setBackground(null);
        remove.setTextFill(Color.WHITE);
        remove.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        remove.setGraphicTextGap(10);
        remove.setCursor(Cursor.HAND);
        setEffect(remove);
        remove.setStyle(" -fx-background-color: #74175E; -fx-background-radius: 10px;");
        
        Image im=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/remove.png");
        ImageView v=new ImageView(im);
        v.setPreserveRatio(true);
        v.setFitHeight(30);
        remove.setGraphic(v);
        
      
        seatsStatus.setFont(Font.font("Times New Roman",16));
        depositRate.setFont(Font.font("Times New Roman",16));
        ticketsPrices.setFont(Font.font("Times New Roman",16));
        transactions.setFont(Font.font("Times New Roman",16));
        
        home.setTextFill(Color.WHITE);
        home.setBackground(null);
        home.setCursor(Cursor.HAND);
        home.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        Image i=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/home.png");
        ImageView vi=new ImageView(i);
        vi.setPreserveRatio(true);
        vi.setFitHeight(30);
        home.setGraphic(vi);
        home.setGraphicTextGap(10);
        setEffect(home);
        home.setStyle(" -fx-background-color: #74175E; -fx-background-radius: 10px;");
        
        logout.setTextFill(Color.WHITE);
        logout.setBackground(null);
        logout.setCursor(Cursor.HAND);
        logout.setFont(Font.font("Times New Roman",FontWeight.BOLD,16));
        Image ima=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/logout.png");
        ImageView vie=new ImageView(ima);
        vie.setPreserveRatio(true);
        vie.setFitHeight(25);
        logout.setGraphic(vie);
        logout.setGraphicTextGap(10);
        logout.setTranslateX(3);
        logout.setOnAction(new LogoutHandler());
        setEffect(logout);
        logout.setStyle(" -fx-background-color: #74175E; -fx-background-radius: 10px;");
        
       
        ticketsPrices.setOnAction(new TicketPricesHandler());
        depositRate.setOnAction(new DepositRateHandler());
        transactions.setOnAction(new TransactionsHandler());
        
        pane.setStyle("-fx-background-color: #74175E;");
        
        pane.add(home, 0, 4);
        pane.add(add,0,5);
        pane.add(remove,0,6);
        pane.add(logout,0,7);
        pane.add(user,0,20);
        /*pane.add(ticketsPrices,0,6);
        pane.add(depositRate,0,7);
        pane.add(seatsStatus,0,8);
        pane.add(transactions,0,9);*/
        
        
        pane.setPadding(new Insets(10));
        pane.setMaxWidth(200);
        pane.setMinWidth(200);
        pane.setHgap(20);
        pane.setVgap(15);
        HBox box=new HBox(pane,pane2);
        
        setRoot(box);
    }
    
    public static void setEffect(Node n){
        DropShadow shadow =new DropShadow();
         n.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
         n.setEffect(shadow);
        });
    
         n.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
         n.setEffect(null);
        });
    }
    
    class AddMovieHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            GridPane pane = new GridPane();
            AddMovieForm form = new AddMovieForm(pane,1000,600);
            CinemaProject.stage.setTitle("Add Movie");
            CinemaProject.stage.setScene(form);
        }
    }
     
    class AddHallHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent arg0) {
           GridPane pane = new GridPane();
           AddHallForm form = new AddHallForm(pane, 1000, 600);
           CinemaProject.stage.setTitle("Add Hall");
           CinemaProject.stage.setScene(form);
        }

    }
    
    class TicketPricesHandler implements EventHandler<ActionEvent> {

            @Override
            public void handle(ActionEvent arg0) {
                GridPane pane = new GridPane();
                EditTicketPricesForm form = new EditTicketPricesForm(pane, 380, 300);
                CinemaProject.stage.setTitle("Add Hall");
                CinemaProject.stage.setScene(form);
            }

    }

    class RemoveMovieHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            GridPane pane = new GridPane();
            RemoveMovieForm form = new RemoveMovieForm(pane, 1000, 600);
            CinemaProject.stage.setTitle("Remove Movie");
            CinemaProject.stage.setScene(form);
        }
    }
    
    class RemoveHallHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            GridPane pane = new GridPane();
            RemoveHallForm form = new RemoveHallForm(pane, 1000, 600);
            CinemaProject.stage.setTitle("Remove Hall");
            CinemaProject.stage.setScene(form);
        }
    }
    
    class RemoveShowingHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            GridPane pane = new GridPane();
           /* RemoveShowingForm form = new RemoveShowingForm(pane, 1000, 600);
            CinemaProject.stage.setTitle("Remove Hall");
            CinemaProject.stage.setScene(form);*/
        }
    }
    
    class AddShowingHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            GridPane pane = new GridPane();
            AddShowingForm form = new AddShowingForm(pane, 1000, 600);
            CinemaProject.stage.setTitle("Add Showing");
            CinemaProject.stage.setScene(form);
        }
    }
    
    class DepositRateHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) 
        {
            GridPane pane = new GridPane();
            EditDepositForm form = new EditDepositForm(pane, 380, 380);
            CinemaProject.stage.setTitle("Deposit Rate");
            CinemaProject.stage.setScene(form);
			
        }
        
    }
    
    class TransactionsHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) 
        {
            GridPane pane = new GridPane();
            ViewTransactionsForm form = new ViewTransactionsForm(pane, 600, 450);
            CinemaProject.stage.setTitle("Transactions Form");
            CinemaProject.stage.setScene(form);
			
        }
    }
    
    class LogoutHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent t) {
            GridPane pane = new GridPane();
            LoginForm form = new LoginForm(pane,1000,600);
            stage.setTitle("Login Form");
            stage.setScene(form);
            stage.show();
        }
        
    }

	
}
