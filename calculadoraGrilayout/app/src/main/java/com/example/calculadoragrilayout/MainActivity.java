package com.example.calculadoragrilayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView resul = (TextView)findViewById(R.id.resultado);

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




    }
}