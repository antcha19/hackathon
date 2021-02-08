package com.example.matriculacion;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.matriculacion.Dialogo.SimpleDialogFrag2;
import com.example.matriculacion.data.ListaAlumno;
import com.example.matriculacion.editlista.ListaAlumnoViewModel;

public class Alumno extends AppCompatActivity  implements  SimpleDialogFrag2.OnSimpleDialogListener{

    private ListaAlumnoViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        //variable del "add *"
        View add = findViewById(R.id.floating_action_button);
        TextView dbalumno = findViewById(R.id.db_Alumno);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new  ViewModelProvider(this, factory).get(ListaAlumnoViewModel.class);

        //codigo para que muestro al pulsar el +
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment simpleDialog = new SimpleDialogFrag2();
                simpleDialog.show(getSupportFragmentManager(),"prueba");
            }
        });
        mViewModel.getListaAlumnos().observe(this,listaAlumnos -> {
            StringBuilder sb = new StringBuilder();
            for(ListaAlumno listaAlumno : listaAlumnos){
                sb.append(listaAlumno.getId()).append("  ");
                sb.append(listaAlumno.getName()).append(" ");

            }
            dbalumno.setText(sb.toString());
        });

    }


    @Override
    public void onPossitiveButtonClick() {

    }

    @Override
    public void onNegativeButtonClick() {

    }
}