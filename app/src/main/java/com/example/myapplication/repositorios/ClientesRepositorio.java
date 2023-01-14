package com.example.myapplication.repositorios;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.myapplication.daos.ClientesDao;
import com.example.myapplication.BaseDatos.BaseDatos;
import com.example.myapplication.entity.Cliente;

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

    public LiveData<Cliente> getOneCliente(String mId) {
        return clientesDao.obtenerCliente(mId);
    }

    public void insert(Cliente objetoCliente){
        BaseDatos.dbExecutor.execute(
                ()-> clientesDao.insert(objetoCliente)
        );
    }
}
