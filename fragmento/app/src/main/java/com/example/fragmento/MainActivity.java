package com.example.fragmento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Obteniendo la instancia del botón add_fragment
       Button añadirfragment = (Button)findViewById(R.id.button);

    //escucha el boton
        añadirfragment.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Paso 1: Obtener la instancia del administrador de fragmentos
               FragmentManager fragmentManager = getFragmentManager();

               //Paso 2: Crear una nueva transacción
               FragmentTransaction transaction = fragmentManager.beginTransaction();

               //Paso 3: Crear un nuevo fragmento y añadirlo
               CountFragment fragment = new CountFragment();
               transaction.add(R.id.contenedor, fragment);
               //Paso 4: Confirmar el cambio
               transaction.commit();

           }
       });

    }
}