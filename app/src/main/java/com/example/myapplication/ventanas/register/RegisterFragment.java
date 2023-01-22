package com.example.myapplication.ventanas.register;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.Menu;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentRegisterBinding;
import com.example.myapplication.ventanas.login.LoginFragment;

public class RegisterFragment extends Fragment {


    private FragmentRegisterBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        RegisterViewModel registerViewModel=new ViewModelProvider(this).get(RegisterViewModel.class);

        binding.loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.registerFragment,new LoginFragment()).commit();
                binding.botonRegistrarse.setVisibility(View.GONE);
                binding.loginRegister.setVisibility(View.GONE);
                binding.view.setVisibility(View.GONE);

            }
        });

        binding.botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creando usuario
                String nombre = binding.nombreRegistro.getText().toString();
                String apellidos = binding.apellidosRegistro.getText().toString();
                String email = binding.emailRegistro.getText().toString();
                String contrasenya = binding.contrasenyaRegistro.getText().toString();

                //Si inserta algo vacion no entrará

                if (!(nombre.isEmpty()||apellidos.isEmpty()||email.isEmpty()||contrasenya.isEmpty())){
                    registerViewModel.validarUsuario(email).observe(getActivity(), ec -> {
                        if (ec.getEmail().equals(email)) {
                            Toast.makeText(getContext(), "El email ya está registrado", Toast.LENGTH_SHORT).show();

                        }
                        //Se inserta en la base de datos
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                registerViewModel.insertarCliente(new Cliente(email,nombre,apellidos,contrasenya));
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getContext(), "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getActivity(), Menu.class));
                                        getActivity().onBackPressed();
                                    }
                                });


                            }
                        }).start();


                    });


                }else{
                    Toast.makeText(getContext(), "No puedes dejar campos vacios", Toast.LENGTH_SHORT).show();
                }

            }

        });

        return binding.getRoot();
    }





}