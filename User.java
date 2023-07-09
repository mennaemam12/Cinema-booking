/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import static cinemaproject.User.showings;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class User  implements Serializable{
    Scanner input=new Scanner(System.in);
    public String name;
    public String username;
    public String email;
    public String password;
    public String userType;
    public String gender;
    public int age;
    public static User currUser;
    public static ArrayList<User>admins=new ArrayList<>();
    public static ArrayList<User>customers=new ArrayList<>();
    public static ArrayList<Movie>movies=new ArrayList<>();
    public static ArrayList<Hall> halls = new ArrayList<>();
    public static ArrayList<Showing> showings=new ArrayList<>();
    public static ArrayList<Booking> bookings = new ArrayList<>();
    
    public static int count=0;
    
    public User signIn(String tempUser,String tempPass,Label msg,Alert alert)throws IOException{
        boolean found=false;  //check if account is found
        
        if(count<3 && !found){
        String incorrect="username";
        
        for(int i=0;i<admins.size();i++){
            if(admins.get(i).username.equals(tempUser)){
                if(admins.get(i).password.equals(tempPass)){
                    found=true;
                    msg.setText("Admin Signed In Successfully");
                    currUser=admins.get(i);
                   
                }
                else
                    incorrect="password";
            }
            
        }
        if(!found){
        for(int i=0;i<customers.size();i++){
              if(customers.get(i).username.equals(tempUser)){
                if(customers.get(i).password.equals(tempPass)){
                    found=true;
                    msg.setText("Customer Signed In Successfully");
                    currUser=customers.get(i);
                }
                else
                    incorrect="password";
            }
        }
        }
        //inform user if username or password are incorrect
        if(incorrect.equals("password") ){
            msg.setTextFill(Color.RED);
            msg.setText("Incorrect Password.");  
            
        }
        
        else{
            if(!found){
                msg.setTextFill(Color.RED);
            msg.setText("Incorrect Username.");
            }
        }   
        }
        if(!found)
            count++;
         if(count==3){
         
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("you have exceeded maximum number of trials");
            alert.showAndWait();
           // System.exit(1);
        }
         return currUser;
    }
        
        
    
    public void signUp(User user) throws IOException{
       
        if(user.userType.equals("admin")){
           admins.add(user);
        }
        else if(userType.equals("customer"))
        {
         customers.add(user);
        } 
        currUser=user;
        
        
        
    }
    
    public static void printAdminFile()throws IOException{
        PrintWriter f=new PrintWriter("Admin.txt");
        for(int i=0;i<admins.size();i++){
            f.println(admins.get(i).name);
            f.println(admins.get(i).age);
            f.println(admins.get(i).gender);
            f.println(admins.get(i).email);
            f.println(admins.get(i).username);
            f.println(admins.get(i).password);
            
        }
        f.close();
        
    }
    
    public static void fillAdminArray() throws IOException{
          String adminFile="Admin.txt";
          File file=new File(adminFile);
          if(file.exists() && file.length()!=0){
              Scanner reader=new Scanner(new FileReader(adminFile));
              while(reader.hasNext()){
                  User user=new User();
                  user.name=reader.nextLine();
                  user.age=Integer.parseInt(reader.nextLine());
                  user.gender=reader.nextLine();
                  user.email=reader.nextLine();
                  user.username=reader.nextLine();
                  user.password=reader.nextLine();
                  user.userType="admin";
                  admins.add(user);
              }
              reader.close();
          }
    }
    
    public static void printCustomerFile() throws IOException{
        FileWriter writer=new FileWriter("Customer.txt");
        PrintWriter f=new PrintWriter(writer);
        for(int i=0;i<customers.size();i++){
            f.println(customers.get(i).name);
             f.println(customers.get(i).age);
            f.println(customers.get(i).gender);
            f.println(customers.get(i).email);
            f.println(customers.get(i).username);
            f.println(customers.get(i).password);
        }
        writer.close();
        f.close();
    }
    
    public static void fillCustomerArray()throws IOException{
         String adminFile="Customer.txt";
          File file=new File(adminFile);
          if(file.exists() && file.length()!=0){
              Scanner reader=new Scanner(new FileReader(adminFile));
              while(reader.hasNext()){
                  User user=new User();
                  user.name=reader.nextLine();
                  user.age=Integer.parseInt(reader.nextLine());
                  user.gender=reader.nextLine();
                  user.email=reader.nextLine();
                  user.username=reader.nextLine();
                  user.password=reader.nextLine();
                  user.userType="customer";
                  customers.add(user);
              }
              reader.close();
          }
    }
    
    public static void fillMovieArray()throws IOException, ClassNotFoundException{
     String movieFile="Movie Details.dat";
     File file=new File(movieFile);
     if(file.exists() && file.length()!=0){
     ObjectInputStream read= new ObjectInputStream(new FileInputStream(movieFile));
     movies=(ArrayList<Movie>) read.readObject();
     read.close();
     }
   }

 //save hall details in halls arraylist to file without append
 public static void fillHallsArray() throws FileNotFoundException {
     File file=new File("Hall Info.txt");
     if(file.exists() && file.length()!=0){
     Scanner readHalls = new Scanner(new FileReader("Hall Info.txt"));
     while (readHalls.hasNext()) {
         Hall x = new Hall();
         x.hallName = readHalls.nextLine();
         x.rows = Integer.parseInt(readHalls.nextLine());
         x.columns= Integer.parseInt(readHalls.nextLine());
         x.setSeats();
         x.silverRows=Integer.parseInt(readHalls.nextLine());
         x.goldRows=Integer.parseInt(readHalls.nextLine());
         x.platinumRows=Integer.parseInt(readHalls.nextLine());
         for (int i = 0; i < x.rows; i++) {
             for (int j = 0; j < x.columns; j++) {
                     x.seats[i][j].seatName = readHalls.nextLine();
                     x.seats[i][j].seatType = readHalls.nextLine();
             }
     }
         halls.add(x);
     }
     readHalls.close();
     }
 }
    
    
public static void fillShowingsArray() throws FileNotFoundException, ParseException {

            File file = new File("Showings.txt");
            if (file.exists() && file.length()!=0) {
                Scanner read = new Scanner(new FileReader(file));
                while (read.hasNext()) {
                        Showing myShow = new Showing();
                        myShow.movie.movieName = read.nextLine();
                        myShow.movie.movieGenre = read.nextLine();

                        myShow.isFull = read.nextLine();
                        myShow.seatsReserved = Integer.parseInt(read.nextLine());
                        String stringdate = read.nextLine();
                        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                        Date date = sdf.parse(stringdate);
                        myShow.timing = date;
                        
                        String movieEnds=read.nextLine();
                        Date finish=sdf.parse(movieEnds);
                        myShow.movieEnds=finish;

                        Hall myHall = new Hall();
                        String hallName = read.nextLine();
                        for (int i = 0; i < halls.size(); i++) {
                                if (halls.get(i).hallName.equals(hallName)) {
                                        myHall = new Hall(halls.get(i));

                                }
                        }

                        for (int i = 0; i < myHall.rows; i++) {
                                for (int j = 0; j < myHall.columns; j++) {
                                        myHall.seats[i][j].seatName = read.nextLine();
                                        myHall.seats[i][j].seatType = read.nextLine();
                                        myHall.seats[i][j].isReserved = read.nextLine();
                                }
                        }
                        myShow.hall = myHall;
                        showings.add(myShow);
                    }
                    read.close();
            }

	}


public static void editShowingFile() throws FileNotFoundException, ParseException {
		PrintWriter write = new PrintWriter("Showings.txt");
		for (int i = 0; i < showings.size(); i++) {
			write.println(showings.get(i).movie.movieName);
			write.println(showings.get(i).movie.movieGenre);
			write.println(showings.get(i).isFull);
			write.println(showings.get(i).seatsReserved);
			write.println(showings.get(i).timing);
                        write.println(showings.get(i).movieEnds);
			write.println(showings.get(i).hall.hallName);
			for (int x = 0; x < showings.get(i).hall.rows; x++) {
				for (int j = 0; j < showings.get(i).hall.columns; j++) {
					write.println(showings.get(i).hall.seats[x][j].seatName);
					write.println(showings.get(i).hall.seats[x][j].seatType);
					write.println(showings.get(i).hall.seats[x][j].isReserved);
				}
			}

		}
		write.close();

	}
   
           
}


