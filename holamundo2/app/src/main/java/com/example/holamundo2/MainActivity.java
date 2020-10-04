package com.example.holamundo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText mitexto = (EditText) findViewById(R.id.mitexto);
        final Button miBoton = (Button) findViewById(R.id.miboton);
        final TextView elsaludo = (TextView) findViewById(R.id.milbl);

        /*probar musica*/

        MediaPlayer mimusica= MediaPlayer.create(getApplicationContext(),R.raw.desigual);
        mimusica.start();

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, pantalla2.class);

                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + mitexto.getText();
                //muestro lo BUNDLE lo que paso
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
                showToast("Pulsado BOTON");
            }
        });
    }

    protected void showToast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    protected void showAlert(CharSequence text){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton(android.R.string.ok,null);
        alert.show();
    }
}