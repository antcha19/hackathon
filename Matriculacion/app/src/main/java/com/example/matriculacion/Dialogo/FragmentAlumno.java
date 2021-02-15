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
import com.example.matriculacion.data.ListaAlumno;

public class FragmentAlumno extends DialogFragment {


    public ListaAlumno listaAlumno;

    public FragmentAlumno(ListaAlumno listaAlumno){
        this.listaAlumno=listaAlumno;
    }
    public Fragmentupdate listener;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.frag_alumno, null);

        EditText dni = view.findViewById(R.id.dnifrg);
        EditText nombre = view.findViewById(R.id.nombrefrg);
        EditText apellidos = view.findViewById(R.id.apellidosfrg);

        dni.setText(listaAlumno.getId());
        nombre.setText(listaAlumno.getName());
        apellidos.setText(listaAlumno.getApellidos());

        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Actulizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nombrenuevo = nombre.getText().toString();
                        String apellidonuevo = apellidos.getText().toString();

                        listaAlumno.setmName(nombrenuevo);
                        listaAlumno.setmApellidos(apellidonuevo);


                        listener.onClickUpdate(listaAlumno);
                    }
                });
        return builder.create();
    }


    public interface Fragmentupdate{
        void onClickUpdate(ListaAlumno listaAlumnos);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            listener = (FragmentAlumno.Fragmentupdate) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"No implemento el listener update");
        }
    }
}


