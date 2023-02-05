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
    int id;

    @ColumnInfo(name = "fechaEntrada")
    String fechaEntrada;

    @ColumnInfo(name = "fechaSalida")
    String fechaSalida;

    @ColumnInfo(name = "idHabitacion")
    int idHabitacion;

    @ColumnInfo(name = "idEmail")
    String idEmail;

    //CONSTRUCTOR

    public Reservas(String fechaEntrada, String fechaSalida,int idHabitacion, String idEmail) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idEmail = idEmail;
        this.idHabitacion=idHabitacion;
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

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }
}