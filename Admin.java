/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import java.io.IOException;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author concept
 */

public class Admin extends User {
    Scanner in=new Scanner(System.in);
    
     public void addMovie(String movieName,String movieGenre,String path,Label msg) throws IOException{
        Movie newMovie=new Movie();
        newMovie.movieName=movieName;
        newMovie.movieGenre=movieGenre;
        newMovie.posterPath=path;
         
        movies.add(newMovie);             //movie is added to list of movies
        msg.setTextFill(Color.DARKGREEN);
        msg.setText("Movie added Successfully");
            
    }
     
public static ArrayList<String> getMovies(){
    ArrayList<String> options=new ArrayList<>();
    for (int i = 0; i < movies.size(); i++) {
            options.add(movies.get(i).movieName);
    }
    return options;
}

public static void removeMovie(String movieName,Label msg,Alert alert) throws IOException, ParseException {


    for(int i=0;i<movies.size();i++){
        if(movies.get(i).movieName.equals(movieName)){
            if(canDeleteMovie(movieName)){
                movies.remove(i);
                for (int j = 0; j < showings.size();) {
                    if (showings.get(j).movie.movieName.equals(movieName)) {
                             showings.remove(j);
                    }
                    else
                        j++;
                }   
                msg.setText("*Movie Deleted Successfully*");
            }
            else{
                alert.setHeaderText("There is an upcoming showing of this movie");
                alert.setContentText("Would you still like to remove movie?");
                alert.getButtonTypes().add(ButtonType.YES);
                alert.getButtonTypes().add(ButtonType.CANCEL);
                System.out.println();
                Optional<ButtonType>result=alert.showAndWait(); 

                if(result.get()==ButtonType.YES){
                    movies.remove(i);
                    for (int j = 0; j < showings.size(); j++) {
                    if (showings.get(j).movie.movieName.equals(movieName)) {
                             showings.remove(j);
                    }
                } 
                    msg.setTextFill(Color.BLACK);
                    msg.setText("*Movie Deleted Successfully*"); 
                }
                else{
                    msg.setTextFill(Color.BLACK);
                    msg.setText("Specified movie is not removed");
                }

            }
        }

    }


}

public static boolean canDeleteMovie(String movieName) throws IOException, ParseException{
    Date date=new Date();
    for(int i=0;i<showings.size();i++){
        if(showings.get(i).movie.movieName.equals(movieName)){
            if(showings.get(i).timing.compareTo(date)==1)
                return false;
        }
    }
    return true;
}

public void addHall(Hall hall, Label msg) {

   
    hall.setSeats();
    specifySeats(hall);
    msg.setTextFill(Color.DARKGREEN);
    msg.setText("Hall Added Successfully");

    halls.add(hall);

}

public void specifySeats(Hall hall) {
    int rows = hall.rows;
    int columns = hall.columns;
    int s = 1;
    int g = 1;
    int p = 1;
    int silver = hall.silverRows;
    int gold = hall.goldRows;
    for (int i = 0; i < silver; i++) {
            for (int j = 0; j < columns; j++) {
                    hall.seats[i][j].seatType = "Silver";
                    hall.seats[i][j].seatName = ("S" + s);
                    s++;
            }
    }

    for (int i = silver; i < (silver + gold); i++) {
            for (int j = 0; j < columns; j++) {
                    hall.seats[i][j].seatType = "Gold";
                    hall.seats[i][j].seatName = ("G" + g);
                    g++;
            }
    }

    for (int i = silver + gold; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                    hall.seats[i][j].seatType = "Platinum";
                    hall.seats[i][j].seatName = ("P" + p);
                    p++;
            }
    }
}

 public static ArrayList<String> getHalls(){
    ArrayList<String> options=new ArrayList<>();
    for (int i = 0; i < halls.size(); i++) {
            options.add(halls.get(i).hallName);
    }
    return options;
}

public static void removeHall(String hallName,Label msg,Alert alert) throws FileNotFoundException, IOException, ParseException {
  

    for (int i = 0; i < halls.size(); i++) {
        if (halls.get(i).hallName.equals(hallName.toLowerCase())) {
            if(canDeleteHall(hallName)){
                halls.remove(i);
                 for (int j = 0; j < showings.size(); j++) {
                    if (showings.get(j).hall.hallName.equals(hallName)) 
                         showings.remove(j);
                 }
                msg.setTextFill(Color.BLACK);
                msg.setText("*Hall Deleted Successfully*");
            }
            else{
                alert.setHeaderText("There is an upcoming showing in this hall");
                alert.setContentText("Would you still like to remove hall?");
                alert.getButtonTypes().add(ButtonType.YES);
                alert.getButtonTypes().add(ButtonType.CANCEL);
                System.out.println();
                Optional<ButtonType>result=alert.showAndWait(); 

                if(result.get()==ButtonType.YES){
                    halls.remove(i);
                    for (int j = 0; j < showings.size();) {
                        if (showings.get(j).hall.hallName.equals(hallName)) {
                                 showings.remove(j);
                        }
                        else
                            j++;
                    } 
                    msg.setTextFill(Color.BLACK);
                    msg.setText("*Hall Deleted Successfully*"); 
                }
                else{
                    msg.setTextFill(Color.BLACK);
                    msg.setText("Specified hall is not removed");
                }
            }   

        }
    }
 

}

  public static boolean canDeleteHall(String hallName)throws IOException,ParseException{
      Date date=new Date();
    for(int i=0;i<showings.size();i++){
        if(showings.get(i).hall.hallName.equals(hallName)){
            if(showings.get(i).timing.compareTo(date)==1)
                return false;
        }
    }
    return true;
}


