package com.example.matriculacion.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Lista_asignaturaDao {

    @Query("SELECT * FROM  lista_asignatura")
    LiveData<List<Lista_asignatura>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //posible error en lista_asignatura
    void insert(Lista_asignatura lista_asignatura);
}

