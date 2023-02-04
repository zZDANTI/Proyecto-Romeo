package com.example.myapplication.ventanas.habitaciones;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.Repositorios.HabitacionesRepositorios;
import com.example.myapplication.Repositorios.ReservasRepositorio;

import java.util.List;


public class HabitacionesViewModel extends AndroidViewModel {

    public final HabitacionesRepositorios habitacionesRepositorios;
    public final LiveData<List<Habitaciones>> listadoHabitaciones;



    public HabitacionesViewModel(@NonNull Application application) {
        super(application);
        habitacionesRepositorios = new HabitacionesRepositorios(application);
        listadoHabitaciones = habitacionesRepositorios.getListadoHabitaciones();
    }

    //METODOS

    public LiveData<List<Habitaciones>> listadoHabitaciones(){
        return habitacionesRepositorios.getListadoHabitaciones();
    }




}