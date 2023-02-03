package com.example.myapplication.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entity.Reservas;

import java.util.List;

@Dao
public interface ReservasDao {
    // Todas las consultas para poder coger reservas de la base de datos

    @Insert
    public void insert(Reservas reservas);

    @Update
    public void update(Reservas reservas);

    @Delete
    public void delete(Reservas reservas);

    @Query("SELECT * FROM reservas ")
    public LiveData<List<Reservas>> todasReservas();

    @Query("SELECT * FROM reservas WHERE clienteEmail =:miEmail ")
    public List<Reservas> getMyRooms(String miEmail);


    @Query("SELECT * FROM reservas WHERE id =:miIdReserva ")
    public Reservas getMyReserva(String miIdReserva);


    @Query("SELECT * FROM reservas WHERE habitacionId =:idHabitacion ")
    public List<Reservas> getMyBooksRoom(String idHabitacion);

}
