package com.example.perrofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class visor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        //declaramos el radiogrupo
        final RadioGroup Rgrupo=(RadioGroup)findViewById(R.id.radiogrupo);
        final   Button boton = (Button)findViewById(R.id.button);
        final TextView texto = (TextView)findViewById(R.id.textView);
        final   String[] textoselecionado={""};

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
                Intent miintent = new Intent();
                Bundle mibBundle = new Bundle();
                mibBundle.putString("respuesta", textoselecionado[0]);
                miintent.putExtras(mibBundle);
                setResult(RESULT_OK,miintent);
                finish();

            }
        });


    }
}