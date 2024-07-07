package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class userdetails extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<String> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        recyclerView = findViewById(R.id.recyclerView);


        userList = new ArrayList<>();
        // Fetch user names from the SQLite database using your DBHelper methods
        // For example, you can use the following code to fetch the user names
        DBHelper dbHelper = new DBHelper(this);
        userList = dbHelper.getAllUserNames();

        userAdapter = new UserAdapter(userList, this);
        recyclerView.setAdapter(userAdapter);
    }

}
