package com.example.calculadoragrilayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private String resultado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView resul = (TextView)findViewById(R.id.resultadotext);

        final Button bcero = (Button)findViewById(R.id.cero);
        final Button buno = (Button)findViewById(R.id.uno);
        final Button bdos = (Button)findViewById(R.id.dos);
        final Button btres = (Button)findViewById(R.id.tres);
        final Button bcuatro = (Button)findViewById(R.id.cuatro);
        final Button bcinco = (Button)findViewById(R.id.cinco);
        final Button bseis = (Button)findViewById(R.id.seis);
        final Button bsiete = (Button)findViewById(R.id.siete);
        final Button bocho = (Button)findViewById(R.id.ocho);
        final Button bnueve = (Button)findViewById(R.id.nueve);
        final Button bsuma = (Button)findViewById(R.id.suma);
        final Button bresta = (Button)findViewById(R.id.resta);
        final Button bmultiplicacion = (Button)findViewById(R.id.multiplicacion);
        final Button bdivision = (Button)findViewById(R.id.division);
        final Button bpunto = (Button)findViewById(R.id.punto);
        final Button bborrar = (Button)findViewById(R.id.borrar);
        final Button bc = (Button)findViewById(R.id.C);
        final Button bigual =(Button)findViewById(R.id.igual);



        bcero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "0";
                resul.setText(resultado);
            }
        });

        buno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "1";
                resul.setText(resultado);
            }
        });
        bdos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "2";
                resul.setText(resultado);
            }
        });
        btres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "3";
                resul.setText(resultado);
            }
        });
        bcuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "4";
                resul.setText(resultado);
            }
        });
        bcinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "5";
                resul.setText(resultado);
            }
        });
        bseis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "6";
                resul.setText(resultado);
            }
        });
        bsiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "7";
                resul.setText(resultado);
            }
        });
        bocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "8";
                resul.setText(resultado);
            }
        });
        bnueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado =resultado + "9";
                resul.setText(resultado);
            }
        });

        bsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resul.setText("");
              
               resultado = "";


            }
        });
        bigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resul.setText(resultado);
            }
        });


    }
}