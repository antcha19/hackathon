package com.example.matriculacion.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ListaAlumno.class}, version = 1, exportSchema = false)
public abstract class ListaAlumnoDatabase extends RoomDatabase {

    public abstract ListaAlumnoDao listaAlumnoDao();

    private static final String DATABASE_NAME = "lista-alumno-db";

    private static ListaAlumnoDatabase INSTANCE;
    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static ListaAlumnoDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ListaAlumnoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), ListaAlumnoDatabase.class,
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
                ListaAlumnoDao dao = INSTANCE.listaAlumnoDao();

                ListaAlumno list1 = new ListaAlumno("12323", "Antonio");

                dao.insert(list1);

            });
        }
    };
}
