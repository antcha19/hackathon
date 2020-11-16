package com.example.perro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class visor extends AppCompatActivity {

    private RadioGroup Rgrupo;
    private Button boton;
    String textoselecionado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        //declaramos el radiogrupo


       final   RadioGroup Rgrupo=(RadioGroup)findViewById(R.id.radiogrupo);
       final   Button boton = (Button)findViewById(R.id.button);
       final TextView texto = (TextView)findViewById(R.id.textView);

         Rgrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {


                 if(group.getCheckedRadioButtonId()== R.id.radio_hermoso){
                     textoselecionado = "hermoso";
                 }
                 if (group.getCheckedRadioButtonId()==R.id.radio_horroroso){
                     textoselecionado="horroroso";
                 }
                 if (group.getCheckedRadioButtonId()==R.id.radio_lindo){
                     textoselecionado="lindo";
                 }
                 if (group.getCheckedRadioButtonId()==R.id.radio_normal){
                     textoselecionado="normal";
                 }
                 texto.setText(textoselecionado);
             }
         });

         boton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent miintent = new Intent(visor.this, MainActivity.class);
                 Bundle miBundle = new Bundle();
                 String mensajePaso = "Te saludo " + textoselecionado;
                 miBundle.putString("TEXTO", mensajePaso);
                 miintent.putExtras(miBundle);
                 startActivity(miintent);
             }
         });
    }


}