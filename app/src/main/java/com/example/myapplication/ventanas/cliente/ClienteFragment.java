package com.example.myapplication.ventanas.cliente;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentClienteBinding;
import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.ventanas.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class ClienteFragment extends Fragment {


    private FragmentClienteBinding binding;
    SharedPreferences sharedPreferences;

    String emailCliente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentClienteBinding.inflate(inflater, container, false);
        ClienteViewModel clienteViewModel = new ViewModelProvider(this).get(ClienteViewModel.class);

        sharedPreferences=getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        emailCliente= sharedPreferences.getString("emailUsuario", "");

        clienteViewModel.cogerUsuario(emailCliente).observe(getActivity(), cu ->{
            binding.nombrePerfil.setText(cu.getNombre());
            binding.apellidoPerfil.setText(cu.getApellidos());
            binding.emailPerfil.setText(cu.getEmail());
        });




        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}