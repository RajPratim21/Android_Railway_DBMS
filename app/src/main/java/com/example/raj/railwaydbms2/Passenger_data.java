package com.example.raj.railwaydbms2;

/**
 * Created by raj on 7/12/16.
 */

public class Passenger_data {

    public String Name, From_station, To_station, Train_no, Date;

    public Passenger_data(){

    }
    public Passenger_data(String name, String from_station, String to_station, String train_no, String date){
        this.Name   = name;
        this.From_station = from_station;
        this.To_station = to_station;
        this.Train_no = train_no;
        this.Date = date;
    }



}
