package com.example.myapplication.Repositorios;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.BaseDatos.BaseDatos;
import com.example.myapplication.Daos.HabitacionDao;
import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.Entity.Reservas;

import java.util.List;

public class HabitacionesRepositorios {

    public final LiveData<List<Habitaciones>> listadoHabitaciones;
    public final HabitacionDao habitacionDao;

    //CONSTRUCTOR

    public HabitacionesRepositorios(Context context) {
        BaseDatos baseDatos = BaseDatos.getInstance(context);
        habitacionDao = baseDatos.habitacionDao();
        listadoHabitaciones = habitacionDao.todasHabitaciones();
    }

    //GETTER Y SETTERS

    public LiveData<List<Habitaciones>> getListadoHabitaciones() {
        return listadoHabitaciones;
    }

    public HabitacionDao getHabitacionDao() {
        return habitacionDao;
    }

    //METODOS

    public void insertarHabitaciones(Habitaciones habitaciones){
        BaseDatos.dbExecutor.execute(
                ()-> habitacionDao.insertarHabitaciones(habitaciones)
        );
    }
}
