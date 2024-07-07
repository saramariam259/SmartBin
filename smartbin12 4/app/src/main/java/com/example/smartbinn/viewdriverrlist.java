package com.example.smartbinn;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.database.Cursor;

public class viewdriverrlist extends AppCompatActivity {

    private TextView textViewDriverNamee;
    private TextView textViewAadhar;
    private TextView textViewNamee;
    private TextView textViewAddresss;
    private TextView textViewDriverId;
    private TextView textViewCity;
    private TextView textViewMobileNoo;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdriverrlist);

        dbHelper = new DBHelper(this);

        textViewDriverNamee = findViewById(R.id.textViewDriverName);
        textViewAadhar = findViewById(R.id.textViewAadhar);
        textViewNamee = findViewById(R.id.textViewNamee);
        textViewAddresss = findViewById(R.id.textViewAddresss);
        textViewDriverId = findViewById(R.id.textViewDriverid);
        textViewCity = findViewById(R.id.textViewCity);
        textViewMobileNoo = findViewById(R.id.textViewMobileNoo);

        Intent intent = getIntent();
        if (intent != null) {
            String DriverNamee = intent.getStringExtra("DriverNamee");

            textViewDriverNamee.setText(DriverNamee);

            Cursor cursor = dbHelper.getUserDetails(DriverNamee);
            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String aadhar = cursor.getString(cursor.getColumnIndex("aadhar"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex("address"));
                @SuppressLint("Range") String driverid = cursor.getString(cursor.getColumnIndex("driverid"));
                @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex("city"));
                @SuppressLint("Range") String mobileNo = cursor.getString(cursor.getColumnIndex("mobileno"));

                textViewAadhar.setText(aadhar);
                textViewNamee.setText(name);
                textViewAddresss.setText(address);
                textViewDriverId.setText(driverid);
                textViewCity.setText(city);
                textViewMobileNoo.setText(mobileNo);
            }

            cursor.close();
        }
    }
}
