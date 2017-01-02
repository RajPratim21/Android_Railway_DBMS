package com.example.raj.railwaydbms2;

import java.security.PublicKey;

import static android.R.attr.name;

/**
 * Created by raj on 7/12/16.
 */

public class Station_data {
    public String Station_id, Station_name;

    public Station_data(){

    }

     Station_data(String station_id, String station_name){

        this.Station_name = station_name;
         this.Station_id = station_id;
    }



}
