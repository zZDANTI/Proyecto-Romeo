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
    String idHabitacion;

    @ColumnInfo(name = "idEmail")
    String idEmail;

    //CONSTRUCTOR

    public Reservas(int id, String fechaEntrada, String fechaSalida, String idHabitacion, String idEmail) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
        this.idEmail = idEmail;
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

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }
}