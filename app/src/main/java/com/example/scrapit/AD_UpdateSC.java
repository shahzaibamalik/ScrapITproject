package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AD_UpdateSC extends Activity {
    DBhelper databaseHelper ;
    EditText name, phone ,pass, email, cnic, address, age, gender, role, status;
    Button save,delete,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad__update_sc);

        databaseHelper = new DBhelper(this);

        name = (EditText) findViewById(R.id.edname);
        phone = (EditText) findViewById(R.id.edphone);
        pass = (EditText) findViewById(R.id.edpass);
        email = (EditText) findViewById(R.id.edemail);
        cnic = (EditText) findViewById(R.id.cnic);
        address = (EditText) findViewById(R.id.address);
        age = (EditText) findViewById(R.id.age);
        gender = (EditText) findViewById(R.id.gender);
        role = (EditText) findViewById(R.id.role);
        status = (EditText) findViewById(R.id.status);


        save = (Button) findViewById(R.id.save);
        delete = (Button) findViewById(R.id.delete);
        update = (Button) findViewById(R.id.update);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertUser (name.getText().toString(),phone.getText().toString(),pass.getText().toString() ,email.getText().toString(),cnic.getText().toString(),address.getText().toString(),age.getText().toString(),gender.getText().toString(),role.getText().toString(),status.getText().toString());
                if (result)
                {
                    Toast.makeText(AD_UpdateSC.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AD_UpdateSC.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intentDelete = new Intent(AD_UpdateSC.this,Deleted.class);
                startActivity(intentDelete);
            }
        });

        update= (Button) findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUpdate = new Intent(AD_UpdateSC.this,Updatedata.class);
                startActivity(intentUpdate);
            }
        });
    }
}

