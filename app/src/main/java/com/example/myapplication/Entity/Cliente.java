package com.example.myapplication.Entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cliente")
public class Cliente {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name ="email")
    String email;

    @ColumnInfo(name ="nombre")
    String nombre;

    @ColumnInfo(name ="apellidos")
    String apellidos;

    @NonNull
    @ColumnInfo(name ="password")
    String password;


    //CONSTRUCTOR


    public Cliente(@NonNull String email, String nombre, String apellidos, @NonNull String password) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
    }


    //GETTER Y SETTERS


    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getId() {
        return email;
    }

    public void setId(@NonNull String id) {
        this.email = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}