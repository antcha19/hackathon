package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaro el bton de login
        final Button btnlogin =(Button) findViewById(R.id.botonLogin);
        final Button btnregistro = (Button)findViewById(R.id.botonRegistar);


        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntentregistro = new Intent(MainActivity.this,Registar.class);
                startActivity(miIntentregistro);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent =  new Intent(MainActivity.this, Login.class);
                startActivity(miIntent);
            }
        });
    }
}