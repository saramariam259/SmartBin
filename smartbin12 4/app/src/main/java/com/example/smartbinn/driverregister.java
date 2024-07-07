package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class driverregister extends AppCompatActivity {
        EditText username, password, repassword, name, address, city, mobileno;
        EditText driverId, aadharNumber;
        Button signup;
        DBHelper DB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_driverregister);

                driverId = (EditText) findViewById(R.id.editTextText11);
                name = (EditText) findViewById(R.id.editTextText);
                address = (EditText) findViewById(R.id.editTextTextPostalAddress2);
                city = (EditText) findViewById(R.id.editTextText4);
                mobileno = (EditText) findViewById(R.id.editTextNumber5);
                username = (EditText) findViewById(R.id.editTextTextEmailAddress2);
                password = (EditText) findViewById(R.id.editTextTextPassword2);
                aadharNumber = (EditText) findViewById(R.id.editTextNumber6);
                repassword = (EditText) findViewById(R.id.editTextTextPassword2);
                signup = (Button) findViewById(R.id.button6);
                DB = new DBHelper(this);

                signup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                String user = username.getText().toString();
                                String pass = password.getText().toString();
                                String repass = repassword.getText().toString();
                                String driverIdText = driverId.getText().toString();
                                String nameText = name.getText().toString();
                                String addressText = address.getText().toString();
                                String aadharText = aadharNumber.getText().toString();
                                String cityText = city.getText().toString();
                                String mobileText = mobileno.getText().toString();

                                if (user.equals("") || pass.equals("") || repass.equals("") || driverIdText.equals("") || nameText.equals("") || addressText.equals("") || cityText.equals("") || mobileText.equals("")) {
                                        Toast.makeText(driverregister.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                                } else {
                                        if (pass.equals(repass)) {
                                                Boolean checkuser = DB.checkdriver(user);
                                                if (checkuser == false) {
                                                        Boolean insert = DB.insertdriverData(driverIdText, pass, nameText, addressText, cityText, mobileText, aadharText, user);
                                                        if (insert == true) {
                                                                Toast.makeText(driverregister.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                                startActivity(intent);
                                                        } else {
                                                                Toast.makeText(driverregister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                                        }
                                                } else {
                                                        Toast.makeText(driverregister.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                                                }
                                        } else {
                                                Toast.makeText(driverregister.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                                        }
                                }
                        }
                });
        }
}
