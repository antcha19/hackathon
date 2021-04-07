package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity  implements View.OnClickListener{

    EditText user, pass;
    Button btnentrar;
    TextView linkregistrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.usuario);
        pass = (EditText)findViewById(R.id.password);
        btnentrar=(Button)findViewById(R.id.log_in);
        linkregistrar = (TextView) findViewById(R.id.link_register);

     //   btnentrar.setOnClickListener(this);
        linkregistrar.setOnClickListener(this);
        dao=new daoUsuario(this);

       btnentrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 String u=user.getText().toString();
                String p =pass.getText().toString();
                if (u.equals("")&&p.equals("")){
                    //Toast.makeText(this,"ERROR: Campos vacios",Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    //Toast.makeText(this,"Datos Correctos",Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(Login.this,InicioUsuario.class);
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                }

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.link_register:
                Intent miIntent = new Intent(Login.this,Registar.class);
                startActivity(miIntent);
                break;
           /* case R.id.btnentrar:
                String u=user.getText().toString();
                String p =pass.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this,"ERROR: Campos vacios",Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this,"Datos Correctos",Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(Login.this,InicioUsuario.class);
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                }


               break;*/
        }

    }
}