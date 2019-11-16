package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SC_MyProfile extends Activity {
    DBhelper databaseHelper ;
    EditText name, phone ,pass, email, cnic, address, age, gender, role, status;
    Button save,delete,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc__my_profile);

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



        update = (Button) findViewById(R.id.update);


        update= (Button) findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.updateScData (name.getText().toString(),phone.getText().toString(),pass.getText().toString() ,email.getText().toString(),address.getText().toString(),age.getText().toString());
                if (result)
                {
                    Toast.makeText(SC_MyProfile.this, "Profile Updated !", Toast.LENGTH_SHORT).show();
                    Intent intentUpdate = new Intent(SC_MyProfile.this,Updatedata.class);
                    startActivity(intentUpdate);
                }else{
                    Toast.makeText(SC_MyProfile.this, "All fields required !", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}

