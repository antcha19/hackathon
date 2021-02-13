package com.example.matriculacion.add;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.matriculacion.R;
import com.example.matriculacion.data.ListaAlumno;
import com.example.matriculacion.editlista.AlumnoViewModel;

public class AnadirAlumno extends AppCompatActivity {

    private AlumnoViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_alumno);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        mViewModel = new  ViewModelProvider(this, factory).get(AlumnoViewModel.class);

        setupCreateButton(mViewModel);

    }

    private void setupCreateButton(AlumnoViewModel mViewModel) {
        findViewById(R.id.Añadir).setOnClickListener(
                view -> {
                    // Obtener valor del campo de texto
                    EditText dnifield =  findViewById(R.id.dni);
                    EditText nombrefield = findViewById(R.id.nombre);
                    EditText apellidosfield = findViewById(R.id.apellidos);
                    String dni = dnifield.getText().toString();
                    String nombre = nombrefield.getText().toString();
                    String apellidos = apellidosfield.getText().toString();

                    // Ignorar acción si hay 0 caractere

                    ListaAlumno alumno = new ListaAlumno(dni,nombre,apellidos);
                    mViewModel.insertAlumno(alumno);

                    // Ir a la lista
                    finish();
                });
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}