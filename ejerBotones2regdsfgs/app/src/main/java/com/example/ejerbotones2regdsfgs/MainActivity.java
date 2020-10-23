package com.example.ejerbotones2regdsfgs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton Rojo = (ImageButton)findViewById(R.id.rojo);
        final ImageButton Azul = (ImageButton)findViewById(R.id.azul);
        final TextView Text = (TextView)findViewById(R.id.textView);

        Rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Text.setBackgroundColor(Color.RED);
            }
        });
        Azul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Text.setBackgroundColor(Color.BLUE);
            }
        });
    }
}