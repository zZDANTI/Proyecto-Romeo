package com.example.myapplication.ventanas.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.Menu;
import com.example.myapplication.R;
import com.example.myapplication.Repositorios.ReservasRepositorio;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.ventanas.habitaciones.HabitacionesViewModel;
import com.example.myapplication.ventanas.home.HomeViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    Context context;
    SharedPreferences sharedPreferences;
    String emailCliente;




    int i;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        //homeViewModel.insertarReserva(new Reservas("2023-03-02","2023-03-05",1,"s"));

        homeViewModel.insertarHabitaciones(new Habitaciones(1,"PEPITO",135,"Una suite estilo tropical moderna en la cual hay una cama de matrimonio, un baño con ducha estilo moderno, luces de ambiente tropical y buenas vistas a la playa",14,R.drawable.fondoinicio));
        homeViewModel.insertarHabitaciones(new Habitaciones(2,"PEPITO",95,"Una habitación cómoda para varias personas con minimos requisitos y útil para pasar la noche",13,R.drawable.fondoinicio));
        homeViewModel.insertarHabitaciones(new Habitaciones(3,"PEPITO",135,"Una suite estilo tropical moderna en la cual hay una cama de matrimonio, un baño con ducha estilo moderno, luces de ambiente tropical y buenas vistas a la playa",14,R.drawable.fondoinicio));
        homeViewModel.insertarHabitaciones(new Habitaciones(4,"PEPITO",95,"Una habitación cómoda para varias personas con minimos requisitos y útil para pasar la noche",13,R.drawable.fondoinicio));
        homeViewModel.insertarHabitaciones(new Habitaciones(5,"PEPITO",135,"Una suite estilo tropical moderna en la cual hay una cama de matrimonio, un baño con ducha estilo moderno, luces de ambiente tropical y buenas vistas a la playa",14,R.drawable.fondoinicio));
        homeViewModel.insertarHabitaciones(new Habitaciones(6,"PEPITO",95,"Una habitación cómoda para varias personas con minimos requisitos y útil para pasar la noche",13,R.drawable.fondoinicio));
        homeViewModel.insertarHabitaciones(new Habitaciones(7,"PEPITO",135,"Una suite estilo tropical moderna en la cual hay una cama de matrimonio, un baño con ducha estilo moderno, luces de ambiente tropical y buenas vistas a la playa",14,R.drawable.fondoinicio));

        //DATOS USUARIO
        sharedPreferences=getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        emailCliente= sharedPreferences.getString("emailUsuario", "");




       //SI HAY UNA RESERVA LE APARECERA EN EL FRAGMENT DE HOME

        new Thread(new Runnable() {
            @Override
            public void run() {
                if(homeViewModel.reservasUsuario(emailCliente)==null){
                    binding.reservaDelCliente.setText("No tienes ninguna reserva");
                }else{
                    binding.reservaDelCliente.setText(homeViewModel.reservasUsuario(emailCliente));

                }
            }
        }).start();





        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}