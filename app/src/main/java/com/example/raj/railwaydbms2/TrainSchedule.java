package com.example.raj.railwaydbms2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TrainSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(TrainSchedule.this,Display_schedule.class);
                startActivity(intent);
            }
        });

        Button Create = (Button)findViewById(R.id.Schedule_create);
        Button Upload = (Button)findViewById(R.id.button);
        Button Delete = (Button)findViewById(R.id.Delete_schedule);
        final Train_schedule_Data train_schedule_data = new Train_schedule_Data();
        final EditText trainid = (EditText)findViewById(R.id.Train_id);
        final EditText stationid = (EditText)findViewById(R.id.Station_id);
        final DatabaseHandlershedule db = new DatabaseHandlershedule(this);
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                train_schedule_data.Train_id = trainid.getText().toString();
                train_schedule_data.Station_id= stationid.getText().toString();
                db.addData(train_schedule_data);
                Toast.makeText(getApplicationContext(), "1 row Schedule created", Toast.LENGTH_LONG).show();

            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                train_schedule_data.Train_id = trainid.getText().toString();
                train_schedule_data.Station_id= stationid.getText().toString();
                db.updateData(train_schedule_data);
                Toast.makeText(getApplicationContext(), "1 row Schedule Updated", Toast.LENGTH_SHORT).show();
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                train_schedule_data.Train_id = trainid.getText().toString();
                train_schedule_data.Station_id= stationid.getText().toString();
                db.deleteData(train_schedule_data);

            }
        });
    }

}
