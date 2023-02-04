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
import com.example.myapplication.Repositorios.ReservasRepositorio;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.ventanas.habitaciones.HabitacionesViewModel;

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


        //DATOS USUARIO
        sharedPreferences=getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        emailCliente= sharedPreferences.getString("emailUsuario", "");


        new Thread(new Runnable() {
            @Override
            public void run() {
                binding.pruebaHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        homeViewModel.insertarReserva(new Reservas("04-02-2023","04-02-2024",emailCliente));
                        homeViewModel.insertarHabitaciones(new Habitaciones("Tu muertos",4,"No hay mierda",100, 1));

                    }
                });

            }
        }).start();



       //SI HAY UNA RESERVA LE APARECERA EN EL FRAGMENT DE HOME
        homeViewModel.reservasUsuario(emailCliente).observe(getActivity(),rc->{
            if(rc!=null){
                binding.reservaDelCliente.setText("No tienes ninguna reserva");
            }else{

                binding.reservaDelCliente.setText(rc.get(i).getFechaEntrada());
            }

        });

        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}