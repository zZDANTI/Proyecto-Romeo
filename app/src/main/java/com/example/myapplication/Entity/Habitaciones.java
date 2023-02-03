package com.example.myapplication.Entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habitaciones")
public class Habitaciones {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name ="id")
    public int id;
    @ColumnInfo(name ="nombre")
    public String nombre;

    @ColumnInfo(name ="numPersonas")
    public int numPersonas;

    @ColumnInfo(name ="descrip")
    public String descrip;

    @ColumnInfo(name ="precio")
    public double precio;

    @ColumnInfo(name ="imagen")
    public int imagen;


    //CONSTRUCTOR


    public Habitaciones(int id, String nombre, int numPersonas, String descrip, double precio, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.numPersonas = numPersonas;
        this.descrip = descrip;
        this.precio = precio;
        this.imagen = imagen;

    }

    //GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
