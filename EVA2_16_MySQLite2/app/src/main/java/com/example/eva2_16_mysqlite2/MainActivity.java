package com.example.eva2_16_mysqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView  listView;
    SQLiteDatabase sqLiteDatabase;
    final String nombre_db = "mi_base_de_datos";
    List <String> listNombre = new ArrayList<String>()  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        sqLiteDatabase = openOrCreateDatabase(nombre_db,MODE_PRIVATE,null );
        try {
            sqLiteDatabase.execSQL("create table mitabla(id integer primary key autoincrement,"+"nombre text,"+"apellido text);");
        }catch (SQLException e){
            e.printStackTrace();
        }

        sqLiteDatabase.execSQL("insert into mitabla(nombre,apellido) values('Mario','Tejada')");
        sqLiteDatabase.execSQL("insert into mitabla(nombre,apellido) values('Isa','Tejada')");
        sqLiteDatabase.execSQL("insert into mitabla(nombre,apellido) values('Felix','Tejada')");
        sqLiteDatabase.execSQL("insert into mitabla(nombre,apellido) values('Luna','Tejada')");
        Cursor cursor = sqLiteDatabase.rawQuery("select * from  mitabla;",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String apellido = cursor.getString(cursor.getColumnIndex("apellido"));
            listNombre.add(cursor.getString(cursor.getColumnIndex("nombre"))+" "+apellido);
            cursor.moveToNext();

        }
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listNombre));




    }
}