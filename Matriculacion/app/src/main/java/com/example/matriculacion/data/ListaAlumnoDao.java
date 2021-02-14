package com.example.matriculacion.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ListaAlumnoDao {

    @Query("SELECT * FROM lista_alumno")
    LiveData<List<ListaAlumno>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ListaAlumno listaAlumno);

    //borrar
    @Delete(entity = ListaAlumno.class)
    void delete(ListaAlumno listaAlumno);
}
