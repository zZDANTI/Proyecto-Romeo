package com.example.myapplication.ventanas.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.BaseDatos.BaseDatos;
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

    //SE USA EN EL HOME PARA SABER EL DIA QUE TIENE RESERVADO EL CLIENTE
    public LiveData<List<Reservas>> reservasUsuario(String idEmail){
        return reservasRepositorio.reservasUsuario(idEmail);
    }

    public  void insertarReserva(Reservas reservas){
        reservasRepositorio.insertarReserva(reservas);
    }

}