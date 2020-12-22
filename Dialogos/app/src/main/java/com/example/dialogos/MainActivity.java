package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements  SimpleDialogFrag.OnSimpleDialogListener{

//declaracion variable
    Button bton;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         bton =  (Button)findViewById(R.id.boton);
         //boton escuchar
        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment simpleDialog = new SimpleDialogFrag();
                simpleDialog.show(getSupportFragmentManager(),"prueba");
            }
        });
    }

    @Override
    public void onPossitiveButtonClick() {
        texto = (TextView)findViewById(R.id.texto) ;
        texto.setText("has pulsado si");
    }

    @Override
    public void onNegativeButtonClick() {
        texto = (TextView)findViewById(R.id.texto) ;
        texto.setText("has pulsado cancelar");
    }
}