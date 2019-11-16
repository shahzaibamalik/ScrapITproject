package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SC_AddScrap extends Activity {
DBhelper DBhelper;
EditText date, SC_ID, User_ID, weight, amount,rate;
Button calculate, AddScrap;
    SharedPreferencesHelper pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc__add_scrap);
        pref = new SharedPreferencesHelper(this);

        final DBhelper DBhelper = new DBhelper(this);

        date = (EditText) findViewById(R.id.date);
        SC_ID = (EditText) findViewById(R.id.SC_ID);
        User_ID = (EditText) findViewById(R.id.User_ID);
        weight = (EditText) findViewById(R.id.weight);
        amount = (EditText) findViewById(R.id.amount);
        rate = (EditText) findViewById(R.id.rate);

        AddScrap = (Button) findViewById(R.id.AddScrap);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double val1 = Double.parseDouble(rate.getText().toString());
                double val2 =Double.parseDouble(weight.getText().toString());
                double calcualte_total = ( val1 * val2);

                amount.setText(Double.toString(calcualte_total));

            }
        });

        AddScrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                boolean result = DBhelper.insertScrap (date.getText().toString(),SC_ID.getText().toString(),User_ID.getText().toString() ,rate.getText().toString(),weight.getText().toString(),amount.getText().toString());
                if (result)
                {
                    Toast.makeText(SC_AddScrap.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SC_AddScrap.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                ((EditText) v).setText(currentDate);

            }
        });
    }
}
