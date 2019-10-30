package com.example.timetable;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class facultyview extends AppCompatActivity {
     ResultSet rs;
    public static String text="A";
    public static String rsmonone="";
    public static String rstue="";
    public static String rswed="";
    public static String rsthu="";
    public static String rsfri="";
    ProgressDialog prgDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultyview);
    }
    public void facimg(View view)
    {

//        Intent intent = new Intent(getApplicationContext(), facimageview.class);
//        startActivity(intent);
        new myTask().execute();
    }
    public class myTask extends AsyncTask<Void,Void,Void>
    {
        String s="";
        String url="jdbc:mysql://database-2.c9vu6etbmknp.us-east-1.rds.amazonaws.com:3306/database1";
        String usr="thisiscmsd";
        String pwd="yuvan123";



        @Override
        protected void onPreExecute() {

//            prgDialog = new ProgressDialog(
//                    studentview.this);
//            prgDialog.setMessage
//                    ("Gathering Details");
//            // prgDialog.setIndeterminate(false);
//            prgDialog.setProgressStyle
//                    (ProgressDialog.STYLE_SPINNER);
//            prgDialog.setCancelable(false);
//            prgDialog.show();

        }
        EditText edit = (EditText)findViewById(R.id.fname);
        String fname = edit.getText().toString();

        @Override
        protected Void doInBackground(Void... voids) {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, usr, pwd);
                s="0";
                Statement st = con.createStatement();
                ResultSet rsmon=st.executeQuery("(select * from CSEA where TeacherID='"+fname+"')union(select * from CSEB where TeacherID='"+fname+"') union (select * from CSEC where TeacherID='"+fname+"');");
                while(rsmon.next())
                    rsmonone += (rsmon.getString(1) + " " +rsmon.getString(2) + " " + rsmon.getString(5) + " "+ rsmon.getString(6) + " ");

                Log.v("san",rsmonone);
//                ResultSet rstue1=st.executeQuery("select * from CSE"+text + " where Day='Tuesday' ");
//                while(rstue1.next())
//                    rstue += (rstue1.getString(3) + " " + rstue1.getString(4) + " "+ rstue1.getString(5) + " ");
//
//                ResultSet rswed1=st.executeQuery("select * from CSE"+text + " where Day='Wednesday' ");
//                while(rswed1.next())
//                    rswed += (rswed1.getString(3) + " " + rswed1.getString(4) + " "+ rswed1.getString(5) + " ");
//
//                ResultSet rsthu1=st.executeQuery("select * from CSE"+text + " where Day='Thursday' ");
//                while(rsthu1.next())
//                    rsthu += (rsthu1.getString(3) + " " + rsthu1.getString(4) + " "+ rsthu1.getString(5) + " ");
//
//                ResultSet rsfri1=st.executeQuery("select * from CSE"+text + " where Day='Friday' ");
//                while(rsfri1.next())
//                    rsfri += (rsfri1.getString(3) + " " + rsfri1.getString(4) + " "+ rsfri1.getString(5) + " ");


                //           String rsmon11[] = rsmonone.split(" ");
//                Log.v("san",rsmonone);
//                Log.v("san2",rsmon11[1]);
//                Log.v("san3",rsmon11[2]);
                con.close();
            }
            catch(Exception E)
            {
                E.printStackTrace();

                s="1";
            }
            return null;
        }



        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(s.equals("1"))
            {
                Toast.makeText(getApplicationContext(),"Not Connected",Toast.LENGTH_LONG).show();
            }
            if(s.equals("0"))
            {

                prgDialog = new ProgressDialog(
                        facultyview.this);
                prgDialog.setMessage
                        ("Gathering Details");
                // prgDialog.setIndeterminate(false);
                prgDialog.setProgressStyle
                        (ProgressDialog.STYLE_SPINNER);
                prgDialog.setCancelable(false);
                prgDialog.show();

              //  Toast.makeText(getApplicationContext(),"Connected",Toast.LENGTH_LONG).show();
                Intent i=new Intent(facultyview.this,facimageview.class);
//                i.putExtra("STRING_I_NEED", rsmonone);
//                i.putExtra("tue",rstue);
//                i.putExtra("wed",rswed);
//                i.putExtra("thu",rsthu);
//                i.putExtra("fri",rsfri);
              //  startActivity(i);
             //   Toast.makeText(getApplicationContext(),"Table :"+rsmonone,Toast.LENGTH_LONG).show();
                new AlertDialog.Builder(facultyview.this)
                        .setTitle(fname+" Timetable")
                        .setMessage(rsmonone)

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


                prgDialog.dismiss();

            }


        }
    }
}
