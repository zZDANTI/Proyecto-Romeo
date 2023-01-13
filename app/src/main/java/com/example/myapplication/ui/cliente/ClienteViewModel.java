package com.example.myapplication.ui.cliente;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.basedatos.Cliente;
import com.example.myapplication.repositorios.ClientesRepositorio;

import java.io.Closeable;
import java.util.List;

public class ClienteViewModel extends AndroidViewModel {



    public final ClientesRepositorio clientesRepositorio;
    public final LiveData<List<Cliente>> listadoCliente;

    public ClienteViewModel(@NonNull Application application) {
        super(application);
        clientesRepositorio = new ClientesRepositorio(application);
        listadoCliente = clientesRepositorio.getListadoCliente();
    }
    public LiveData<List<Cliente>> getOcioListado(){
        return listadoCliente;
    }
    public  void insert(Cliente objetoCliente){
        clientesRepositorio.insert(objetoCliente);
    }


}

