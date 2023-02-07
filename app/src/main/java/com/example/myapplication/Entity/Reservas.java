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
},primaryKeys = {"fechaEntrada","fechaSalida","idHabitacion","idEmail"})

public class Reservas {

    @NonNull
    @ColumnInfo(name = "fechaEntrada")
    String fechaEntrada;

    @NonNull
    @ColumnInfo(name = "fechaSalida")
    String fechaSalida;
    @NonNull
    @ColumnInfo(name = "idHabitacion")
    int idHabitacion;
    @NonNull
    @ColumnInfo(name = "idEmail")
    String idEmail;

    //CONSTRUCTOR

    public Reservas( String fechaEntrada, String fechaSalida, int idHabitacion, String idEmail) {

        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
        this.idEmail = idEmail;
    }


    //GETTER Y SETTERS


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

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }
}