package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class myprofile extends AppCompatActivity {
TextView name,house,a,l,c,m;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        DB = new DBHelper(this);
        setContentView(R.layout.activity_myprofile);
        String house1 = "";
        house1 = house1 + DB.myprofilehouse(loginpage.user1);
        house = (TextView) findViewById(R.id.editTextNumber4);
        house.setText(house1);
        String name1 = "";
        name1 = name1 + DB.myprofilename(loginpage.user1);
        name = (TextView) findViewById(R.id.editTextText6);
        name.setText(name1);
        String a1 = "";
        a1 = a1 + DB.myprofilead(loginpage.user1);
        a = (TextView) findViewById(R.id.editTextTextPostalAddress);
        a.setText(a1);
        String l1 = "";
        l1 = l1 + DB.myprofilelo(loginpage.user1);
        l = (TextView) findViewById(R.id.editTextText8);
        l.setText(l1);
        String c1 = "";
        c1 = c1 + DB.myprofilect(loginpage.user1);
        c = (TextView) findViewById(R.id.editTextText9);
        c.setText(c1);
        String m1 = "";
        m1 = m1 + DB.myprofilemobile(loginpage.user1);
        m = (TextView) findViewById(R.id.editTextPhone);
        m .setText(m1);

        

    }
}