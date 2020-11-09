package com.example.perro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final TextView text= (TextView)findViewById(R.id.enlace);
         final Button Mostrar = (Button)findViewById(R.id.mostrar);
            final TextView text2 = findViewById(R.id.opinion);


         Mostrar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent miIntent = new Intent(MainActivity.this, visor.class);
                 startActivity(miIntent);
             }
         });

        Bundle miBundleRecoger = getIntent().getExtras();
        text2.setText(miBundleRecoger.getString("TEXTO"));


          text.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Uri web= Uri.parse("http://hermosaprogramacion.blogspot.com");
                  Intent intent = new Intent(Intent.ACTION_VIEW,web);
                  startActivity(intent);
                  // Verificar si hay aplicaciones disponibles
                  PackageManager packageManager = getPackageManager();
                  List activities = packageManager.queryIntentActivities(intent, 0);
                  boolean isIntentSafe = activities.size() > 0;

                  // Si hay, entonces ejecutamos la actividad
                  if (isIntentSafe) {
                      startActivity(intent);
                  }
              }
          });







}
}