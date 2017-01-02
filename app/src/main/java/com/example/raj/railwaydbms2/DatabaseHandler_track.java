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
public class DatabaseHandler_track extends SQLiteOpenHelper {

    private static final int DATABASEVERSION = 1;

    private static final String DATABASENAME = "TrackManager";

    private static final String TABLE_Track = "TrackData";

    public static final String KEY_ID = "ID";
    public static final String KEY_From = "From2";
    public static final String KEY_TO= "TO2";



    public DatabaseHandler_track(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_Track + "("
                + KEY_ID+ " TEXT, " + KEY_From + " TEXT, " + KEY_TO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Track);

        // Create tables again
        onCreate(db);
    }

    void addData( Track_Data Track_Data)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, Track_Data.Track_id);
        values.put(KEY_From, Track_Data.from_Station);
        values.put(KEY_TO, Track_Data.TO_station);

        db.insert(TABLE_Track ,null,values);
        db.close();
    }


    public int updateData(Track_Data Track_Data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, Track_Data.Track_id);
        values.put(KEY_From, Track_Data.from_Station);
        values.put(KEY_TO, Track_Data.TO_station);

        // updating row
        return db.update(TABLE_Track, values, KEY_ID + " = ?",
                new String[] { String.valueOf(Track_Data.Track_id) });

    }

    public void deleteData(Track_Data aceralationData) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Track, KEY_ID +  " = ?",
                new String[] { String.valueOf(aceralationData.Track_id) });
        db.close();
    }


    // Getting contacts Count
    public int getDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_Track;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public List<Track_Data> getAllData(){
        List<Track_Data> dataList= new ArrayList<Track_Data>();

        String selectQuery = "SELECT  * FROM " + TABLE_Track;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Track_Data aceralationData = new Track_Data();
                aceralationData.Track_id  = (cursor.getString(0));
                aceralationData.from_Station = cursor.getString(1);
                aceralationData.TO_station = cursor.getString(2);

                dataList.add(aceralationData);
            }while (cursor.moveToNext());
        }
        return dataList;
    }
}
