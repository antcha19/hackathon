package com.example.matriculacion.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ListRepository {
    private final LiveData<List<ListaAsignatura>> mListaAsignaturas;
    private final LiveData<List<ListaAlumno>> mListaAlumnos;

    private final ListaAsignaturaDao mListaAsignaturaDao;
    private final ListaAlumnoDao mListaAlumnoDao;

    public ListRepository(Context context) {
        ListDataBase db = ListDataBase.getInstance(context);
        mListaAsignaturaDao = db.listaAsignaturaDao();
        mListaAlumnoDao =db.listaAlumnoDao();

        mListaAsignaturas = mListaAsignaturaDao.getAll();
       mListaAlumnos = mListaAlumnoDao.getAll();
    }

    public LiveData<List<ListaAsignatura>> getAllListaAsignaturas() {

        return mListaAsignaturas;
    }
    public LiveData<List<ListaAlumno>> getAllListaAlumnos() {

        return mListaAlumnos;
    }


    public void insertAsignatura(ListaAsignatura listaAsignatura) {
        ListDataBase.dbExecutor.execute(
                () -> mListaAsignaturaDao.insert(listaAsignatura)
        );
    }

    public void insertAlumno(ListaAlumno listaAlumno){
        ListDataBase.dbExecutor.execute(()-> mListaAlumnoDao.insert(listaAlumno));
    }

    //funcion para borrar
    public  void borrarAsignatura(ListaAsignatura listaAsignatura){
        ListDataBase.dbExecutor.execute(()->mListaAsignaturaDao.deleteAsignatura(listaAsignatura));
    }
    public void borrarAlumno(ListaAlumno listaAlumno){
        ListDataBase.dbExecutor.execute(()-> mListaAlumnoDao.delete(listaAlumno));
    }

    public void actualizarAlumno(ListaAlumno listaAlumno){
        ListDataBase.dbExecutor.execute(()->mListaAlumnoDao.update(listaAlumno));
    }
    public void actualizarAsignatura(ListaAsignatura listaAsignatura){
        ListDataBase.dbExecutor.execute(()->mListaAsignaturaDao.updateAsignaturaDao(listaAsignatura));
    }

}
