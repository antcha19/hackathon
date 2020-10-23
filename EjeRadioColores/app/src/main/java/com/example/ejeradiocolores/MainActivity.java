package com.example.ejeradiocolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RadioGroup grupo = (RadioGroup)findViewById(R.id.grupo);
        final TextView text = (TextView)findViewById(R.id.textView);
        final Button buton =  (Button)findViewById(R.id.boton);

       /* buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (group.getCheckedRadioButtonId()==R.id.Rojo){
                            //cambiar el color de fondo del textview
                            text.setBackgroundColor(Color.RED);
                        }
                        if (group.getCheckedRadioButtonId()==R.id.Verde){
                            //cambiar el color de fondo del textview
                            text.setBackgroundColor(Color.GREEN);
                        }
                        if (group.getCheckedRadioButtonId()==R.id.Azul){
                            //cambiar el color de fondo del textview
                            text.setBackgroundColor(Color.BLUE);
                        }
                    }
                });
            }
        });*/





      grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getCheckedRadioButtonId()==R.id.Rojo){
                    //cambiar el color de fondo del textview
                    text.setBackgroundColor(Color.RED);
                }
                if (group.getCheckedRadioButtonId()==R.id.Verde){
                    //cambiar el color de fondo del textview
                    text.setBackgroundColor(Color.GREEN);
                }
                if (group.getCheckedRadioButtonId()==R.id.Azul){
                    //cambiar el color de fondo del textview
                    text.setBackgroundColor(Color.BLUE);
                }
            }
        });
    }
}