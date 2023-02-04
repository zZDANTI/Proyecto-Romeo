package com.example.myapplication.Repositorios;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.BaseDatos.BaseDatos;
import com.example.myapplication.Daos.ReservasDao;
import com.example.myapplication.Entity.Cliente;
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

    //SE USA EN EL HOME PARA SABER EL DIA QUE TIENE RESERVADO EL CLIENTE
    public LiveData<List<Reservas>> reservasUsuario(String idEmail) {
        return reservasDao.reservasUsuario(idEmail);
    }

    //SE USA PARA INSERTAR UNA RESERVA DEL CLIENTE
    public void insertarReserva(Reservas reservas){
        BaseDatos.dbExecutor.execute(
                ()-> reservasDao.insertarReserva(reservas)
        );
    }

}
