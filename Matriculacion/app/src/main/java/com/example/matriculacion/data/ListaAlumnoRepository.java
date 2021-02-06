package com.example.matriculacion.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ListaAlumnoRepository {
    private final LiveData<List<ListaAlumno>> mListaAlumnos;
    private final ListaAlumnoDao mListaAlumnoDao;

    public ListaAlumnoRepository(Context context) {
        ListaAlumnoDatabase db = ListaAlumnoDatabase.getInstance(context);
        mListaAlumnoDao = db.listaAlumnoDao();
        mListaAlumnos = mListaAlumnoDao.getAll();
    }

    public LiveData<List<ListaAlumno>> getAllListaALumnos() {
        return mListaAlumnos;
    }

    public void insert(ListaAlumno listaAlumno) {
        ListaAlumnoDatabase.dbExecutor.execute(
                () -> mListaAlumnoDao.insert(listaAlumno)
        );
    }


}
