package com.example.matriculacion.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Lista_asignaturaRepository {

    private final LiveData<List<Lista_asignatura>> mLista_asignaturas;
    private final Lista_asignaturaDao mLista_asignaturaDao;

    public Lista_asignaturaRepository(Context context){
        Lista_asignaturaDatabase db = Lista_asignaturaDatabase.getInstance(context);
        mLista_asignaturaDao=db.lista_asignaturaDao();
        mLista_asignaturas=mLista_asignaturaDao.getAll();
    }
    //posible error
    public LiveData<List<Lista_asignatura>> getAllLista_asignaturas(){
        return mLista_asignaturas;
    }

    public void insert(Lista_asignatura lista_asignatura){
        Lista_asignaturaDatabase.dbExecutor.execute(
                ()-> mLista_asignaturaDao.insert(lista_asignatura)
        );
    }
}
