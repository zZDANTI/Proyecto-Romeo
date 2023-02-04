package com.example.myapplication.ventanas.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.Repositorios.ClientesRepositorio;
import com.example.myapplication.Repositorios.ReservasRepositorio;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    public final ReservasRepositorio reservasRepositorio;
    public final LiveData<List<Reservas>> listadoReserva;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        reservasRepositorio = new ReservasRepositorio(application);
        listadoReserva = reservasRepositorio.listadoReservas;
    }

    //Coge la reserva que tenga un usuario
    public LiveData<List<Reservas>> reservasUsuario(){
        return reservasRepositorio.listadoReservas;
    }
}