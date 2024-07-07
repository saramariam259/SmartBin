package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class userlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        Button clickMe=findViewById(R.id.button7);
        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.userlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(userlogin.this,registercomplaint.class);
                startActivity( intent);
            }
        });
        Button click=findViewById(R.id.button8);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.smartbinn.userlogin.this, "opening", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(userlogin.this,myprofile.class);
                startActivity( intent);
            }
        });
    }
}