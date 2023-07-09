/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaproject;

import java.util.Date;

/**
 *
 * @author concept
 */
public class Showing {
    public Movie movie = new Movie();
    public Date timing;
    public Date movieEnds;
    public Hall hall=new Hall();
    public String isFull = "false";
    public int seatsReserved = 0;  
}
