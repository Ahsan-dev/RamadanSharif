package com.example.ramadansharif;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "romjan.db";
    public static final String DHAKA_TABLE_NAME = "Dhaka";
    public static final int DB_VERSION = 1;

    public static final String Number = "num";
    public static final String tarikh = "tarikh";
    public static final String Sahri = "Sahri";
    public static final String Fozor = "fozor";
    public static final String Iftar = "Iftar";
    public static final String CREATE_DHAKA_TABLE = "CREATE TABLE "+DHAKA_TABLE_NAME+"( "+Number+" INTEGER PRIMARY KEY AUTOINCREMENT, "+tarikh+" VARCHAR(255), "+Sahri+" VARCHAR(255), "+Fozor+" VARCHAR(255), "+Iftar+" VARCHAR(255) );";

    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            Toast.makeText(context,"OnCreate is called",Toast.LENGTH_LONG).show();

            db.execSQL(CREATE_DHAKA_TABLE);

            db.execSQL("INSERT INTO "+DHAKA_TABLE_NAME+" " +
                    "(tarikh, sahri, fozor, iftar) " +
                    "VALUES('25/04/2020', '4:05 am', '4:11 am', '6:28 pm')," +
                    "('26/04/2020', '4:04 am', '4:10 am', '6:29 pm')," +
                    "('27/04/2020', '4:03 am', '4:09 am', '6:29 pm')," +
                    "('28/04/2020', '4:02 am', '4:08 am', '6:29 pm')," +
                    "('29/04/2020', '4:01 am', '4:07 am', '6:30 pm')," +
                    "('30/04/2020', '4:00 am', '4:06 am', '6:30 pm')," +
                    "('01/05/2020', '3:59 am', '4:05 am', '6:31 pm')," +
                    "('02/05/2020', '3:58 am', '4:04 am', '6:31 pm')," +
                    "('03/05/2020', '3:57 am', '4:03 am', '6:32 pm')," +
                    "('04/05/2020', '3:55 am', '4:00 am', '6:32 pm')," +
                    "('05/05/2020', '3:54 am', '3:59 am', '6:33 pm')," +
                    "('06/05/2020', '3:53 am', '3:59 am', '6:33 pm')," +
                    "('07/05/2020', '3:52 am', '3:58 am', '6:34 pm')," +
                    "('08/05/2020', '3:51 am', '3:57 am', '6:34 pm')," +
                    "('09/05/2020', '3:50 am', '3:56 am', '6:35 pm')," +
                    "('10/05/2020', '3:50 am', '3:56 am', '6:35 pm')," +
                    "('11/05/2020', '3:49 am', '3:55 am', '6:36 pm')," +
                    "('12/05/2020', '3:49 am', '3:55 am', '6:36 pm')," +
                    "('13/05/2020', '3:48 am', '3:54 am', '6:36 pm')," +
                    "('14/05/2020', '3:48 am', '3:54 am', '6:37 pm')," +
                    "('15/05/2020', '3:47 am', '3:53 am', '6:37 pm')," +
                    "('16/05/2020', '3:47 am', '3:53 am', '6:38 pm')," +
                    "('17/05/2020', '3:46 am', '3:52 am', '6:38 pm')," +
                    "('18/05/2020', '3:46 am', '3:52 am', '6:39 pm')," +
                    "('19/05/2020', '3:45 am', '3:51 am', '6:39 pm')," +
                    "('20/05/2020', '3:44 am', '3:50 am', '6:40 pm')," +
                    "('21/05/2020', '3:44 am', '3:50 am', '6:40 pm')," +
                    "('22/05/2020', '3:43 am', '3:49 am', '6:41 pm')," +
                    "('23/05/2020', '3:43 am', '3:49 am', '6:42 pm')," +
                    "('24/05/2020', '3:42 am', '3:48 am', '6:42 pm')" );


        }catch (Exception e){

            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {





    }



    public Cursor showalldata(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM "+DHAKA_TABLE_NAME,null);
        return c;
    }


}
