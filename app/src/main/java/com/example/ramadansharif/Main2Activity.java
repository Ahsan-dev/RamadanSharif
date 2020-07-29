package com.example.ramadansharif;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private TextView todaDateText, presentTimeText, sahriTimeText, iftarTimeText;
    String timeS,dateS, dateD;
    public static  DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("হোম  ");



        drawerLayout = findViewById(R.id.drawerId);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nev_open,R.string.nev_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigationViewId);
        navigationView.setNavigationItemSelectedListener(this);

        todaDateText = findViewById(R.id.todayDateId);
        presentTimeText = findViewById(R.id.presentTimeId);

        sahriTimeText = findViewById(R.id.sahriTimeId);
        iftarTimeText = findViewById(R.id.iftarTimeId);

         db = new DatabaseHelper(this);
         SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();

        /*Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
        String date = simpleDateFormat.format(calendar.getTime());
        todaDateText.setText(date);

        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm a");
        String time = simpleTimeFormat.format(calendar.getTime());
        presentTimeText.setText(time);*/

       Thread t = new Thread(){

           @Override
           public void run() {

               try {
                   while (!isInterrupted()){
                       Thread.sleep(1000);
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               long time = System.currentTimeMillis();
                               SimpleDateFormat stf = new SimpleDateFormat("hh:mm a");
                               timeS = stf.format(time);
                               presentTimeText.setText(timeS);
                               long date = System.currentTimeMillis();
                               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                               dateS = sdf.format(date);

                               todaDateText.setText(dateS);
                               dateD = dateS;

                               String sahriT = showSahri(dateD);
                               String iftarT = showIftar(dateD);

                               sahriTimeText.setText(sahriT);
                               iftarTimeText.setText(iftarT);


                           }
                       });
                   }

               }catch (InterruptedException e){

               }

           }
       };
       t.start();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Intent intent;

        if(menuItem.getItemId()==R.id.homeMenuId){

            intent = new Intent(this,Main2Activity.class);
            startActivity(intent);

        }
        else if(menuItem.getItemId()==R.id.ansMenuId){

            intent = new Intent(this,AboutRamadanActivity.class);
            startActivity(intent);

        }
        else if(menuItem.getItemId()==R.id.duaMenuId){

            intent = new Intent(this,DuyaActivity.class);
            startActivity(intent);

        }
        else if(menuItem.getItemId()==R.id.calenderMenuId){

            intent = new Intent(this,CalenderActivity.class);
            startActivity(intent);

        }
        else if(menuItem.getItemId()==R.id.alarmMenuId){

            intent = new Intent(this,AlarmActivity.class);
            startActivity(intent);

        }
        else if(menuItem.getItemId()==R.id.aboutAppId){

            intent = new Intent(this,AboutAppActivity.class);
            startActivity(intent);

        }

        return false;
    }

    public String showSahri(String date){
        String sahris = "";

        Cursor c = db.showalldata();

        if(c.getCount() == 0){
            Toast.makeText(this,"No data is found",Toast.LENGTH_LONG).show();
        }
        else {

            while (c.moveToNext()){

                String sahrit = c.getString(1);
                if(sahrit.equals(date)){
                    sahris = c.getString(2);
                    break;
                }

            }



        }


        return sahris;
    }

    public String showIftar(String date){
        String iftars = "";

        Cursor c = db.showalldata();

        if(c.getCount() == 0){
            Toast.makeText(this,"No data is found",Toast.LENGTH_LONG).show();
        }
        else {

            while (c.moveToNext()){

                String sahrit = c.getString(1);
                if(sahrit.equals(date)){
                    iftars = c.getString(4);
                    break;
                }

            }



        }


        return iftars;
    }



}
