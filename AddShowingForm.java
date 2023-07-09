/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import static cinemaproject.User.halls;
import static cinemaproject.User.movies;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
 
/**
 *
 * @author concept
 */
public class AddShowingForm extends Scene{
    boolean isVis=false;
    Label addShowing=new Label();
    Label movie=new Label();
    Label hall=new Label();
    Label date=new Label();
    Label hrs=new Label();
    Label min=new Label();
    Label sec=new Label();
    Label msg=new Label();
    Label l = new Label("no date selected");
    Label duration=new Label();
    Label dec=new Label("*Decimal is required");
    TextField dur=new TextField();
    Button add=new Button();
    Button reset=new Button();
    Alert alert=new Alert(AlertType.WARNING);


    ObservableList<String>movies;
    ComboBox availMovies=new ComboBox();
    ObservableList<String>halls;
    ComboBox availHalls=new ComboBox();
    DatePicker dat = new DatePicker();
    boolean found=true;

    ObservableList<String>movieHours;
    ComboBox startHour=new ComboBox();

    ObservableList<String>movieMin;
    ComboBox startMin=new ComboBox();
    
    GridPane pane=new GridPane();
    GridPane sPane=new GridPane();
    VBox show;
    
    public AddShowingForm(Parent parent, double d, double d1) {
        super(parent, d, d1);
        

        addShowing.setText("Add Showing");
        addShowing.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));
        addShowing.setTranslateX(220);
        addShowing.setTranslateY(-20);

        movie.setText("Movie Name:");
        movie.setFont(Font.font("Times New Roman",18));

        hall.setText("Hall Name:");
        hall.setFont(Font.font("Times New Roman",18));

        date.setText("Date:");
        date.setFont(Font.font("Times New Roman",18));

        hrs.setText("Hours:");
        hrs.setFont(Font.font("Times New Roman",18));

        min.setText("Minutes:");
        min.setFont(Font.font("Times New Roman",18));

        sec.setText("Seconds:");
        sec.setFont(Font.font("Times New Roman",18));
        
        duration.setText("Duration");
        duration.setFont(Font.font("Times New Roman",18));

        add.setText("Add");
        add.setFont(Font.font("Times New Roman",20));
        add.setCursor(Cursor.HAND);

        reset.setText("Reset");
        reset.setFont(Font.font("Times New Roman",20));
        reset.setCursor(Cursor.HAND);

        msg.setFont(Font.font("Times New Roman",15));
        msg.setTranslateY(-30);
        
        dec.setFont(Font.font("Times New Roman",13));
        dec.setTextFill(Color.PURPLE);

        movies=FXCollections.observableList(Admin.getMovies());
        availMovies.setItems(movies);

        halls=FXCollections.observableList(Admin.getHalls());
        availHalls.setItems(halls);
        
        add.setStyle(" -fx-background-color: #d63d62; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(add);
        reset.setStyle(" -fx-background-color:#f08f1e; -fx-background-radius: 10px; -fx-text-fill: #ffffff;");
        AdminForm.setEffect(reset);
        
        dur.setPrefColumnCount(4);


        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e)
            {
               LocalDate value = dat.getValue(); 

                l.setText("Date :" + value);
            }
        };
        dat.setShowWeekNumbers(true);
        dat.setOnAction(event);
        
        dat.setDayCellFactory(picker -> new DateCell() {
        @Override
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            LocalDate today = LocalDate.now();

            setDisable(empty || date.compareTo(today) < 0 );
        }
    });

       movieHours=FXCollections.observableList(Admin.getHours());
       startHour.setItems(movieHours);

       movieMin=FXCollections.observableList(Admin.getMin());
       startMin.setItems(movieMin);

       HBox box=new HBox();
       HBox Hours=new HBox(hrs,startHour);
       HBox Minutes=new HBox(min,startMin);
       VBox vd=new VBox(dur,dec);
       vd.setSpacing(10);
       HBox Duration=new HBox(duration,vd);
       
       Hours.setSpacing(10);
       Minutes.setSpacing(10);
       Duration.setSpacing(10);
       box.setSpacing(30);
       box.getChildren().addAll(Hours,Minutes,Duration);
       
       add.setOnAction(new AddHandler());
       reset.setOnAction(new ResetHandler());
        
        if(movies.isEmpty() && halls.isEmpty()){
            alert.setHeaderText("");
            alert.setContentText("No Movies or Halls Available");
            alert.showAndWait();
            found=false;
        }
        else if(movies.isEmpty()){
            alert.setHeaderText("");
            alert.setContentText("No Movies Available");
            alert.showAndWait();
            found=false;
        }
        else if(halls.isEmpty()){
            alert.setHeaderText("");
            alert.setContentText("No Halls Available");
            alert.showAndWait();
            found=false;
        }
        
        if(!found){
             add.setDisable(true);
        }
        
        availMovies.setMinWidth(100);
        availMovies.setMaxWidth(100);
        availHalls.setMinWidth(100);
        availHalls.setMaxWidth(100);
        
        availHalls.setTranslateX(16);
        dat.setTranslateX(60);
        l.setTranslateX(60);
        
        HBox m=new HBox(movie,availMovies);
        HBox h=new HBox(hall,availHalls);
        HBox hd=new HBox(date,dat,l);
        HBox buttons=new HBox(reset,add);
        
        m.setSpacing(20);
        h.setSpacing(20);
        hd.setSpacing(20);
        buttons.setSpacing(60);
        buttons.setTranslateX(200);
        buttons.setTranslateY(20);

        sPane.add(addShowing, 0,0 );
        sPane.add(m, 0,1 );
        sPane.add(h, 0,2 );
        sPane.add(hd, 0,3 );
        sPane.add(box, 0,4);
        sPane.add(buttons, 0,5 );
        sPane.add(msg, 0, 6);


      
       sPane.setStyle("-fx-background-color: #FFFFFF;");
       sPane.setBorder(Border.stroke(Color.GREY));
       sPane.setPadding(new Insets(20));
       sPane.setMinWidth(700);
       sPane.setMaxWidth(700);
       sPane.setMinHeight(500);
       sPane.setMaxHeight(500);
       sPane.setTranslateY(27);
       sPane.setTranslateX(28);
       sPane.setPadding(new Insets(50));
       sPane.setHgap(20);
       sPane.setVgap(40);
       
       pane.add(sPane, 0, 0);
       pane.setPadding(new Insets(20));
       pane.setHgap(20);
       pane.setVgap(15);
       
       
       Image bg=new Image("C:/Users/concept/OneDrive/Desktop/Cinema Booking System/bg.jpg");
        pane.setBackground(new Background(new BackgroundImage(bg,BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,
                   new BackgroundSize(800,600,false,false,true,false))));
       pane.setMinWidth(800);
       pane.setMaxWidth(800);
       
       HBox Box=new HBox(AdminForm.pane,pane);

       setRoot(Box);

    }

    class AddHandler implements EventHandler<ActionEvent>{
         @Override
         public void handle(ActionEvent e){
             if(availMovies.getSelectionModel().isEmpty() || availHalls.getSelectionModel().isEmpty() || 
                     startHour.getSelectionModel().isEmpty() || startMin.getSelectionModel().isEmpty()
                     || dat.getValue()==null || dur.getText().isEmpty()){
                 msg.setText("All Fields Required");
             }
             else{
                 
                 boolean validDur=true;
                 try{
                     double d=Double.parseDouble(dur.getText());
                     if(d<0 || d>5)
                         validDur=false;
                 }catch(NumberFormatException x){
                     validDur=false;
                 }
             
            if(validDur){     
             String movieName=(String)availMovies.getSelectionModel().getSelectedItem();
             String hallName=(String)availHalls.getSelectionModel().getSelectedItem();
             String h =(String)startHour.getSelectionModel().getSelectedItem();
             String m =(String)startMin.getSelectionModel().getSelectedItem();
             LocalDate d=dat.getValue();
             double du=Double.parseDouble(dur.getText());
             try {     
                 Admin.addShowing(movieName,hallName,h,m,d,du,msg,alert);
                 isVis=true;
                 show=new VBox();
                 show.setAlignment(Pos.CENTER);
                 show.setTranslateX(480);
                 show.setTranslateY(-90);
                 show.setMaxHeight(280);
                 show.setMaxWidth(250);
                 show.setPadding(new Insets(10));
                 show.setSpacing(2.5);
                 Label poster=new Label();
                 int index=User.showings.size()-1;
                 String p=User.showings.get(index).movie.posterPath;
                 Image im=new Image(p);
                 ImageView v=new ImageView(im);
                 v.setFitHeight(150);
                 v.setFitWidth(100);
                 poster.setGraphic(v);
                 Label mName=new Label("    "+User.showings.get(index).movie.movieName);
                 Label hName=new Label("     "+User.showings.get(index).hall.hallName);
                 Label date=new Label();
                 int n=User.showings.size()-1;
                 Date da = User.showings.get(n).timing;
                    String pattern = "EEEEE";
                    String patt= "MMMMM yyyy";
                    String pt="dd-MM-yy";
                    SimpleDateFormat day=new SimpleDateFormat(pt);
                    String dayInInt=day.format(da);
                    SimpleDateFormat sdf=new SimpleDateFormat(pattern);
                    SimpleDateFormat sd=new SimpleDateFormat(patt);
                    String time="HH:mm";
                    SimpleDateFormat st=new SimpleDateFormat(time);
                    date.setText(sdf.format(da)+" "+ dayInInt.substring(0, dayInInt.indexOf('-'))+
                     " "+sd.format(da)+"\n              "+st.format(da)
                    +" - "+st.format(User.showings.get(n).movieEnds));
                Label added=new Label("Added Showing");
                added.setTranslateX(10);
                
                added.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
                mName.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
                hName.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
                date.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
                    show.getChildren().addAll(added,poster,mName,hName,date);
                    pane.add(show, 0, 0);
                    
             } catch (IOException ex) {
                 Logger.getLogger(AddShowingForm.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ParseException ex) {
                 Logger.getLogger(AddShowingForm.class.getName()).log(Level.SEVERE, null, ex);
             }
             }
            else
                msg.setText("Numeric duration required");
            }
             

         }
    }
    
     class ResetHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            availMovies.setValue(null);
            availHalls.setValue(null);
            startHour.setValue(null);
            startMin.setValue(null);
            dat.setValue(null);
            dur.setText(null);
            l.setText("no date selected");
            msg.setText(null);
            if(isVis){
                show.setVisible(false);
            }
        }
    }
    
    
}
