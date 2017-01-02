package com.example.raj.railwaydbms2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Display_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_schedule);
        DatabaseHandlershedule db = new DatabaseHandlershedule(this);
        ListView lv = (ListView)findViewById(R.id.listView_schedule);
        ArrayList<Train_schedule_Data> data = new ArrayList(db.getAllData());
        Log.e("Hello","world");
        Log.e("Data",data.toString());
        ArrayList<Train_schedule_Data> theList = new ArrayList<>();

        /*while(data.moveToNext()){

            theList.add(data.getString(1));
            ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            lv.setAdapter(listAdapter);

        }*/
        for(Train_schedule_Data dataitem:data)
            Log.e("View data : ",dataitem.toString());
        ListViewSchedule adapter=new ListViewSchedule(this, data);
        lv.setAdapter(adapter);
    }
}
