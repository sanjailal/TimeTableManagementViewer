package com.example.timetable;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void studbutton(View view)
    {
        Intent intent = new Intent(getApplicationContext(), studentview.class);
        startActivity(intent);
    }
    public void facbutton(View view)
    {
        Intent intent1 = new Intent(getApplicationContext(), facultyview.class);
        startActivity(intent1);
    }




}
