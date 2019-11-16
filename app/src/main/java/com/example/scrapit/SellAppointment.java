package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SellAppointment extends Activity {
    DBhelper databaseHelper ;
    EditText  phone ,  address, assign, status;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_appointment);

        databaseHelper = new DBhelper(this);

        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        assign = (EditText) findViewById(R.id.assign);
        status = (EditText) findViewById(R.id.status);



        save = (Button) findViewById(R.id.save);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertAppointment (phone.getText().toString(), address.getText().toString(),assign.getText().toString(),status.getText().toString());
                if (result)
                {
                    Toast.makeText(SellAppointment.this, "Successfully Booked !", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(SellAppointment.this,AppointmentBooked.class);
                    startActivity(intent);


                }else{
                    Toast.makeText(SellAppointment.this, "Fill all required fields ! ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
