package com.example.smartbinn;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.widget.Toast;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView textViewUserName;
    private TextView textViewHouseNo;
    private TextView textViewName;
    private TextView textViewAddress;
    private TextView textViewLocality;
    private TextView textViewCity;
    private TextView textViewMobileNo;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userrdetails);

        dbHelper = new DBHelper(this);

        textViewUserName = findViewById(R.id.textViewUserName);
        textViewHouseNo = findViewById(R.id.textViewHouseNo);
        textViewName = findViewById(R.id.textViewName);
        textViewAddress = findViewById(R.id.textViewAddress);
        textViewLocality = findViewById(R.id.textViewLocality);
        textViewCity = findViewById(R.id.textViewCity);
        textViewMobileNo = findViewById(R.id.textViewMobileNo);

        Intent intent = getIntent();
        if (intent != null) {
            String userName = intent.getStringExtra("userName");

            textViewUserName.setText(userName);

            Cursor cursor = dbHelper.getUserDetails(userName);
            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String houseNo = cursor.getString(cursor.getColumnIndex("houseno"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex("address"));
                @SuppressLint("Range") String locality = cursor.getString(cursor.getColumnIndex("locality"));
                @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex("city"));
                @SuppressLint("Range") String mobileNo = cursor.getString(cursor.getColumnIndex("mobileno"));

                textViewHouseNo.setText(houseNo);
                textViewName.setText(name);
                textViewAddress.setText(address);
                textViewLocality.setText(locality);
                textViewCity.setText(city);
                textViewMobileNo.setText(mobileNo);
            }
            Button OnclickkMe = findViewById(R.id.button18);
            OnclickkMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(com.example.smartbinn.UserDetailsActivity.this, "opening", Toast.LENGTH_SHORT).show();
                    Intent intent = new  Intent(UserDetailsActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
            });
            Button OnclickKMe=findViewById(R.id.button19);
            OnclickKMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(com.example.smartbinn.UserDetailsActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
                }
            });

            cursor.close();
        }
    }
}
