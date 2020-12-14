package com.example.eva2_11_file_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

        private TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView = findViewById(R.id.textView);
        }

        @Override
        protected void onStart() {
            super.onStart();
            //Abrir el archivo
            //Leerlo en forma de bytes InputStreamReader
            // Interpretarlo

            @SuppressLint("ResourceType") InputStream is = getResources().openRawResource(R.drawable.ic_launcher_background);
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isReader);
            String sCade;
            try{
                while ((sCade = br.readLine()) != null){
                    textView.append(sCade);
                    textView.append("\n");
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }


    }
}