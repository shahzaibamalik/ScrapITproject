package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AD_AddItem extends Activity {

    DBhelper databaseHelper ;
    EditText name, rate;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad__add_item);

        databaseHelper = new DBhelper(this);

        name = (EditText) findViewById(R.id.edname);
        rate = (EditText) findViewById(R.id.edrate);

        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertItem (name.getText().toString(),rate.getText().toString());
                if (result)
                {
                    Toast.makeText(AD_AddItem.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AD_AddItem.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}

