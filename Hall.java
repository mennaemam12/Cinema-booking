/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

/**
 *
 * @author concept
 */
public class Hall {
    public String hallName;
    public int rows;
    public int columns;
    public Seats[][] seats;
    
    public int silverRows;
    public int goldRows;
    public int platinumRows;
    
    public Hall(){
        
    }
    
    public Hall(Hall hall){
        hallName=hall.hallName;
        rows=hall.rows;
        columns=hall.columns;
        silverRows=hall.silverRows;
        goldRows=hall.goldRows;
        platinumRows=hall.platinumRows;
        setSeats();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                seats[i][j].seatName=hall.seats[i][j].seatName;
                seats[i][j].seatType=hall.seats[i][j].seatType;
                seats[i][j].isReserved=hall.seats[i][j].isReserved;
            }
        }
    }
    //print hall seats
    public void displayHall(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++)
            {
                System.out.print((seats[i][j].seatName)+" ");
            }
            System.out.println();
        }
            
    }
    //initialize array of seats
    public void setSeats(){
        seats=new Seats[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                seats[i][j]=new Seats();
            }
        }
    }

	
}
