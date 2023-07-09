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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author concept
 */
public class RemoveHallForm extends Scene{
    
    Alert alert=new Alert(Alert.AlertType.WARNING);
    Label removeHall=new Label();
    Label msg=new Label();
    Button remove=new Button();
    Label hall=new Label();
    ObservableList<String>halls;
    ComboBox availHalls=new ComboBox();
    
    public RemoveHallForm(Parent parent, double d, double d1) {
        super(parent, d, d1);
        
        GridPane pane=new GridPane();
        
        hall.setText("Hall Name:");
        hall.setFont(Font.font("Times New Roman",18));
        
        removeHall.setText("Remove Hall");
        removeHall.setFont(Font.font("Times New Roman",FontWeight.BOLD,23));
        
        remove.setText("Remove");
        remove.setFont(Font.font("Times New Roman",20));
        remove.setOnAction(new RemoveHandler());
        
        msg.setFont(Font.font("Times New Roman",15));
        
        halls=FXCollections.observableList(Admin.getHalls());
        availHalls.setItems(halls);
        
        HBox h=new HBox(hall,availHalls);
        h.setSpacing(10);
        h.setTranslateX(10);
        h.setTranslateY(20);
        removeHall.setTranslateX(30);
        
        remove.setTranslateX(50);
        remove.setCursor(Cursor.HAND);
        remove.setStyle(" -fx-background-color: #d63d62; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(remove);
        
        pane.add(removeHall, 0,0 );
        pane.add(h, 0, 1);
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
                  new BackgroundSize(800,600,false,false,true,false))));
       box.setSpacing(10);
       
       setRoot(box);
        
    }
    
    class RemoveHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(availHalls.getSelectionModel().getSelectedItem() == null)
                msg.setText("No Hall Selected");
            else{
                String hallName=availHalls.getValue().toString();
                try {
                    Admin.removeHall(hallName, msg, alert);
                } catch (IOException ex) {
                    Logger.getLogger(RemoveMovieForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(RemoveMovieForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}
