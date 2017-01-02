package com.example.raj.railwaydbms2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajPratim on 7/7/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASEVERSION = 1;

    private static final String DATABASENAME = "PassengerManager";

    private static final String TABLE_PASSENGER = "passengerData";

    public static final String KEY_From_Station = "from_station";
    public static final String KEY_TO_Station = "to_station";
    public static final String KEY_NAME = "name";
    public static final String KEY_TRAIN= "train_id";
    public static final String KEY_DATE = "date";




    public DatabaseHandler(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PASSENGER + "("
                + KEY_From_Station + " Text ," + KEY_TO_Station + " TEXT,"+  KEY_NAME
                 + " Text ," + KEY_TRAIN+ " Text," + KEY_DATE+ " Text" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PASSENGER);

        // Create tables again
        onCreate(db);
    }

    void addData( Passenger_data passenger_data)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_From_Station, passenger_data.From_station);
        values.put(KEY_TO_Station, passenger_data.To_station);
        values.put(KEY_NAME, passenger_data.Name);
        values.put(KEY_TRAIN, passenger_data.Train_no);
        values.put(KEY_DATE, passenger_data.To_station);


        db.insert(TABLE_PASSENGER,null,values);
        db.close();
    }


    public int updateData(Passenger_data passenger_data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_From_Station, passenger_data.From_station);
        values.put(KEY_TO_Station, passenger_data.To_station);
        values.put(KEY_NAME, passenger_data.Name);
        values.put(KEY_TRAIN, passenger_data.Train_no);
        values.put(KEY_DATE, passenger_data.To_station);


        // updating row
        return 1;
    }

    public void deleteData(Passenger_data aceralationData) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PASSENGER, KEY_NAME +  " = ?",
                new String[] { String.valueOf(aceralationData.Name) });
        db.close();
    }


    // Getting contacts Count
    public int getDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PASSENGER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public List<Passenger_data> getAllData(){
        List<Passenger_data> dataList= new ArrayList<Passenger_data>();

        String selectQuery = "SELECT  * FROM " + TABLE_PASSENGER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Passenger_data aceralationData = new Passenger_data();
                aceralationData.Name = (cursor.getString(0));
                aceralationData.From_station = cursor.getString(1);
                aceralationData.To_station = cursor.getString(2);
                aceralationData.Date = cursor.getString(3);
                aceralationData.Train_no = cursor.getString(4);
                dataList.add(aceralationData);
            }while (cursor.moveToNext());
    }
    return dataList;
    }
}
