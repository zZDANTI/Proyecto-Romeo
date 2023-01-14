package com.example.myapplication.BaseDatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.myapplication.Daos.ClientesDao;
import com.example.myapplication.Entity.Cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Faltan clases

@Database(entities = {Cliente.class}, version = 1)
public abstract class BaseDatos extends RoomDatabase {

    //Exposición de los DAOs: Se crea un método get*() abstracto por cada DAO que tengamos
    //Todos los dao
    public abstract ClientesDao clientesDao();

    private static final String DATABASE_NAME = "hotel_db";

    //Patrón SINGLETON: Para tener una única instancia abierta
    private static BaseDatos INSTANCE;
    private static final int THREADS = 4;

    // Declaramos un ExecutorService para ejecutar operaciones de bases de datos en otros hilos de trabajo
    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    //Patrón SINGLETON
    public static BaseDatos getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (BaseDatos.class){
                if(INSTANCE == null){
                    //Creamos la base de datos
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BaseDatos.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

    /*


    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                ClientesDao dao = INSTANCE.clientesDao();

                Cliente list1 = new Cliente("1", "Manuel");
                Cliente list2 = new Cliente("2", "Jorge");

                dao.insert(list1);
                dao.insert(list2);
            });
        }
    };

     */
}
