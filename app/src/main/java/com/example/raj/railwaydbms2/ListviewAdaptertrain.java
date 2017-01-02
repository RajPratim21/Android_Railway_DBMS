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

public class ListviewAdaptertrain extends BaseAdapter implements DialogInterface.OnClickListener {

    private ArrayList<Train_schedule_Data.Train_Data> datalist;
    Context context;

    public ListviewAdaptertrain(Context con,ArrayList<Train_schedule_Data.Train_Data> list)
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
        View newView = view;

        if(newView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            newView=inflater.inflate(R.layout.display_train,null);
            TextView name,trackId;
            name= (TextView) newView.findViewById(R.id.trainname_display);
            trackId= (TextView) newView.findViewById(R.id.train_id_display);
            Train_schedule_Data.Train_Data data=datalist.get(i);

            name.setText(data.Train_name);
            trackId.setText(data.Train_id);
            return newView;
        }
        else
        {
            TextView name,trackId;
            name= (TextView) newView.findViewById(R.id.trainname_display);
            trackId= (TextView) newView.findViewById(R.id.train_id_display);
            Train_schedule_Data.Train_Data data=datalist.get(i);

            name.setText(data.Train_name);
            trackId.setText(data.Train_id);
            return newView;
        }
    }

}


