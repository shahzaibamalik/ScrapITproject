package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.scrapit.adapters.RateListAdapter;

import java.util.ArrayList;
import java.util.List;

public class RateList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_list);

        initializeList();
    }

    private void initializeList() {
        List<String> items = new ArrayList<>();

        items.add("123");
        items.add("321");
        items.add("456");

        ListView list = findViewById(R.id.listView);
        list.setAdapter(new RateListAdapter(items, this));

    }
}
