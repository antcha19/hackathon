package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText minumero1 =(EditText)findViewById(R.id.numero1);
        final EditText minumero2 =(EditText)findViewById(R.id.numero2);
        final Button miboton =(Button)findViewById(R.id.Sumar);
        final Button miboton2 =(Button)findViewById(R.id.Restar);
        final Button miboton3 =(Button)findViewById(R.id.Multiplicacion);
        final Button miboton4 =(Button)findViewById(R.id.Division);
        final TextView miresultado =(TextView)findViewById(R.id.resultado);



        miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1=0;
                int num2=0;
                int suma;
                num1= Integer.parseInt(minumero1.getText().toString());
                num2= Integer.parseInt(minumero2.getText().toString());
                suma= num1+num2;
                miresultado.setText(String.valueOf(suma));

                Intent miIntent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle miBundle = new Bundle();
                String mensaje = (String) miresultado.getText();
                miBundle.putString("TEXTO",mensaje);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
        miboton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1=0;
                int num2=0;
                int restar;
                num1= Integer.parseInt(minumero1.getText().toString());
                num2= Integer.parseInt(minumero2.getText().toString());
                restar= num1-num2;
                  miresultado.setText(String.valueOf(restar));

                Intent miIntent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle miBundle = new Bundle();
                String mensaje = (String) miresultado.getText();
                miBundle.putString("TEXTO",mensaje);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

        miboton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1=0;
                int num2=0;
                int suma;
                num1= Integer.parseInt(minumero1.getText().toString());
                num2= Integer.parseInt(minumero2.getText().toString());
                suma= num1*num2;
                   miresultado.setText(String.valueOf(suma));

                Intent miIntent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle miBundle = new Bundle();
                String mensaje = (String) miresultado.getText();
                miBundle.putString("TEXTO",mensaje);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

        miboton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1=0;
                int num2=0;
                int suma;
                num1= Integer.parseInt(minumero1.getText().toString());
                num2= Integer.parseInt(minumero2.getText().toString());
                suma= num1/num2;
                   miresultado.setText(String.valueOf(suma));

                Intent miIntent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle miBundle = new Bundle();
                String mensaje = (String) miresultado.getText();
                miBundle.putString("TEXTO",mensaje);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

    }

}