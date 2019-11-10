package com.example.scrapit.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scrapit.R;

public class myAdapter extends ArrayAdapter<String>
{
    public Activity context;
    public  String mainhead[];
    public String subhead[];

    public myAdapter(Context context, String mainhead[] , String subhead[] )
    {

        super(context, R.layout.row,mainhead);
        this.context= (Activity) context;
        this.mainhead=mainhead;
        this.subhead=subhead;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater layoutInflater= context.getLayoutInflater();
        View rview= layoutInflater.inflate(R.layout.row,null,true);


        TextView mtitle=(TextView)rview.findViewById(R.id.tvname);
        TextView stitle=(TextView)rview.findViewById(R.id.tvrate);

        mtitle.setText(mainhead[position]);
        stitle.setText(subhead[position]);


        return rview;
    }
}
