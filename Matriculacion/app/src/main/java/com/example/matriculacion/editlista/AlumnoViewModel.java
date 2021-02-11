package com.example.matriculacion.editlista;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.matriculacion.data.ListRepository;
import com.example.matriculacion.data.ListaAlumno;

import java.util.List;

public class AlumnoViewModel extends AndroidViewModel {

    private final ListRepository listaRepository;

    private final LiveData<List<ListaAlumno>> mlistaALumnos;

    public AlumnoViewModel(@NonNull Application application) {
        super(application);
        listaRepository  = new ListRepository(application);
        mlistaALumnos = listaRepository.getAllListaAlumnos();
    }
    public LiveData<List<ListaAlumno>> getListaAlumnos(){
        return mlistaALumnos;
    }
    public void insertAlumno(ListaAlumno listaAlumno){
        listaRepository.insertAlumno(listaAlumno);
    }
}
