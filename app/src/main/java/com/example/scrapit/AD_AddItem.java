package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AD_AddItem extends AppCompatActivity {
    DBhelper databaseHelper ;
    EditText ename,erate;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad__add_item);
        databaseHelper = new DBhelper(this);
        ename=(EditText)findViewById(R.id.ednamee);
        erate=(EditText)findViewById(R.id.edweight);
        b=(Button)findViewById(R.id.basave);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertproduct (ename.getText().toString(),erate.getText().toString());
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
