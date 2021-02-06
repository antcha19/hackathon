package com.example.matriculacion.data;

import android.content.Context;

import androidx.room.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Lista_asignatura.class}, version = 1,exportSchema = false)
public abstract class Lista_asignaturaDatabase  extends RoomDatabase{

    //Exposicion de DAOs
    public abstract Lista_asignaturaDao lista_asignaturaDao();
    private static final String DATABASE_NAME ="lista-asignatura-db";
    private static Lista_asignaturaDatabase INSTANCE;
    private static final int THREADS = 4;
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static Lista_asignaturaDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (Lista_asignaturaDatabase.class){
                if(INSTANCE ==null){
                    INSTANCE= Room.databaseBuilder(
                            context.getApplicationContext(), Lista_asignaturaDatabase.class,
                            DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
