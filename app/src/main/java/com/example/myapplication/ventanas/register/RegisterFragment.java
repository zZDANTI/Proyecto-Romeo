package com.example.myapplication.ventanas.register;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.BaseDatos.BaseDatos;
import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.databinding.FragmentRegisterBinding;
import com.example.myapplication.databinding.FragmentReservasBinding;
import com.example.myapplication.ventanas.login.LoginViewModel;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        RegisterViewModel registerViewModel=new ViewModelProvider(this).get(RegisterViewModel.class);

        binding.botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creando usuario
                String nombre = String.valueOf(binding.nombreRegistro.getText());
                String apellidos = String.valueOf(binding.apellidosRegistro.getText());
                String email = String.valueOf(binding.emailRegistro.getText());
                String contrasenya = String.valueOf(binding.contrasenyaRegistro.getText());

                if (!(nombre.isEmpty()||apellidos.isEmpty()||email.isEmpty()||contrasenya.isEmpty())){
                    //Se inserta en la base de datos
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            registerViewModel.insertarCliente(new Cliente(nombre,apellidos,email,contrasenya));
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getContext(), "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();


                }else{
                    Toast.makeText(getContext(), "No puedes dejar campos vacios", Toast.LENGTH_SHORT).show();
                }

            }

        });













        return binding.getRoot();
    }



}