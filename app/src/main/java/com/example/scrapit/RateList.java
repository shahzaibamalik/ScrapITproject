package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.scrapit.adapters.RateListAdapter;

import java.util.ArrayList;
import java.util.List;

public class RateList extends AppCompatActivity {

    DBhelper databaseHelper ;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_list);
        databaseHelper = new DBhelper(this);
        listView = (ListView) findViewById(R.id.listViewRate);

        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor data = databaseHelper.getRateListContents();

        while (data.moveToNext()) {
            arrayList.add(data.getString(1));
            arrayList.add(data.getString(2));

            ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(arrayAdapter);
        }
    }}