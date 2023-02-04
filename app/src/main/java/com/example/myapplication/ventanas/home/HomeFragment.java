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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        ReservasRepositorio reservasRepositorio = new ReservasRepositorio(context);

        //Datos del usuario
        sharedPreferences=getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        emailCliente= sharedPreferences.getString("emailUsuario", "");
        binding.reservaDelCliente.setText(emailCliente);


       //DATOS DEL CLIENTE

        reservasRepositorio.reservasCliente(emailCliente).observe(getActivity(),rc->{


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