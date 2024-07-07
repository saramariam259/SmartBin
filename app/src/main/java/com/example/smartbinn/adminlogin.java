package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        Button clickMe=findViewById(R.id.button11);
        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.adminlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(adminlogin.this,driverregister.class);
                startActivity( intent);
            }
        });
        Button OnclickMe=findViewById(R.id.button13);
        OnclickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.adminlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(adminlogin.this,viewcomplaint.class);
                startActivity( intent);
            }
        });
        Button touch=findViewById(R.id.button12);
        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.adminlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(adminlogin.this,viewdriverlist.class);
                startActivity( intent);
            }
        });
        Button fetch=findViewById(R.id.button14);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.adminlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(adminlogin.this,userdetails.class);
                startActivity( intent);
            }
        });
        Button clickMee=findViewById(R.id.button15);
        clickMee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.adminlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(adminlogin.this,viewworkreport.class);
                startActivity( intent);
            }
        });
    }
}