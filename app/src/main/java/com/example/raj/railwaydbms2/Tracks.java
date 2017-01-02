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

public class Tracks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(Tracks.this,Display_track.class);
                startActivity(intent);
            }
        });
        final Track_Data track_data = new Track_Data();

        final DatabaseHandler_track db = new DatabaseHandler_track(this);
        final EditText ToStation = (EditText)findViewById(R.id.To_Station_Track);
        final EditText FromStation = (EditText)findViewById(R.id.From_Station_Track);
        final EditText Track_id = (EditText)findViewById(R.id.Track_no);
        Button Create = (Button)findViewById(R.id.track_create_button);
        Button Upload = (Button)findViewById(R.id.track_update_button);
        Button Delete = (Button)findViewById(R.id.delete_track);

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                track_data.TO_station = ToStation.getText().toString();
                track_data.from_Station  = FromStation.getText().toString();
                track_data.Track_id = Track_id.getText().toString();
                db.addData(track_data);
                Toast.makeText(getApplicationContext(), "1 row Track created", Toast.LENGTH_SHORT).show();
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                track_data.TO_station = ToStation.getText().toString();
                track_data.from_Station  = FromStation.getText().toString();
                track_data.Track_id = Track_id.getText().toString();
                db.updateData(track_data);
                Toast.makeText(getApplicationContext(), "1 row Track Updated", Toast.LENGTH_SHORT).show();
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                track_data.TO_station = ToStation.getText().toString();
                track_data.from_Station  = FromStation.getText().toString();
                track_data.Track_id = Track_id.getText().toString();
                db.deleteData(track_data);

            }
        });

    }



}