public void setTicketPrices(int silverP, int goldP, int platP, Label msg) throws IOException {
        Ticket.silverPrice = silverP;
        Ticket.goldPrice = goldP;
        Ticket.platinumPrice = platP;

        FileWriter f = new FileWriter("Ticket Prices.txt");
        PrintWriter add = new PrintWriter(f);
        add.println(Ticket.silverPrice);
        add.println(Ticket.goldPrice);
        add.println(Ticket.platinumPrice);
        f.close();
        msg.setTextFill(Color.BLACK);
        msg.setText("Ticket Prices Set Successfully");

}

public static void setDepositPercentage(double deposit,Label msg) throws IOException {
    PrintWriter dep = new PrintWriter(new FileWriter("Deposit Percentage.txt"));
    dep.println(deposit);
    msg.setTextFill(Color.BLACK);
    msg.setText("Deposit Rate updated Successfully");
    dep.close();
}

public static void printMovieArray() throws IOException,InvocationTargetException {
    String fileName = "Movie Details.dat";
    ObjectOutputStream printer;
    printer = new ObjectOutputStream(new FileOutputStream(fileName));    
    printer.writeObject(movies);
    printer.flush();
    printer.close();

}

public static void printHallArray() throws IOException {   
            PrintWriter print = new PrintWriter(new FileWriter("Hall Info.txt"));
            for (int i = 0; i < halls.size(); i++) {
                    print.println(halls.get(i).hallName);
                    print.println(halls.get(i).rows);
                    print.println(halls.get(i).columns);
                    print.println(halls.get(i).silverRows);
                    print.println(halls.get(i).goldRows);
                    print.println(halls.get(i).platinumRows);
                    for (int j = 0; j < halls.get(i).rows; j++) {
                            for (int k = 0; k < halls.get(i).columns; k++) {
                                    print.println(halls.get(i).seats[j][k].seatName);
                                    print.println(halls.get(i).seats[j][k].seatType);

                            }
                    }
            }
            print.close();
    }

public static ArrayList<String> getHours(){
    ArrayList<String>hours=new ArrayList<>();
   for(int i=0;i<24;i++){
       if(i<10)
           hours.add('0'+Integer.toString(i));
       else
           hours.add(Integer.toString(i));
   }
   return hours;
}

public static ArrayList<String> getMin(){
    ArrayList<String>mins=new ArrayList<>();
   for(int i=0;i<60;i++){
       if(i<10)
           mins.add('0'+Integer.toString(i));
       else
           mins.add(Integer.toString(i));
   }
   return mins;
}


public static void addShowing(String movieName,String hallName,String hours,String min,LocalDate date,double duration,Label msg,Alert alert) throws IOException, ParseException{
        Showing myShowing = new Showing();
        boolean hallAvail=true;
        for(int i=0;i<movies.size();i++){
            if(movies.get(i).movieName.equals(movieName)){
                movies.get(i).inShow = "true";
                myShowing.movie=movies.get(i);
            }
        }
       
      
        for(int i=0;i<halls.size();i++){
          if(halls.get(i).hallName.equals(hallName)){
             
              myShowing.hall=new Hall(halls.get(i));
              
          }
        }
        
        String sec="00";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateInString;
        dateInString = date.toString()+" "+hours+":"+min+":"+sec;
        Date d=sdf.parse(dateInString);
        myShowing.timing=d;
        long seconds=(long)duration*60*60;
        Date finish=Date.from(d.toInstant().plusSeconds(seconds));
        myShowing.movieEnds=finish;
        
        for(int i=0;i<showings.size();i++){
            if(showings.get(i).hall.hallName.equals(hallName)){
                if((d.compareTo(showings.get(i).timing)>=0 && d.compareTo(showings.get(i).movieEnds)<0)||
                (finish.compareTo(showings.get(i).timing)>=0 && finish.compareTo(showings.get(i).movieEnds)<0)){
                    hallAvail=false;
                }
            }
            
        }
        if(hallAvail ){
        showings.add(myShowing);
        msg.setTextFill(Color.DARKGREEN);
        msg.setText("Showing Added Successfully");
        }
        else{
            alert.setHeaderText("");
            alert.setContentText("Hall is not available in the specified timing");
            alert.showAndWait();
        }
      
    }

   

}


