package com.example.smartbinn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registercomplaint extends AppCompatActivity {
    Button ShowMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercomplaint);
        ShowMap = findViewById(R.id.ShowMap);
        ShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registercomplaint.this,MapsActivity.class);
                startActivity(intent);

            }
        });
        Button clickMee=findViewById(R.id.button9);
        clickMee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.registercomplaint.this, "updated successfully", Toast.LENGTH_SHORT).show();
            }
        });  }
}