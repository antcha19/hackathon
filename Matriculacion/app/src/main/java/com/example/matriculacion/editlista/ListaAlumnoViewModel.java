package com.example.matriculacion.editlista;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.matriculacion.data.ListaAlumno;
import com.example.matriculacion.data.ListaAlumnoRepository;

import java.util.List;

public class ListaAlumnoViewModel  extends AndroidViewModel{

    private final ListaAlumnoRepository mRepository;

    private final LiveData<List<ListaAlumno>> mListaAlumnos;

    public ListaAlumnoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ListaAlumnoRepository(application);
        mListaAlumnos = mRepository.getAllListaALumnos();
    }

    public LiveData<List<ListaAlumno>> getListaAlumnos() {
        return mListaAlumnos;
    }

    public void insert(ListaAlumno listaAlumno) {
        mRepository.insert(listaAlumno);
    }
}
