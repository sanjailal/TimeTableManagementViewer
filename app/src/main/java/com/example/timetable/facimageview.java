package com.example.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;
import java.util.ArrayList;




import static java.lang.Integer.parseInt;



public class facimageview extends AppCompatActivity {

    private ArrayList<Model> productList;
    public static String rsmon1;
    public static String rstue1;
    public static String rswed1;
    public static String rsthu1;
    public static String rsfri1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facimageview);
        Bundle extras;
        if (savedInstanceState == null)
        {
//fetching extra data passed with intents in a Bundle type variable
            extras = getIntent().getExtras();
            if(extras == null)
            {
                rsmon1= null;
                rstue1=null;
                rswed1=null;
                rsthu1=null;
                rsfri1=null;


                //       System.out.print("Actually null");
            }
            else
            {            /* fetching the string passed with intent using ‘extras’*/

                rsmon1= extras.getString("STRING_I_NEED");
                rstue1= extras.getString("tue");
                rswed1= extras.getString("wed");
                rsthu1= extras.getString("thu");
                rsfri1= extras.getString("fri");
            }
        }

        productList = new ArrayList<Model>();
        ListView lview = (ListView) findViewById(R.id.listview);
        listviewAdapter adapter = new listviewAdapter(this, productList);
        lview.setAdapter(adapter);
        populateList();

        adapter.notifyDataSetChanged();

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String sno = ((TextView)view.findViewById(R.id.sNo)).getText().toString();
                String product = ((TextView)view.findViewById(R.id.product)).getText().toString();
                String category = ((TextView)view.findViewById(R.id.category)).getText().toString();
                String price = ((TextView)view.findViewById(R.id.price)).getText().toString();

                Toast.makeText(getApplicationContext(),
                        "S no : " + sno +"\n"
                                +"Product : " + product +"\n"
                                +"Category : " +category +"\n"
                                +"Price : " +price, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateList()  {

//        Log.e("TAG", "onCreate: "+rsmon );
//        while(rsmon.next());
//            System.out.println(rsmon.getString(1) + "  " + rsmon.getString(2));



        String rsmon11[] = rsmon1.split(" ");
        String rstue11[] = rstue1.split(" ");
        String rswed11[] = rswed1.split(" ");
        String rsthu11[] = rsthu1.split(" ");
        String rsfri11[] = rsfri1.split(" ");


        //  System.out.println(rsmon11);
        Log.v("san",rsmon11[0]);

        Model item1, item2, item3, item4, item5;
        String m[]=new String[100];
        String tue[]=new String[100];
        String wed[]=new String[100];
        String thu[]=new String[100];
        String fri[]=new String[100];
        // for(int i=1;i<=18;i+=3) {

        m[1] = rsmon11[0] + "\n" + rsmon11[1] + "\n" + rsmon11[2];
        m[2] = rsmon11[3] + "\n" + rsmon11[4] + "\n" + rsmon11[5];
        m[3] = rsmon11[6] + "\n" + rsmon11[7] + "\n" + rsmon11[8];
        m[4] = rsmon11[9] + "\n" + rsmon11[10] + "\n" + rsmon11[11];
        m[5] = rsmon11[12] + "\n" + rsmon11[13] + "\n" + rsmon11[14];
        m[6] = rsmon11[15] + "\n" + rsmon11[16] + "\n" + rsmon11[17];

        tue[1] = rstue11[0] + "\n" + rstue11[1] + "\n" + rstue11[2];
        tue[2] = rstue11[3] + "\n" + rstue11[4] + "\n" + rstue11[5];
        tue[3] = rstue11[6] + "\n" + rstue11[7] + "\n" + rstue11[8];
        tue[4] = rstue11[9] + "\n" + rstue11[10] + "\n" + rstue11[11];
        tue[5] = rstue11[12] + "\n" + rstue11[13] + "\n" + rstue11[14];
        tue[6] = rstue11[15] + "\n" + rstue11[16] + "\n" + rstue11[17];


        wed[1] = rswed11[0] + "\n" + rswed11[1] + "\n" + rswed11[2];
        wed[2] = rswed11[3] + "\n" + rswed11[4] + "\n" + rswed11[5];
        wed[3] = rswed11[6] + "\n" + rswed11[7] + "\n" + rswed11[8];
        wed[4] = rswed11[9] + "\n" + rswed11[10] + "\n" + rswed11[11];
        wed[5] = rswed11[12] + "\n" + rswed11[13] + "\n" + rswed11[14];
        wed[6] = rswed11[15] + "\n" + rswed11[16] + "\n" + rswed11[17];


        thu[1] = rsthu11[0] + "\n" + rsthu11[1] + "\n" + rsthu11[2];
        thu[2] = rsthu11[3] + "\n" + rsthu11[4] + "\n" + rsthu11[5];
        thu[3] = rsthu11[6] + "\n" + rsthu11[7] + "\n" + rsthu11[8];
        thu[4] = rsthu11[9] + "\n" + rsthu11[10] + "\n" + rsthu11[11];
        thu[5] = rsthu11[12] + "\n" + rsthu11[13] + "\n" + rsthu11[14];
        thu[6] = rsthu11[15] + "\n" + rsthu11[16] + "\n" + rsthu11[17];



        fri[1] = rsfri11[0] + "\n" + rsfri11[1] + "\n" + rsfri11[2];
        fri[2] = rsfri11[3] + "\n" + rsfri11[4] + "\n" + rsfri11[5];
        fri[3] = rsfri11[6] + "\n" + rsfri11[7] + "\n" + rsfri11[8];
        fri[4] = rsfri11[9] + "\n" + rsfri11[10] + "\n" + rsfri11[11];
        fri[5] = rsfri11[12] + "\n" + rsfri11[13] + "\n" + rsfri11[14];
        fri[6] = rsfri11[15] + "\n" + rsfri11[16] + "\n" + rsfri11[17];
        // }


//
//        String tue[]=new String[20];
//        for(int i=1;i<=18;i+=3) {
//            tue[i] = rstue11[0+i] + "\n" + rstue11[1+i] + "\n" + rstue11[2+i];
//        }
//
//        String wed[]=new String[20];
//        for(int i=1;i<=18;i+=3) {
//            wed[i] = rswed11[0+i] + "\n" + rswed11[1+i] + "\n" + rswed11[2+i];
//        }
//        String thu[]=new String[20];
//        for(int i=1;i<=18;i+=3) {
//            thu[i] = rsthu11[0+i] + "\n" + rsthu11[1+i] + "\n" + rsthu11[2+i];
//        }
//
//        String fri[]=new String[20];
//        for(int i=1;i<=18;i+=3) {
//            fri[i] = rsfri11[0+i] + "\n" + rsfri11[1+i] + "\n" + rsfri11[2+i];
//        }

        Log.v("san",m[1]);
        item1 = new Model("Monday",m[1], m[2], m[3],m[4] ,m[5],m[6]);
        productList.add(item1);
        Log.v("san2",m[1]);
//[1], m[2], m[3],m[4] ,m[5],m[6]
        item2 = new Model("Tuesday", tue[1], tue[2], tue[3],tue[4] ,tue[5],tue[6]);
        productList.add(item2);

        item3 = new Model("Wednesday", wed[1], wed[2], wed[3],wed[4] ,wed[5],wed[6]);
        productList.add(item3);

        item4 = new Model("Thursday", thu[1], thu[2], thu[3],thu[4] ,thu[5],thu[6]);
        productList.add(item4);

        item5 = new Model("Friday", fri[1], fri[2], fri[3],fri[4] ,fri[5],fri[6]);
        productList.add(item5);
    }

}

