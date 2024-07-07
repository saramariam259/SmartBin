package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class workreport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workreport);
        Button click=findViewById(R.id.button19);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.workreport.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(workreport.this,MapsActivity.class);
                startActivity( intent);
            }
        });

        Button OnclickMe = findViewById(R.id.button17);
        OnclickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.workreport.this, "update successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}