package com.example.raj.railwaydbms2;

/**
 * Created by raj on 7/12/16.
 */

public class Train_schedule_Data {

public String Train_id, Station_id;
    Train_schedule_Data(){

    }

    /**
     * Created by raj on 7/12/16.
     */

    public static class Train_Data {

        public String Train_id, Train_name;

        Train_Data(String _id, String name ){
            this.Train_id = _id;
            this.Train_name = name;
        }

        public Train_Data() {

        }
    }
}

