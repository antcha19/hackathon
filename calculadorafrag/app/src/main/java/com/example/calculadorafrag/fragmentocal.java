package com.example.calculadorafrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentocal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentocal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //variables mias
    private boolean punto = false;
    private boolean entra = true;
    private double resultado=0;
    private String guarda,guarda2,operacion="";

    public fragmentocal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentocal.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentocal newInstance(String param1, String param2) {
        fragmentocal fragment = new fragmentocal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view  = inflater.inflate(R.layout.fragment_fragmentocal, container, false);

        //declaro todos los botonoes y el resultado
            final TextView resul = (TextView)view.findViewById(R.id.resultadotext);
            final Button bcero = (Button)view.findViewById(R.id.cero);
            final Button buno = (Button)view.findViewById(R.id.uno);
            final Button bdos = (Button)view.findViewById(R.id.dos);
            final Button btres = (Button)view.findViewById(R.id.tres);
            final Button bcuatro = (Button)view.findViewById(R.id.cuatro);
            final Button bcinco = (Button)view.findViewById(R.id.cinco);
            final Button bseis = (Button)view.findViewById(R.id.seis);
            final Button bsiete = (Button)view.findViewById(R.id.siete);
            final Button bocho = (Button)view.findViewById(R.id.ocho);
            final Button bnueve = (Button)view.findViewById(R.id.nueve);
            final Button bsuma = (Button)view.findViewById(R.id.suma);
            final Button bresta = (Button)view.findViewById(R.id.resta);
            final Button bmultiplicacion = (Button)view.findViewById(R.id.multiplicacion);
            final Button bdivision = (Button)view.findViewById(R.id.division);
            final Button bpunto = (Button)view.findViewById(R.id.punto);
            final Button bborrar = (Button)view.findViewById(R.id.borrar);
            final Button bc = (Button)view.findViewById(R.id.C);
            final Button bigual =(Button)view.findViewById(R.id.igual);



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
                    punto = false;
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
       return  view;
    }


}