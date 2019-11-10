package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUser extends Activity {
    DBhelper databaseHelper ;
    EditText name, phone ,pass, email;
    Button save,delete,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        databaseHelper = new DBhelper(this);

        name = (EditText) findViewById(R.id.edname);
        phone = (EditText) findViewById(R.id.edphone);
        pass = (EditText) findViewById(R.id.edpass);
        email = (EditText) findViewById(R.id.edemail);

        save = (Button) findViewById(R.id.save);
        delete = (Button) findViewById(R.id.delete);
        update = (Button) findViewById(R.id.update);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertContact (name.getText().toString(),Integer.parseInt(phone.getText().toString()),pass.getText().toString() ,email.getText().toString());
                if (result)
                {
                    Toast.makeText(RegisterUser.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterUser.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intentDelete = new Intent(RegisterUser.this,Deleted.class);
                startActivity(intentDelete);
            }
        });

        update= (Button) findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUpdate = new Intent(RegisterUser.this,Updatedata.class);
                startActivity(intentUpdate);
            }
        });
    }
}
