package com.example.matriculacion.Dialogo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

public class SimpleDialogFrag2 extends DialogFragment {


    //  PASO 2.- Declarar un atributo del tipo de la interfaz para conseguir la instancia directa de la actividad.
    //  Interfaz de comunicación
    OnSimpleDialogListener listener;


    public SimpleDialogFrag2() {
    }


    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createSimpleDialog();
    }

    /**
     * Crea un diálogo de alerta sencillo
     * @return Nuevo diálogo
     */
    public AlertDialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        builder.setTitle("Introduce Alumno");
        final EditText dni = new EditText(getActivity());
        dni.setHint("DNI");
        layout.addView(dni);
        final EditText nombre = new EditText(getActivity());
        nombre.setHint("Nombre");
        layout.addView(nombre);
        final EditText apellidos = new EditText(getActivity());
        apellidos.setHint("Apellidos");
        layout.addView(apellidos);
        builder.setView(layout);
        builder.setPositiveButton("Guardar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //PASO5.-
                        String DNI = dni.getText().toString();
                        listener.onPossitiveButtonClick();
                    }
                });
        builder.setNegativeButton("CANCELAR",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onNegativeButtonClick();
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnSimpleDialogListener) activity;


        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSimpleDialogListener");

        }
    }




    public   interface OnSimpleDialogListener {
        void onPossitiveButtonClick();// Eventos Botón Positivo
        void onNegativeButtonClick();// Eventos Botón Negativo
    }
}
