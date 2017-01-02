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

public class Passenger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(Passenger.this,Display_passenger.class);
                startActivity(intent);
            }
        });

        final Passenger_data passenger_data = new Passenger_data();
        final EditText Name  =  (EditText)findViewById(R.id.Name);
        final EditText From_station  =  (EditText)findViewById(R.id.From_Station);
        final EditText To_station = (EditText)findViewById(R.id.To_Station);
        final EditText Date = (EditText)findViewById(R.id.Date);
        final EditText Train = (EditText)findViewById(R.id.train);

        Button Create = (Button)findViewById(R.id.Passenger_create_button);
        Button Upload = (Button)findViewById(R.id.Update_passenger_button);
        Button Delete = (Button)findViewById(R.id.Delete_pasenger);
        final DatabaseHandler databaseHandler= new DatabaseHandler(this);
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    passenger_data.Name = Name.getText().toString();
                    passenger_data.Train_no = Train.getText().toString();
                    passenger_data.To_station = To_station.getText().toString();
                    passenger_data.From_station = From_station.getText().toString();
                    passenger_data.Date = Date.getText().toString();
                    databaseHandler.addData(passenger_data);
                Toast.makeText(getApplicationContext(), "1 row Passenger created", Toast.LENGTH_SHORT).show();
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                passenger_data.Name = Name.getText().toString();
                passenger_data.Train_no = Train.getText().toString();
                passenger_data.To_station = To_station.getText().toString();
                passenger_data.From_station = From_station.getText().toString();
                passenger_data.Date = Date.getText().toString();
                databaseHandler.updateData(passenger_data);
                Toast.makeText(getApplicationContext(), "1 row Passenger Updated", Toast.LENGTH_SHORT).show();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passenger_data.Name = Name.getText().toString();
                passenger_data.Train_no = Train.getText().toString();
                passenger_data.To_station = To_station.getText().toString();
                passenger_data.From_station = From_station.getText().toString();
                passenger_data.Date = Date.getText().toString();
                databaseHandler.deleteData(passenger_data);
                Toast.makeText(getApplicationContext(), "1 row Passenger Updated", Toast.LENGTH_SHORT).show();


            }
        });

    }

}
