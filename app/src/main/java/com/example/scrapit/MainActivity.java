package com.example.scrapit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btnLogin,b2;
    EditText edt1,edt2;
    String role;
    DBhelper dbhelper ;
    SharedPreferencesHelper pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = new SharedPreferencesHelper(this);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        boolean isRemember= sharedPreferences.getBoolean("isRemember",false);
        if(isRemember) {
            if(pref.getAuthData().getRole().equals("User")) {
                Toast.makeText(MainActivity.this, "User Successfully Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, UserDashboard2.class);
                startActivity(intent);
                finish();

                SharedPreferences shareddPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor1 = shareddPreferences.edit();
                editor1.putBoolean("isRemember",true);
                editor1.apply();


            }
            if(pref.getAuthData().getRole().equals("Admin")) {
                Toast.makeText(MainActivity.this, "Admin Successfully Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AdminDashboard.class);
                startActivity(intent);
                finish();

                SharedPreferences shareddPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor1 = shareddPreferences.edit();
                editor1.putBoolean("isRemember",true);
                editor1.apply();

            }
            if(pref.getAuthData().getRole().equals("ScrapCollector")) {
                Toast.makeText(MainActivity.this, "Scrap Collector Successfully Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ScrapCollectorDashboard.class);
                startActivity(intent);
                finish();

                SharedPreferences shareddPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor1 = shareddPreferences.edit();
                editor1.putBoolean("isRemember",true);
                editor1.apply();

            }
        }else{
            Toast.makeText(this, "not Remeber", Toast.LENGTH_SHORT).show();
        }
        btnLogin =(Button)findViewById(R.id.btnLogin);
        b2=(Button)findViewById(R.id.b2);

        edt1=(EditText) findViewById(R.id.mob);
        edt2=(EditText)findViewById(R.id.pass);
        dbhelper = new DBhelper(MainActivity.this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbhelper.getData(pref, edt1.getText().toString(), edt2.getText().toString());

                if(pref.getAuthData() != null)
                {
                    if(edt1.getText().toString().equals(pref.getAuthData().getPhoneno()) && edt2.getText().toString().equals(pref.getAuthData().getPassword()))
                    {
                        if(pref.getAuthData().getRole().equals("User")) {
                            Toast.makeText(MainActivity.this, "User Successfully Login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, UserDashboard2.class);
                            startActivity(intent);
                            finish();

                            SharedPreferences shareddPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                            SharedPreferences.Editor editor1 = shareddPreferences.edit();
                            editor1.putBoolean("isRemember",true);
                            editor1.apply();

                        }
                        if(pref.getAuthData().getRole().equals("Admin")) {
                            Toast.makeText(MainActivity.this, "Admin Successfully Login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, AdminDashboard.class);
                            startActivity(intent);
                            finish();

                            SharedPreferences shareddPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                            SharedPreferences.Editor editor1 = shareddPreferences.edit();
                            editor1.putBoolean("isRemember",true);
                            editor1.apply();



                        }
                        if(pref.getAuthData().getRole().equals("ScrapCollector")) {
                            Toast.makeText(MainActivity.this, "Scrap Collector Successfully Login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, ScrapCollectorDashboard.class);
                            startActivity(intent);
                            finish();
                            SharedPreferences shareddPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                            SharedPreferences.Editor editor1 = shareddPreferences.edit();
                            editor1.putBoolean("isRemember",true);
                            editor1.apply();


                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "wrong password or phone no", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,RegisterUser.class);
                startActivity(intent);
            }
        });
    }
}
