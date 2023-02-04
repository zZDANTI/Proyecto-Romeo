package com.example.myapplication.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservas",foreignKeys = {
        @ForeignKey(
                entity = Cliente.class,
                parentColumns = "email",
                childColumns = "idEmail"
        ),
        @ForeignKey(
                entity = Habitaciones.class,
                parentColumns = "id",
                childColumns = "idHabitacion"
        )
})
public class Reservas {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "fechaEntrada")
    public String fechaEntrada;

    @ColumnInfo(name = "fechaSalida")
    public String fechaSalida;

    @ColumnInfo(name = "idHabitacion")
    public int idHabitacion;

    @ColumnInfo(name = "idEmail")
    public int idEmail;

    @ColumnInfo(name = "observaciones")
    public String observaciones;

    @ColumnInfo(name = "precio")
    public String precio;

    //CONSTRUCTOR

    public Reservas(int id, String fechaEntrada, String fechaSalida, int idHabitacion, int idEmail, String observaciones, String precio) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
        this.idEmail = idEmail;
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

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idCliente) {
        this.idEmail = idCliente;
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