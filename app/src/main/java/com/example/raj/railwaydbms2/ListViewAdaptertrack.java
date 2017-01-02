package com.example.raj.railwaydbms2;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by raj on 8/12/16.
 */

public class ListViewAdaptertrack extends BaseAdapter implements DialogInterface.OnClickListener{

    private ArrayList<Track_Data> datalist;
    Context context;

    public ListViewAdaptertrack(Context con,ArrayList<Track_Data> list)
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
            newView=inflater.inflate(R.layout.display_track,null);
            TextView toStation,fromStation,trackId;
            toStation= (TextView) newView.findViewById(R.id.tostation_display);
            fromStation= (TextView) newView.findViewById(R.id.fromstation_display);
            trackId= (TextView) newView.findViewById(R.id.trackid_display);
            Track_Data data=datalist.get(i);
            toStation.setText(data.TO_station);
            fromStation.setText(data.from_Station);
            trackId.setText(data.Track_id);
            return newView;
        }
        else
        {
            TextView toStation,fromStation,trackId;
            toStation= (TextView) newView.findViewById(R.id.tostation_display);
            fromStation= (TextView) newView.findViewById(R.id.fromstation_display);
            trackId= (TextView) newView.findViewById(R.id.trackid_display);
            Track_Data data=datalist.get(i);
            toStation.setText(data.TO_station);
            fromStation.setText(data.from_Station);
            trackId.setText(data.Track_id);
            return newView;
        }
    }
}
