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

public class Train extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(Train.this,Display_train.class);
                startActivity(intent);
            }
        });
        final EditText Trainid = (EditText)findViewById(R.id.Train_no);
        final EditText Trainname = (EditText)findViewById(R.id.Train_name);
        final DatabaseHandler_train db = new DatabaseHandler_train(this);
        Button Create = (Button)findViewById(R.id.Create_train_button5);
        Button Upload = (Button)findViewById(R.id.Upate_train_button2);
        Button Delete = (Button)findViewById(R.id.delete_train);
        final Train_schedule_Data.Train_Data train_data = new Train_schedule_Data.Train_Data();
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "1 row of Train created", Toast.LENGTH_SHORT).show();
                train_data.Train_id = Trainid.getText().toString();
                train_data.Train_name = Trainname.getText().toString();
                db.addData(train_data);
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                train_data.Train_id = Trainid.getText().toString();
                train_data.Train_name = Trainname.getText().toString();
                db.addData(train_data);
                Toast.makeText(getApplicationContext(), "1 row of Train updated", Toast.LENGTH_SHORT).show();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                train_data.Train_id = Trainid.getText().toString();
                train_data.Train_name = Trainname.getText().toString();
                db.deleteData(train_data);
            }
        });
    }

}
