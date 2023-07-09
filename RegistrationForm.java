/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import static cinemaproject.CinemaProject.stage;
import java.io.BufferedWriter;
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
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HANI
 */
public class RegistrationForm extends Scene
{
    User currUser=new User();
    Label register = new Label();
    ToggleGroup group = new ToggleGroup();
    Label AorC = new Label();
    RadioButton Admin = new RadioButton();
    RadioButton Customer = new RadioButton();
    Label full = new Label();
    TextField fullname = new TextField();
    Label age = new Label();
    TextField Age = new TextField();
    Label gender = new Label();
    ToggleGroup grp = new ToggleGroup();
    RadioButton Male = new RadioButton();
    RadioButton Female = new RadioButton();
    Label email = new Label();
    TextField Email = new TextField();
    Label user = new Label();
    TextField username = new TextField();
    Label pass = new Label();
    PasswordField password = new PasswordField();
    Label confPass = new Label();
    PasswordField confirmPass = new PasswordField();
    Button signUp = new Button();
    Label msg = new Label();
    Button back=new Button();
    Image im=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/wback.png");
    ImageView view=new ImageView(im);
    
    
    public RegistrationForm(Parent parent, double d, double d1) 
    {
        super(parent, d, d1);
        
        GridPane pane = new GridPane();
        
        register.setText("Register");
        register.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));
        
        AorC.setText("Admin/Customer: ");
        AorC.setFont(Font.font("Times New Roman",18));
        
        Admin.setText("Admin");
        Admin.setFont(Font.font("Times New Roman",15));
        Admin.setToggleGroup(group);
        
        Customer.setText("Customer");
        Customer.setFont(Font.font("Times New Roman",15));
        Customer.setToggleGroup(group);
        
        full.setText("Fullname: ");
        full.setFont(Font.font("Times New Roman",18));
        
        age.setText("Age: ");
        age.setFont(Font.font("Times New Roman",18));
        
        Age.setPrefColumnCount(2);
        
        gender.setText("Gender: ");
        gender.setFont(Font.font("Times New Roman",18));
        
        Male.setText("Male");
        Male.setFont(Font.font("Times New Roman",15));
        Male.setToggleGroup(grp);
        
        Female.setText("Female");
        Female.setFont(Font.font("Times New Roman",15));
        Female.setToggleGroup(grp);
        
        email.setText("Email: ");
        email.setFont(Font.font("Times New Roman",18));
        
        user.setText("Username: ");
        user.setFont(Font.font("Times New Roman",18));
        
        pass.setText("Password: ");
        pass.setFont(Font.font("Times New Roman",18));
        
        confPass.setText("Confirm Password: ");
        confPass.setFont(Font.font("Times New Roman",18));
        
        view.setFitWidth(50);
        view.setFitHeight(50);
        back.setGraphic(view);
        back.setMaxWidth(50);
        back.setMaxHeight(50);
        Circle circle=new Circle();
        back.setShape(circle);
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        back.setTranslateX(10);
        back.setTranslateY(65);
        LoginForm.pane2.getChildren().add(back);
        back.setCursor(Cursor.HAND);
        back.setStyle("-fx-background-color: #FFFFFF;");
        back.setOnAction(new BackHandler());
        AdminForm.setEffect(back);
        
        
        SignUpHandler handler = new SignUpHandler();
        signUp.setText("Sign Up");
        signUp.setFont(Font.font("Arial",16));
        signUp.setOnAction(handler);
        signUp.setAlignment(Pos.CENTER);
        signUp.setMaxWidth(500);
        signUp.setMinWidth(300);
        signUp.setMaxHeight(200);
        signUp.setStyle(" -fx-background-color: #74175E; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        signUp.setCursor(Cursor.HAND);
        
          DropShadow shadow1 = new DropShadow();  
        signUp.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        signUp.setEffect(shadow1);
        });
    
        signUp.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        signUp.setEffect(null);
        });
        
        msg.setFont(Font.font("Times New Roman",15));
        msg.setTextFill(Color.RED);
        
        
        pane.setStyle("-fx-background-color: #FFFFFF;");
        
        pane.setPrefWidth(400);
        pane.setMaxHeight(500);
        pane.setTranslateY(50);
        pane.setTranslateX(30);
        
        VBox ac=new VBox(Admin,Customer);
        ac.setSpacing(5);
        HBox a=new HBox(AorC,ac);
        HBox b=new HBox(full,fullname);
        VBox Gender=new VBox(Male,Female);
        Gender.setSpacing(5);
        HBox c=new HBox(gender,Gender);
        HBox f=new HBox(age,Age);
        HBox e=new HBox(email,Email);
        HBox g=new HBox(user,username);
        HBox h=new HBox(pass,password);
        HBox i=new HBox(confPass,confirmPass);
        HBox j=new HBox(register,msg);
        a.setSpacing(10);
        b.setSpacing(70);
        c.setSpacing(85);
        f.setSpacing(107);
        e.setSpacing(94);
        g.setSpacing(65);
        h.setSpacing(69);
        i.setSpacing(5);
        j.setSpacing(25);
        
        
        pane.add(j,0,0);
        pane.add(a,0,1);
        pane.add(b,0,3);
        pane.add(c,0,4);
        pane.add(f,0,6);
        pane.add(e,0,7);
        pane.add(g,0,8);
        pane.add(h,0,9);
        pane.add(i,0,10);
        pane.add(signUp,0,11);

        
        
        pane.setPadding(new Insets(15));
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(15);
        HBox box=new HBox(LoginForm.pane2,pane);
        box.setStyle("-fx-background-color: #74175E;");
        
        setRoot(box);
    }
    
    public class BackHandler implements EventHandler<ActionEvent>
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
    
    public class SignUpHandler implements EventHandler<ActionEvent>
    {
          
        @Override
        public void handle(ActionEvent event) 
        {
            msg.setText("");
            // sign in info taken from user
            boolean allValid=true;
            String user="",gender="";
            int age;
             RadioButton selectedUserType = (RadioButton)group.getSelectedToggle();
             RadioButton selectedGender = (RadioButton)grp.getSelectedToggle();
             try{
	     user = selectedUserType.getText();
             user = user.toLowerCase();
             gender = selectedGender.getText();
             gender = gender.toLowerCase();
             }
             catch(NullPointerException e){
                 msg.setText("All Fields required");
             }
             
              if(fullname.getText().isEmpty()  || Email.getText().isEmpty()
                || username.getText().isEmpty() || password.getText().isEmpty() || confirmPass.getText().isEmpty()  ){
                  msg.setText("All Fields required");
              }
              else{
                  
                  for(int i=0;i<User.admins.size();i++){
                      if(User.admins.get(i).username.equals(username.getText())){
                          msg.setText("Username already taken");
                          allValid=false;
                      }
                      if(User.admins.get(i).password.equals(password.getText())){
                          msg.setText("Email exists in another account");
                          allValid=false;
                      }
                  }
                  
                  for(int i=0;i<User.customers.size();i++){
                      if(User.customers.get(i).username.equals(username.getText())){
                          msg.setText("Username already taken");
                          allValid=false;
                      }
                      if(User.customers.get(i).password.equals(password.getText())){
                          msg.setText("Email exists in another account");
                          allValid=false;
                      }
                  }
                  
         
                  if(!fullname.getText().contains(" ")){
                      msg.setText("Full Name Required");
                      allValid=false;
                  }
               
                  if(!Email.getText().contains("@gmail.com")&& !Email.getText().contains("@hotmail.com")
                          && !Email.getText().contains("@yahoo.com") && !Email.getText().contains("@icloud.com")){
                      msg.setText("Valid Email Required");
                      allValid=false;
                  }
                  if(!password.getText().equals(confirmPass.getText())){
                      msg.setText("Passwords do not match");
                      allValid=false;
                  }
                  
                  if(password.getText().length()<5){
                      msg.setText("Password requires 5\nor more characters");
                      allValid=false;
                   }
                  
                  try{
                     age=Integer.parseInt(Age.getText()); 
                     if(age<10 || age>100){
                         msg.setText("Invalid Age");
                         allValid=false;
                     }
                  }
                  catch(NumberFormatException e){
                      msg.setText("Invalid age");
                      allValid=false;
                  }
               
                  if(allValid){
                  currUser.name=fullname.getText();
                  currUser.email=Email.getText();
                  currUser.userType = user;
                  currUser.gender=gender;
                  currUser.age=Integer.parseInt(Age.getText());
                  currUser.username=username.getText();
                  currUser.password=password.getText();
                                   
                 try {
                     currUser.signUp(currUser);
                 } catch (IOException ex) {
                     Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
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
                       CustomerForm form = null;
                        try {
                            form = new CustomerForm(pane,1000,600);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       CinemaProject.stage.setTitle("Customer");
                       CinemaProject.stage.setScene(form);
                    }
                 }
                }
              }
                

        }
        
    }
}
