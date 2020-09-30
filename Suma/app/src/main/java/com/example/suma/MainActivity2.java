package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView resultadofinal =(TextView)findViewById(R.id.resultadofinal);
        final TextView botonvolver =(TextView)findViewById(R.id.mibotonvolver);


        Bundle miBundlefinal = getIntent().getExtras();
        resultadofinal.setText(miBundlefinal.getString("TEXTO"));

        botonvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(miIntent);
            }
        });


    }
}