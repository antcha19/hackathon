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
    public String textoselec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        //declaramos el radiogrupo
       final   RadioGroup Rgrupo=(RadioGroup)findViewById(R.id.radiogrupo);
        final   Button boton = (Button)findViewById(R.id.button);
        final TextView texto = (TextView)findViewById(R.id.textView);
       final   String[] textoselecionado={""};


    /*     Rgrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 if(group.getCheckedRadioButtonId()== R.id.radio_hermoso){
                     textoselec = "hermoso";
                 }
                 if (group.getCheckedRadioButtonId()==R.id.radio_horroroso){
                     textoselec="horroroso";
                 }
                 if (group.getCheckedRadioButtonId()==R.id.radio_lindo){
                     textoselec="lindo";
                 }
                 if (group.getCheckedRadioButtonId()==R.id.radio_normal){
                     textoselec="normal";
                 }
                 texto.setText(textoselec);
             }
         });*/

        Rgrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (Rgrupo.getCheckedRadioButtonId()) {
                    case R.id.radio_hermoso:
                        textoselecionado[0] = "hermoso";
                        break;
                    case R.id.radio_horroroso:
                        textoselecionado[0] = "horroroso";
                        break;
                    case R.id.radio_lindo:
                        textoselecionado[0] = "lindo";
                        break;
                    case R.id.radio_normal:
                        textoselecionado[0] = "normal";
                    default:
                        break;
                }

            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent databack = new Intent();
                Bundle sending = new Bundle();
                sending.putString("respuesta", textoselecionado[0]);
                databack.putExtras(sending);
                setResult(RESULT_OK,databack);
                finish();

            }
        });
    }


}