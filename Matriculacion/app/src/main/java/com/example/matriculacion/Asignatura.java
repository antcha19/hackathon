package com.example.matriculacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Entity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.matriculacion.data.Lista_asignatura;
import com.example.matriculacion.editlista.Lista_asignaturaViewModel;

import java.util.List;

public class Asignatura extends AppCompatActivity {

    private Lista_asignaturaViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        TextView dbText = findViewById(R.id.db_text);

        ViewModelProvider.AndroidViewModelFactory factory=
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this,factory).get(Lista_asignaturaViewModel.class);

        mViewModel.getMlista_asignaturas().observe(this, (List<Lista_asignatura> lista_asignaturas) -> {
            StringBuilder sb= new StringBuilder();
            for (Lista_asignatura list : lista_asignaturas){
                sb.append(list.getId()).append("\n");
            }
            dbText.setText(sb.toString());
        }
        );
    }
    
}