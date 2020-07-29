package com.example.ramadansharif;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CalenderActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    TableLayout tableLayout;
    TextView rojat,tarikht,sahrit,fozort,iftart;
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("রমজান এর ক্যালেন্ডার ");

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        /*if(flag==false){

            databaseHelper.insertData();
            flag = true;

        }*/

        tableLayout = findViewById(R.id.tablelayoutId);

        Cursor data = databaseHelper.showalldata();

        data.moveToFirst();
        do{

            View tablerow = LayoutInflater.from(this).inflate(R.layout.table_item,null,false);
            rojat = tablerow.findViewById(R.id.rojatextId);
            tarikht = tablerow.findViewById(R.id.tarikhtextId);
            sahrit = tablerow.findViewById(R.id.sahritextId);
            fozort = tablerow.findViewById(R.id.fozortextId);
            iftart = tablerow.findViewById(R.id.iftartextId);

            rojat.setText(data.getString(0));
            tarikht.setText(data.getString(1));
            sahrit.setText(data.getString(2));
            fozort.setText(data.getString(3));
            iftart.setText(data.getString(4));
            tableLayout.addView(tablerow);

        }while (data.moveToNext());

        data.close();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
