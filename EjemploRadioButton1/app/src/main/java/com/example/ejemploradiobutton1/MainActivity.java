package com.example.ejemploradiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mensaje =(TextView)findViewById(R.id.Seleccion);
        final RadioGroup Radiogrupo=(RadioGroup)findViewById(R.id.grupo);
        final EditText minumero1=(EditText) findViewById(R.id.numero1);
        final EditText minumero2=(EditText)findViewById(R.id.numero2);

        Radiogrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
             //   mensaje.setText("ID opcion seleccionada " + checkedId );
                String textoOpcion="";
                int resultado=0;
                if( group.getCheckedRadioButtonId()==R.id.radio1) {
                   // textoOpcion += "OPCION 1 con ID:" + checkedId;
                    int num1=0;
                    int num2=0;

                    num1= Integer.parseInt(minumero1.getText().toString());
                    num2= Integer.parseInt(minumero2.getText().toString());
                    resultado= num1+num2;

                }
                if( group.getCheckedRadioButtonId()==R.id.radio2) {
                  //  textoOpcion += "OPCION 2 con ID:" + checkedId;
                    int num1=0;
                    int num2=0;

                    num1= Integer.parseInt(minumero1.getText().toString());
                    num2= Integer.parseInt(minumero2.getText().toString());
                    resultado= num1-num2;

                }
                mensaje.setText(String.valueOf(resultado));
            }

        });
    }
}