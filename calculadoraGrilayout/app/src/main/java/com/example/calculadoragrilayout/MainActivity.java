package com.example.calculadoragrilayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private boolean punto = false;
    private boolean entra = true;
    private double resultado=0;
    private int numero1=0;
    private int numero2=0;
    private String guarda,guarda2,operacion="";
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
                guarda =resul.getText().toString();
                guarda = guarda +"0";
                resul.setText(guarda);
            }
        });

        buno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"1";
                resul.setText(guarda);
            }
        });
        bdos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"2";
                resul.setText(guarda);
            }
        });
        btres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"3";
                resul.setText(guarda);
            }
        });
        bcuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"4";
                resul.setText(guarda);
            }
        });
        bcinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"5";
                resul.setText(guarda);
            }
        });
        bseis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"6";
                resul.setText(guarda);
            }
        });
        bsiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"7";
                resul.setText(guarda);
            }
        });
        bocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"8";
                resul.setText(guarda);
            }
        });



        bnueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda =resul.getText().toString();
                guarda = guarda +"9";
                resul.setText(guarda);
            }
        });
    //multipliacion
        bmultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             guarda2 = resul.getText().toString();
             operacion = "*";
             //vacio el resultado
             resul.setText("");
            }
        });
        bsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda2 = resul.getText().toString();
                operacion = "+";
                //vacio el resultado
                resul.setText("");
            }
        });

        bresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda2 = resul.getText().toString();
                operacion = "-";
                //vacio el resultado
                resul.setText("");
            }
        });
        bdivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda2 = resul.getText().toString();
                operacion = "/";
                //vacio el resultado
                resul.setText("");
            }
        });

        //punto
        bpunto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                guarda = resul.getText().toString();
                if (guarda.length()<=0){
                    entra=false;
                }
                if(punto==false&&entra==true){
                    guarda = resul.getText().toString();
                    guarda = guarda + ".";
                    resul.setText(guarda);
                    punto=true;
                }
                entra=true;
            }
        });



        //borrar todo
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda = "";
                resul.setText(guarda);
                guarda2 ="";
                operacion="";
            }
        });

        //Borrar solo uno
        bborrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                guarda = resul.getText().toString();

                char ultimo = guarda.charAt(guarda.length()-1);
                String compara = String.valueOf(ultimo);
                if (compara.equals(".")) {
                    punto=false;
                }
                guarda = guarda.substring(0,guarda.length()-1);
                resul.setText(guarda);
            }
        });

        bigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guarda= resul.getText().toString();

                punto = false;

                if(operacion.equals("+")){
                        resultado = Double.parseDouble(guarda2)+ Double.parseDouble(resul.getText().toString());
                        resul.setText(String.valueOf(resultado));
                }
                if(operacion.equals("-")){
                    resultado = Double.parseDouble(guarda2)- Double.parseDouble(resul.getText().toString());
                    resul.setText(String.valueOf(resultado));
                }
                if(operacion.equals("*")){
                    resultado = Double.parseDouble(guarda2)*Double.parseDouble(resul.getText().toString());
                    resul.setText(String.valueOf(resultado));
                }
                if(operacion.equals("/")){
                    resultado = Double.parseDouble(guarda2)/ Double.parseDouble(resul.getText().toString());
                    resul.setText(String.valueOf(resultado));
                }

            }
        });


    }
}