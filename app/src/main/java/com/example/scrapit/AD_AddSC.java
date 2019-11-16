package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AD_AddSC extends Activity {
    DBhelper databaseHelper ;
    EditText name, phone ,pass, email, cnic, address, age, gender, role, status;
    Button save,delete,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad__add_sc);

        databaseHelper = new DBhelper(this);

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        pass = (EditText) findViewById(R.id.pass);
        email = (EditText) findViewById(R.id.email);
        cnic = (EditText) findViewById(R.id.cnic);
        address = (EditText) findViewById(R.id.address);
        age = (EditText) findViewById(R.id.age);
        gender = (EditText) findViewById(R.id.gender);
        role = (EditText) findViewById(R.id.role);
        status = (EditText) findViewById(R.id.status);


        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertUser (name.getText().toString(),phone.getText().toString(),pass.getText().toString() ,email.getText().toString(),cnic.getText().toString(),address.getText().toString(),age.getText().toString(),gender.getText().toString(),role.getText().toString(),status.getText().toString());
                if (result)
                {
                    Toast.makeText(AD_AddSC.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AD_AddSC.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}

