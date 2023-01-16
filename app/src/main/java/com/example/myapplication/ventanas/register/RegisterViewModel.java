package com.example.myapplication.ventanas.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.Repositorios.ClientesRepositorio;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {
    public final ClientesRepositorio clientesRepositorio;
    public final LiveData<List<Cliente>> listadoCliente;


    public RegisterViewModel(@NonNull Application application) {
        super(application);
        clientesRepositorio = new ClientesRepositorio(application);
        listadoCliente = clientesRepositorio.getListadoCliente();
    }


    //Inserta un cliente a la base de datos
    public  void insertarCliente(Cliente cliente){
        clientesRepositorio.insertarCliente(cliente);
    }
}