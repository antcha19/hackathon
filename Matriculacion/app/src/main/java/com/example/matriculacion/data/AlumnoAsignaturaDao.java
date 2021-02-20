package com.example.matriculacion.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlumnoAsignaturaDao {

    @Query("SELECT * FROM alumnoasignatura")
    LiveData<List<AlumnoAsignatura>> getALL();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AlumnoAsignatura alumnoAsignatura);


}
