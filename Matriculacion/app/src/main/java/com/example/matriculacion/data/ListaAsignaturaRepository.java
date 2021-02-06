package com.example.matriculacion.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ListaAsignaturaRepository {
    private final LiveData<List<ListaAsignatura>> mListaAsignaturas;
    private final ListaAsignaturaDao mListaAsignaturaDao;

    public ListaAsignaturaRepository(Context context) {
        ListaAsignaturaDatabase db = ListaAsignaturaDatabase.getInstance(context);
        mListaAsignaturaDao = db.listaAsignaturaDao();
        mListaAsignaturas = mListaAsignaturaDao.getAll();
    }

    public LiveData<List<ListaAsignatura>> getAllListaAsignaturas() {
        return mListaAsignaturas;
    }

    public void insert(ListaAsignatura listaAsignatura) {
        ListaAsignaturaDatabase.dbExecutor.execute(
                () -> mListaAsignaturaDao.insert(listaAsignatura)
        );
    }
}
