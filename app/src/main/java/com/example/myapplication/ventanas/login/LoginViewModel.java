package com.example.myapplication.ventanas.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.Repositorios.ClientesRepositorio;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {

    public final ClientesRepositorio clientesRepositorio;
    public final LiveData<List<Cliente>> listadoCliente;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        clientesRepositorio = new ClientesRepositorio(application);
        listadoCliente = clientesRepositorio.getListadoCliente();
    }

    //Valida si un usuario esta registrado para poder loguearse
    public LiveData<Cliente> validarUsuario(String email){
        return clientesRepositorio.validarUsuario(email);
    }


}