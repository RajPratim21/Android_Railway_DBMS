package com.example.raj.railwaydbms2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Display_track extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_track);
        DatabaseHandler_track db = new DatabaseHandler_track(this);
        ListView lv = (ListView)findViewById(R.id.listView_track);
        ArrayList<Track_Data> data = new ArrayList(db.getAllData());
        Log.e("Hello","world");
        Log.e("Data",data.toString());
        ArrayList<Track_Data> theList = new ArrayList<>();

        /*while(data.moveToNext()){

            theList.add(data.getString(1));
            ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            lv.setAdapter(listAdapter);

        }*/
        for(Track_Data dataitem:data)
            Log.e("View data : ",dataitem.toString());
        ListViewAdaptertrack adapter=new ListViewAdaptertrack(this, data);
        lv.setAdapter(adapter);

    }
}
