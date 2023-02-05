package com.example.myapplication.ventanas.register;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.Menu;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentRegisterBinding;
import com.example.myapplication.ventanas.login.LoginFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFragment extends Fragment {


    private FragmentRegisterBinding binding;

    SharedPreferences sharedPreferences;
    CheckBox recordarContra;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        RegisterViewModel registerViewModel=new ViewModelProvider(this).get(RegisterViewModel.class);

        sharedPreferences=getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        recordarContra=(CheckBox) binding.checkRegister;
        binding.emailRegistro.setText(sharedPreferences.getString("email",""));
        recordarContra.setChecked(false);

        if (!(sharedPreferences.getString("email","").length()==0)){
            recordarContra.setChecked(true);
        }

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
                        if (ec!=null && ec.getEmail().equals(email)) {
                            Toast.makeText(getContext(), "El email ya está registrado", Toast.LENGTH_SHORT).show();

                        }else{
                                //Se inserta en la base de datos
                            if (validarUsuario(email,nombre,apellidos,contrasenya)){
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        registerViewModel.insertarCliente(new Cliente(email,nombre,apellidos,contrasenya));
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(getContext(), "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                                if (recordarContra.isChecked()){
                                                    editor.putString("email",binding.emailRegistro.getText().toString());
                                                }else {
                                                    editor.putString("email","");
                                                }
                                                editor.putString("emailUsuario",binding.emailRegistro.getText().toString());
                                                editor.commit();
                                                startActivity(new Intent(getActivity(), Menu.class));
                                                getActivity().onBackPressed();
                                            }
                                        });

                                    }


                                }).start();
                            }


                        }

                    });

                }else{
                    Toast.makeText(getContext(), "No puedes dejar campos vacios", Toast.LENGTH_SHORT).show();
                }



            }

        });

        return binding.getRoot();
    }

    public boolean validarUsuario(String email ,String nombre, String apellido, String contrasenya ){
        Pattern patronEmail = Pattern.compile("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}");
        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        Pattern patronTexto = Pattern.compile("[a-zA-ZñÑüÜáéíóúÁÉÍÓÚ\\s]{3,}");
        Matcher mNombre = patronTexto.matcher(nombre);
        Matcher mApellidos = patronTexto.matcher(apellido);
        Pattern patronContrasenya = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        Matcher mContrasenya = patronContrasenya.matcher(contrasenya);
        if (mEmail.matches()){
            if (mNombre.matches()){
                if (mApellidos.matches()){
                    if (mContrasenya.matches()){
                        return true;
                    }else{
                        Toast.makeText(getContext(), "Tu contraseña no es segura", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(), "Tu apellido no puede contener caracteres especiales", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getContext(), "Tu nombre no puede contener caracteres especiales", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getContext(), "Email incorrecto", Toast.LENGTH_SHORT).show();
        }
        return false;
    }





}