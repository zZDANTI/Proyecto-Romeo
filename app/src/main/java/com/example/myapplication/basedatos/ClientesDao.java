package com.example.myapplication.basedatos;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClientesDao {

// Todas las consultas para poder coger datos de la base de datos

    @Query("SELECT * FROM usuario")
    List<Usuario> obtenerClientes();

    @Query("SELECT * FROM Usuario WHERE nombre = :user")
    Usuario obtenerCliente(String user);

    @Insert
    void insert (Usuario...usuario);

    @Query("UPDATE usuario Set nombre = :nombre where  nombre = :user")
    void actualizarUsuario(String user, String nombre);

    @Query("Delete FROM usuario where nombre = :user")
    void borrarUsuario(String user);


    @Delete
    void delete (Usuario cliente);


}
