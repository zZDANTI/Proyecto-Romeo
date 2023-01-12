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

    /*

    public final ClientesRepositorio clientesRepositorio;
    public final LiveData<List<Cliente>> listadoCliente;

    public ClienteViewModel(@NonNull Application application) {
        super(application);
        ClientesRepositorio = new ClientesRepositorio(application);
        listadoCliente = ger();
    }
    public LiveData<List<Ocio>> getOcioListado(){
        return ocioListado;
    }
    public  void insert(Ocio objetoOcio){
        ocioRepository.insert(objetoOcio);
    }

     */
}

