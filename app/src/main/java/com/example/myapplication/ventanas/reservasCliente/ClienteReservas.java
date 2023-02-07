package com.example.myapplication.ventanas.reservasCliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.R;
import com.example.myapplication.adaptadores.AdapterHabitaciones;
import com.example.myapplication.adaptadores.AdapterReservas;
import com.example.myapplication.ventanas.reservas.ReservasViewModel;

import java.util.ArrayList;

public class ClienteReservas extends AppCompatActivity {



    GridView grid;
    String emailCliente;
    SharedPreferences sharedPreferences;
    ClienteReservasViewModel clienteReservasViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_cliente);
        clienteReservasViewModel= new ViewModelProvider(this).get(ClienteReservasViewModel.class);

        sharedPreferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        emailCliente= sharedPreferences.getString("emailUsuario", "");
        ArrayList<Reservas> reservaClientes= new ArrayList<>();

        grid = findViewById(R.id.recyclerReservas);


        clienteReservasViewModel.reservasTotalUsuarios(emailCliente).observe(this, ru ->{
            for (Reservas reservas : ru){

                String fechaEntrada=reservas.getFechaEntrada();
                String fechaSalida=reservas.getFechaSalida();
                int idHabitacion= reservas.getIdHabitacion();
                String idEmail= reservas.getIdEmail();
                reservaClientes.add(new Reservas(fechaEntrada,fechaSalida,idHabitacion,idEmail));
            }
        });

        AdapterReservas adapterReservas = new AdapterReservas(this, reservaClientes);
        grid.setAdapter(adapterReservas);


    }
}