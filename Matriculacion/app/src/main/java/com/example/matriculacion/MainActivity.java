package com.example.matriculacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.matriculacion.asignatura.asignatura;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ir a la actividad asignatura
        Button asig = (Button) findViewById(R.id.idasignatura);
        asig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (v.getContext(), asignatura.class);
                startActivityForResult(intent2, 0);
            }
        });

        Button alumno=(Button) findViewById(R.id.idalumnos);
        alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentalu = new Intent (v.getContext(), com.example.matriculacion.alumno.alumno.class);
                startActivityForResult(intentalu, 0);
            }
        });
    }
}