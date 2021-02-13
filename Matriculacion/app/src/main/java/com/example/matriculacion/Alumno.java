package com.example.matriculacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.Dialogo.SimpleDialogFrag2;
import com.example.matriculacion.add.AnadirAlumno;
import com.example.matriculacion.editlista.AlumnoViewModel;
import com.example.matriculacion.editlista.ListAdapter;

public class Alumno extends AppCompatActivity  implements  SimpleDialogFrag2.OnSimpleDialogListener{

    private AlumnoViewModel mViewModel;
    private RecyclerView mList;
    private ListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        //variable del "add *"
        View add = findViewById(R.id.floating_action_button);
        TextView dbalumno = findViewById(R.id.db_Alumno);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new  ViewModelProvider(this, factory).get(AlumnoViewModel.class);

        //codigo para que muestro al pulsar el +
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //este codigo lleva al fragment de añadir
             /*   DialogFragment simpleDialog = new SimpleDialogFrag2();
                simpleDialog.show(getSupportFragmentManager(),"prueba");*/

                //este lleva a la actividad de añadir
                Intent intentañadir = new Intent (v.getContext(), AnadirAlumno.class);
                startActivityForResult(intentañadir, 0);
            }
        });

   /*     mViewModel.getListaAlumnos().observe(this,listaAlumnos -> {
            StringBuilder sb = new StringBuilder();
            for(ListaAlumno listaAlumno : listaAlumnos){
                sb.append(listaAlumno.getId()).append("  ");
                sb.append(listaAlumno.getName()).append(" ");
                sb.append(listaAlumno.getApellidos()).append(" ");

            }
            dbalumno.setText(sb.toString());
        });*/
       setupList();

    }


    @Override
    public void onPossitiveButtonClick() {

    }

    @Override
    public void onNegativeButtonClick() {

    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new ListAdapter();
        mList.setAdapter(mAdapter);
        mViewModel.getListaAlumnos().observe(this, mAdapter::setItems);
    }
}