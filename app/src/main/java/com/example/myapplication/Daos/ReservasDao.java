package com.example.myapplication.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entity.Reservas;

import java.util.List;

@Dao
public interface ReservasDao {
    // Todas las consultas para poder coger reservas de la base de datos

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertarReserva(Reservas reservas);

    @Update
    void update(Reservas reservas);

    @Delete
    void delete(Reservas reservas);

    @Query("SELECT * FROM reservas")
    LiveData<List<Reservas>> todasReservas();

    //SE USA EN EL HOME PARA SABER EL DIA QUE TIENE RESERVADO EL CLIENTE
    @Query("SELECT fechaEntrada FROM reservas WHERE idEmail =:miEmail  ORDER BY fechaEntrada ASC limit 1 ")
    String reservasUsuario(String miEmail);


    @Query("SELECT * FROM reservas WHERE id =:miIdReserva ")
    Reservas getMyReserva(String miIdReserva);


    @Query("SELECT * FROM reservas WHERE idHabitacion =:idHabitacion ")
    List<Reservas> getMyBooksRoom(String idHabitacion);

}
