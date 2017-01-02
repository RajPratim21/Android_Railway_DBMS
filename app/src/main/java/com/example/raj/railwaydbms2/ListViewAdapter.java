package com.example.raj.railwaydbms2;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by raj on 8/12/16.
 */

public class ListViewAdapter extends BaseAdapter implements DialogInterface.OnClickListener{

    private ArrayList<Passenger_data> datalist;
    Context context;

    public ListViewAdapter(Context con,ArrayList<Passenger_data> list)
    {
        context=con;
        datalist=list;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView=view;
        if(newView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            newView=inflater.inflate(R.layout.display_passenger,null);
            TextView toStation,fromStation,name,date,trainId;
            toStation= (TextView) newView.findViewById(R.id.to_station_list_pass);
            fromStation= (TextView) newView.findViewById(R.id.to_list_pass);
            name= (TextView) newView.findViewById(R.id.name_list_pass);
            date= (TextView) newView.findViewById(R.id.date_list_pass);
            trainId= (TextView) newView.findViewById(R.id.trainID_list_pass);
            Passenger_data data=datalist.get(i);
            toStation.setText(data.To_station);
            fromStation.setText(data.From_station);
            date.setText(data.Date);
            name.setText(data.Name);
            trainId.setText(data.Train_no);
            return newView;
        }
        else
        {
            TextView toStation,fromStation,name,date,trainId;
            toStation= (TextView) newView.findViewById(R.id.to_station_list_pass);
            fromStation= (TextView) newView.findViewById(R.id.to_list_pass);
            name= (TextView) newView.findViewById(R.id.name_list_pass);
            date= (TextView) newView.findViewById(R.id.date_list_pass);
            trainId= (TextView) newView.findViewById(R.id.trainID_list_pass);
            Passenger_data data=datalist.get(i);
            toStation.setText(data.To_station);
            fromStation.setText(data.From_station);
            date.setText(data.Date);
            name.setText(data.Name);
            trainId.setText(data.Train_no);
            return newView;
        }
    }
}
