package com.example.myapplication.ventanas.cliente;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.ventanas.reservasCliente.ClienteReservas;

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



        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ClienteReservas.class));
            }
        });




        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}