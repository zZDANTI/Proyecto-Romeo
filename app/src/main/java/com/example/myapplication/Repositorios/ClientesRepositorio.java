package com.example.myapplication.Repositorios;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.myapplication.Daos.ClientesDao;
import com.example.myapplication.BaseDatos.BaseDatos;
import com.example.myapplication.Entity.Cliente;

import java.util.List;

public class ClientesRepositorio {


   public final LiveData<List<Cliente>> listadoCliente;
   public final ClientesDao clientesDao;

   //CONSTRUCTOR

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

    //METODOS


    //Valida un cliente para poder iniciar sesion en login o comprueba si esta registrado
    public LiveData<Cliente> validarUsuario(String email) {
        return clientesDao.validarUsuario(email);
    }

    //Inserta un cliente a la base de datos
    public void insertarCliente(Cliente cliente){
        BaseDatos.dbExecutor.execute(
                ()-> clientesDao.insertarCliente(cliente)
        );
    }


}
