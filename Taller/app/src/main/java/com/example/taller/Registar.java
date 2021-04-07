package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registar extends AppCompatActivity implements View.OnClickListener {

    EditText us,pass,nom,ap;
    Button reg,can;
    TextView volverlogin;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        us = (EditText)findViewById(R.id.RegUsuario);
        pass = (EditText)findViewById(R.id.Regpass);
        nom = (EditText)findViewById(R.id.RegNombre);
        ap = (EditText)findViewById(R.id.RegApellidos);
        reg = (Button)findViewById(R.id.RegbtnRegister);
        can =(Button)findViewById(R.id.RegbtnCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao = new daoUsuario((this));

         volverlogin = (TextView) findViewById(R.id.link_login);



        volverlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(Registar.this,Login.class);
                startActivity(miIntent);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RegbtnRegister:
                Usuario u = new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pass.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this,"ERROR: Campos vacion",Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)){
                    Toast.makeText(this,"registro exitoso", Toast.LENGTH_LONG).show();
                    Intent miiIntent2 = new Intent(Registar.this,Login.class);
                    startActivity(miiIntent2);
                    finish();
                }else{
                    Toast.makeText(this,"usuario ya registrado",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.RegbtnCancelar:
                Intent miiIntent = new Intent(Registar.this,MainActivity.class);
                startActivity(miiIntent);
                finish();
                break;
        }
    }
}