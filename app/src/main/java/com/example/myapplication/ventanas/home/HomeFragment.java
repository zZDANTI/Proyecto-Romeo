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

        homeViewModel.insertarHabitaciones(new Habitaciones(1,"Habitacion Deluxe",2,"Disfruta del confort personalizado al más puro estilo de Manhattan en este moderno hotel donde se han recopilado las obras de Romeo",50,R.drawable.habitacion1));
        homeViewModel.insertarHabitaciones(new Habitaciones(2,"Habitacion TutiFruti",4,"El lugar legante que ofrece a sus huéspedes una experiencia cautivadora. Está equipado con tecnología en todas las instalaciones.",55,R.drawable.habitacion2));
        homeViewModel.insertarHabitaciones(new Habitaciones(3,"Habitacion Fresa",3,"Los barrios más exclusivos de la ciudad, ofrece un diseño sofisticado con detalles artísticos que desborda elegancia y distinción",80,R.drawable.habitacion3));
        homeViewModel.insertarHabitaciones(new Habitaciones(4,"Habitacion Mango",2,"En el Hotel Romeop, son meticulosos hasta el último detalle y saben cómo llevar a sus clientes a una sensación de confort y bienestar",40,R.drawable.habitacion4));
        homeViewModel.insertarHabitaciones(new Habitaciones(5,"Habitacion Sandia",3,"Las lujosas habitaciones , ofrecen confort y comodidad. El ambiente cálido de las estancias te sumergen en un estado de relax total.",150,R.drawable.habitacion5));
        homeViewModel.insertarHabitaciones(new Habitaciones(6,"Habitacion Melon",4,"Para los amantes de la gastronomía, hay varios restaurantes y bares, alguno de ellos con estrella Michelin",130,R.drawable.habitacion6));
        homeViewModel.insertarHabitaciones(new Habitaciones(7,"Habitacion Cereza",5,"Entre sus instalaciones, podrás encontrar bar, restaurante, «patio andaluz», una bonita piscina exterior, sala de Fitness y además, está adaptado para mascotas.",140,R.drawable.habitacion7));

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