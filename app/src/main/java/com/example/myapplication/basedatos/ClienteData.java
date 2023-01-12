package com.example.myapplication.basedatos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class}, version = 1)
public abstract class ClienteData extends RoomDatabase {
    public abstract ClientesDao clientesDao();
}

