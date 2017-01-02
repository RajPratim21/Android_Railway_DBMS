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
public class DatabaseHandler_station extends SQLiteOpenHelper {

    private static final int DATABASEVERSION = 1;

    private static final String DATABASENAME = "StationManager";

    private static final String TABLE_STATION = "StationData";

    public static final String KEY_ID = "ID";
    public static final String KEY_NAME = "NAME";
     



    public DatabaseHandler_station(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_STATION + "("
                + KEY_ID+ " Text" + KEY_NAME + " Text" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATION);

        // Create tables again
        onCreate(db);
    }

    void addData( Station_data station_data)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, station_data.Station_id);
        values.put(KEY_NAME, station_data.Station_name);


        db.insert(TABLE_STATION ,null,values);
        db.close();
    }


    public int updateData(Station_data station_data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, station_data.Station_id);
        values.put(KEY_NAME, station_data.Station_name);

        // updating row
        return db.update(TABLE_STATION, values, KEY_ID + " = ?",
                new String[] { String.valueOf(station_data.Station_id) });

    }

    public void deleteData(Station_data aceralationData) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STATION, KEY_ID +  " = ?",
                new String[] { String.valueOf(aceralationData.Station_id) });
        db.close();
    }


    // Getting contacts Count
    public int getDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_STATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public List<Station_data> getAllData(){
        List<Station_data> dataList= new ArrayList<Station_data>();

        String selectQuery = "SELECT  * FROM " + TABLE_STATION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Station_data aceralationData = new Station_data();
                aceralationData.Station_id  = (cursor.getString(0));
                aceralationData.Station_name = cursor.getString(1);

                dataList.add(aceralationData);
            }while (cursor.moveToNext());
    }
    return dataList;
    }
}
