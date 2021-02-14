package com.example.matriculacion.add;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matriculacion.R;
import com.example.matriculacion.data.ListaAsignatura;
import com.example.matriculacion.editlista.AsignaturaViewModel;
import com.example.matriculacion.editlista.ListAdapterAsig;

public class AnadirAsignatura extends AppCompatActivity {
    private AsignaturaViewModel mViewModelAsig;
    private ListAdapterAsig adaptersig;
    private RecyclerView recylistaasignatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_asignatura);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ViewModelProvider.AndroidViewModelFactory factory=
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        //llamo a la clase
        mViewModelAsig =  new ViewModelProvider(this, factory).get(AsignaturaViewModel.class);

        anadirasignatura(mViewModelAsig);
        //funcion para borrar pero peta
      //  setuplist();

    }



    private void anadirasignatura(AsignaturaViewModel mViewModelAsig) {
        findViewById(R.id.AñadirAsignatura).setOnClickListener(
                view -> {
                    // Obtener valor del campo de texto
                    EditText codigotext =  findViewById(R.id.codigo);
                    EditText asignatura = findViewById(R.id.asignatura);

                    String Codido = codigotext.getText().toString();
                    String Asignatura = asignatura.getText().toString();


                    // Ignorar acción si hay 0 caractere

                    ListaAsignatura insertAsignatura = new ListaAsignatura(Codido,Asignatura);
                    mViewModelAsig.insert(insertAsignatura);

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