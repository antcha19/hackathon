package com.example.matriculacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.Dialogo.FragmentAsignatura;
import com.example.matriculacion.add.AnadirAsignatura;
import com.example.matriculacion.data.ListaAsignatura;
import com.example.matriculacion.editlista.AsignaturaViewModel;
import com.example.matriculacion.editlista.ListAdapterAsig;

public class Asignatura extends AppCompatActivity implements FragmentAsignatura.Fragmentupdateasig {

private AsignaturaViewModel mviewModel;
    private RecyclerView mList;
    private ListAdapterAsig mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        View addasig = findViewById(R.id.floating_action_button2);


        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mviewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        //codigo para que muestro al pulsar el +
        addasig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //este lleva a la actividad de añadir
                Intent intentañadir = new Intent (v.getContext(), AnadirAsignatura.class);
                startActivityForResult(intentañadir, 0);
            }
        });
        setuplist();
    }




    public void setuplist(){

        mList = findViewById(R.id.listasig);
        mAdapter = new ListAdapterAsig();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new ListAdapterAsig.ItemListener() {
            @Override
            public void onClick(ListaAsignatura listaAsignatura) {

            }

            @Override
            public void onDeleteIconClicked(ListaAsignatura listaAsignatura) {
                mviewModel.borrarasignaturaviewmodel(listaAsignatura);
            }

            @Override
            public void onClickUpdate(ListaAsignatura listaAsignatura) {
                   //llamo fragemnento asignatura
                DialogFragment dialogFragmentasig = new FragmentAsignatura(listaAsignatura);
                dialogFragmentasig.show(getSupportFragmentManager(),"asignatura");
            }
        });
        mviewModel.getListaAsignaturas().observe(this, mAdapter::setItemsAsig);
    }


    @Override
    public void onClickUpdate(ListaAsignatura listaAsignatura) {
        mviewModel.actualizarasignaturaviewmodel(listaAsignatura);
    }
}