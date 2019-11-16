package com.example.scrapit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Updatedata extends AppCompatActivity {
    Button btUpadted ;
    EditText name, number,pass, email;
    private DBhelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);
        databaseHelper = new DBhelper (this);

        btUpadted = (Button) findViewById(R.id.btupdate_data);
        name = (EditText) findViewById(R.id.updateName);
        number = (EditText) findViewById(R.id.updateNumber);
        pass = (EditText) findViewById(R.id.updatePass);
        email = (EditText) findViewById(R.id.updateEmail);

        btUpadted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                databaseHelper.updateScData(name.getText().toString(),number.getText().toString(),pass.getText().toString(),email.getText().toString());

            }
        });
    }
}
