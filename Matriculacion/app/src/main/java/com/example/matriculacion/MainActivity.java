package com.example.matriculacion;

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


        //ir a la actividad asignatura
        Button asig = (Button) findViewById(R.id.Asignaturas);
        asig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (v.getContext(),Asignatura.class);
                startActivityForResult(intent2, 0);
            }
        });

        Button alumno=(Button) findViewById(R.id.Alumnos);
        alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentalu = new Intent (v.getContext(), Alumno.class);
                startActivityForResult(intentalu, 0);
            }
        });

    }
}