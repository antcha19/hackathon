package com.example.matriculacion.Dialogo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.example.matriculacion.R;
import com.example.matriculacion.data.ListaAsignatura;

public class FragmentAsignatura extends DialogFragment {


    public ListaAsignatura listaAsignatura;

    public FragmentAsignatura(ListaAsignatura listaAsignatura){
        this.listaAsignatura=listaAsignatura;
    }
    public Fragmentupdateasig listener;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        //obtengo el xml para el fragment
        View view = inflater.inflate(R.layout.frag_asignatura, null);

        EditText codigo = view.findViewById(R.id.codigofrag);
        EditText asignatura = view.findViewById(R.id.asigfrag);
       //obtengo los datos
        codigo.setText(listaAsignatura.getCodigo());
        asignatura.setText(listaAsignatura.getNombre());



        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String asignaturanueva = asignatura.getText().toString();

                        listaAsignatura.setmNombre(asignaturanueva);
                        listener.onClickUpdate(listaAsignatura);
                    }
                });
        return builder.create();
    }


    public interface Fragmentupdateasig{
        void onClickUpdate(ListaAsignatura listaAsignatura);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            listener = (Fragmentupdateasig) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"No implemento el listener update");
        }
    }
}
