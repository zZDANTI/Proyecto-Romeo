package com.example.myapplication.ventanas.reservas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.Repositorios.HabitacionesRepositorios;
import com.example.myapplication.Repositorios.ReservasRepositorio;

import java.util.List;

public class ReservasViewModel extends AndroidViewModel {

    public final ReservasRepositorio reservasRepositorio;
    public final LiveData<List<Reservas>> listadoReserva;


    public ReservasViewModel(@NonNull Application application) {
        super(application);
        reservasRepositorio = new ReservasRepositorio(application);
        listadoReserva = reservasRepositorio.listadoReservas;
    }

    public  void insertarReserva(Reservas reservas){
        reservasRepositorio.insertarReserva(reservas);
    }

    public LiveData<List<Reservas>> todasReservas(){
       return reservasRepositorio.todasReservas();
    }
}