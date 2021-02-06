package com.example.matriculacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.matriculacion.data.ListaAsignatura;
import com.example.matriculacion.editlista.ListaAsignaturaViewModel;

public class Asignatura extends AppCompatActivity {

private ListaAsignaturaViewModel mviewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        TextView dbasig = findViewById(R.id.db_text);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mviewModel = new ViewModelProvider(this, factory)
                .get(ListaAsignaturaViewModel.class);

        mviewModel.getListaAsignaturas().observe(this,listaAsignaturas -> {
            StringBuilder sb =  new StringBuilder();
            for (ListaAsignatura list : listaAsignaturas){
                sb.append(list.getCodigo()).append("  ");
                sb.append(list.getNombre()).append("\n");
            }
            dbasig.setText(sb.toString());
        });
    }
    
}