package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InicioUsuario extends AppCompatActivity implements View.OnClickListener {
        Button btnsalir;
        TextView nombre;
        int id=0;
        Usuario u;
        daoUsuario dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuario);

        nombre=(TextView)findViewById(R.id.MostartUsuario);
        btnsalir=(Button)findViewById(R.id.botonsalirlog);
        btnsalir.setOnClickListener(this);

        Bundle miBundle = getIntent().getExtras();
        id=miBundle.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioID(id);
        nombre.setText("Hola" + u.getNombre()+", "+ u.getApellidos());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonsalirlog:
                Intent i2=new Intent(InicioUsuario.this, MainActivity.class);
                startActivity(i2);

        }
    }
}