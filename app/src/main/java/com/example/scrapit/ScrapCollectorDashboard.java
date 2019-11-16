package com.example.scrapit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScrapCollectorDashboard extends Activity {
Button b1,b2, addScrap,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap_collector_dashboard);
        b1=(Button)findViewById(R.id.logout);
        b2=(Button)findViewById(R.id.profile);
        addScrap =(Button)findViewById(R.id.button4);
        b4=(Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ScrapCollectorDashboard.this,MainActivity.class);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ScrapCollectorDashboard.this,SC_MyProfile.class);
                startActivity(intent);

            }
        });

        addScrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ScrapCollectorDashboard.this,SC_AddScrap.class);
                startActivity(intent);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ScrapCollectorDashboard.this,SC_Appointments.class);
                startActivity(intent);

            }
        });


    }
}
