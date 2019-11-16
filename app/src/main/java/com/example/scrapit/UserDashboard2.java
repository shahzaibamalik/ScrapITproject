package com.example.scrapit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDashboard2 extends Activity {
    Button b1,b2,b3, btnLogout;
    TextView title;
    DBhelper dbhelper ;
    SharedPreferencesHelper pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard2);
        b1=(Button)findViewById(R.id.buttonsellnow);
        b2=(Button)findViewById(R.id.buttonratelist);
        b3=(Button)findViewById(R.id.buttonreport);
        btnLogout =(Button)findViewById(R.id.buttonlogout);
        title = (TextView)findViewById(R.id.title);
        dbhelper = new DBhelper(UserDashboard2.this);
        pref = new SharedPreferencesHelper(this);


        String name=pref.getAuthData().getName();

        title.setText(name);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserDashboard2.this,SellAppointment.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserDashboard2.this,RateList.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserDashboard2.this,Reports.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserDashboard2.this,MainActivity.class);
                startActivity(intent);
                SharedPreferences shareddPreferences = PreferenceManager.getDefaultSharedPreferences(UserDashboard2.this);
                SharedPreferences.Editor editor1 = shareddPreferences.edit();
                editor1.putBoolean("isRemember",false);
                editor1.apply();
            }
        });
    }
}
