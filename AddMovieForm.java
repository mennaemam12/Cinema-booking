

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import static cinemaproject.CinemaProject.stage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import static javax.swing.text.StyleConstants.Background;


public class AddMovieForm extends Scene
{
    Admin admin=new Admin();
    String path=null;
    Label addMovie = new Label();
    Label movieName = new Label();
    TextField tfmovieName = new TextField();
    Label movieGenre = new Label();
    TextField tfmovieGenre = new TextField();
    Label poster=new Label();
    Label avail=new Label();
    Label post=new Label();
    Label mName=new Label();
    Label lName=new Label();
    Label mGenre=new Label();
    Label lGenre=new Label();
    Button done = new Button();
    Button reset=new Button();
    Button insert=new Button();
    Button left=new Button();
    Button right=new Button();
    Label msg = new Label();
    Alert alert=new Alert(AlertType.ERROR);
    GridPane pane = new GridPane();
    GridPane mPane = new GridPane();
    GridPane availPane=new GridPane();
    HBox n=new HBox();
    HBox g=new HBox();
    HBox pBox=new HBox();
    int index;
    
    public AddMovieForm(Parent parent, double d, double d1) 
    {
        super(parent, d, d1);
        
        addMovie.setText("Add Movie");
        addMovie.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));
        addMovie.setTranslateX(130);
        
        movieName.setText("Movie Name:");
        movieName.setFont(Font.font("Times New Roman",18));
        
        movieGenre.setText("Movie Genre:");
        movieGenre.setFont(Font.font("Times New Roman",18));
        
        poster.setText("Movie Poster:");
        poster.setFont(Font.font("Times New Roman",18));
        
        insert.setText("+");
        insert.setFont(Font.font("Times New Roman",50));
        insert.setTextFill(Color.DARKGRAY);
        insert.setMinHeight(150);
        insert.setMaxHeight(150);
        insert.setMaxWidth(100);
        insert.setMinWidth(100);
        
        FileChooser fileChooser=new FileChooser();
        EventHandler<ActionEvent> event =
        new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent e)
            {
                // get the file selected
                File file = fileChooser.showOpenDialog(stage);
                if(file!=null){
                path=file.getAbsolutePath();
                Image img=new Image(path);
                ImageView view=new ImageView(img);
                view.setFitHeight(150);
                view.setFitWidth(100);
                insert.setText(null);
                insert.setGraphic(null);
                insert.setGraphic(view);
                }
 
            }
        };
        insert.setOnAction(event);
        AdminForm.setEffect(insert);
        insert.setCursor(Cursor.HAND);
        
        done.setText("Add");
        done.setFont(Font.font("Times New Roman",20));
        done.setOnAction(new AddHandler());
        done.setCursor(Cursor.HAND);
        
        reset.setText("Reset");
        reset.setFont(Font.font("Times New Roman",20));
        reset.setOnAction(new ResetHandler());
        reset.setTranslateX(30);
        reset.setCursor(Cursor.HAND);
        
        msg.setFont(Font.font("Times New Roman",15));
        msg.setTranslateY(40);
        
        done.setStyle(" -fx-background-color: #d63d62; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(done);
        reset.setStyle(" -fx-background-color:#f08f1e; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(reset);
        
        HBox name=new HBox(movieName,tfmovieName);
        HBox genre=new HBox(movieGenre,tfmovieGenre);
        HBox buttons=new HBox(reset,done);
        HBox mPoster=new HBox(poster,insert);
        
        name.setSpacing(10);
        genre.setSpacing(10);
        mPoster.setSpacing(35);
        buttons.setSpacing(80);
        
        name.setTranslateX(60);
        genre.setTranslateX(60);
        mPoster.setTranslateX(60);
        buttons.setTranslateX(60);
        
        
       mPane.add(addMovie,0,0);
       mPane.add(name,0,1);
       mPane.add(genre, 0, 2);
       mPane.add(mPoster,0,3);
       mPane.add(buttons,0,4);
       mPane.add(msg,0,3);
       
            Circle c=new Circle(2.5);
            right.setText(">");
            right.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
            right.setTextFill(Color.WHITE);
            left.setText("<");
            left.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
            left.setTextFill(Color.WHITE);
            right.setShape(c);
            left.setShape(c);
            left.setStyle("-fx-background-color:#02c0e1;");
            right.setStyle("-fx-background-color:#02c0e1;");
            AdminForm.setEffect(left);
            AdminForm.setEffect(right);
            left.setCursor(Cursor.HAND);
            right.setCursor(Cursor.HAND);
            
            left.setOnAction(new leftHandler());
            right.setOnAction(new rightHandler());
            
            avail.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));
            avail.setAlignment(Pos.CENTER);

            post.setMinHeight(150);
            post.setMaxHeight(150);
            post.setMaxWidth(100);
            post.setMinWidth(100);
            post.setTranslateX(5);
            
            mName.setText("Name:");
            mName.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
            lName.setFont(Font.font("Times New Roman",18));
            
            mGenre.setText("Genre:");
            mGenre.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
            lGenre.setFont(Font.font("Times New Roman",18));
            
            n.getChildren().addAll(mName,lName);
            g.getChildren().addAll(mGenre,lGenre);
            
            n.setTranslateX(55);
            g.setTranslateX(55);
            left.setTranslateY(50);
            right.setTranslateY(50);
       
       if(!User.movies.isEmpty()){  
            lName.setText(User.movies.get(0).movieName);
            lGenre.setText(User.movies.get(0).movieGenre);
            avail.setTranslateY(-30);
            avail.setText("Available\n  Movies");
            index=0;
            String p=User.movies.get(0).posterPath;
            Image im=new Image(p);
            ImageView v=new ImageView(im);
            v.setFitHeight(150);
            v.setFitWidth(100);
            post.setGraphic(v); 
            availPane.add(avail, 0, 0);
            pBox.setSpacing(20);
            pBox.getChildren().addAll(left,post,right);
            availPane.add(pBox, 0, 1);
            
            avail.setTranslateX(55);
                
            if(User.movies.size()==1){
               left.setVisible(false);
               right.setVisible(false);
            }
            
            availPane.add(n, 0, 2);
            availPane.add(g, 0, 3);
       
       }
       else{
           avail.setText("      No\nAvailable\n  Movies");
           availPane.add(avail, 0, 0);
       }
       
       
       n.setSpacing(10);
       g.setSpacing(10);
       availPane.setPadding(new Insets(30));
       availPane.setVgap(15);
       availPane.setStyle("-fx-background-color: #FFFFFF;");
       availPane.setBorder(Border.stroke(Color.GREY));
       availPane.setMinWidth(250);
       availPane.setMaxWidth(250);
       availPane.setTranslateX(20);
       availPane.setTranslateY(30);
       availPane.setAlignment(Pos.CENTER);
       
       pane.add(mPane, 0, 0);
       pane.add(availPane, 1, 0);
       
       
       mPane.setStyle("-fx-background-color: #FFFFFF;");
       mPane.setBorder(Border.stroke(Color.GREY));
       mPane.setPadding(new Insets(30));
       mPane.setMinWidth(450);
       mPane.setMaxWidth(450);
       mPane.setTranslateX(15);
       mPane.setTranslateY(30);
       mPane.setVgap(40);
       mPane.setHgap(20);
       pane.setPadding(new Insets(20));
       pane.setHgap(20);
       pane.setVgap(15);
       
       Image bg=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/bg.jpg");
       pane.setBackground(new Background(new BackgroundImage(bg,BackgroundRepeat.NO_REPEAT,
               BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,
                  new BackgroundSize(800,600,false,false,true,false))));
       pane.setMinWidth(800);
       pane.setMaxWidth(800);
       
       HBox box=new HBox(AdminForm.pane,pane);
       
       setRoot(box);
    }
    
     class leftHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            if(index==0)
                index=User.movies.size()-1;
            else
                index--;
            lName.setText(User.movies.get(index).movieName);
            lGenre.setText(User.movies.get(index).movieGenre);
            String p=User.movies.get(index).posterPath;
            Image im=new Image(p);
            ImageView v=new ImageView(im);
            v.setFitHeight(150);
            v.setFitWidth(100);
            post.setGraphic(v);
        }
         
     }
     
     class rightHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            if(index==User.movies.size()-1)
                index=0;
            else
                index++;
            lName.setText(User.movies.get(index).movieName);
            lGenre.setText(User.movies.get(index).movieGenre);
            String p=User.movies.get(index).posterPath;
            Image im=new Image(p);
            ImageView v=new ImageView(im);
            v.setFitHeight(150);
            v.setFitWidth(100);
            post.setGraphic(v);
        }
         
     }
    
     class ResetHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
           tfmovieName.setText(null);
           tfmovieGenre.setText(null);
           insert.setGraphic(null);
           insert.setText("+");
           insert.setFont(Font.font("Times New Roman",50));
           insert.setTextFill(Color.DARKGRAY);
           msg.setText(null);
        }
    }
    
    class AddHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            msg.setTextFill(Color.RED);
            if(tfmovieName.getText().isEmpty() || tfmovieGenre.getText().isEmpty()){
                msg.setText("All Fields Required");
            }
            else if(path==null){
                msg.setText("Insert Movie Poster");
            }
            else{
                boolean isValid;
                try{
                    isValid=false;
                     int i=Integer.parseInt(tfmovieName.getText());
                     msg.setText("Text required");
                     int j=Integer.parseInt(tfmovieGenre.getText());
                     msg.setText("Text required");
                     
                }
                catch(NumberFormatException x){
                    isValid=true;
                }
                
                     for(int i=0;i<User.movies.size();i++){
                    if(User.movies.get(i).movieName.equals(tfmovieName.getText())){
                        isValid=false;
                        alert.setHeaderText("");
                        alert.setContentText(" This Movie is Already Available");
                        alert.showAndWait();
                    }
                }
                  
                
                if(isValid){
                    
                try {
                    admin.addMovie(tfmovieName.getText(), tfmovieGenre.getText(),path, msg);
                    index=User.movies.size()-1;
                    lName.setText(User.movies.get(index).movieName);
                    lGenre.setText(User.movies.get(index).movieGenre);
                    avail.setTranslateY(-30);
                    avail.setText("Available\n  Movies");
                    String p=User.movies.get(index).posterPath;
                    Image im=new Image(p);
                    ImageView v=new ImageView(im);
                    v.setFitHeight(150);
                    v.setFitWidth(100);
                    post.setGraphic(v); 
                    pBox.setSpacing(20);
                    if(User.movies.size()==1){
                       availPane.add(n, 0, 2);
                       availPane.add(g, 0, 3); 
                       pBox.getChildren().addAll(left,post,right);
                       availPane.add(pBox, 0, 1); 
                       left.setVisible(false);
                       right.setVisible(false);
                    }
                    else
                    {
                       left.setVisible(true);
                       right.setVisible(true); 
                    }
                   

                    avail.setTranslateX(55);
                    n.setTranslateX(55);
                    g.setTranslateX(55);
                    left.setTranslateY(50);
                    right.setTranslateY(50);
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(AddMovieForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        }
    }
   
    
}
