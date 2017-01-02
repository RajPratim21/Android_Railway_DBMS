package com.example.raj.railwaydbms2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button passenger_button =  (Button)findViewById(R.id.passenger_button);
        Button station_button = (Button)findViewById(R.id.station_button);
        Button Train_button = (Button)findViewById(R.id.Train_button);
        Button Track_button = (Button)findViewById(R.id.track_button);
        Button Schedule_button = (Button)findViewById(R.id.Schedule_button);

        passenger_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Passenger.class);
                startActivity(intent);
            }
        });

        station_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Station.class);
                startActivity(intent);
            }
        });

        Train_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Train.class);
                startActivity(intent);
            }
        });

        Track_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Tracks.class);
                startActivity(intent);
            }
        });

        Schedule_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TrainSchedule.class);
                startActivity(intent);

            }
        });
    }
}
