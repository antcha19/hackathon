package com.example.matriculacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.matriculacion.data.ListaAlumno;
import com.example.matriculacion.editlista.ListaAlumnoViewModel;

public class Alumno extends AppCompatActivity {

    private ListaAlumnoViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        TextView dbalumno = findViewById(R.id.db_Alumno);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new  ViewModelProvider(this, factory).get(ListaAlumnoViewModel.class);

        mViewModel.getListaAlumnos().observe(this,listaAlumnos -> {
            StringBuilder sb = new StringBuilder();
            for(ListaAlumno listaAlumno : listaAlumnos){
                sb.append(listaAlumno.getId()).append("  ");
                sb.append(listaAlumno.getName()).append(" ");

            }
            dbalumno.setText(sb.toString());
        });

    }
}