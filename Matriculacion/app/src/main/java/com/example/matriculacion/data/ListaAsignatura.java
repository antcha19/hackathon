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
    private  String mCodigo;

    @NonNull
    @ColumnInfo(name = "nombre")
    private  String mNombre;


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

    public void setmCodigo(@NonNull String mCodigo) {
        this.mCodigo = mCodigo;
    }

    public void setmNombre(@NonNull String mNombre) {
        this.mNombre = mNombre;
    }
}
