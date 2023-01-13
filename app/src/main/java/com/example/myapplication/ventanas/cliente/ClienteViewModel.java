package com.example.myapplication.ventanas.cliente;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.entity.Cliente;
import com.example.myapplication.repositorios.ClientesRepositorio;

import java.util.List;

public class ClienteViewModel extends AndroidViewModel {



    public final ClientesRepositorio clientesRepositorio;
    public final LiveData<List<Cliente>> listadoCliente;

    public ClienteViewModel(@NonNull Application application) {
        super(application);
        clientesRepositorio = new ClientesRepositorio(application);
        listadoCliente = clientesRepositorio.getListadoCliente();
    }
    public LiveData<List<Cliente>> getListadoCliente(){
        return listadoCliente;
    }
    public LiveData<Cliente> getOneCliente(String mId){
        return clientesRepositorio.getOneCliente(mId);
    }
    public  void insert(Cliente objetoCliente){
        clientesRepositorio.insert(objetoCliente);
    }


}
