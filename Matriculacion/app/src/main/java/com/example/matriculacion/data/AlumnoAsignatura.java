package com.example.matriculacion.data;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "alumnoasignatura", primaryKeys = {"dnialumno","idasignatura"})
public class AlumnoAsignatura {
    @NonNull
    @ColumnInfo(name = "dnialumno")
    String dnialumno;

    @NonNull
    @ColumnInfo(name = "idasignatura")
    int idasignatura;

    @NonNull
    @ColumnInfo(name = "nameasignatura")
    String nameasignatura;

    public AlumnoAsignatura(@NonNull String dnialumno, int idasignatura, String nameasignatura) {
        this.dnialumno = dnialumno;
        this.idasignatura = idasignatura;
        this.nameasignatura = nameasignatura;
    }

    @NonNull
    public String getDni_alumno() {
        return dnialumno;
    }

    @NonNull
    public int getId_asignatura() {
        return idasignatura;
    }

    @NonNull
    public String getName_asignatura() {
        return nameasignatura;
    }
}