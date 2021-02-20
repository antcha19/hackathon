package com.example.matriculacion.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {ListaAsignatura.class,ListaAlumno.class,AlumnoAsignatura.class}, version = 1, exportSchema = false)

public  abstract class ListDataBase extends RoomDatabase {

    // Exposición de DAOs
    //  public abstract ListaAsignaturaDao listaAsignaturaDao;
    public abstract ListaAsignaturaDao listaAsignaturaDao();
    public abstract ListaAlumnoDao listaAlumnoDao();
    public abstract AlumnoAsignaturaDao alumnoAsignaturaDao();

    private static final String DATABASE_NAME = "lista-db11";

    private static ListDataBase INSTANCE;


    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static ListDataBase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ListDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), ListDataBase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .fallbackToDestructiveMigration()
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

                ListaAsignatura list1 = new ListaAsignatura("1", "matematicas");
                dao.insert(list1);

                ListaAlumnoDao daoAlumno= INSTANCE.listaAlumnoDao();

                ListaAlumno alumno1 = new ListaAlumno("3434fs","Antonio ","Yepez");
                ListaAlumno alumno2= new ListaAlumno("3434fs","Antondfgdfio ","Yepedfgdfz");
                daoAlumno.insert(alumno1);
                daoAlumno.insert(alumno2);

            });
        }
    };

}
