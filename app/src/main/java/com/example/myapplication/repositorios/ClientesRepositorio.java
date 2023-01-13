package com.example.myapplication.repositorios;

import static android.os.AsyncTask.execute;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.basedatos.BaseDatos;
import com.example.myapplication.basedatos.Cliente;
import com.example.myapplication.basedatos.ClientesDao;

import java.util.List;

public class ClientesRepositorio {

    //Crear uno para cada uno

   public final LiveData<List<Cliente>> listadoCliente;
   public final ClientesDao clientesDao;

    public ClientesRepositorio(Context context) {
        BaseDatos baseDatos = BaseDatos.getInstance(context);
        clientesDao = baseDatos.clientesDao();
        listadoCliente = clientesDao.obtenerClientes();
    }


    //GETTERS
    public LiveData<List<Cliente>> getListadoCliente() {
        return listadoCliente;
    }

    public void insert(Cliente objetoCliente){
        BaseDatos.dbExecutor.execute(
                ()-> clientesDao.insert(objetoCliente)
        );
    }
}
