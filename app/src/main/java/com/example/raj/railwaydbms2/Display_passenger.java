package com.example.raj.railwaydbms2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Display_passenger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_passenger);
        DatabaseHandler db = new DatabaseHandler(this);
        ListView lv = (ListView)findViewById(R.id.listView_pass);
        ArrayList<Passenger_data> data = new ArrayList(db.getAllData());
        Log.e("Hello","world");
        Log.e("Data",data.toString());
        ArrayList<Passenger_data> theList = new ArrayList<>();

        /*while(data.moveToNext()){

            theList.add(data.getString(1));
            ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            lv.setAdapter(listAdapter);

        }*/
        for(Passenger_data dataitem:data)
            Log.e("View data : ",dataitem.toString());
        ListViewAdapter adapter=new ListViewAdapter(this,data);
        lv.setAdapter(adapter);
    }
}
