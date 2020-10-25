package com.example.todoslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton Ilinear = (ImageButton)findViewById(R.id.linear);
        final ImageButton Itable = (ImageButton)findViewById(R.id.table);
        final ImageButton Irelative = (ImageButton)findViewById(R.id.relative);
        final ImageButton Igrid = (ImageButton)findViewById(R.id.grid);

        Ilinear.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, LinearLayout.class);
                startActivity(miIntent);
            }
        });
        Itable.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Tablelayout.class);
                startActivity(miIntent);
            }
        });
        Irelative.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this,RealtiveLayout.class);
                startActivity(miIntent);
            }
        });
        Igrid.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this,GridLayoud.class);
                startActivity(miIntent);
            }
        });
    }
}