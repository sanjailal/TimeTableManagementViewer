package com.example.timetable;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.sql.*;


public class studentview extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] course = { "B.Tech", "M.Tech", "MBA"};
    String[] dept={"CSE","MECH","ECE","EEE","Civil"};
    ProgressDialog prgDialog;
    public static int flag =0;
    String[] sect={"A","B","C"};
    public static String text="";
    public static String rsmonone="";
    public static String rstue="";
    public static String rswed="";
    public static String rsthu="";
    public static String rsfri="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentview);
            //Getting the instance of Spinner and applying OnItemSelectedListener on it
            Spinner spin = (Spinner) findViewById(R.id.spinner);
            spin.setOnItemSelectedListener(this);
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,course);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);


            Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
            spin2.setOnItemSelectedListener(this);
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter ab = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dept);
            ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin2.setAdapter(ab);

            Spinner spin3 = (Spinner) findViewById(R.id.spinner3);
            spin3.setOnItemSelectedListener(this);
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter ac = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sect);
            ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner

            spin3.setAdapter(ac);
        }
    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Toast.makeText(getApplicationContext(),course[position] , Toast.LENGTH_LONG).show();
        text=arg0.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        text="A";
    }
    public void stuimg(View view)
    {
        flag=0;
        new myTask().execute();
       // prgDialog.dismiss();
       // Intent intent = new Intent(getApplicationContext(), studimageview.class);
     //   System.out.print(rsmonone);
       // intent.putExtra("STRING_I_NEED", rsmonone);
       // while(flag==1){
      //  startActivity(intent);
      //  break;
      //  }
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


        @Override
        protected Void doInBackground(Void... voids) {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, usr, pwd);
                s="0";
                Statement st = con.createStatement();
                ResultSet rsmon=st.executeQuery("select * from CSE"+text + " where Day='Monday' ");
                while(rsmon.next())
                    rsmonone += (rsmon.getString(3) + " " + rsmon.getString(4) + " "+ rsmon.getString(5) + " ");


                ResultSet rstue1=st.executeQuery("select * from CSE"+text + " where Day='Tuesday' ");
                while(rstue1.next())
                    rstue += (rstue1.getString(3) + " " + rstue1.getString(4) + " "+ rstue1.getString(5) + " ");

                ResultSet rswed1=st.executeQuery("select * from CSE"+text + " where Day='Wednesday' ");
                while(rswed1.next())
                    rswed += (rswed1.getString(3) + " " + rswed1.getString(4) + " "+ rswed1.getString(5) + " ");

                ResultSet rsthu1=st.executeQuery("select * from CSE"+text + " where Day='Thursday' ");
                while(rsthu1.next())
                    rsthu += (rsthu1.getString(3) + " " + rsthu1.getString(4) + " "+ rsthu1.getString(5) + " ");

                ResultSet rsfri1=st.executeQuery("select * from CSE"+text + " where Day='Friday' ");
                while(rsfri1.next())
                    rsfri += (rsfri1.getString(3) + " " + rsfri1.getString(4) + " "+ rsfri1.getString(5) + " ");


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
                    studentview.this);
            prgDialog.setMessage
                    ("Gathering Details");
            // prgDialog.setIndeterminate(false);
            prgDialog.setProgressStyle
                    (ProgressDialog.STYLE_SPINNER);
            prgDialog.setCancelable(false);
            prgDialog.show();

                Toast.makeText(getApplicationContext(),"Connected",Toast.LENGTH_LONG).show();
                Intent i=new Intent(studentview.this,studimageview.class);
                i.putExtra("STRING_I_NEED", rsmonone);
                i.putExtra("tue",rstue);
                i.putExtra("wed",rswed);
                i.putExtra("thu",rsthu);
                i.putExtra("fri",rsfri);
                startActivity(i);
                prgDialog.dismiss();

            }


        }
    }
}

