package com.example.myapplication.daos;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.myapplication.entity.Cliente;

import java.util.List;

@Dao
public interface ClientesDao {

// Todas las consultas para poder coger datos de la base de datos

    @Query("SELECT * FROM cliente")
    LiveData<List<Cliente>> obtenerClientes();

    @Query("SELECT * FROM cliente WHERE id = :id")
    LiveData<Cliente> obtenerCliente(String id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Cliente cliente);

    /*
    @Insert
    void insert(Cliente cliente);

     */

    @Query("UPDATE cliente Set nombre = :nombre where  nombre = :user")
    void actualizarUsuario(String user, String nombre);

    @Query("Delete FROM cliente where nombre = :user")
    void borrarUsuario(String user);


    @Delete
    void delete (Cliente cliente);


}
