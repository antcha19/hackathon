package com.example.matriculacion.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ListaAsignatura.class}, version = 1, exportSchema = false)

public  abstract class ListaAsignaturaDatabase extends RoomDatabase {

    // Exposición de DAOs
  //  public abstract ListaAsignaturaDao listaAsignaturaDao;
    public abstract ListaAsignaturaDao listaAsignaturaDao();

    private static final String DATABASE_NAME = "lista-asignatura-db";

    private static ListaAsignaturaDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static ListaAsignaturaDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ListaAsignaturaDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), ListaAsignaturaDatabase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Prepoblar base de datos con callback
    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                ListaAsignaturaDao dao = INSTANCE.listaAsignaturaDao();

                ListaAsignatura list1 = new ListaAsignatura("1", "Lidgd ejemplo");
                dao.insert(list1);

            });
        }
    };

}
