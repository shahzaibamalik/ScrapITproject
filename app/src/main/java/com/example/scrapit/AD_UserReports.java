package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AD_UserReports extends Activity {
    DBhelper databaseHelper ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad__user_reports);
        databaseHelper = new DBhelper(this);

        listView = (ListView) findViewById(R.id.listViewRate);
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor data = databaseHelper.getUserReportListContents();
        while (data.moveToNext()) {
            arrayList.add(data.getString(1));

            //arrayList.add(data.getString(7));

            ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(arrayAdapter);
        }
    }}