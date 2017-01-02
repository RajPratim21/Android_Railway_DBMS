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
public class DatabaseHandlershedule extends SQLiteOpenHelper {

    private static final int DATABASEVERSION = 1;

    private static final String DATABASENAME = "Train_ScheduleManager";

    private static final String TABLE_Train_Schedule = "Train_ScheduleData";

    public static final String KEY_ID = "ID";
    public static final String KEY_NAME = "NAME";




    public DatabaseHandlershedule(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_Train_Schedule + "("
                + KEY_ID+ " Text," + KEY_NAME + " Text" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Train_Schedule);

        // Create tables again
        onCreate(db);
    }

    void addData( Train_schedule_Data Train_Schedule_data)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, Train_Schedule_data.Train_id);
        values.put(KEY_NAME, Train_Schedule_data.Station_id);


        db.insert(TABLE_Train_Schedule ,null,values);
        db.close();
    }


    public int updateData(Train_schedule_Data Train_Schedule_data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, Train_Schedule_data.Station_id);
        values.put(KEY_NAME, Train_Schedule_data.Train_id);

        // updating row
        return db.update(TABLE_Train_Schedule, values, KEY_ID + " = ?",
                new String[] { String.valueOf(Train_Schedule_data.Station_id) });

    }

    public void deleteData(Train_schedule_Data aceralationData) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Train_Schedule, KEY_ID +  " = ?",
                new String[] { String.valueOf(aceralationData.Station_id) });
        db.close();
    }


    // Getting contacts Count
    public int getDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_Train_Schedule;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public List<Train_schedule_Data> getAllData(){
        List<Train_schedule_Data> dataList= new ArrayList<Train_schedule_Data>();

        String selectQuery = "SELECT  * FROM " + TABLE_Train_Schedule;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Train_schedule_Data aceralationData = new Train_schedule_Data();
                aceralationData.Station_id  = (cursor.getString(0));
                aceralationData.Train_id = cursor.getString(1);

                dataList.add(aceralationData);
            }while (cursor.moveToNext());
        }
        return dataList;
    }
}
