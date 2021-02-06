package com.example.matriculacion.editlista;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.matriculacion.data.Lista_asignatura;
import com.example.matriculacion.data.Lista_asignaturaRepository;

import java.util.List;

public class Lista_asignaturaViewModel extends AndroidViewModel {

    private final Lista_asignaturaRepository mRepository;

    private final LiveData<List<Lista_asignatura>> mlista_asignaturas;

    public Lista_asignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Lista_asignaturaRepository(application);
        mlista_asignaturas = mRepository.getAllLista_asignaturas();
    }
    public  LiveData<List<Lista_asignatura>> getMlista_asignaturas(){
        return mlista_asignaturas;
    }

    public void insert(Lista_asignatura lista_asignatura){
        mRepository.insert(lista_asignatura);
    }
}