//public class facimageview extends AppCompatActivity {
//
//    private ArrayList<Model> productList;
//    public static String rsmon1;
//    public static String rstue1;
//    public static String rswed1;
//    public static String rsthu1;
//    public static String rsfri1;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_facimageview);
//        Bundle extras;
//        if (savedInstanceState == null)
//        {
////fetching extra data passed with intents in a Bundle type variable
//            extras = getIntent().getExtras();
//            if(extras == null)
//            {
//                rsmon1= null;
////                rstue1=null;
////                rswed1=null;
////                rsthu1=null;
////                rsfri1=null;
//
//
//                //       System.out.print("Actually null");
//            }
//            else
//            {            /* fetching the string passed with intent using ‘extras’*/
//
//                rsmon1= extras.getString("STRING_I_NEED");
////                rstue1= extras.getString("tue");
////                rswed1= extras.getString("wed");
////                rsthu1= extras.getString("thu");
////                rsfri1= extras.getString("fri");
//            }
//        }
//        productList = new ArrayList<Model>();
//        ListView lview = (ListView) findViewById(R.id.listview);
//        listviewAdapter adapter = new listviewAdapter(this, productList);
//        lview.setAdapter(adapter);
//        populateList();
//
//        adapter.notifyDataSetChanged();
//
//        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                String sno = ((TextView)view.findViewById(R.id.sNo)).getText().toString();
//                String product = ((TextView)view.findViewById(R.id.product)).getText().toString();
//                String category = ((TextView)view.findViewById(R.id.category)).getText().toString();
//                String price = ((TextView)view.findViewById(R.id.price)).getText().toString();
//
//                Toast.makeText(getApplicationContext(),
//                        "S no : " + sno +"\n"
//                                +"Product : " + product +"\n"
//                                +"Category : " +category +"\n"
//                                +"Price : " +price, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void populateList()  {
//
////        Log.e("TAG", "onCreate: "+rsmon );
////        while(rsmon.next());
////            System.out.println(rsmon.getString(1) + "  " + rsmon.getString(2));
//
//
//
//        String rsmon11[] = rsmon1.split(" ");
////        String rstue11[] = rstue1.split(" ");
////        String rswed11[] = rswed1.split(" ");
////        String rsthu11[] = rsthu1.split(" ");
////        String rsfri11[] = rsfri1.split(" ");
//
//
//        //  System.out.println(rsmon11);
//
//
//        Model item1, item2, item3, item4, item5;
//        String m[]=new String[100];
//        String tue[]=new String[100];
//        String wed[]=new String[100];
//        String thu[]=new String[100];
//        String fri[]=new String[100];
//        // for(int i=1;i<=18;i+=3) {
//        int n;
//        n = rsmon11.length;
//        n=n/4;
////        for (int i=0;i<=n;i=i+4){
////            if(rsmon11[i]=="Monday"){
////                m[parseInt(rsmon11[i+1])]= rsmon11[i+2]+"\n"+rsmon11[i+2];
////            }
////            if(rsmon11[i]=="Tuesday"){
////                tue[parseInt(rsmon11[i+1])]= rsmon11[i+2]+"\n"+rsmon11[i+2];
////            }
////            if(rsmon11[i]=="Wednesday"){
////                wed[parseInt(rsmon11[i+1])]= rsmon11[i+2]+"\n"+rsmon11[i+2];
////            }
////            if(rsmon11[i]=="Thursday"){
////                thu[parseInt(rsmon11[i+1])]= rsmon11[i+2]+"\n"+rsmon11[i+2];
////            }
////            if(rsmon11[i]=="Friday"){
////                fri[parseInt(rsmon11[i+1])]= rsmon11[i+2]+"\n"+rsmon11[i+2];
////            }
////        }
////        m[1]="";
////        m[2]="";
////        m[3]="";
////        m[4]="";
////        m[5]="";
////        m[6]="";
////
////        tue[1]="";
////        tue[2]="";
////        tue[3]="";
////        tue[4]="";
////        tue[5]="";
////        tue[6]="";
////
////        wed[1]="";
////        wed[2]="";
////        wed[3]="";
////        wed[4]="";
////        wed[5]="";
////        wed[6]="";
////
////        thu[1]="";
////        thu[2]="";
////        thu[3]="";
////        thu[4]="";
////        thu[5]="";
////        thu[6]="";
////
////        thu[1]="";
////        thu[2]="";
////        thu[3]="";
////        thu[4]="";
////        thu[5]="";
////        thu[6]="";
////        for (int i=0;i<=n;i=i+4){
////            if(rsmon11[i]=="Monday"){
////                if(parseInt(rsmon11[i+1])==1) {
////                    m[1] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==2) {
////                    m[2] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==3) {
////                    m[3] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==4) {
////                    m[4] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==5) {
////                    m[5] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==6) {
////                    m[6] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////            }
////            if(rsmon11[i]=="Tuesday"){
////                if(parseInt(rsmon11[i+1])==1) {
////                    tue[1] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==2) {
////                    tue[2] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==3) {
////                    tue[3] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==4) {
////                    tue[4] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==5) {
////                    tue[5] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==6) {
////                    tue[6] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////            }
////            if(rsmon11[i]=="Wednesday"){
////                if(parseInt(rsmon11[i+1])==1) {
////                    wed[1] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==2) {
////                    wed[2] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==3) {
////                    wed[3] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==4) {
////                    wed[4] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==5) {
////                    wed[5] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==6) {
////                    wed[6] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////            }
////            if(rsmon11[i]=="Thursday"){
////                if(parseInt(rsmon11[i+1])==1) {
////                    thu[1] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==2) {
////                    thu[2] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==3) {
////                    thu[3] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==4) {
////                    thu[4] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==5) {
////                    thu[5] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==6) {
////                    thu[6] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////            }
////            if(rsmon11[i]=="Friday"){
////                if(parseInt(rsmon11[i+1])==1) {
////                    fri[1] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==2) {
////                    fri[2] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==3) {
////                    fri[3] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==4) {
////                    fri[4] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==5) {
////                    fri[5] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////                if(parseInt(rsmon11[i+1])==6) {
////                    fri[6] = rsmon11[i + 2] + "\n" + rsmon11[i + 2];
////                }
////            }
////        }
//
////        m[1] = rsmon11[3] + "\n" + rsmon11[4] + "\n" + rsmon11[2];
////        m[2] = rsmon11[3] + "\n" + rsmon11[4] + "\n" + rsmon11[5];
////        m[3] = rsmon11[6] + "\n" + rsmon11[7] + "\n" + rsmon11[8];
////        m[4] = rsmon11[9] + "\n" + rsmon11[10] + "\n" + rsmon11[11];
////        m[5] = rsmon11[12] + "\n" + rsmon11[13] + "\n" + rsmon11[14];
////        m[6] = rsmon11[15] + "\n" + rsmon11[16] + "\n" + rsmon11[17];
//
////        tue[1] = rstue11[0] + "\n" + rstue11[1] + "\n" + rstue11[2];
////        tue[2] = rstue11[3] + "\n" + rstue11[4] + "\n" + rstue11[5];
////        tue[3] = rstue11[6] + "\n" + rstue11[7] + "\n" + rstue11[8];
////        tue[4] = rstue11[9] + "\n" + rstue11[10] + "\n" + rstue11[11];
////        tue[5] = rstue11[12] + "\n" + rstue11[13] + "\n" + rstue11[14];
////        tue[6] = rstue11[15] + "\n" + rstue11[16] + "\n" + rstue11[17];
////
////
////        wed[1] = rswed11[0] + "\n" + rswed11[1] + "\n" + rswed11[2];
////        wed[2] = rswed11[3] + "\n" + rswed11[4] + "\n" + rswed11[5];
////        wed[3] = rswed11[6] + "\n" + rswed11[7] + "\n" + rswed11[8];
////        wed[4] = rswed11[9] + "\n" + rswed11[10] + "\n" + rswed11[11];
////        wed[5] = rswed11[12] + "\n" + rswed11[13] + "\n" + rswed11[14];
////        wed[6] = rswed11[15] + "\n" + rswed11[16] + "\n" + rswed11[17];
////
////
////        thu[1] = rsthu11[0] + "\n" + rsthu11[1] + "\n" + rsthu11[2];
////        thu[2] = rsthu11[3] + "\n" + rsthu11[4] + "\n" + rsthu11[5];
////        thu[3] = rsthu11[6] + "\n" + rsthu11[7] + "\n" + rsthu11[8];
////        thu[4] = rsthu11[9] + "\n" + rsthu11[10] + "\n" + rsthu11[11];
////        thu[5] = rsthu11[12] + "\n" + rsthu11[13] + "\n" + rsthu11[14];
////        thu[6] = rsthu11[15] + "\n" + rsthu11[16] + "\n" + rsthu11[17];
////
////
////
////        fri[1] = rsfri11[0] + "\n" + rsfri11[1] + "\n" + rsfri11[2];
////        fri[2] = rsfri11[3] + "\n" + rsfri11[4] + "\n" + rsfri11[5];
////        fri[3] = rsfri11[6] + "\n" + rsfri11[7] + "\n" + rsfri11[8];
////        fri[4] = rsfri11[9] + "\n" + rsfri11[10] + "\n" + rsfri11[11];
////        fri[5] = rsfri11[12] + "\n" + rsfri11[13] + "\n" + rsfri11[14];
////        fri[6] = rsfri11[15] + "\n" + rsfri11[16] + "\n" + rsfri11[17];
////        // }
//
//
////
////        String tue[]=new String[20];
////        for(int i=1;i<=18;i+=3) {
////            tue[i] = rstue11[0+i] + "\n" + rstue11[1+i] + "\n" + rstue11[2+i];
////        }
////
////        String wed[]=new String[20];
////        for(int i=1;i<=18;i+=3) {
////            wed[i] = rswed11[0+i] + "\n" + rswed11[1+i] + "\n" + rswed11[2+i];
////        }
////        String thu[]=new String[20];
////        for(int i=1;i<=18;i+=3) {
////            thu[i] = rsthu11[0+i] + "\n" + rsthu11[1+i] + "\n" + rsthu11[2+i];
////        }
////
////        String fri[]=new String[20];
////        for(int i=1;i<=18;i+=3) {
////            fri[i] = rsfri11[0+i] + "\n" + rsfri11[1+i] + "\n" + rsfri11[2+i];
////        }
//
//
//
//        item1 = new Model("Monday"," ", "CSEA L201", "","" ,"CSEC L421","");
//        productList.add(item1);
//
//        item2 = new Model("Tuesday", " ", "CSEA L201", "","" ,"CSEC L421","");
//        productList.add(item2);
//
//        item3 = new Model("Wednesday", " ", "CSEA L201", "","" ,"CSEC L421","");
//        productList.add(item3);
//
//        item4 = new Model("Thursday", " ", "CSEA L201", "","" ,"CSEC L421","");
//        productList.add(item4);
//
//        item5 = new Model("Friday", " ", "CSEA L201", "","" ,"CSEC L421","");
//        productList.add(item5);
//    }
//
//}
