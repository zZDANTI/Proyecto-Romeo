package com.example.myapplication.ventanas.habitaciones;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.Repositorios.ReservasRepositorio;

import java.util.List;


public class HabitacionesViewModel extends AndroidViewModel {

    public final ReservasRepositorio reservasRepositorio;
    public final LiveData<List<Reservas>> listadoReservas;


    public HabitacionesViewModel(@NonNull Application application) {
        super(application);
        reservasRepositorio = new ReservasRepositorio(application);
        listadoReservas = reservasRepositorio.listadoReservas();
    }

    //METODOS

    public LiveData<List<Reservas>> listadoReservas(){
        return reservasRepositorio.listadoReservas;
    }




}