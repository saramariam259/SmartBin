package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewComplaints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewwcomplaints);

        Button clickKMe = findViewById(R.id.button10);
        clickKMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.ViewComplaints.this, "Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}