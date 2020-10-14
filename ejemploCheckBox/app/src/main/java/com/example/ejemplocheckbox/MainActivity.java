package com.example.ejemplocheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox Cycling;
    CheckBox Teaching;
    CheckBox Blogging;
    Button ButtonHobby;
    TextView TextHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metodocheckbox();
    }

    public void metodocheckbox(){

        Cycling = (CheckBox) findViewById(R.id.checkboxCycling);
        Teaching = (CheckBox) findViewById(R.id.checkboxTeaching);
        Blogging = (CheckBox) findViewById(R.id.checkboxBlogging);
        ButtonHobby = (Button)findViewById(R.id.botonHobby);
        TextHobby = (TextView)findViewById(R.id.txtHobby);

        ButtonHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metodogetHObbyClick(v);
            }
        });

    }
    //funciona cuando pulsamos el boton
    public void metodogetHObbyClick(View v){
        String strMessage=" ";
        if(Cycling.isChecked()){
            strMessage+="Cycling ";
        }
        if(Teaching.isChecked()){
            strMessage+="Teaching ";
        }
        if(Blogging.isChecked()){
            strMessage+="Blogging ";
        }
        showTextNotification(strMessage);
    }
    public void showTextNotification(String msgToDisplay)
    {
        TextHobby.setText(msgToDisplay);
        //Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }



}