package com.example.matriculacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.Dialogo.SimpleDialogFrag;
import com.example.matriculacion.add.AnadirAsignatura;
import com.example.matriculacion.editlista.AsignaturaViewModel;
import com.example.matriculacion.editlista.ListAdapterAsig;

public class Asignatura extends AppCompatActivity implements SimpleDialogFrag.OnSimpleDialogListener {

private AsignaturaViewModel mviewModel;
    private RecyclerView mList;
    private ListAdapterAsig mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        View addasig = findViewById(R.id.floating_action_button2);
        TextView dbasig = findViewById(R.id.db_text);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mviewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        //codigo para que muestro al pulsar el +
        addasig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codigo para añadir con el dialogo
           /*     DialogFragment simple = new SimpleDialogFrag();
                simple.show(getSupportFragmentManager(),"prueba");*/

                //este lleva a la actividad de añadir
                Intent intentañadir = new Intent (v.getContext(), AnadirAsignatura.class);
                startActivityForResult(intentañadir, 0);
            }
        });

 /*       mviewModel.getListaAsignaturas().observe(this,listaAsignaturas -> {
            StringBuilder sb =  new StringBuilder();
            for (ListaAsignatura list : listaAsignaturas){
                sb.append(list.getCodigo()).append("  ");
                sb.append(list.getNombre()).append("\n");
            }
            dbasig.setText(sb.toString());
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
        mAdapter = new ListAdapterAsig();
        mList.setAdapter(mAdapter);
        mviewModel.getListaAsignaturas().observe(this, mAdapter::setItemsAsig);
    }


}