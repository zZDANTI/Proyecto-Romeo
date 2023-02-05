package com.example.myapplication.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entity.Habitaciones;

import java.util.List;

@Dao
public interface HabitacionDao {

    // Todas las consultas para poder coger habitaciones de la base de datos

    @Update
    void update(Habitaciones habitaciones);

    @Delete
    void delete(Habitaciones habitaciones);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertarHabitaciones(Habitaciones habitaciones);



    @Query("SELECT * FROM habitaciones")
    LiveData<List<Habitaciones>> todasHabitaciones();

    @Query("SELECT * FROM habitaciones WHERE id = :miId ")
    Habitaciones unaHabitacion(String miId);

    @Query("SELECT * FROM habitaciones WHERE precio BETWEEN :minPrecio AND :maxPrecio ")
    LiveData<List<Habitaciones>> todosPrecios(int minPrecio, int maxPrecio);

}
