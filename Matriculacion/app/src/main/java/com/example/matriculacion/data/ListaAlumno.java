package com.example.matriculacion.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lista_alumno")
public class ListaAlumno {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final String mId;

    @NonNull
    @ColumnInfo(name = "name")
    private final String mName;
    @NonNull
    @ColumnInfo(name = "apellidos")
    String mApellidos;


    public ListaAlumno(@NonNull String id, @NonNull String name, @NonNull String apellidos) {
        mId = id;
        mName = name;
        mApellidos=apellidos;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getApellidos(){
        return mApellidos;
    }
}
