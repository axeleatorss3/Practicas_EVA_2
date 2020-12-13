package com.example.eva2_9_transiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Intent Inten;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inten = new Intent(this, MainActivity2.class);
        imageView = findViewById(R.id.imageView1);
    }

    public void onclick(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                this,imageView,"mi_trans"
        );
        startActivity(Inten,options.toBundle());
    }
}