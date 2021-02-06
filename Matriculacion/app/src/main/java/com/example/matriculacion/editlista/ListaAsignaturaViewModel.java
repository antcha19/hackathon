package com.example.matriculacion.editlista;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.matriculacion.data.ListaAsignatura;
import com.example.matriculacion.data.ListaAsignaturaRepository;

import java.util.List;

public class ListaAsignaturaViewModel extends AndroidViewModel {
    private final ListaAsignaturaRepository mRepositoryAsig;
    private final LiveData<List<ListaAsignatura>> mListaAsignaturas;


    public ListaAsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepositoryAsig = new ListaAsignaturaRepository(application);
        mListaAsignaturas = mRepositoryAsig.getAllListaAsignaturas();
    }

    public LiveData<List<ListaAsignatura>> getListaAsignaturas(){
        return mListaAsignaturas;
    }

    public void insert(ListaAsignatura listaAsignatura){
        mRepositoryAsig.insert(listaAsignatura);
    }
}
