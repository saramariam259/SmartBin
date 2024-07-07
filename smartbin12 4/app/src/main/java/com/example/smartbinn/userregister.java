package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

                if(user.equals("")||pass.equals("")||repass.equals("")||house.equals("")||namee.equals("")||add.equals("")||loc.equals("")||cit.equals("")||mob.equals(""))
                    Toast.makeText(userregister.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass,house,namee,add,loc,cit,mob);
                            if(insert==true){
                                Toast.makeText(userregister.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(userregister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(userregister.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(userregister.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });



    }
}