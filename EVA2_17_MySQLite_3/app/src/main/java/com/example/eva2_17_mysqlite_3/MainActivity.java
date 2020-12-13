package com.example.eva2_17_mysqlite_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    final String nombre_db = "mi_base_de_datos";
    List<String> listNombre = new ArrayList<String>()  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        sqLiteDatabase = openOrCreateDatabase(nombre_db, MODE_PRIVATE, null);
        try {
            sqLiteDatabase.execSQL(" drop table if exists mitabla;");
            sqLiteDatabase.execSQL("create table mitabla(id integer primary key autoincrement," + "nombre text," + "apellido text);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre","Mario");
        contentValues.put("apellido","Tejada");
        sqLiteDatabase.insert("mitabla",null,contentValues);
        contentValues.clear();
        contentValues.put("nombre","Luna");
        contentValues.put("apellido","Tejada");
        sqLiteDatabase.insert("mitabla",null,contentValues);
        contentValues.clear();
        contentValues.put("nombre","ISa");
        contentValues.put("apellido","Tejada");
        sqLiteDatabase.insert("mitabla",null,contentValues);

        long iclave;
        contentValues.put("nombre","ISa");
        contentValues.put("apellido","Tejada");
        iclave = sqLiteDatabase.insert("mitabla",null,contentValues);
        Toast.makeText(this, ""+iclave, Toast.LENGTH_SHORT).show();
        contentValues.clear();
        //UPADTE
        contentValues.put("nombre","isabel");
        contentValues.put("apellido","Quintana");
        String [] args ={String.valueOf(iclave)};
        sqLiteDatabase.update("mitabla",contentValues,"id = ?",args);

        //DELETE
        String [] args2 ={"ISa"};
        sqLiteDatabase.delete("mitabla","nombre = ?", args2);


      // Cursor cursor = sqLiteDatabase.rawQuery("select * from  mitabla;",null);
        String[] args3 = {"isabel"+","+"Mario"};
        String[] columns = {"nombre","apellido"};
        Cursor cursor = sqLiteDatabase.query("mitabla",columns,null,null,null,null,"nombre");
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String apellido = cursor.getString(cursor.getColumnIndex("apellido"));
            listNombre.add(cursor.getString(cursor.getColumnIndex("nombre"))+" "+apellido);
            cursor.moveToNext();

        }
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listNombre));





    }
}