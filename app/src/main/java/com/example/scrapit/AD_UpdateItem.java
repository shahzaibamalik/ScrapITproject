package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AD_UpdateItem extends Activity {

    DBhelper databaseHelper ;
    EditText name, rate;
    Button save,delete,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad__update_item);

        databaseHelper = new DBhelper(this);

        name = (EditText) findViewById(R.id.edname);
        rate = (EditText) findViewById(R.id.edrate);

        save = (Button) findViewById(R.id.save);
        delete = (Button) findViewById(R.id.delete);
        update = (Button) findViewById(R.id.update);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertItem (name.getText().toString(),rate.getText().toString());
                if (result)
                {
                    Toast.makeText(AD_UpdateItem.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AD_UpdateItem.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intentDelete = new Intent(AD_UpdateItem.this,Deleted.class);
                startActivity(intentDelete);
            }
        });

        update= (Button) findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUpdate = new Intent(AD_UpdateItem.this,Updatedata.class);
                startActivity(intentUpdate);
            }
        });
    }
}

