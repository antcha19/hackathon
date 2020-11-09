package com.example.perro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class visor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        //declaramos el radiogrupo

        final RadioGroup Rgrupo=(RadioGroup)findViewById(R.id.radiogrupo);
        final Button boton = (Button)findViewById(R.id.button);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rgrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                         String texto = "";
                        if (group.getCheckedRadioButtonId()== R.id.radio_hermoso){
                            texto = "hermoso";
                        }
                       else  if (group.getCheckedRadioButtonId()== R.id.radio_horroroso){
                            texto = "horroroso";
                        }
                     else   if (group.getCheckedRadioButtonId()== R.id.radio_lindo){
                            texto = "lindo";
                        }
                       else if (group.getCheckedRadioButtonId()== R.id.radio_normal){
                            texto = "normal";
                        }

                        Intent miintent =  new Intent(visor.this, MainActivity.class);
                        Bundle miBundle = new Bundle();
                        String mensajePaso = texto;
                        //muestro lo BUNDLE lo que paso
                        miBundle.putString("TEXTO", mensajePaso);
                        miintent.putExtras(miBundle);
                        startActivity(miintent);

                    }
                });



            }
        });
    }
}