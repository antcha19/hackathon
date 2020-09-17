package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText mitexto = (EditText) findViewById(R.id.mitexto);
        final Button miBoton = (Button) findViewById(R.id.miboton);
        final TextView elsaludo = (TextView) findViewById(R.id.milbl);

        //boton preparado para escuchar
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensajesaludo = "te saluda " + mitexto.getText();
                elsaludo.setText(mensajesaludo.toUpperCase());
            }
        });
    }
}