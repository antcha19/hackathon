package com.example.matriculacion.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lista_asignatura")
public class Lista_asignatura {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final String id ="";

    @NonNull
    @ColumnInfo(name = "name")
    private final String name ="";

    public Lista_asignatura(@NonNull String id, @NonNull String name) {
        id = id;
        name = name;
    }


    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }
}
