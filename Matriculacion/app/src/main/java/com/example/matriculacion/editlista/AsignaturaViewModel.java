package com.example.matriculacion.editlista;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.matriculacion.data.ListRepository;
import com.example.matriculacion.data.ListaAsignatura;

import java.util.List;

public class AsignaturaViewModel extends AndroidViewModel {
    private final ListRepository mRepository;
    private final LiveData<List<ListaAsignatura>> mListaAsignaturas;


    public AsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ListRepository(application);
        mListaAsignaturas = mRepository.getAllListaAsignaturas();
    }

    public LiveData<List<ListaAsignatura>> getListaAsignaturas(){

        return mListaAsignaturas;
    }

    public void insert(ListaAsignatura listaAsignatura){
        mRepository.insertAsignatura(listaAsignatura);
    }
}
