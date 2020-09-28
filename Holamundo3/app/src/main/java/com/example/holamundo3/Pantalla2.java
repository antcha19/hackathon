package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo=(TextView)findViewById(R.id.miMensaje);
        final Button volverBoton= (Button)findViewById(R.id.miVolver);
        final ImageButton imageboton=(ImageButton)findViewById(R.id.imgvolver);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarSaludo=miBundleRecoger.getString("TEXTO");
        volverBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vueltaIntent= new Intent();
                Bundle vueltaBundle=new Bundle();
                String mensajeDevuelto="Devuelvo a principal " + completarSaludo;
                vueltaBundle.putString("DEVUELVO", mensajeDevuelto);
                vueltaIntent.putExtras(vueltaBundle);
                setResult(RESULT_OK, vueltaIntent);
                finish();
            }
        });
    }

    /* Proceso para entender el ciclo de vida */
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart-Pantalla2", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume-Pantalla2", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        Toast.makeText(this, "onPause-Pantalla2", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop-Pantalla2", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart-Pantalla2", Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}