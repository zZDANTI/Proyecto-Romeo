package com.example.myapplication.Repositorios;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.BaseDatos.BaseDatos;
import com.example.myapplication.Daos.ReservasDao;
import com.example.myapplication.Entity.Reservas;

import java.util.List;

public class ReservasRepositorio {

    public final LiveData<List<Reservas>> listadoReservas;
    public final ReservasDao reservasDao;

    //CONSTRUCTOR

    public ReservasRepositorio(Context context) {
        BaseDatos baseDatos = BaseDatos.getInstance(context);
        reservasDao = baseDatos.reservasDao();
        listadoReservas = reservasDao.todasReservas();
    }

    //GETTER

    public LiveData<List<Reservas>> listadoReservas() {
        return listadoReservas;
    }

    public ReservasDao getReservasDao() {
        return reservasDao;
    }

    //METODOS

    public LiveData<List<Reservas>> reservasCliente(String idEmail) {
        return reservasDao.reservasCliente(idEmail);
    }

}
