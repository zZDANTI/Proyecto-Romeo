package com.example.myapplication.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "cliente")
public class Cliente implements Serializable {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name ="id")
    public String id;


    @ColumnInfo(name ="Nombre")
    public String nombre;


    public Cliente(@NonNull String id, String nombre) {
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