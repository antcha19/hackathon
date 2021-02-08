package com.example.matriculacion.Dialogo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.matriculacion.R;


/**
 * Fragmento con diálogo básico
 */
public class SimpleDialogFrag extends DialogFragment {

    private EditText mEditText;
    //  PASO 2.- Declarar un atributo del tipo de la interfaz para conseguir la instancia directa de la actividad.
    //  Interfaz de comunicación
    OnSimpleDialogListener listener;

    public SimpleDialogFrag() {
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
        builder.setTitle("Introduce Asignatura");
        final EditText codigo = new EditText(getActivity());
        codigo.setHint("codigo");
        layout.addView(codigo);
        final EditText Asignatura = new EditText(getActivity());
        Asignatura.setHint("Asignatura");
        layout.addView(Asignatura);
        builder.setView(layout);
        builder.setPositiveButton("Guardar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //PASO5.-
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

    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick();// Eventos Botón Positivo
        void onNegativeButtonClick();// Eventos Botón Negativo
    }

}