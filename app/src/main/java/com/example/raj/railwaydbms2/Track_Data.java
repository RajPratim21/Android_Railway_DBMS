package com.example.raj.railwaydbms2;

/**
 * Created by raj on 7/12/16.
 */

public class Track_Data {
public String Track_id, from_Station, TO_station;


    Track_Data(String track_id, String from,String to){
        this.Track_id = track_id;
        this.from_Station = from;
        this.TO_station = to;
    }

    public Track_Data() {

    }
}
