/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author concept
 */
public class RemoveMovieForm extends Scene {
    Alert alert=new Alert(AlertType.WARNING);
    Label removeMovie=new Label();
    Label msg=new Label();
    Button remove=new Button();
    Label movie=new Label();
    ObservableList<String>movies;
    ComboBox availMovies=new ComboBox();
    public RemoveMovieForm(Parent parent, double d, double d1) {
        super(parent, d, d1);
        GridPane pane=new GridPane();
        
        movie.setText("Movie Name:");
        movie.setFont(Font.font("Times New Roman",18));
        
        removeMovie.setText("Remove Movie");
        removeMovie.setFont(Font.font("Times New Roman",FontWeight.BOLD,23));
        
        remove.setText("Remove");
        remove.setFont(Font.font("Times New Roman",20));
        remove.setOnAction(new RemoveHandler());
        
        msg.setFont(Font.font("Times New Roman",15));
        msg.setTextFill(Color.RED);
        
        movies=FXCollections.observableList(Admin.getMovies());
        availMovies.setItems(movies);
        
        HBox m=new HBox(movie,availMovies);
        m.setSpacing(10);
        m.setTranslateX(10);
        m.setTranslateY(20);
        removeMovie.setTranslateX(30);
        
        remove.setTranslateX(60);
        remove.setCursor(Cursor.HAND);
        remove.setStyle(" -fx-background-color: #d63d62; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(remove);
        
        pane.add(removeMovie, 0,0 );
        pane.add(m, 0, 1);
        pane.add(remove, 0,3 );
        pane.add(msg, 1, 3);
        
       pane.setStyle("-fx-background-color: #FFFFFF;");
       pane.setBorder(Border.stroke(Color.GREY));
       pane.setPadding(new Insets(30));
       pane.setMinWidth(300);
       pane.setMaxWidth(300);
       pane.setMinHeight(250);
       pane.setMaxHeight(250);
       pane.setTranslateX(15);
       pane.setTranslateY(30);
       pane.setVgap(40);
       pane.setHgap(20);
       pane.setAlignment(Pos.CENTER);
       HBox box=new HBox(AdminForm.pane,pane);
       Image bg=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/bg.jpg");
       box.setBackground(new Background(new BackgroundImage(bg,BackgroundRepeat.NO_REPEAT,
               BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,
                  new BackgroundSize(800,600,false,true,true,false))));
       box.setSpacing(10);
       
       
       setRoot(box);
        
    }
    
    class RemoveHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
             
            if(availMovies.getSelectionModel().getSelectedItem() == null)
                msg.setText("No Movie Selected");
            else{
                String movieName=availMovies.getValue().toString();
                try {
                    Admin.removeMovie(movieName, msg, alert);
                } catch (IOException ex) {
                    Logger.getLogger(RemoveMovieForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(RemoveMovieForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
   
    
}
