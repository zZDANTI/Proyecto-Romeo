package com.example.myapplication.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservas")
public class Reservas {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "fechaEntrada")
    public String fechaEntrada;

    @ColumnInfo(name = "fechaSalida")
    public String fechaSalida;

    @ColumnInfo(name = "clienteEmail")
    public String clienteEmail;

    @ColumnInfo(name = "habitacionId")
    public int habitacionId;

    @ColumnInfo(name = "observaciones")
    public String observaciones;

    @ColumnInfo(name = "precio")
    public String precio;

    //CONSTRUCTOR

    public Reservas(int id, String fechaEntrada, String fechaSalida, String clienteEmail, int habitacionId, String observaciones, String precio) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.clienteEmail = clienteEmail;
        this.habitacionId = habitacionId;
        this.observaciones = observaciones;
        this.precio = precio;
    }

    //GETTER Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}