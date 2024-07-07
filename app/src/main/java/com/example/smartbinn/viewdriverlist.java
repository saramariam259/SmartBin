package com.example.smartbinn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class viewdriverlist extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DriverAdapter driverAdapter;
    private List<String> driverList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdriverlist);

        recyclerView = findViewById(R.id.recyclerView);


        driverList = new ArrayList<>();
        // Fetch user names from the SQLite database using your DBHelper methods
        // For example, you can use the following code to fetch the user names
        DBHelper dbHelper = new DBHelper(this);
        driverList = dbHelper.getAllUserNames();

        driverAdapter = new DriverAdapter(driverList, this);
        recyclerView.setAdapter(driverAdapter);
    }
}
