package com.myapplicationdev.android.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lv;
    TaskAdapter ta;
    ArrayList<Task> task = new ArrayList<Task>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btn);
        DBHelper dbh = new DBHelper(this);
        task = dbh.getTasks();
        lv = findViewById(R.id.lv);
        ta = new TaskAdapter(getApplicationContext(), R.layout.row, task);
        lv.setAdapter(ta);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the activity's Context

                btnAdd = findViewById(R.id.btn);
                ta.notifyDataSetChanged();
                Intent intent = new Intent(getBaseContext(), Add.class);
                startActivity(intent);
            }
        });
    }
}
