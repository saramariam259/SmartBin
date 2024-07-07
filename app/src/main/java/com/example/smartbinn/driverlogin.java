package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class driverlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverlogin);
        Button clickMe=findViewById(R.id.button16);
        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.driverlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(driverlogin.this,workreport.class);
                startActivity( intent);
            }
        });
    }
}