/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginForm extends Scene{
    GridPane pane = new GridPane();
    public static StackPane pane2=new StackPane();
    HBox box=new HBox();
    Label sign= new Label();
    Label user= new Label();
    Label pass=new Label();
    Label img=new Label();
    TextField username = new TextField();
    PasswordField password = new PasswordField();
    Label acc = new Label();
    Button signIn = new Button();
    Label msg = new Label();
    Alert alert=new Alert(Alert.AlertType.ERROR);
    Image im=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/515.jpg");
    ImageView view=new ImageView(im);
    Hyperlink link=new Hyperlink();
     
    static User currUser;
  
    
    public LoginForm(Parent parent, double d, double d1) 
    {
        super(parent, d, d1);
        
        sign.setText("Sign In");
        sign.setFont(Font.font("Times New Roman",FontWeight.BOLD,30));
        user.setText("Username: ");
        user.setFont(Font.font("Times New Roman",20));
        pass.setText("Password: ");
        pass.setFont(Font.font("Times New Roman",20));
        
        
        signIn.setText("Sign In");
        signIn.setFont(Font.font("Arial",18));
        signIn.setOnAction(new SignInHandler());
        signIn.setAlignment(Pos.CENTER);
        signIn.setMaxWidth(500);
        signIn.setMaxHeight(200);
        signIn.setStyle(" -fx-background-color: #74175E; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        signIn.setCursor(Cursor.HAND);
        
        DropShadow shadow = new DropShadow();  
        signIn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        signIn.setEffect(shadow);
        });
    
        signIn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        signIn.setEffect(null);
        });
        
        
        acc.setText("Don't have an account?");
        acc.setFont(Font.font("Times New Roman",17));
        acc.setAlignment(Pos.CENTER);
        
        msg.setFont(Font.font("Times New Roman",16));
        
        view.setPreserveRatio(true);
        view.setFitHeight(600);
        view.setFitWidth(500);
        img.setGraphic(view);
        
        box.setStyle("-fx-background-color: #74175E;");
        pane.setStyle("-fx-background-color: #FFFFFF;");
        
        link.setText("Sign Up");
        link.setFont(Font.font("Times New Roman",17));
        SignUpHandler handler2 = new SignUpHandler();
        link.setOnAction(handler2);
        
        HBox u=new HBox(user,username);
        HBox p=new HBox(pass,password);
        u.setSpacing(5);
        p.setSpacing(8);
        VBox v=new VBox(u,p);
        v.setSpacing(20);
        
        HBox b=new HBox(acc,link);
        b.setSpacing(5);
        
        pane.add(sign,0,1);
        pane.add(v,0,4);
        pane.add(signIn,0,7);
        pane.add(b,0,10);
        pane.add(msg,0,11);
        //pane2.add(img, 0, 0);
        pane2.getChildren().add(img);
        
       // pane.setPadding(new Insets(3));
       GridPane.setHalignment(v, HPos.LEFT);
        b.setAlignment(Pos.CENTER);
        pane.setPrefWidth(400);
        pane.setMaxHeight(500);
        pane.setTranslateY(50);
        pane.setTranslateX(30);
        pane2.setTranslateX(60);
        pane2.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(70));
        pane.setVgap(0.5);
        pane.setVgap(15);
        box.getChildren().addAll(pane2,pane);
        

        setRoot(box);
        
    }
    
    class SignInHandler implements EventHandler<ActionEvent>  
    {
        @Override
        public void handle(ActionEvent event) 
        {
           if(username.getText().isEmpty() || password.getText().isEmpty()){
               msg.setText("All Fields Required");
               msg.setTextFill(Color.RED);
           }
           else{
               String user=username.getText();
               String pass=password.getText();
               try {
                  currUser=new User();
                  currUser= currUser.signIn(user, pass, msg,alert);
               } catch (IOException ex) {
                   Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
               }
               if(currUser!=null){
                    if(currUser.userType.equals("admin")){
                       GridPane pane=new GridPane();
                       AdminForm form=new AdminForm(pane,1000,600);
                       CinemaProject.stage.setTitle("Admin");
                       CinemaProject.stage.setScene(form);
                    }
                    else if(currUser.userType.equals("customer")){
                        GridPane pane=new GridPane();
                         CustomerForm form=null;
                        try {
                           form = new CustomerForm(pane,1000,600);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       CinemaProject.stage.setTitle("Customer");
                       CinemaProject.stage.setScene(form);
                    }
               }
           }
        }
    } 
    
     class SignUpHandler implements EventHandler <ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) 
        {
            GridPane pane = new GridPane();
            RegistrationForm form = new RegistrationForm(pane,1000,600);
            CinemaProject.stage.setTitle("Registration Form");
            CinemaProject.stage.setScene(form);
        }
        
    }
        
}

 
