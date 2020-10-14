package com.example.ejemplocheckbox2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;

    TextView textHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metodocheck();
    }
    //evento directo sobre el Checkbox
    public void metodocheck() {
        chkBoxCycling = (CheckBox) findViewById(R.id.checkboxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.checkboxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.checkboxBlogging);

        TextView textHobby = (TextView) findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
    }
        class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView == chkBoxCycling) {
                        showTextNotification("Cycling");
                    }
                    if (buttonView == chkBoxTeaching) {
                        showTextNotification("Teaching");
                    }
                    if (buttonView == chkBoxBlogging) {
                        showTextNotification("Blogging");
                    }

                }


            }

        }//clase interna

    public void showTextNotification(String msgToDisplay){
      //textHobby.setText(msgToDisplay);
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }

}