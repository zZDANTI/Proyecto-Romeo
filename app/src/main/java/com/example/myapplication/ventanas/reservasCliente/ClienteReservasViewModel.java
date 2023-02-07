package com.example.myapplication.ventanas.reservasCliente;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.Repositorios.ReservasRepositorio;

import java.util.List;

public class ClienteReservasViewModel extends AndroidViewModel {

    public final ReservasRepositorio reservasRepositorio;
    public final LiveData<List<Reservas>> listadoReserva;


    public ClienteReservasViewModel(@NonNull Application application) {
        super(application);
        reservasRepositorio = new ReservasRepositorio(application);
        listadoReserva = reservasRepositorio.listadoReservas;
    }


    public LiveData<List<Reservas>> reservasTotalUsuarios(String idEmail) {
        return reservasRepositorio.reservasTotalUsuarios(idEmail);
    }
}
