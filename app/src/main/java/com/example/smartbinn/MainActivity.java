package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button clickMe=findViewById(R.id.button);
            clickMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(com.example.smartbinn.MainActivity.this, "opening", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,loginpage.class);
                    startActivity( intent);
                }
            });
            Button click=findViewById(R.id.button2);
            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(com.example.smartbinn.MainActivity.this, "opening", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,userregister.class);
                    startActivity( intent);
                }
            });
            Button touch=findViewById(R.id.button3);
            touch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(com.example.smartbinn.MainActivity.this, "opening", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,adminloginpage.class);
                    startActivity( intent);
                }
            });
            Button clickMee=findViewById(R.id.button4);
            clickMee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(com.example.smartbinn.MainActivity.this, "opening", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,driverloginpage.class);
                    startActivity( intent);
                }
            });


        }
    }