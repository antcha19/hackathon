package com.example.matriculacion.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "lista_asignatura")
public class ListaAsignatura {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "codigo")
    private final String mCodigo;

    @NonNull
    @ColumnInfo(name = "nombre")
    private final String mNombre;


    public ListaAsignatura(@NonNull String codigo, @NonNull String nombre) {
        mCodigo = codigo;
        mNombre = nombre;
    }

    @NonNull
    public String getCodigo() {
        return mCodigo;
    }

    @NonNull
    public String getNombre() {
        return mNombre;
    }
}
