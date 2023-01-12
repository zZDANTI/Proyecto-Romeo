package com.example.myapplication.basedatos;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "usuario")
public class Usuario {

    @NonNull
    @PrimaryKey
    public String id;

    public String nombre;


    public Usuario(@NonNull String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
