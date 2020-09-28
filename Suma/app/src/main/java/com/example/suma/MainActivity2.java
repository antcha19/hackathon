package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView resultadofinal =(TextView)findViewById(R.id.resultadofinal);

        Bundle miBundlefinal = getIntent().getExtras();
        resultadofinal.setText(miBundlefinal.getString("TEXTO"));
    }
}