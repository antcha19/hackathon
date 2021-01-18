package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ShoppingListViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dbText = findViewById(R.id.db_text);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(ShoppingListViewModel.class);

        mViewModel.getShoppingLists().observe(this, shoppingLists -> {
                    StringBuilder sb = new StringBuilder();
                    for (ShoppingList list : shoppingLists) {
                        sb.append(list.getName()).append("\n");
                    }
                    dbText.setText(sb.toString());
                }
        );

    }
}



 /*
        pasos
        1-creo el proyecto , emptyactivity
        2-añadir dependencias build.gradle del module
        2.1-añadir dependencias build.gradle del proyecto
        3-crear una entidad
            clik derecho mainactivity new class
        4-creo el DAO de clase interface
        5-crear la base de datos
        6- creo el repositorio
        7-crear viewmode
        * */