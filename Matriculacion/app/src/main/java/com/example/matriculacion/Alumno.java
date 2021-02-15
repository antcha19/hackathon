package com.example.matriculacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.Dialogo.FragmentAlumno;
import com.example.matriculacion.add.AnadirAlumno;
import com.example.matriculacion.data.ListaAlumno;
import com.example.matriculacion.editlista.AlumnoViewModel;
import com.example.matriculacion.editlista.ListAdapter;

public class Alumno extends AppCompatActivity implements FragmentAlumno.Fragmentupdate {

    private AlumnoViewModel mViewModel;
    private RecyclerView mList;
    private ListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        //variable del "add *"
        View add = findViewById(R.id.floating_action_button);


        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new  ViewModelProvider(this, factory).get(AlumnoViewModel.class);

        //codigo para que muestro al pulsar el +
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //este lleva a la actividad de añadir
                Intent intentañadir = new Intent (v.getContext(), AnadirAlumno.class);
                startActivityForResult(intentañadir, 0);
            }
        });

        setupList();

    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new ListAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListenerAlumno(new ListAdapter.ItemListener() {
            @Override
            public void onClick(ListaAlumno listaAlumno) {

            }
            //iconborrar
            @Override
            public void onDeleteIconClicked(ListaAlumno listaAlumno) {
                        mViewModel.deleteAlumno(listaAlumno);
            }

            @Override
            public void UpdateIconClick(ListaAlumno listaAlumno) {
                DialogFragment dialog = new FragmentAlumno(listaAlumno);
                dialog.show(getSupportFragmentManager(),"alumnooos");
            }
        });
        mViewModel.getListaAlumnos().observe(this, mAdapter::setItems);
    }


    @Override
    public void onClickUpdate(ListaAlumno listaAlumnos) {
        mViewModel.updateAlumno(listaAlumnos);
    }
}
