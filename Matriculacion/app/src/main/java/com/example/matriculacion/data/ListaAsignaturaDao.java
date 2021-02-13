package com.example.matriculacion.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ListaAsignaturaDao {
    @Query("SELECT * FROM lista_asignatura")
    LiveData<List<ListaAsignatura>> getAll();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ListaAsignatura listaAsignatura);

    @Delete(entity = ListaAsignatura.class)
    void deleteAsignatura(ListaAsignatura listaAsignatura);

    //borrar toda la lista
    @Query("DELETE FROM lista_asignatura")
    void deleteAllShoppingLists();
}
