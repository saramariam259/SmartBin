package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Pattern;

public class userregister extends AppCompatActivity {

    EditText username, password, repassword,houseno,name,address,locality,city,mobileno;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregister);
        houseno = (EditText) findViewById(R.id.editTextNumber);
        name = (EditText) findViewById(R.id.editTextText);
        address = (EditText) findViewById(R.id.editTextText2);
        locality = (EditText) findViewById(R.id.editTextText3);
        city = (EditText) findViewById(R.id.editTextText4);
        mobileno = (EditText) findViewById(R.id.editTextNumber2);
        username = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        repassword = (EditText) findViewById(R.id.editTextTextPassword2);
        signup = (Button) findViewById(R.id.button6);
        //signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String house = houseno.getText().toString();
                String namee = name.getText().toString();
                String add = address.getText().toString();
                String loc = locality.getText().toString();
                String cit = city.getText().toString();
                String mob = mobileno.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("") || house.equals("") || namee.equals("") || add.equals("") || loc.equals("") || cit.equals("") || mob.equals("")) {
                    Toast.makeText(userregister.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            // Validate the phone number
                            if (isValidPhoneNumber(mob)) {
                                // Validate the email address
                                String email = user;
                                if (isValidEmail(email)) {
                                    Boolean insert = DB.insertData(user, pass, house, namee, add, loc, cit, mob);
                                    if (insert == true) {
                                        Toast.makeText(userregister.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(userregister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(userregister.this, "Invalid email address. Please enter a valid email.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(userregister.this, "Invalid phone number. Please enter a 10-digit number.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(userregister.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(userregister.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            // Function to validate the phone number
            public boolean isValidPhoneNumber(String mobileno) {
                // Remove any non-digit characters from the phone number
                String digitsOnly = mobileno.replaceAll("[^0-9]", "");

                // Check if the resulting string has a length of 10
                return digitsOnly.length() == 10;
            }

            public boolean isValidEmail(String username) {
                // Regular expression pattern for email validation
                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

                // Check if the email matches the pattern
                return username.matches(emailRegex);
            }
            public boolean isValidPassword(String password) {
                // Define the password requirements
                int minLength = 8; // Minimum length
                int maxLength = 20; // Maximum length
                String pattern = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@#$%^&+=])(?=.*[!])[A-Za-z\\d@#$%^&+=!]+$";
                // At least one lowercase letter, one uppercase letter, one digit, one special character, and no whitespace

                // Check if the password meets the requirements
                return password.length() >= minLength && password.length() <= maxLength && password.matches(pattern);
            }
        });
    }
}