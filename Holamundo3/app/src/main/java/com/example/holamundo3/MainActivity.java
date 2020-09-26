package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA = 0;
    TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView elSaludo = (TextView) findViewById(R.id.miLbl);

        //si regreso de otra actvidad
        if (savedInstanceState != null) {
            String mensajePasado = savedInstanceState.getString("TEXTO");
            elSaludo.setText(mensajePasado);
        }
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);
            }
        });
    }

    public void onActivityForResult(int cod_resp, int cod_result, Intent intent) {
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("DEVUELTO"));
        }
    }

    /* proceso para entender el ciclo de vida*/
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        Toast.makeText(this, "onPause-ClasePrincipal", Toast.LENGTH_SHORT).show();
        super.onPause();
    }


    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        Toast.makeText(this, "onDestroy-ClasePrincipaly", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}