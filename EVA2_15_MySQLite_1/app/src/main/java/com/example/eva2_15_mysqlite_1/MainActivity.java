package com.example.eva2_15_mysqlite_1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //crear o abir database
        sqLiteDatabase = openOrCreateDatabase("mi_base",MODE_PRIVATE,null);
        try{
            sqLiteDatabase.execSQL("create table prueba(id integer primary key autoincrement,"+"coulmna1 text,"+"columna2 integer);");
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            sqLiteDatabase.execSQL("insert into prueba(coulmna1,columna2) values('hola mundo',100);");
        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }

}